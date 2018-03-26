package com.consumer_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practiceapp.ConsumerActivity;
import com.practiceapp.R;
public class ConsumerOneFragment extends Fragment {

    public static ConsumerOneFragment newInstance() {
        ConsumerOneFragment fragment = new ConsumerOneFragment();
        return fragment;
    }

    public ConsumerOneFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((ConsumerActivity) getActivity()).setActionBarTitle("Home");
        return inflater.inflate(R.layout.fragment_consumer_1, container, false);
    }
}