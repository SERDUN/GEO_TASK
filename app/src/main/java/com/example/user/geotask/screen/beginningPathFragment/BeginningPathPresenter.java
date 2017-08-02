package com.example.user.geotask.screen.beginningPathFragment;

import com.example.user.geotask.model.placeDetails.PlaceDetails;
import com.example.user.geotask.model.places.Places;
import com.example.user.geotask.repository.Repository;

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
        repository.getPlaceDetail(placeId, new Repository.Callback() {
            @Override
            public void onLoaded(Object o) {
                PlaceDetails placeDetails = (PlaceDetails) o;
                view.showPlacesInMap(((PlaceDetails) o).getResult().getGeometry().getLocation().getLat(),
                        ((PlaceDetails) o).getResult().getGeometry().getLocation().getLng());
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }
}
