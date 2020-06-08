package br.com.branch.testes.Telas;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.branch.testes.R;

public class TelaAvalicao extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_avaliacao);



    }

    public void OnClickMeAvalia(View v){


        try{

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+"br.com.branch.afimdefeira")));


        }catch (ActivityNotFoundException e){

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.goolge.com/store/apps/details?id="+getPackageName())));
        }
    }

}
