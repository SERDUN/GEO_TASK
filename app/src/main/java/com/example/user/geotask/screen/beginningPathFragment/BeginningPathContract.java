package com.example.user.geotask.screen.beginningPathFragment;

import com.example.user.geotask.BasePresenter;
import com.example.user.geotask.BaseView;
import com.example.user.geotask.model.places.Places;

import java.util.ArrayList;

/**
 * Created by User on 28.07.2017.
 */

public class BeginningPathContract {
    public interface View extends BaseView {
        public void  showNewPlaces(Places places);

    }

    public  interface Presenter extends BasePresenter {

        public void getPlacesByWord(String place);
    }
}
