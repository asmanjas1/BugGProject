package com.consumer_fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.beans.Country;
import com.beans.Order;
import com.practiceapp.ConsumerActivity;
import com.practiceapp.R;
import com.resources.BuyGUtils;
import com.resources.DummyResponseResultFromRest;
import com.resources.RestClient;
import com.resources.RestInvokerService;
import com.viewAdapter.ConsumerOrderAdapter;
import com.viewAdapter.ShopkeeperOrderAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsumerTwoFragment extends Fragment {
    //a list to store all the products
    List<Order> orderList;

    //the recyclerview
    RecyclerView recyclerView;

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
        View view = inflater.inflate(R.layout.fragment_consumer_2, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewForConsumer);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadOrderItems();
       /* textView = (TextView) view.findViewById(R.id.resttext);
        RestInvokerService restInvokerService = RestClient.getClient().create(RestInvokerService.class);
        Call<List<Country>> call = restInvokerService.getTopRatedMovies();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                Log.e("Inside Rest",((Integer)response.code()).toString());
                List<Country> countries =response.body();
                textView.setText(countries.get(0).getCountryName());
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                textView.setText(t.toString());
                Log.e("Inside Rest",t.toString());
            }
        });*/
        return view;
    }

    private void loadOrderItems() {
        final ProgressDialog progressDialog =  BuyGUtils.getProgressDialog(getContext());
        progressDialog.show();
        orderList = DummyResponseResultFromRest.getOrderList();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(orderList!= null && orderList.size()>0){
                    progressDialog.dismiss();
                    ConsumerOrderAdapter consumerOrderAdapter = new ConsumerOrderAdapter(getContext(),orderList);
                    recyclerView.setAdapter(consumerOrderAdapter);
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(getContext(),"Not able to fetch Order List",Toast.LENGTH_SHORT).show();
                }
            }
        }, 1000);



        /*RestInvokerService restInvokerService = RestClient.getClient().create(RestInvokerService.class);
        Call<List<Country>> call = restInvokerService.getTopRatedMovies();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                progressDialog.dismiss();

            }
        });*/
    }
}