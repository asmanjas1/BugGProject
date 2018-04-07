package com.shop_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practiceapp.R;
import com.practiceapp.ShopActivity;

public class ShopTwoFragment extends Fragment {

    public static ShopTwoFragment newInstance() {
        ShopTwoFragment fragment = new ShopTwoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((ShopActivity) getActivity()).setActionBarTitle("Profile");
        View view = inflater.inflate(R.layout.fragment_shop_2, container, false);
        return view;
    }


}