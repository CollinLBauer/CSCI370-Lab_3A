package com.example.advancedadapterlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    Context context;
    ListView studentListView;
    StudentAdapter myAdapter;
    Student[] students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();


        Log.i(TAG, "  Create student objects...");
        // initialize student objects
        students = new Student[5];
        String[] first = getResources().getStringArray(R.array.test_student_first);
        String[] last = getResources().getStringArray(R.array.test_student_last);
        String[] major = getResources().getStringArray(R.array.test_student_major);
        for (int i = 0; i < 5; i++) {
            students[i] = new Student(first[i], last[i], major[i]);
        }

        // set adapter for studentListView
        myAdapter = new StudentAdapter(context, students);
        studentListView = findViewById(R.id.student);
        studentListView.setAdapter(myAdapter);

        Toast toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);

        studentListView.setOnItemClickListener((parent, view, position, id) -> {
            toast.setText(getResources().getString(R.string.toast_short));
            toast.show();
            Log.i(TAG, "onItemClick");
        });
        studentListView.setOnItemLongClickListener((parent, view, position, id) -> {
            toast.setText(getResources().getString(R.string.toast_long));
            toast.show();
            Log.i(TAG, "onItemLooooooooongClick");
            return true;
        });


    }
}
