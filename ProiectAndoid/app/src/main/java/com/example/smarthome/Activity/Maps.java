package com.example.smarthome.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.smarthome.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    FrameLayout map;

    private Button butonnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        map=findViewById(R.id.idmaps);

        SupportMapFragment supportMapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.idmaps);

        supportMapFragment.getMapAsync(this);
        butonnext=findViewById(R.id.nextButtonmaps);
        butonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Maps.this, VremeParsare.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        this.gMap=googleMap;
        LatLng mapRo=new LatLng(44.4353, 26.1028);

        this.gMap.addMarker(new MarkerOptions().position(mapRo).title("Mark Romania"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapRo));

    }
}