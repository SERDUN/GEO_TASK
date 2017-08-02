package com.example.user.geotask.screen.endRoadFragment;

import com.example.user.geotask.BasePresenter;
import com.example.user.geotask.BaseView;
import com.example.user.geotask.model.places.Places;

/**
 * Created by User on 28.07.2017.
 */

public class EndRoadContract {
    public interface View extends BaseView {
        public void  showNewPlaces(Places places);

    }

    public  interface Presenter extends BasePresenter {

        public void getPlacesByWord(String place);
    }
}
