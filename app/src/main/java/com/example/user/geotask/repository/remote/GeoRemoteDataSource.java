package com.example.user.geotask.repository.remote;

import android.support.annotation.NonNull;

import com.example.user.geotask.repository.Repository;


/**
 * Created by Serdun on 16.07.2017.
 */

public class GeoRemoteDataSource implements Repository {
    private static GeoRemoteDataSource INSTANCE = null;

    private GeoRemoteDataSource() {
    }

    public static GeoRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GeoRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getWeathers(@NonNull LoadWeathersCallback callback) {

    }

    @Override
    public void getWeathers(@NonNull GetWeatherCallback callback) {

    }
}
