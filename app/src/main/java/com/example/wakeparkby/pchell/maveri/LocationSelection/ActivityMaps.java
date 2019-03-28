package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.R;
import com.example.wakeparkby.pchell.maveri.SignIn.ActivitySignIn;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityMaps extends FragmentActivity implements OnMapReadyCallback , View.OnClickListener{
    Button buttonAddCoordinates;
    private GoogleMap mMap;
    private Marker marker;
    private LatLng latLng;
    private String coordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        buttonAddCoordinates = findViewById(R.id.buttonAddCoordinates);
        buttonAddCoordinates.setOnClickListener((View.OnClickListener) this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (getIntent().getStringExtra("coordinates") != null){
            String[] latLng = getIntent().getStringExtra("coordinates").split(",");
            double latitude = Double.parseDouble(latLng[0]);
            double longitude = Double.parseDouble(latLng[1]);
            this.latLng = new LatLng(latitude, longitude);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (latLng!=null){
            mMap.addMarker(new MarkerOptions().position(latLng).title("Место встречи"));
          //  mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
            CameraUpdate centre = CameraUpdateFactory.newLatLng(latLng);
            mMap.moveCamera(centre);
            mMap.animateCamera(zoom);
        }
        else {
            LatLng latLng1 = new LatLng(53.907211, 27.558678 );
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);
            CameraUpdate centre = CameraUpdateFactory.newLatLng(latLng1);
            mMap.moveCamera(centre);
            mMap.animateCamera(zoom);
        }
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (marker == null){
                    marker = mMap.addMarker(new MarkerOptions().position(latLng).title("Место встречи"));
                    setLatLng(latLng);
                }
                else {
                    mMap.clear();
                    marker = null;
                }
            }
        });
    }

    public boolean onMarkerClick(Marker marker) {
        Integer clickCount = (Integer) marker.getTag();

        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if(latLng != null){
            this.coordinates = String.valueOf(latLng.latitude +","+ latLng.longitude);
            Intent intent_data = new Intent(this,ActivityDateSelection.class);
            intent_data.putExtra("coordinates",coordinates);
            intent_data.putExtra("name","Бар <<Веселая Пчелка>>");
            AdapterMapsDataTime.startActivity(this,intent_data);
        }
        else {
            Toast.makeText(ActivityMaps.this, "Установите отметку", Toast.LENGTH_SHORT).show();
        }
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}