package com.shop_fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beans.Order;
import com.practiceapp.R;
import com.practiceapp.ShopActivity;
import com.resources.BuyGUtils;
import com.resources.DummyResponseResultFromRest;
import com.viewAdapter.ShopkeeperOrderAdapter;

import java.util.List;

public class ShopOneFragment extends Fragment {
    //a list to store all the products
    List<Order> orderList;

    //the recyclerview
    RecyclerView recyclerView;

    public static ShopOneFragment newInstance() {
        ShopOneFragment fragment = new ShopOneFragment();
        return fragment;
    }

    public ShopOneFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((ShopActivity) getActivity()).setActionBarTitle("Home");
        View view = inflater.inflate(R.layout.fragment_shop_1, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewForShopkeeper);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadOrderItems();
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
                    ShopkeeperOrderAdapter shopkeeperOrderAdapter = new ShopkeeperOrderAdapter(getContext(),orderList);
                    recyclerView.setAdapter(shopkeeperOrderAdapter);
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