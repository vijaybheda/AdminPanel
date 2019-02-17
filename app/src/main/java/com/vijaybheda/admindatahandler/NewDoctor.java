package com.vijaybheda.admindatahandler;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class NewDoctor extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName, editTextdob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_doctor);
        setTitle("Add Doctor Details");

        editTextName = findViewById(R.id.edit_text_doctorfname);
        editTextdob = findViewById(R.id.edit_text_drdob);
        editTextdob.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        editTextdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DOB 
                pickDate();
            }
        });
    }

    private void pickDate() {
        int date, month, year;
        final Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                editTextdob.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        }, date, month, year);
        datePickerDialog.show();

    }
}
