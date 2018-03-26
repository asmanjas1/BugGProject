package com.consumer_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practiceapp.ConsumerActivity;
import com.practiceapp.R;

public class EditConsumerDetailsFragment extends Fragment {


    public EditConsumerDetailsFragment() {
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
        ((ConsumerActivity) getActivity()).setActionBarTitle("Edit Details");
        return inflater.inflate(R.layout.fragment_edit_consumer_details, container, false);
    }

}