package com.androidbootcamp.androidtemplate;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.androidbootcamp.androidtemplate.ui.listeners.OnFirstFragmentListener;

public class MyFirstFragmentActivity extends AppCompatActivity implements
        OnFirstFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_first_fragment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void showMessageActivity(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void activityChangeBackgroundColor() {
        findViewById(R.id.container).setBackgroundColor(Color.RED);
    }
}
