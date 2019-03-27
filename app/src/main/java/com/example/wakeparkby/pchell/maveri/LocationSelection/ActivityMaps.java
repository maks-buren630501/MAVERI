package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng latLng; //= new LatLng(18.5259949,109.3576236);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (latLng!=null){
            mMap.addMarker(new MarkerOptions().position(latLng).title("Место встречи"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        }
        else
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(ActivityMaps.this, "НАЖАТИЕ НА КАРТУ", Toast.LENGTH_SHORT).show();
                mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
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
}