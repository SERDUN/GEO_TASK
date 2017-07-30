package com.example.user.geotask.repository;

import android.support.annotation.NonNull;

import com.example.user.geotask.model.places.Places;

import java.util.Map;

/**
 * Created by Serdun on 16.07.2017.
 */

public class PlacesRepository implements Repository {

    private static PlacesRepository INSTANCE = null;

    private final Repository remoteRepository;

    private final Repository localRepository;

    Map<String, Places> cachedWeathers;

    private boolean cacheIsDirty = false;

    private PlacesRepository(@NonNull Repository remoteRepository, @NonNull Repository localRepository) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
    }

    public static PlacesRepository getInstance(Repository tasksRemoteDataSource,
                                               Repository tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new PlacesRepository(tasksRemoteDataSource, tasksLocalDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public void getPlaces(String places, @NonNull PlaceCallback callback) {
        remoteRepository.getPlaces(places, callback);
    }
}
