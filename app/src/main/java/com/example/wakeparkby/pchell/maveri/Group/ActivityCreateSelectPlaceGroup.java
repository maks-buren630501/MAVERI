package com.example.wakeparkby.pchell.maveri.Group;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.LocationSelection.ActivityDateSelection;
import com.example.wakeparkby.pchell.maveri.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityCreateSelectPlaceGroup extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {
    private Button buttonEnter;
    private GoogleMap mMap;
    private Marker marker;
    private LatLng latLng;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        buttonEnter = findViewById(R.id.buttonAddCoordinates);
        buttonEnter.setOnClickListener(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (latLng != null) {
            mMap.addMarker(new MarkerOptions().position(latLng).title("Место встречи"));
            //  mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
            CameraUpdate centre = CameraUpdateFactory.newLatLng(latLng);
            mMap.moveCamera(centre);
            mMap.animateCamera(zoom);
        } else {
            LatLng latLng1 = new LatLng(53.907211, 27.558678);
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);
            CameraUpdate centre = CameraUpdateFactory.newLatLng(latLng1);
            mMap.moveCamera(centre);
            mMap.animateCamera(zoom);
        }
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (marker == null) {
                    marker = mMap.addMarker(new MarkerOptions().position(latLng).title("Место встречи"));
                    setLatLng(latLng);
                } else {
                    mMap.clear();
                    marker = null;
                }
            }
        });
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    @Override
    public void onClick(View v) {
        String password = null;
        String coordinates = String.valueOf(latLng.latitude + "," + latLng.longitude);
        Intent intent_group = new Intent(this, ActivityGroup.class);
        Toast.makeText(this, "Группа успешно добавлена !",
                Toast.LENGTH_SHORT).show();
        if (getIntent().getStringExtra("Status").equals("1"))
        {
            password = getIntent().getStringExtra("Password");
        }
        CreateGroupController createGroupController = new CreateGroupController(getIntent().getStringExtra("Status"),
                getIntent().getStringExtra("Date"), getIntent().getStringExtra("Time"), getIntent().getStringExtra("Name"),
                getIntent().getStringExtra("Description"), coordinates, password, this, intent_group);
    }
}
