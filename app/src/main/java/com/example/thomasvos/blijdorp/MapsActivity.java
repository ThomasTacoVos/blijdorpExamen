package com.example.thomasvos.blijdorp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

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
        int route = getIntent().getIntExtra("ROUTE", 0);

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

        LatLng Ingang2 = new LatLng( 51.925530, 4.454018);
        mMap.addMarker(new MarkerOptions().position(Ingang2).title("De tweede ingang"));

        if (route == 1) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Hoofdingang, 16f));
            LatLng Ijsberen = new LatLng(51.927349, 4.445087);
            mMap.addMarker(new MarkerOptions().position(Ijsberen).title("Ijsberenverblijf 10:00 en 14:00"));

            LatLng Bizonverblijf = new LatLng(51.927530, 4.446149);
            mMap.addMarker(new MarkerOptions().position(Bizonverblijf).title("Bizonverblijf 10:30 en 14:30"));

            LatLng Oceanium = new LatLng(51.928613, 4.445264);
            mMap.addMarker(new MarkerOptions().position(Oceanium).title("Oceanium 11:00 en 15:00"));

//            LatLng Leeuwen = new LatLng(51.928387, 4.449838);
//            mMap.addMarker(new MarkerOptions().position(Leeuwen).title("Leeuwen 10:00 en 14:00"));
//
//            LatLng Amazonica = new LatLng(51.927984, 4.447261);
//            mMap.addMarker(new MarkerOptions().position(Amazonica).title("Amazonica 10:30 en 14:30"));
//
//            LatLng Vogelvoorstelling = new LatLng(51.927205, 4.446924);
//            mMap.addMarker(new MarkerOptions().position(Vogelvoorstelling).title("Vogelvoorstelling 11:00 en 15:00"));

        }

        else if (route ==2) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ingang2, 17f));
//            LatLng Leeuwen = new LatLng(51.928387, 4.449838);
//            mMap.addMarker(new MarkerOptions().position(Leeuwen).title("Leeuwen 10:00 en 14:00"));
//
//            LatLng Amazonica = new LatLng(51.927984, 4.447261);
//            mMap.addMarker(new MarkerOptions().position(Amazonica).title("Amazonica 10:30 en 14:30"));
//
//            LatLng Vogelvoorstelling = new LatLng(51.927205, 4.446924);
//            mMap.addMarker(new MarkerOptions().position(Vogelvoorstelling).title("Vogelvoorstelling 11:00 en 15:00"));

//
            LatLng Kamelen = new LatLng(51.927962, 4.453940);
            mMap.addMarker(new MarkerOptions().position(Kamelen).title("Kamelen 10:00 en 14:00"));


            LatLng Apen = new LatLng(51.927051, 4.452571);
            mMap.addMarker(new MarkerOptions().position(Apen).title("Apen 10:30 en 14:30"));

            LatLng Vogels = new LatLng(51.926558, 4.453153);
            mMap.addMarker(new MarkerOptions().position(Vogels).title("Aziatische vogels 11:00 en 15:00"));


        }


    }

    public void startMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
