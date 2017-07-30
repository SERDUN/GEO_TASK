package com.example.user.geotask.source.network;


import android.util.Log;

import com.example.user.geotask.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

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
        Log.d("test_iterapt", "intercept: "+request.url());
        return chain.proceed(request);
    }
}
