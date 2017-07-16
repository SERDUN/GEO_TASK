package com.example.user.geotask.repository;

import android.content.Context;
import android.support.annotation.NonNull;


import com.example.user.geotask.repository.local.GeoLocalDataSource;
import com.example.user.geotask.repository.remote.GeoRemoteDataSource;

/**
 * Created by Serdun on 16.07.2017.
 */

public class Injection {
    public static WeatherRepository provideWeathersRepository(@NonNull Context context) {
        return WeatherRepository.getInstance(GeoLocalDataSource.getInstance(context),
                GeoRemoteDataSource.getInstance());
    }
}
