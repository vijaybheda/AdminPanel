package com.vijaybheda.admindatahandler;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;

public class NewDoctor extends AppCompatActivity {

    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_doctor);
        setTitle("Add Doctor Details");

        editTextName = findViewById(R.id.edit_text_doctorname);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_dr_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_dr:
                saveDoctor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    int count;// should fetch latest dcr number from firebase and store in count

    int getCount() {
        count++;
        return count;
    }

    private void saveDoctor() {
        String name = editTextName.getText().toString();
        int doctorcode = getCount();

        if (name.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a value", Toast.LENGTH_SHORT).show();
            return;
        }

        CollectionReference doctorbookRef = FirebaseFirestore.getInstance()
                .collection("DoctorBook");
        doctorbookRef.add(new Doctor(name, doctorcode));
        Toast.makeText(this, "Doctor added", Toast.LENGTH_SHORT).show();
        finish();
    }
}
