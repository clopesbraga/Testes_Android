package br.com.branch.testes.Telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAd;

import br.com.branch.testes.R;

public class TelaPropaganda extends AppCompatActivity {

    private AdView propagandaBannerAd,adv2;
    private InterstitialAd propagandaInterstitialAd;
    private InterstitialAd propagandaInterstitialVideo;
            AdLoader        propagandaNativa;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_propaganda);

       //MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");

        //PROPAGANDA INTERESTITIAL
        propagandaInterstitialAd = new InterstitialAd(this);
        propagandaInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        //PROPAGANDA INTERESTITIAL VIDEO
        propagandaInterstitialVideo = new InterstitialAd(this);
        propagandaInterstitialVideo.setAdUnitId("ca-app-pub-3940256099942544/8691691433");

        //PROPAGANDA BANNER
        propagandaBannerAd = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        propagandaBannerAd.loadAd(adRequest);

    }

    public void onResume(){
        super.onResume();

        propagandaInterstitialAd.loadAd(new AdRequest.Builder().build());
        propagandaInterstitialVideo.loadAd(new AdRequest.Builder().build());
        propagandaNativa.loadAd(new AdRequest.Builder().build());

    }

    public void propagandaOnClick(View vpropaganda){

        switch(vpropaganda.getId()){

            case R.id.btn_propInterestitial:
                if(propagandaInterstitialAd.isLoaded()){
                propagandaInterstitialAd.show();
            }else{
                Log.d("TAG","A propaganda ainda não rodou");
            }break;

            case R.id.btn_propagandavideo:
                if(propagandaInterstitialVideo.isLoaded()){
                    propagandaInterstitialVideo.show();
                }else{
                    Log.d("TAG","A propaganda video ainda não rodou");
                }break;


        }


    }



}
