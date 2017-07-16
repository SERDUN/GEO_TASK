package com.example.user.geotask.source.network;

import com.example.user.geotask.places.Places;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Serdun on 16.07.2017.
 */

public interface GeoService {
    @GET("/place/autocomplete/json?types=geocode")
    public Call<Places> getPlaces(@Query("input") String place);

}
