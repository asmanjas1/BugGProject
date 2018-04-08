package com.consumer_fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beans.ShopkeeperBean;
import com.practiceapp.ConsumerActivity;
import com.practiceapp.R;
import com.resources.BuyGUtils;
import com.resources.RestClient;
import com.resources.RestInvokerService;
import com.viewAdapter.ShopkeeperListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsumerOneFragment extends Fragment {

    List<ShopkeeperBean> shopkeeperBeanList;
    RecyclerView recyclerView;

    public static ConsumerOneFragment newInstance() {
        ConsumerOneFragment fragment;
        fragment = new ConsumerOneFragment();
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
        View view  = inflater.inflate(R.layout.fragment_consumer_1, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewForConsumerList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadShopkeeperList();
        return view;
    }

    private void loadShopkeeperList() {
        final ProgressDialog progressDialog =  BuyGUtils.getProgressDialog(getContext());
        progressDialog.show();
        RestInvokerService restInvokerService = RestClient.getClient().create(RestInvokerService.class);
        Call<List<ShopkeeperBean>> call = restInvokerService.getShopkeeperList();
        call.enqueue(new Callback<List<ShopkeeperBean>>() {
            @Override
            public void onResponse(Call<List<ShopkeeperBean>> call, Response<List<ShopkeeperBean>> response) {
                shopkeeperBeanList = response.body();
                ShopkeeperListAdapter shopkeeperListAdapter = new ShopkeeperListAdapter(getContext(),shopkeeperBeanList);
                progressDialog.dismiss();
                recyclerView.setAdapter(shopkeeperListAdapter);
            }

            @Override
            public void onFailure(Call<List<ShopkeeperBean>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}