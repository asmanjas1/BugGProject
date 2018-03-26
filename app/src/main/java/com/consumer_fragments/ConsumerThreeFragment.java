package com.consumer_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.beans.ConsumerBean;
import com.common_fragments.ManageAddressFragment;
import com.practiceapp.ConsumerActivity;
import com.practiceapp.R;
import com.resources.SaveSharedPreference;

public class ConsumerThreeFragment extends Fragment implements View.OnClickListener {

    TextView userName;
    TextView emailID;
    TextView phoneNo;
    Button btn_manage_address;
    Button btn_edit_consumer_details;

    public ConsumerThreeFragment(){}

    public static ConsumerThreeFragment newInstance() {
        ConsumerThreeFragment fragment = new ConsumerThreeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((ConsumerActivity) getActivity()).setActionBarTitle("Profile");
        View rootView = inflater.inflate(R.layout.fragment_consumer_3, container, false);
        userName = (TextView) rootView.findViewById (R.id.userName);
        emailID = (TextView) rootView.findViewById (R.id.emailID);
        phoneNo = (TextView) rootView.findViewById (R.id.phoneNo);
        btn_manage_address = (Button) rootView.findViewById(R.id.btn_manage_address);
        btn_edit_consumer_details = (Button) rootView.findViewById(R.id.btn_edit_consumer_details);

        ConsumerBean bean = SaveSharedPreference.getConsumerObjectValue(getContext());
        if(bean!=null){
            userName.setText(bean.getUserName());
            emailID.setText(bean.getEmailID());
            phoneNo.setText(bean.getPhoneNo());
        }else{
            userName.setText("Not Provided");
            emailID.setText("Not Provided");
            phoneNo.setText("Not Provided");
        }

        btn_manage_address.setOnClickListener(this);
        btn_edit_consumer_details.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.btn_manage_address:
                fragment = new ManageAddressFragment();
                replaceFragment(fragment);
                break;

            case R.id.btn_edit_consumer_details:
                fragment = new EditConsumerDetailsFragment();
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_consumer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}