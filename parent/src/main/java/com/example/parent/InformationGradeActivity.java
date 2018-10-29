package com.example.parent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class InformationGradeActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonSearch;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> selectedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_grade);

//        Spinner
        Spinner spinnerGrade = findViewById(R.id.spGrade);
        Spinner spinnerTypeGrade = findViewById(R.id.spTypeGrade);
        Spinner spinnerDay = findViewById(R.id.spDay);
        Spinner spinnerTime = findViewById(R.id.spTime);

        adapter = ArrayAdapter.createFromResource(this, R.array.number_class, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGrade.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.type_class, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeGrade.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.day_study, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.time_study, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(adapter);

        buttonSearch = (Button) findViewById(R.id.btn_search);
        buttonSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == buttonSearch) {
            Intent intent = new Intent(InformationGradeActivity.this, ListTeacherGradeActivity.class);

            startActivity(intent);
        }
    }
}
