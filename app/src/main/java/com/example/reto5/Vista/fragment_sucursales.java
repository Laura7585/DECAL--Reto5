package com.example.reto5.Vista;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reto5.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class fragment_sucursales extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng bogota1 = new LatLng(4.61985, -74.12051);
            LatLng bogota2 = new LatLng(4.65309, -74.12616);
            LatLng bogota3 = new LatLng(4.66639, -74.13156);
            LatLng bogota4 = new LatLng(4.63261, -74.11563);
            googleMap.addMarker(new MarkerOptions().position(bogota1).title("Puente Aranda, Carrera 56, Bogotá"));
            googleMap.addMarker(new MarkerOptions().position(bogota2).title("Av. Boyacá #17a-65, Bogotá"));
            googleMap.addMarker(new MarkerOptions().position(bogota3).title("Cl. 20 #82 - 52, Bogotá"));
            googleMap.addMarker(new MarkerOptions().position(bogota4).title("Cra. 65 #11-50, Bogotá"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(bogota2));
            googleMap.setMinZoomPreference(13);

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