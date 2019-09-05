package com.example.toturialandroidtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ir.map.sdk_map.annotations.IconFactory;
import ir.map.sdk_map.annotations.Marker;
import ir.map.sdk_map.annotations.MarkerOptions;
import ir.map.sdk_map.geometry.LatLng;
import ir.map.sdk_map.maps.MapirMap;
import ir.map.sdk_map.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity {

    private LatLng TEHRAN = new LatLng(35.732521, 51.422575);
    private MapirMap mapirMap;
    private Marker mTehran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap source = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_announcement_black, options);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView);
        supportMapFragment.getMapAsync(mapirMap -> {
            MainActivity.this.mapirMap = mapirMap;
            if (MainActivity.this.mapirMap != null) // Checks if we were successful in obtaining the map
                //mTehran object holds marker instance for future use like remove marker from Map
                mTehran = mapirMap.addMarker(new MarkerOptions()
                        .position(TEHRAN)
                        .title("تهران")
                        .setIcon(IconFactory.recreate("ic_announcement_black" , source))
                        .snippet("جمعیت : 8,627,30 نفر"));
        });
    }

}
