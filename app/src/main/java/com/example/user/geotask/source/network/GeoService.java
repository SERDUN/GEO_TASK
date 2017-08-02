package com.example.user.geotask.source.network;

import com.example.user.geotask.model.placeDetails.PlaceDetails;
import com.example.user.geotask.model.places.Places;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Serdun on 16.07.2017.
 */

public interface GeoService {
    @GET("maps/api/place/autocomplete/json?sensor=false&types=(cities)")
    public Call<Places> getPlaces(@Query("input") String place);

    @GET("/maps/api/place/details/json")
    public Call<PlaceDetails> getPlaceDetail(@Query("placeid") String id);

}
