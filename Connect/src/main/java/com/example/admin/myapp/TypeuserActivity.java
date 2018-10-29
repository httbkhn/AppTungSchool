package com.example.admin.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TypeuserActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonParent;
    Button buttonTeacher;
    TextView textViewBack;
    static String nameRole = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeuser);

        buttonParent = (Button) findViewById(R.id.btn_parent);
        buttonTeacher = (Button) findViewById(R.id.btn_teacher);

        textViewBack = (TextView) findViewById(R.id.tvBack);

        buttonParent.setOnClickListener(this);
        buttonTeacher.setOnClickListener(this);
        textViewBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonParent) {
            Intent intent = new Intent(TypeuserActivity.this, RegisterActivity.class);
            nameRole = "Parent";
            startActivity(intent);
        }
        if (v == buttonTeacher) {
            Intent intent = new Intent(TypeuserActivity.this, RegisterActivity.class);
            nameRole = "Teacher";
            startActivity(intent);
        }
        if (v == textViewBack) {
            Intent intent = new Intent(TypeuserActivity.this, MainActivity.class);

            startActivity(intent);
        }
    }
}
