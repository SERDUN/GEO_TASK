package com.example.user.geotask.screen.endRoadFragment;

import com.example.user.geotask.model.places.Places;
import com.example.user.geotask.repository.Repository;
import com.example.user.geotask.screen.beginningPathFragment.BeginningPathContract;

/**
 * Created by User on 28.07.2017.
 */

public class EndRoadPresenter implements BeginningPathContract.Presenter {
    private EndRoadContract.View view;
    private Repository repository;

    public EndRoadPresenter(EndRoadContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void init() {

    }

    @Override
    public void getPlacesByWord(String place) {
        repository.getPlaces(place, new Repository.Callback() {
            @Override
            public void onLoaded(Object o) {
                view.showNewPlaces((Places) o);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

    }

    @Override
    public void getDetailsPlace(String placeId) {

    }
}
