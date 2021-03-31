package com.example.advancedadapterlab;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.Arrays;


public class StudentAdapter extends BaseAdapter {
    private final String TAG = "StudentAdapter";

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Student> mDataSource;


    public StudentAdapter(Context context, Student[] students) {
        Log.i(TAG, "StudentAdapter constructor");
        mContext = context;
        mDataSource = new ArrayList<>(Arrays.asList(students));
        mInflater = (LayoutInflater) mContext.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
        Log.i(TAG, "  constructor done");

    }

    @Override
    public int getCount() {
        Log.i(TAG, "getCount()");
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        Log.i(TAG, "getItem()");
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.i(TAG, "getItemId()");
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i(TAG, "getView()");
        View rowView = mInflater.inflate(R.layout.list_view_row, parent, false);
        Log.i(TAG, "  rowView set");

        // get this view's data
        Student student = (Student) getItem(position);
        Log.i(TAG, "  Student item gotten");

        // get the relevant view fields
        ImageView icon = (ImageView) rowView.findViewById(R.id.category_thumbnail);
        TextView firstNameView = (TextView) rowView.findViewById(R.id.first_name);
        TextView lastNameView = (TextView) rowView.findViewById(R.id.last_name);
        TextView majorView = (TextView) rowView.findViewById(R.id.major);
        Log.i(TAG, "  Views found");

        // set the relevant view data
        icon.setBackground(ResourcesCompat.getDrawable(rowView.getResources(),R.drawable.doge, null));
        firstNameView.setText(student.getFirstName());
        lastNameView.setText(student.getLastName());
        majorView.setText(student.getMajor());

        Log.i(TAG, "  rowView finalized?");
        return rowView;
    }
}
