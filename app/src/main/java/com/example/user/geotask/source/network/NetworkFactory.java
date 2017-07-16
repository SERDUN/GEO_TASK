package com.example.user.geotask.source.network;


import com.example.user.geotask.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Serdun on 16.07.2017.
 */

public class NetworkFactory {
    private static GeoService service;
    private static OkHttpClient okHttpClient;


    public static GeoService getService() {
        GeoService currentService = service;
        if (currentService == null) {
            synchronized (NetworkFactory.class) {
                if (currentService == null) {
                    currentService = service = getRetrofitBuilder().create(GeoService.class);
                }
            }
        }
        return currentService;
    }


    private static Retrofit getRetrofitBuilder() {
        return new Retrofit.Builder().client(getOkHttpClient())
                .baseUrl(BuildConfig.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient client = okHttpClient;
        if (client == null) {
            synchronized (NetworkFactory.class) {
                client = okHttpClient;
                if (client == null) {
                    client = okHttpClient = buildOkHttpClient();
                }
            }
        }
        return client;
    }

    private static OkHttpClient buildOkHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(new GeoInterceptor()).build();
    }
}
