package com.resources;

import com.beans.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInvokerService {

    @GET("data")
    Call<List<Country>> getTopRatedMovies();

}
