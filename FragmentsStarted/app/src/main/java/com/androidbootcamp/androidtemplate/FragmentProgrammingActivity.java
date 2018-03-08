package com.androidbootcamp.androidtemplate;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.androidbootcamp.androidtemplate.ui.fragments.BlankFragment;
import com.androidbootcamp.androidtemplate.ui.listeners.BlankFragmentListener;


public class FragmentProgrammingActivity extends AppCompatActivity
        implements BlankFragmentListener {

    private FrameLayout frameLayoutContainer;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_programming);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        frameLayoutContainer=findViewById(R.id.frameLayoutContainer);
        fragmentManager= getSupportFragmentManager();

        addFragment();
    }

    @Override
    public void actionFragment(Object object) {

    }

    @Override
    public void actionActivityCambiarColor() {

    }

    @Override
    public void callToActivity(Object object) {
        Toast.makeText(this,object.toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void cerrarSesion() {

    }

    private void addFragment(){
        BlankFragment blankFragment=new BlankFragment();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayoutContainer,blankFragment,"BlankFragment");
        fragmentTransaction.commit();

        //fragmentManager.findFragmentByTag()
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
