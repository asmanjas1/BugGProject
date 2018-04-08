package com.resources;

import com.beans.ConsumerBean;
import com.beans.Order;
import com.beans.ShopkeeperBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class DummyResponseResultFromRest {

    public static List<Order> getOrderList(){
        List<Order> orderList = new ArrayList<Order>();
        Order order1 = new Order(125456973, new ConsumerBean(), new ShopkeeperBean(null,null,null,null,null,null), new Date(System.currentTimeMillis()), 512.40, "General Items", "Completed");
        Order order2 = new Order(125456453, new ConsumerBean(), new ShopkeeperBean(null,null,null,null,null,null), new Date(System.currentTimeMillis()), 5189.40, "General Items", "Completed");
        Order order3 = new Order(325456973, new ConsumerBean(), new ShopkeeperBean(null,null,null,null,null,null), new Date(System.currentTimeMillis()), 71.40, "General Items", "Completed");
        Order order4 = new Order(525456973, new ConsumerBean(), new ShopkeeperBean(null,null,null,null,null,null), new Date(System.currentTimeMillis()), 612.40, "General Items", "Completed");
        Order order5 = new Order(625456973, new ConsumerBean(), new ShopkeeperBean(null,null,null,null,null,null), new Date(System.currentTimeMillis()), 12.40, "General Items", "Completed");

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);

        return orderList;
    }


}
