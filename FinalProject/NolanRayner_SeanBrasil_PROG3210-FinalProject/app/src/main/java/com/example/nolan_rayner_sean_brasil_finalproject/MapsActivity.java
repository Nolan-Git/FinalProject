package com.example.nolan_rayner_sean_brasil_finalproject;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.nolan_rayner_sean_brasil_finalproject.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        //grabs 2 arrays from the string.xml file adn stores them
        String[] placeNames = getResources().getStringArray(R.array.name);
        String[] placeCoordinates = getResources().getStringArray(R.array.Coordinate);
        int x =0;
        //idk if we need this but added it just in case
        //for each entry in the place name string splits the same line in the second array of coords
        //creates a new long lat adress and adds a marker there with the name given.
        for (String i : placeNames) {
            //System.out.println(i);
            //System.out.println(placeCoordinates[x]);
            String[] Coords = placeCoordinates[x].split(",");
            //System.out.println(Coords[0]+" "+Coords[1] + " broken up");
            LatLng marker = new LatLng(Double.parseDouble(Coords[0]), Double.parseDouble(Coords[1]));
            mMap.addMarker(new MarkerOptions().position(marker).title(i));

            x++;
        }

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}