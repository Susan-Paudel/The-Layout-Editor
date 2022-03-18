package com.example.helloworld;
//import required library
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Display two Buttons and a TextView
 * -Clicking the Count button that increases the displayed mCount
 * -Clicking the Toast button that show the toast message
 */
//MinActivity child class inherit all the property of AppCompatActivity i.e. parent
public class MainActivity extends AppCompatActivity {
    //private int mCount
    private int mCount = 0;
    //TextView
    private TextView mShowCount;

    /**
     * Activities have the ability,to restore themselves to a previous state using the data stored in this bundle
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super keyword is used to refer parent class object
        super.onCreate(savedInstanceState);
        //it set the XML file as your main layout when the app starts
        setContentView(R.layout.activity_main);
        //taking the id from textview
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    /*
     * Shows a Toast when the TOAST button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since a toast always shows on the top,
     *             the passed in view is not used.
     */
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        //show toast
        toast.show();
    }

    /*
     * Increments the number in the TextView when the COUNT button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since the count always appears in the TextView,
     *             the passed in view is not used.
     */
    public void countUp(View view) {
        //increase count
        mCount++;
        //if count is not null
        if (mShowCount != null)
            //setText to textview
            mShowCount.setText(Integer.toString(mCount));
    }
}