package br.com.branch.testes.Servicos;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class ServButton extends AppCompatActivity {

    double lat, longi;
    float media;

    public void ServLocalizacao(String cidade,String bairro, Context ctx){

        String local= ""+cidade+","+bairro+"";

        Geocoder gc = new Geocoder(ctx);
        List<Address> list = null;
        try {
            list = gc.getFromLocationName(local, 1);

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        Address add = list.get(0);
        lat= add.getLatitude();
        longi = add.getLongitude();

    }

    public LatLng ServTrazLocalizacao(){


        LatLng local= new LatLng(lat,longi);

        return local;
    }


public void ServCamera(GoogleMap map){


    CameraPosition cameraPosition = new CameraPosition.Builder()
            .target(ServTrazLocalizacao())
            .zoom(13)
            .build();

    map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

}

public float ServCalcmedia(float num1,float num2,float num3){

    float valor = (num1+num2+num3)/3;

    media=valor;
    return media;


}



public void ServCapturaMedia(float valorDamedia){


        Float mediaSalva=  valorDamedia;


}


public void ServPorc(){


    float mediaantiga = media;





}



}
