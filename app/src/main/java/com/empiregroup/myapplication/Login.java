package com.empiregroup.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button btnLogin;
    Dialog dialogNotice;
    TextView btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        dialogNotice = new Dialog(Login.this);
        dialogNotice.setContentView(R.layout.dialog_notice);
        dialogNotice.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCancel  = dialogNotice.findViewById(R.id.btnCancel);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                    }
                });

                dialogNotice.show();
            }
        });
    }
}