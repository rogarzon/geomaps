package com.rogarzonc87.geomaps.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rogarzonc87.geomaps.R;
import com.rogarzonc87.geomaps.pojos.Place;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder> {
    private List<Place> placeList;
    private OnClickPlaceListener clickPlaceListener;

    public PlaceAdapter(Collection<Place> places) {
        placeList = new ArrayList<>();
        placeList.addAll(places);
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new PlaceHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, int position) {
        Place p = placeList.get(position);
        holder.bind(p);
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public void setClickPlaceListener(OnClickPlaceListener listener) {
        this.clickPlaceListener = listener;
    }

    public class PlaceHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private ImageView ivImage;

        public PlaceHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivImage = itemView.findViewById(R.id.ivImage);
        }

        public void bind(@NonNull Place p) {
            tvTitle.setText(p.getTitle());
            Picasso.get().load(p.getImage()).into(ivImage);
            itemView.setOnClickListener(v -> {
                if (clickPlaceListener != null) {
                    clickPlaceListener.onClickPlace(p);
                }
            });
        }
    }

    public interface OnClickPlaceListener {
        void onClickPlace(Place place);
    }
}
