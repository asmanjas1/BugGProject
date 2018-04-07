package com.viewAdapter;


import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.beans.Order;
import com.consumer_fragments.ConsumerCommonOrderFragment;
import com.practiceapp.ConsumerActivity;
import com.practiceapp.R;

import java.util.List;

public class ConsumerOrderAdapter extends RecyclerView.Adapter<ConsumerOrderAdapter.OrderViewHolder>{
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the Orders in a list
    private List<Order> orderList;

    public ConsumerOrderAdapter(Context ctx, List<Order> orderList){
        this.mCtx = ctx;
        this.orderList = orderList;
    }
    @Override
    public void onBindViewHolder(ConsumerOrderAdapter.OrderViewHolder holder, int position) {
        //getting the Order of the specified position
        Order order = orderList.get(position);
        //binding the data with the viewholder views
        holder.bindData(order);
    }

    @Override
    public ConsumerOrderAdapter.OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.generalorderlayoutforconsumer, null);
        return new ConsumerOrderAdapter.OrderViewHolder(view);
       /* View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.generalorderlayoutforshopkeeper, parent, false);

        return new OrderViewHolder(itemView);*/
    }


    @Override
    public int getItemCount() {
        return orderList.size();
    }


    class OrderViewHolder extends RecyclerView.ViewHolder {

        Order orderSelected;
        TextView textViewOrderId, textViewShopkeeperName, textViewOrderDate, textViewOrderAmount;
       /* ImageView imageView;*/

        public OrderViewHolder(View itemView) {
            super(itemView);
            textViewOrderId = (TextView) itemView.findViewById(R.id.textViewOrderId);
            textViewShopkeeperName = (TextView) itemView.findViewById(R.id.textViewShopkeeperName);
            textViewOrderDate = (TextView) itemView.findViewById(R.id.textViewOrderDate);
            textViewOrderAmount = (TextView) itemView.findViewById(R.id.textViewOrderAmount);
           /* imageView = (ImageView) itemView.findViewById(R.id.imageView);*/
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Fragment fragment = new ConsumerCommonOrderFragment();
                   FragmentManager fragmentManager = ((ConsumerActivity) mCtx).getSupportFragmentManager();// this is basically context of the class
                   FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   Bundle bundle=new Bundle(); //key and value
                   bundle.putSerializable("OrderSelected",orderSelected);//set Fragmentclass Arguments
                   fragment.setArguments(bundle);
                   fragmentTransaction.replace(R.id.frame_layout_consumer, fragment);
                   fragmentTransaction.addToBackStack(null);
                   fragmentTransaction.commit();
               }
           });
        }

        public void bindData(Order order){
            orderSelected = order;
            textViewOrderId.setText(String.valueOf(order.getOrderId()));
            textViewShopkeeperName.setText(order.getShopkeeperBean().toString());
            textViewOrderDate.setText(String.valueOf(order.getOrderDate().getTime()));
            textViewOrderAmount.setText(String.valueOf(order.getOrderAmount()));
            /*imageView.setImageDrawable(mCtx.getResources().getDrawable(Order.getImage()));*/

        }
    }
}
