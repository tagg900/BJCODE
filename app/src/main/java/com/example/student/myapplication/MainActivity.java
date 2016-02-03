package com.example.student.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   Button but;
    FragmentManager fm;
    MainActivityFragment fragment;
    int i = 0;
    TextView tv = null;
    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fragment = (MainActivityFragment)fm.findFragmentById(R.id.fragment);
        tv = fragment.tv;




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void clickMethod(View view){
        a++;
        tv.setText("Card Number:" + a + " Suit:" + fragment.card[a].suit + " Rank:" + fragment.card[a].rank);
        GetterSetter.currentCard = a;
    }


    @Override
    public boolean onTouchEvent(MotionEvent e){
        GetterSetter.touchX = e.getX();
        GetterSetter.touchY = e.getY();

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.Larger) {
            GetterSetter.size = GetterSetter.size += 20;

            return true;
        }
        if (id == R.id.Smaller) {
            GetterSetter.size = GetterSetter.size -= 20;
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
