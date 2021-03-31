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
        mContext = context;
        mDataSource = new ArrayList<>(Arrays.asList(students));
        mInflater = (LayoutInflater) mContext.getSystemService((Context.LAYOUT_INFLATER_SERVICE));

    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.i(TAG, "getItemId()");
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Other examples I've seen of this use convertView instead of this rowView object.
        // Also, my linter does not like this method of inflating the row view,
        //   without putting it in a conditional statement, i.e.
        //   if convertView == null, THEN inflate a new view.
        // Should we be doing that instead?
        View rowView = mInflater.inflate(R.layout.list_view_row, parent, false);

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
