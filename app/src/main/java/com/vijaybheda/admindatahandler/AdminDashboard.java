package com.vijaybheda.admindatahandler;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AdminDashboard extends AppCompatActivity implements View.OnClickListener {

    CardView mFSCardView, mDoctorCardView, mPurchaseCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        mFSCardView = findViewById(R.id.fsCardView);mDoctorCardView = findViewById(R.id.doctorCardView); mPurchaseCardView = findViewById(R.id.purchaseCardView);
        mFSCardView.setOnClickListener(this);mDoctorCardView.setOnClickListener(this);mPurchaseCardView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        mFSCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FSViewActivity.class));
            }
        });

        mDoctorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DoctorListView.class));
            }
        });

        mPurchaseCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "mPurchaseCardView", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
