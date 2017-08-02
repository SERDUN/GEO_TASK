package com.example.user.geotask.screen.baseContainerActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.user.geotask.R;
import com.example.user.geotask.model.places.Prediction;
import com.example.user.geotask.screen.baseContainerActivity.listener.RecyclerViewListener;

import java.util.ArrayList;


public class BeginningPathRecyclerAdapter extends RecyclerView.Adapter<BeginningPathRecyclerAdapter.PlaceHolder> {
    private ArrayList<Prediction> predictions;
    private RecyclerViewListener recyclerViewListener;
    private int lastCheckedPosition = -1;


    public int getLastCheckedPosition() {
        return lastCheckedPosition;
    }

    public BeginningPathRecyclerAdapter(RecyclerViewListener recyclerViewListener, ArrayList<Prediction> predictions) {
        this.recyclerViewListener = recyclerViewListener;
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
        holder.bindView(predictions.get(position));
        holder.select.setChecked(position == lastCheckedPosition);


    }

    @Override
    public int getItemCount() {
        return predictions.size();
    }

    class PlaceHolder extends RecyclerView.ViewHolder {
        TextView tvCountry;
        TextView tvCity;
        RadioButton select;

        public PlaceHolder(View itemView) {
            super(itemView);
            tvCountry = (TextView) itemView.findViewById(R.id.tvCountry);
            tvCity = (TextView) itemView.findViewById(R.id.tvCity);
            select = (RadioButton) itemView.findViewById(R.id.rbSelect);

            itemView.setOnClickListener(v -> {
                lastCheckedPosition = getAdapterPosition();
                notifyItemRangeChanged(0, predictions.size());
                notifyItemChanged(lastCheckedPosition);
                recyclerViewListener.onClick(predictions.get(getAdapterPosition()));
            });
        }

        public void bindView(Prediction p) {
            tvCountry.setText(p.getTerms().get(p.getTerms().size() - 1).getValue());
            tvCity.setText(p.getDescription());


        }
    }


}
