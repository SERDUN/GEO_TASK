package com.example.user.geotask.repository;

import android.support.annotation.NonNull;

import com.example.user.geotask.places.Places;

import java.util.List;

/**
 * Created by Serdun on 16.07.2017.
 */

public interface Repository {

    interface LoadWeathersCallback {

        void onWeathersLoaded(List<Places> weathers);

        void onDataNotAvailable();
    }

    interface GetWeatherCallback {

        void onWeatherLoaded(Places weather);

        void onDataNotAvailable();
    }

    void getWeathers(@NonNull LoadWeathersCallback callback);

    void getWeathers(@NonNull GetWeatherCallback callback);

}
