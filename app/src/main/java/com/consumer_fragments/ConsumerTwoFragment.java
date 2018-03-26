package com.consumer_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practiceapp.ConsumerActivity;
import com.practiceapp.R;

public class ConsumerTwoFragment extends Fragment {
    public static ConsumerTwoFragment newInstance() {
        ConsumerTwoFragment fragment = new ConsumerTwoFragment();
        return fragment;
    }

    public ConsumerTwoFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((ConsumerActivity) getActivity()).setActionBarTitle("Your Orders");
        return inflater.inflate(R.layout.fragment_consumer_2, container, false);
    }
}