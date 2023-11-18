package com.example.spyridonsaridakiscvapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            Bundle bund = getArguments();
            if (bund != null) {
                // Extract data from the Bundle
                int country = bund.getInt("code");
                LatLng location=null;
                int zoom=0;
                if(country==1){
                    location = new LatLng(37.9838, 23.7275);
                    LatLng m1 = new LatLng(40.6292, 22.9474);
                    LatLng m2 = new LatLng(35.3418, 25.1482);
                    googleMap.addMarker(new MarkerOptions().position(location).title("Marker in Athens"));
                    googleMap.addMarker(new MarkerOptions().position(m1).title("Marker in Thessaloniki"));
                    googleMap.addMarker(new MarkerOptions().position(m2).title("Marker in Heraklion"));
                    zoom = 6;
                }else if(country==2){
                    location = new LatLng( 35.1855,33.3822);
                    LatLng m1 = new LatLng(34.7071,33.0226);
                    googleMap.addMarker(new MarkerOptions().position(location).title("Marker in Nicosia"));
                    googleMap.addMarker(new MarkerOptions().position(m1).title("Marker in Limassol"));
                    zoom = 8;
                }
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(location)      // Sets the center of the map to the specified location
                        .zoom(zoom)           // Sets the orientation of the camera to the east (in degrees)
                        .build();
                googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}