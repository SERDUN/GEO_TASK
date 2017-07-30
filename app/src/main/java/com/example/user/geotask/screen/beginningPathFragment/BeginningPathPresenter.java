package com.example.user.geotask.screen.beginningPathFragment;

import com.example.user.geotask.model.places.Places;
import com.example.user.geotask.repository.Repository;

import java.util.List;

/**
 * Created by User on 28.07.2017.
 */

public class BeginningPathPresenter implements BeginningPathContract.Presenter {
    private BeginningPathContract.View view;
    private Repository repository;

    public BeginningPathPresenter(BeginningPathContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void init() {

    }

    @Override
    public void getPlacesByWord(String place) {
        repository.getPlaces(place, new Repository.PlaceCallback() {
            @Override
            public void onWeatherLoaded(Places weather) {
                view.showNewPlaces(weather);
            }

            @Override
            public void onDataNotAvailable() {
                int ds = 3;

            }
        });
    }
}
