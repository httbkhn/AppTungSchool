package com.example.admin.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.myapp.ConnectDatabase.BackgroungWorker;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    boolean IsHide = false;
    TextView textViewSignIn;
    TextView textViewBack;
    TextView textViewVisiablePass;
    EditText editTextuserName, editTextpassWord, editTextphone;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textViewSignIn = (TextView) findViewById(R.id.tvSingIn);
        textViewBack = (TextView) findViewById(R.id.tvBack);
        textViewVisiablePass = (TextView) findViewById(R.id.tv_show_hide_password);

        editTextuserName = (EditText) findViewById(R.id.et_username);
        editTextpassWord = (EditText) findViewById(R.id.et_password);
        editTextphone = (EditText) findViewById(R.id.et_phone);

        buttonRegister = (Button) findViewById(R.id.btn_register);

        textViewSignIn.setOnClickListener(this);
        textViewBack.setOnClickListener(this);
        textViewVisiablePass.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == textViewBack) {
            Intent intent = new Intent(RegisterActivity.this, TypeuserActivity.class);

            startActivity(intent);
        }
        if (v == textViewSignIn) {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);

            startActivity(intent);
        }
        if (v == textViewVisiablePass) {
            if (!IsHide) {
                IsHide = true;
                editTextpassWord.setTransformationMethod(null);

                if (editTextpassWord.getText().length() > 0)
                    editTextpassWord.setSelection(editTextpassWord.getText().length());

                textViewVisiablePass.setBackgroundResource(R.drawable.ic_visibility_black_24dp);
            } else {
                IsHide = false;
                editTextpassWord.setTransformationMethod(new PasswordTransformationMethod());

                if (editTextpassWord.getText().length() > 0)
                    editTextpassWord.setSelection(editTextpassWord.getText().length());

                textViewVisiablePass.setBackgroundResource(R.drawable.ic_visibility_off_black_24dp);
            }
        }
        if (v == buttonRegister) {
            RegisterMethod();
        }
    }

    private void RegisterMethod() {
        String userName = editTextuserName.getText().toString();
        String passWord = editTextpassWord.getText().toString();
        String phone = editTextphone.getText().toString();

        String type = "register";

        BackgroungWorker backgroungWorker = new BackgroungWorker(RegisterActivity.this);
        backgroungWorker.execute(type, userName, passWord , phone);
    }
}
