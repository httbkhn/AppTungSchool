package com.example.parent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.parent.Model.CustomListView;

public class ListTeacherGradeActivity extends AppCompatActivity {
    CheckBox IsCheck;
    ListView listView;
    String[] userName={"Nguyen Van Bao","Nguyen Anh Dung","Le Anh Dung","Le Tien Dat"};
    String[] description={"Teacher","Teacher","Teacher","Teacher"};
    Integer[] imgId={R.drawable.user1,R.drawable.user1,R.drawable.user1,R.drawable.user1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_teacher_grade);

        listView = findViewById(R.id.lv_listclass);
        IsCheck = findViewById(R.id.cbIdteacher);
        CustomListView customListView = new CustomListView(this,userName,description,imgId);
        listView.setAdapter(customListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //CustomListView customListView1 =parent.getSelectedView();
            }
        });
    }
}
