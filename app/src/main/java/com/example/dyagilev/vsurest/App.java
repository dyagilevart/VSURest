package com.example.dyagilev.vsurest;

import android.app.Application;

import com.example.dyagilev.vsurest.api.IMyInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static IMyInterface iMyInterface;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.45:50384/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iMyInterface = retrofit.create(IMyInterface.class);
    }

    public static IMyInterface getApi() {
        return iMyInterface;
    }
}
