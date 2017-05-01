package com.example.dyagilev.vsurest.api;

import com.example.dyagilev.vsurest.Pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dyagilev on 23.03.2017.
 */

public interface IMyInterface {
    @GET("/Service1.svc/findAll")
    Call<List<Pojo>> getItems();
}
