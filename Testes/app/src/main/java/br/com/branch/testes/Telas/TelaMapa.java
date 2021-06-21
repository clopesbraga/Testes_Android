package br.com.branch.testes.Telas;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.branch.testes.R;

public class TelaMapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Marker mark,mark2;
    LatLng sydney = new LatLng(-34, 151);
    LatLng saopaulo = new LatLng(-23.5652, -46.6388);
    LatLng belavista = new LatLng(-23.5489, -46.6521);


    // VARIAVEIS USADAS PARA TRAZER AS INFORMAÇÕES DO BANCO
    private GoogleMap Mymap;
    private static final int LOCAL_REQUEST = 500;


    FloatingActionButton fabteste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fabteste = findViewById(R.id.btnfab);
    }

    @Override
    protected void onResume()
    {
        super.onResume();


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;

        MarkerOptions markerTest = new MarkerOptions();

        markerTest.position(saopaulo)
                .title("Marker in Sao Paulo")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_loc));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(saopaulo));

        mark=mMap.addMarker(markerTest);


        fabteste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(saopaulo)
                        .zoom(13)
                        .build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));



            }
        });


        return;


    }

    public void inserirOnClick(View view)
    {

        MarkerOptions markerTest2 = new MarkerOptions();
        markerTest2.position(belavista)
                .title("Marker in Bela Vista")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_loc));

        mark2=mMap.addMarker(markerTest2);



    }

    public void apagarOnClick(View view)
    {


    }



    }


