package br.com.branch.testes.Telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import br.com.branch.testes.R;

public class TelaPropaganda extends AppCompatActivity {

    private AdView adv1,adv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_propaganda);

       //MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");


        adv1 = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adv1.loadAd(adRequest);


        adv2 = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adv2.loadAd(adRequest);



    }
}
