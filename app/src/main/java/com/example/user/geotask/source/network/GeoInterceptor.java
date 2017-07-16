package com.example.user.geotask.source.network;


import com.example.user.geotask.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Serdun on 16.07.2017.
 */

public class GeoInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url().newBuilder().addQueryParameter("key", BuildConfig.GOOGLE_MAP_KEY)
                .addQueryParameter("format", "json").build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
