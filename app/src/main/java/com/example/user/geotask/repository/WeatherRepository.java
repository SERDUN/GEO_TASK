package com.example.user.geotask.repository;

import android.support.annotation.NonNull;

import com.example.user.geotask.places.Places;

import java.util.Map;

/**
 * Created by Serdun on 16.07.2017.
 */

public class WeatherRepository implements Repository {

    private static WeatherRepository INSTANCE = null;

    private final Repository remoteRepository;

    private final Repository localRepository;

    Map<String, Places> cachedWeathers;

    private boolean cacheIsDirty = false;

    private WeatherRepository(@NonNull Repository remoteRepository, @NonNull Repository localRepository) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
    }

    public static WeatherRepository getInstance(Repository tasksRemoteDataSource,
                                                Repository tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new WeatherRepository(tasksRemoteDataSource, tasksLocalDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public void getWeathers(@NonNull LoadWeathersCallback callback) {

    }

    @Override
    public void getWeathers(@NonNull GetWeatherCallback callback) {

    }
}
