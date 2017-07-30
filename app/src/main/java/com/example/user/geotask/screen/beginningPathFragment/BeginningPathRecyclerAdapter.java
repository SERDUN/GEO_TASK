package com.example.user.geotask.screen.beginningPathFragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.geotask.R;
import com.example.user.geotask.model.places.Places;
import com.example.user.geotask.model.places.Prediction;

import java.util.ArrayList;

/**
 * Created by User on 29.07.2017.
 */

public class BeginningPathRecyclerAdapter extends RecyclerView.Adapter<BeginningPathRecyclerAdapter.PlaceHolder> {

    ArrayList<Prediction> predictions;

    public BeginningPathRecyclerAdapter(ArrayList<Prediction> predictions) {
        this.predictions = predictions;
    }


    public void setPlaces(ArrayList<Prediction> places) {
        predictions = places;
        notifyDataSetChanged();

    }

    @Override
    public PlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.place_item_view, parent, false);
        return new PlaceHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceHolder holder, int position) {
        int f=4;
        holder.bindView(predictions.get(position));

    }

    @Override
    public int getItemCount() {
        return predictions.size();
    }

    class PlaceHolder extends RecyclerView.ViewHolder {
        private TextView tvCountry;
        private TextView tvCity;

        public PlaceHolder(View itemView) {
            super(itemView);
            tvCountry = (TextView) itemView.findViewById(R.id.tvCountry);
            tvCity = (TextView) itemView.findViewById(R.id.tvCity);
        }

        public void bindView(Prediction p) {
            tvCountry.setText(p.getTerms().get(p.getTerms().size()-1).getValue());
            tvCity.setText(p.getDescription());


        }
    }


}
