package com.androidbootcamp.androidtemplate.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidbootcamp.androidtemplate.R;
import com.androidbootcamp.androidtemplate.ui.listeners.OnFirstFragmentListener;

public class MyFirstFragment extends Fragment {

    private OnFirstFragmentListener mListener;

    public MyFirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_first, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFirstFragmentListener) {
            mListener = (OnFirstFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFirstFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener!=null){
                    //mListener.showMessageActivity("Hello from Fragment");
                    mListener.activityChangeBackgroundColor();
                }
            }
        });
    }
}
