package com.empiregroup.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    EditText txt_dept, txt_job, txt_location, txt_phone, txt_email;
    TextView lblName, lbl_id, btnUpdate;
    ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();
    }

    public void init(){

        txt_dept = findViewById(R.id.txt_dept);
        txt_job = findViewById(R.id.txt_job);
        txt_location = findViewById(R.id.txt_location);
        txt_phone = findViewById(R.id.txt_phone);
        txt_email = findViewById(R.id.txt_email);
        lblName = findViewById(R.id.lblName);
        lbl_id = findViewById(R.id.lbl_id);
        btnUpdate = findViewById(R.id.btnUpdate);
        imgProfile = findViewById(R.id.imgProfile);




    }
}