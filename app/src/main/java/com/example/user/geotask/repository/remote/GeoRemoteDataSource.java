package com.example.user.geotask.repository.remote;

import android.support.annotation.NonNull;

import com.example.user.geotask.model.placeDetails.PlaceDetails;
import com.example.user.geotask.model.places.Places;
import com.example.user.geotask.repository.Repository;
import com.example.user.geotask.source.network.NetworkFactory;

import retrofit2.Call;
import retrofit2.Response;


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
    public void getPlaces(String places, @NonNull Callback callback) {
        Call<Places> call = NetworkFactory.getService().getPlaces(places);
        call.enqueue(new retrofit2.Callback<Places>() {
            @Override
            public void onResponse(Call<Places> call, Response<Places> response) {
                callback.onLoaded(response.body());
//                Places places1=response.body();
            }

            @Override
            public void onFailure(Call<Places> call, Throwable t) {

            }
        });

    }

    @Override
    public void getPlaceDetail(String id, @NonNull Callback callback) {
        Call<PlaceDetails> pdCall = NetworkFactory.getService().getPlaceDetail(id);
        pdCall.enqueue(new retrofit2.Callback<PlaceDetails>() {
            @Override
            public void onResponse(Call<PlaceDetails> call, Response<PlaceDetails> response) {
                callback.onLoaded(response.body());
            }

            @Override
            public void onFailure(Call<PlaceDetails> call, Throwable t) {

            }
        });

    }
}
