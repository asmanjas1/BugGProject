package com.common_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.practiceapp.ConsumerActivity;
import com.practiceapp.MainActivity;
import com.practiceapp.R;
import com.practiceapp.ShopActivity;
import com.resources.SaveSharedPreference;

public class ContactUsFragment extends Fragment {
    private static final String CONTACT_EMAIL = "asmanjaskumar@gmail.com";
    Button logOutButton;
    Button contactUS_btn;

    public static ContactUsFragment newInstance() {
        ContactUsFragment fragment = new ContactUsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("skndc","Idod ghe logout");
        if(SaveSharedPreference.getUserType(getContext()).toLowerCase().equals("shopkeeper")){
            ((ShopActivity) getActivity()).setActionBarTitle("Settings & More");
        }else if(SaveSharedPreference.getUserType(getContext()).toLowerCase().equals("consumer")){
            ((ConsumerActivity) getActivity()).setActionBarTitle("Settings & More");
        }

        View v = inflater.inflate(R.layout.fragment_contact_us, container, false);
        logOutButton= (Button) v.findViewById(R.id.btn_logout);
        contactUS_btn= (Button) v.findViewById(R.id.btn_contact_us);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.logOut(getContext());
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        contactUS_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{CONTACT_EMAIL} );
                // intent.putExtra(Intent.EXTRA_SUBJECT, "Subject"); // if you want extra
                // intent.putExtra(Intent.EXTRA_TEXT, "I'm email body."); // if you want extra
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
        return v;
    }

}