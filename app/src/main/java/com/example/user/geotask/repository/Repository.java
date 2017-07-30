package com.example.user.geotask.repository;

import android.support.annotation.NonNull;

import com.example.user.geotask.model.places.Places;

/**
 * Created by Serdun on 16.07.2017.
 */

public interface Repository {

    interface PlaceCallback {

        void onWeatherLoaded(Places weather);

        void onDataNotAvailable();
    }


    void getPlaces(String places,@NonNull PlaceCallback callback);

}
