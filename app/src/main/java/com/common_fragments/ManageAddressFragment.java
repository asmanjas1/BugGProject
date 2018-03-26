package com.common_fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.practiceapp.ConsumerActivity;
import com.practiceapp.R;
import com.services.GPSTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ManageAddressFragment extends Fragment {

    Button btnGPSShowLocation;
    TextView address;
    GPSTracker gps;

    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    public ManageAddressFragment() {
        // Required empty public constructor
    }

    public static ManageAddressFragment newInstance(String param1, String param2) {
        ManageAddressFragment fragment = new ManageAddressFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (ActivityCompat.checkSelfPermission(getActivity(), mPermission)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(getActivity(), new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

                // If any permission above not allowed by user, this condition will execute every time, else your else part will work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((ConsumerActivity) getActivity()).setActionBarTitle("Manage Address");
        View view = inflater.inflate(R.layout.fragment_manage_address, container, false);
        address = (TextView) view.findViewById(R.id.appAddress);

        btnGPSShowLocation = (Button) view.findViewById(R.id.btnGPSShowLocation);
        btnGPSShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // create class object
                gps = new GPSTracker(getContext());

                // check if GPS enabled
                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    if(latitude==0.0 || longitude==0.0){
                       showSettingsAlert();
                    }else{
                        address.setText(hereLocation(latitude,longitude));
                        // \n is for new line
                        /*Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "+ latitude + "\nLong: " + longitude, Toast.LENGTH_SHORT).show();*/
                    }
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }
            }
        });
        return view;
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        getContext().startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    public String hereLocation(double let, double lon){

        List<String> list= new ArrayList<>();
        Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
        List<Address> addressList ;
        try{
            addressList=geocoder.getFromLocation(let,lon,1);
            if(addressList.size()>0){
                Address ad= addressList.get(0);
                list.add(ad.getLocality());
                list.add(ad.getCountryCode());
                list.add(ad.getAdminArea());
                list.add(ad.getPostalCode());
                list.add(ad.getAddressLine(0));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list.toString();
    }
}
