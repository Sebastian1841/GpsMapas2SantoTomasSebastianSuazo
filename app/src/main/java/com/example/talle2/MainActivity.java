package com.example.talle2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;
    List<LatLng> ubicaciones = new ArrayList<>();
    List<String> nombres = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud = findViewById(R.id.txt_Latitud);
        txtLongitud = findViewById(R.id.txt_longitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

        ubicaciones.add(new LatLng(-18.4849969619178, -70.30299458652735));
        ubicaciones.add(new LatLng(-20.210561215364717, -70.1437796652317));
        ubicaciones.add(new LatLng(-23.64769067207556, -70.39116181433201));
        ubicaciones.add(new LatLng(-29.918837, -71.253256));
        ubicaciones.add(new LatLng(-33.011550, -71.545733));
        ubicaciones.add(new LatLng(-33.443639, -70.621272));
        ubicaciones.add(new LatLng(-35.445098, -71.688130));
        ubicaciones.add(new LatLng(-36.810485, -73.072274));
        ubicaciones.add(new LatLng(-37.463771, -72.349229));
        ubicaciones.add(new LatLng(-38.734563, -72.602294));
        ubicaciones.add(new LatLng(-39.836375, -73.228724));
        ubicaciones.add(new LatLng(-40.573049, -73.133102));
        ubicaciones.add(new LatLng(-41.464489, -72.961174));

        nombres.add("Sede Arica");
        nombres.add("Sede Iquique");
        nombres.add("Sede Antofagasta");
        nombres.add("Sede La Serena");
        nombres.add("Sede Viña del Mar");
        nombres.add("Sede Santiago");
        nombres.add("Sede Talca");
        nombres.add("Sede Concepcion");
        nombres.add("Sede Los Angeles");
        nombres.add("Sede Temuco");
        nombres.add("Sede Valdivia");
        nombres.add("Sede Osorno");
        nombres.add("Sede Puerto Montt");

        VideoView Mivideito = findViewById(R.id.videito);

        String videito = "android.resource://"+ getPackageName()+"/"+R.raw.santo;

        Uri uri = Uri.parse(videito);
        Mivideito.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(Mivideito);
        Mivideito.start();



    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setText("" + latLng.latitude);
        txtLongitud.setText("" + latLng.longitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLatitud.setText("" + latLng.latitude);
        txtLongitud.setText("" + latLng.longitude);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        for (int i = 0; i < ubicaciones.size(); i++) {
            LatLng ubicacion = ubicaciones.get(i);
            String nombre = nombres.get(i);
            mMap.addMarker(new MarkerOptions().position(ubicacion).title(nombre));
        }

        if (!ubicaciones.isEmpty()) {
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicaciones.get(0)));
        }
    }
}
