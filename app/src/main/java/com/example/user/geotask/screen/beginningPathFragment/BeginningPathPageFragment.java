package com.example.user.geotask.screen.beginningPathFragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.user.geotask.R;
import com.example.user.geotask.model.places.Places;
import com.example.user.geotask.model.places.Prediction;
import com.example.user.geotask.repository.PlacesRepository;
import com.example.user.geotask.repository.local.GeoLocalDataSource;
import com.example.user.geotask.repository.remote.GeoRemoteDataSource;
import com.example.user.geotask.screen.baseContainerActivity.BeginningPathRecyclerAdapter;
import com.example.user.geotask.screen.baseContainerActivity.MapDialogFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


public class BeginningPathPageFragment extends Fragment implements BeginningPathContract.View {

    private EditText etPlaces;
    private RecyclerView recyclerView;
    private BeginningPathRecyclerAdapter beginningPathRecyclerAdapter;
    private ConstraintLayout constraintLayout;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    BeginningPathContract.Presenter presenter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BeginningPathPageFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static BeginningPathPageFragment newInstance(String param1, String param2) {
        BeginningPathPageFragment fragment = new BeginningPathPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.beginning_path_fragment, container, false);
        presenter = new BeginningPathPresenter(this, PlacesRepository.getInstance(GeoRemoteDataSource.getInstance(), GeoLocalDataSource.getInstance(getContext())));
        init(view);
        return view;
    }

    private void init(View view) {
        beginningPathRecyclerAdapter = new BeginningPathRecyclerAdapter(position -> {
            Snackbar bar = Snackbar.make(getActivity().findViewById(R.id.main_container), "Показати на карті?", Snackbar.LENGTH_SHORT);

            bar.setAction("open", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  presenter.getDetailsPlace(position.getPlaceId());
                }
            });
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            bar.show();


        }, new ArrayList<>());

        recyclerView = (RecyclerView) view.findViewById(R.id.rvPlaces);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(beginningPathRecyclerAdapter);
        etPlaces = (EditText) view.findViewById(R.id.etPlaces);

        etPlaces.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.getPlacesByWord(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showNewPlaces(Places places) {
        ((BeginningPathRecyclerAdapter) recyclerView.getAdapter()).setPlaces((ArrayList<Prediction>) places.getPredictions());
    }

    @Override
    public void showPlacesInMap(double lat, double lng) {
        MapDialogFragment mapDialogFragment=MapDialogFragment.newInstance(lat,lng);
//        MapDialogFragment mapDialogFragment=new MapDialogFragment();
//        mapDialogFragment.setLatLng(new LatLng(lat,lng));
        mapDialogFragment.show(getActivity().getSupportFragmentManager(),"map");
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
