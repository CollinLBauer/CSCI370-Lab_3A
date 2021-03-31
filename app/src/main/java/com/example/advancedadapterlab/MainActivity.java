package com.example.advancedadapterlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


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
        Log.i(TAG, "  Create adapter...");
        myAdapter = new StudentAdapter(context, students);
        Log.i(TAG, "  Get list view...");
        studentListView = findViewById(R.id.student);
        Log.i(TAG, "  Set list view adapter...");
        studentListView.setAdapter(myAdapter);

        Log.i(TAG, "Done.");
    }
}