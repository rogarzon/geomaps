package com.rogarzonc87.geomaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.rogarzonc87.geomaps.adapters.PlaceAdapter;
import com.rogarzonc87.geomaps.pojos.Place;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PlaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setOrientation(GridLayoutManager.VERTICAL);

        recyclerView = findViewById(R.id.rvPlaces);
        recyclerView.setLayoutManager(manager);
    }

    private void populateList() {
        Place[] places = new Place[] {
            new Place("Florida Atlantic University", R.raw.florida_atlantic_university,
                    26.3375554, -80.205719),
            new Place("Madeira Beach", R.raw.madeira_beach,
                    27.7955523, -82.8105351),
            new Place("Miami Beach", R.raw.miami_beach,
                    25.801165, -80.125628),
            new Place("Miami Zoo", R.raw.miami_zoo,
                    25.6126229, -80.3617599),
        };
        adapter = new PlaceAdapter(Arrays.asList(places));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        populateList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setClickPlaceListener(place -> {
            Intent i = new Intent(MainActivity.this, MapsActivity.class);
            i.putExtra("LAT", place.getLat());
            i.putExtra("LON", place.getLon());
            i.putExtra("NAME", place.getTitle());
            startActivity(i);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}