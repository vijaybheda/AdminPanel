package com.vijaybheda.admindatahandler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class DoctorListView extends AppCompatActivity implements DoctorAdapter.OnItemClickListener {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference DoctorRef = db.collection("DoctorBook");

    private DoctorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list_view);

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_Doctor);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewDoctor.class));
//                Toast.makeText(getApplicationContext(), "soon Available for You :)", Toast.LENGTH_SHORT).show();
            }
        });

        setUpRecyclerDoctorView();
    }

    private void setUpRecyclerDoctorView() {
        Query query = DoctorRef.orderBy("drCode", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Doctor> options = new FirestoreRecyclerOptions.Builder<Doctor>()
                .setQuery(query, Doctor.class)
                .build();

        adapter = new DoctorAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.drrecycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new DoctorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                Doctor note = documentSnapshot.toObject(Doctor.class);
                String id = documentSnapshot.getId();
                String path = documentSnapshot.getReference().getPath();
                Toast.makeText(getApplicationContext(),
                        "Position: " + position + " ID: " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onItemClick(DocumentSnapshot documentSnapshot, int position) {

    }
}
