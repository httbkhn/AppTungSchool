package com.example.admin.myapp;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.myapp.ConnectDatabase.BackgroungWorker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean IsHide = false;
    EditText editTextuserName, editTextpassWord;
    TextView textViewSignUp;
    Button buttonlogin;
    TextView textViewVisiablePass;
    public static ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSignUp = findViewById(R.id.tvSignUp);
        progressBar =  findViewById(R.id.progressBar);

        editTextuserName =  findViewById(R.id.et_username);
        editTextpassWord =  findViewById(R.id.et_password);

        buttonlogin =  findViewById(R.id.btn_login);

        textViewVisiablePass = findViewById(R.id.tv_show_hide_password);

        buttonlogin.setOnClickListener(this);
        textViewVisiablePass.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == textViewSignUp) {
            Intent intent = new Intent(MainActivity.this, TypeuserActivity.class);

            startActivity(intent);
        }
        if (v == buttonlogin) {
            progressBar.setVisibility(View.VISIBLE);

            LoginMethod();
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

    }

    private void LoginMethod() {

        String userName = editTextuserName.getText().toString();
        String passWord = editTextpassWord.getText().toString();

        String type = "login";

        BackgroungWorker backgroungWorker = new BackgroungWorker(MainActivity.this);
        backgroungWorker.execute(type, userName, passWord);

    }


}
