package com.resources;

import com.beans.Country;
import com.beans.ShopkeeperBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInvokerService {

    @GET("data")
    Call<List<Country>> getTopRatedMovies();

    @GET("getShopkeeperList")
    Call<List<ShopkeeperBean>> getShopkeeperList();

}
