package com.example.dyagilev.vsurest.api;

import com.example.dyagilev.vsurest.NewsObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dyagilev on 23.03.2017.
 */

public interface IMyInterface {
    @GET("/Service1.svc/findAll")
    Call<List<NewsObject>> getItems();

    @GET("/Service1.svc/find/{id}")
    Call<List<NewsObject>> getItem(@Path("<id>") String variable);
}
