package com.example.user.geotask.screen.endRoadFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.user.geotask.R;
import com.example.user.geotask.model.places.Places;
import com.example.user.geotask.model.places.Prediction;
import com.example.user.geotask.repository.PlacesRepository;
import com.example.user.geotask.repository.local.GeoLocalDataSource;
import com.example.user.geotask.repository.remote.GeoRemoteDataSource;
import com.example.user.geotask.screen.baseContainerActivity.BeginningPathRecyclerAdapter;
import com.example.user.geotask.screen.beginningPathFragment.BeginningPathContract;
import com.example.user.geotask.screen.endRoadFragment.EndRoadContract;

import java.util.ArrayList;


public class EndRoadPageFragment extends Fragment implements EndRoadContract.View {

    private EditText etPlaces;
    private RecyclerView recyclerView;
    private BeginningPathRecyclerAdapter beginningPathRecyclerAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    BeginningPathContract.Presenter presenter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EndRoadPageFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static EndRoadPageFragment newInstance(String param1, String param2) {
        EndRoadPageFragment fragment = new EndRoadPageFragment();
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

        View view = inflater.inflate(R.layout.fragment_setting_second_page, container, false);
        presenter = new EndRoadPresenter(this, PlacesRepository.getInstance(GeoRemoteDataSource.getInstance(), GeoLocalDataSource.getInstance(getContext())));
        init(view);
        return view;
    }

    private void init(View view) {
        beginningPathRecyclerAdapter = new BeginningPathRecyclerAdapter(position -> {

        },new ArrayList<>());

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
        ((BeginningPathRecyclerAdapter)recyclerView.getAdapter()).setPlaces((ArrayList<Prediction>) places.getPredictions());
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
