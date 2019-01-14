package com.example.thomasvos.blijdorp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            mMap.setMyLocationEnabled(true);
        }

        // Add a marker in Blijdorp and move the camera
        LatLng Hoofdingang = new LatLng(51.928193, 4.443830);
        mMap.addMarker(new MarkerOptions().position(Hoofdingang).title("Hoofdingang van Blijdorp"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Hoofdingang, 18f));

        LatLng Ingang2 = new LatLng( 51.925530, 4.454018);
        mMap.addMarker(new MarkerOptions().position(Ingang2).title("De tweede ingang"));


        LatLng Ijsberen = new LatLng( 51.927349, 4.445087);
        mMap.addMarker(new MarkerOptions().position(Ijsberen).title("Ijsberenverblijf"));

        LatLng Bizonverblijf = new LatLng( 51.927530, 4.446149);
        mMap.addMarker(new MarkerOptions().position(Bizonverblijf).title("Bizonverblijf"));

    }
}