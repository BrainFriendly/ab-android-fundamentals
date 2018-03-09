package com.androidbootcamp.androidtemplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textView1).setOnClickListener(this);
        findViewById(R.id.textView2).setOnClickListener(this);
        findViewById(R.id.textView3).setOnClickListener(this);
        findViewById(R.id.textView4).setOnClickListener(this);
        findViewById(R.id.textView5).setOnClickListener(this);
        findViewById(R.id.textView6).setOnClickListener(this);
        findViewById(R.id.textView7).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textView1:
                    //goToActivity(StarWarsEventsActivity.class);
                break;
            case R.id.textView2:
                    //goToActivity(StarWarsEventsFragmentActivity.class);
                break;
            case R.id.textView3:
                    //goToActivity(StarWarsEventsTabletActivity.class);
                break;
            case R.id.textView4:
                    goToActivity(ColorActivity.class);
                break;
            case R.id.textView5:
                    goToActivity(TabFragmentActivity.class);
                break;

            case R.id.textView6:
                    //goToActivity(ContactsActivity.class);
                break;
            case R.id.textView7:
                    //goToActivity(CardsActivity.class);
                break;
        }
    }

    private void goToActivity(Class activity){
        Intent intent= new Intent(this,activity);
        startActivity(intent);
    }
}
