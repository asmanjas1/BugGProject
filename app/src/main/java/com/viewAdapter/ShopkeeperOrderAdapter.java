package com.viewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.beans.Order;
import com.practiceapp.R;

import java.util.List;


public class ShopkeeperOrderAdapter extends RecyclerView.Adapter<ShopkeeperOrderAdapter.OrderViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the Orders in a list
    private List<Order> orderList;

    //getting the context and Order list with constructor
    public ShopkeeperOrderAdapter(Context mCtx, List<Order> orderList) {
        this.mCtx = mCtx;
        this.orderList = orderList;
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        //getting the Order of the specified position
        Order order = orderList.get(position);

        //binding the data with the viewholder views
        holder.textViewOrderId.setText(String.valueOf(order.getOrderId()));
        holder.textViewConsumerName.setText(order.getConsumerBean().toString());
        holder.textViewOrderDate.setText(String.valueOf(order.getOrderDate().getTime()));
        holder.textViewOrderAmount.setText(String.valueOf(order.getOrderAmount()));

        /*holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(Order.getImage()));*/

    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.generalorderlayoutforshopkeeper,parent, false);
        return new OrderViewHolder(view);
       /* View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.generalorderlayoutforshopkeeper, parent, false);

        return new OrderViewHolder(itemView);*/
    }


    @Override
    public int getItemCount() {
        return orderList.size();
    }


    class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView textViewOrderId, textViewConsumerName, textViewOrderDate, textViewOrderAmount;
       /* ImageView imageView;*/

        public OrderViewHolder(View itemView) {
            super(itemView);

            textViewOrderId = (TextView) itemView.findViewById(R.id.textViewOrderId);
            textViewConsumerName = (TextView) itemView.findViewById(R.id.textViewConsumerName);
            textViewOrderDate = (TextView) itemView.findViewById(R.id.textViewOrderDate);
            textViewOrderAmount = (TextView) itemView.findViewById(R.id.textViewOrderAmount);
           /* imageView = (ImageView) itemView.findViewById(R.id.imageView);*/
        }
    }
}
