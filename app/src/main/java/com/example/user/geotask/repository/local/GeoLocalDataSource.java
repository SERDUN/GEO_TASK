package com.example.user.geotask.repository.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.user.geotask.repository.Repository;


/**
 * Created by Serdun on 16.07.2017.
 */

public class GeoLocalDataSource implements Repository {
    private static GeoLocalDataSource INSTANCE = null;

    private GeoLocalDataSource(Context context) {
    }

    public static GeoLocalDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new GeoLocalDataSource(context);
        }
        return INSTANCE;
    }


    @Override
    public void getPlaces(String place,@NonNull PlaceCallback callback) {
int f=4;
    }
}
