package com.example.user.geotask.repository;

import android.support.annotation.NonNull;

/**
 * Created by Serdun on 16.07.2017.
 */

public interface Repository {

    interface Callback<T> {

        void onLoaded(T o);

        void onDataNotAvailable();
    }


    void getPlaces(String places,@NonNull Callback callback);
    void getPlaceDetail(String id,@NonNull Callback callback);


}
