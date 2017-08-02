package com.example.user.geotask.screen.baseContainerActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.example.user.geotask.R;
import com.example.user.geotask.model.places.Prediction;
import com.example.user.geotask.screen.beginningPathFragment.BeginningPathPageFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by User on 31.07.2017.
 */

public class MapDialogFragment extends DialogFragment implements OnMapReadyCallback {
    private static final String ARG_PARAM_LAT = "param1";
    private static final String ARG_PARAM_LNG = "param2";

    private GoogleMap mMap;
    private LatLng latLng;

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public static MapDialogFragment newInstance(double lat, double lng) {
        MapDialogFragment fragment = new MapDialogFragment();
        Bundle args = new Bundle();
        args.putDouble(ARG_PARAM_LAT, lat);
        args.putDouble(ARG_PARAM_LNG, lng);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Bundle args = getArguments();
            this.latLng = new LatLng(args.getDouble(ARG_PARAM_LAT), args.getDouble(ARG_PARAM_LNG));
        }
        View rootView = inflater.inflate(R.layout.map_dialog_fragment, container, false);
        SupportMapFragment mapFragment = new SupportMapFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.mapView, mapFragment).commit();


        mapFragment.getMapAsync(this);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.ivCancel);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
//        LatLng sydney = new LatLng(46.482526, 30.7233095);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(5), 1000, null);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

    }
}
