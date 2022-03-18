package com.example.helloworld;
//import required library
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Display two Buttons and a TextView
 * -Clicking the Count button that increases the displayed mCount
 * -Clicking the Toast button that show the toast message
 * -clicking the count Zero button that reset the value to zero
 */
//MinActivity child class inherit all the property of AppCompatActivity i.e. parent
public class MainActivity extends AppCompatActivity {
    //assign the initial value
    private int mCount = 0;
    //declare textview and Button
    private TextView mShowCount;
    private Button button,count;

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
        //getting show count by id i.e.textview
        mShowCount = (TextView) findViewById(R.id.show_count);
        //getting button by id
        button=(Button) findViewById(R.id.button_zero);
        count=(Button)findViewById(R.id.button_count);
    }

    /**
     * Shows a Toast when the TOAST button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since a toast always shows on the top,
     *             the passed in view is not used.
     */
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        //show the toast message
        toast.show();
    }

    /**
     * Increments the number in the TextView when the COUNT button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since the count always appears in the TextView,
     *             the passed in view is not used.
     */
    @SuppressLint("ResourceAsColor")
    public void countUp(View view) {
        //increase the counter value
        mCount++;
        //if counter variable is not null
        if (mShowCount != null)
            //it will set the value to mShowCount textview
            mShowCount.setText(Integer.toString(mCount));
           //it will change the background color of zero button to pink
            button.setBackgroundResource(R.color.colorAccent);
            if(mCount % 2 == 0){
                //even
                view.setBackgroundResource(R.color.green);
            }else if(mCount%2==1){
                //it will change the background color of button of count to green
                view.setBackgroundResource(R.color.teal_200);
            }else{
            //it will change the background color of button of count to green
            view.setBackgroundResource(R.color.colorPrimary);
        }
    }
    /**
     * reset the value of counter to zero
     *
     * @param view The view that triggered this onClick handler.
     * Since the count always appears in the TextView,the passed in view is not used.
     */
    public void countZero(View view) {
        //store the value of mCount to zero
        mCount=0;
        //if mShowCount is not null
        if (mShowCount != null)
            //it will set the value to mShowCount textview
            mShowCount.setText(Integer.toString(mCount));
           //it will change the background color of zero button to gray
            view.setBackgroundResource(R.color.gray);
           //it will change the background color of count button to primary color
            count.setBackgroundResource(R.color.colorPrimary);
    }
}