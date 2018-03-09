package com.androidbootcamp.androidtemplate;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.androidbootcamp.androidtemplate.ui.fragments.BottomBarFragment;
import com.androidbootcamp.androidtemplate.ui.fragments.BoxFragment;
import com.androidbootcamp.androidtemplate.ui.listeners.OnColorListener;


public class ColorActivity extends AppCompatActivity implements OnColorListener {

    private BottomBarFragment bottomBarFragment;
    private BoxFragment boxFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentManager= getSupportFragmentManager();

        bottomBarFragment= (BottomBarFragment) fragmentManager.findFragmentById(R.id.fragBottom);
        boxFragment= (BoxFragment) fragmentManager.findFragmentById(R.id.fragBox);
    }

    @Override
    public void seleccionarColor(int pos) {
        boxFragment.recibirColoryPintar(pos);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
