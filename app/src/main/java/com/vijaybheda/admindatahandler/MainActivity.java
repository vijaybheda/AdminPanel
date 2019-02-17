package com.vijaybheda.admindatahandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread t=new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(2000);
                }
                catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                Intent i=new Intent(getApplicationContext(), AdminDashboard.class);
                startActivity(i);
                finish();
            }
        };
        t.start();
    }
}
