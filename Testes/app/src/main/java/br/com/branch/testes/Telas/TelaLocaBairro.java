package br.com.branch.testes.Telas;

import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import br.com.branch.testes.ModeloTabelas.ModeloBanco;
import br.com.branch.testes.R;
import br.com.branch.testes.Servicos.ServButton;

public class TelaLocaBairro extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Marker mark,mark2;
    LatLng saopaulo = new LatLng(-23.5652, -46.6388);



    // VARIAVEIS USADAS PARA TRAZER AS INFORMAÇÕES DO BANCO
    String[] idarray;
    String[] nomearray;
    String[] precoarray;
    String[] feiraarray;
    String[] latitudearray;
    String[] longitudearray;
    String[] enderecoarray;
    String[] bairroarray;

    // VARIAVEIS USADAS PARA TRAZER AS INFORMAÇÕES DO BANCO

    private int i;
    private GoogleMap Mymap;
    private static final int LOCAL_REQUEST = 500;
    ArrayAdapter adapter,adapter2;


    ArrayList<ModeloBanco> listamodelobanco;
    ModeloBanco modeloBanco;
    Spinner spinnercidade,spinnerbairro;
    Button btnLoc;

    //DECLARACAO DE OBJETOS
      ServButton servButton = new ServButton();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_mapa_bairro);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapbairro);
        mapFragment.getMapAsync(this);

        spinnercidade = findViewById(R.id.spinner2);
        spinnerbairro = findViewById(R.id.spinner3);
        btnLoc = findViewById(R.id.btnLoc);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Background background = new Background();
        background.execute("SAB");

        adapter = ArrayAdapter.createFromResource(getApplication(), R.array.cidades, android.R.layout.simple_spinner_dropdown_item);
        spinnercidade.setAdapter(adapter);

        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (spinnercidade.getSelectedItemPosition()) {

                    case 0:
                        adapter2 = ArrayAdapter.createFromResource(getApplication(), R.array.sp_bairros, android.R.layout.simple_spinner_dropdown_item);
                        spinnerbairro.setAdapter(adapter2);
                        break;

                    case 1:
                        adapter2 = ArrayAdapter.createFromResource(getApplication(), R.array.guaru_bairros, android.R.layout.simple_spinner_dropdown_item);
                        spinnerbairro.setAdapter(adapter2);
                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        };
        spinnercidade.setOnItemSelectedListener(escolha);

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               servButton.ServLocalizacao(spinnercidade.getSelectedItem().toString(),spinnerbairro.getSelectedItem().toString(),getApplicationContext());
               servButton.ServCamera(mMap);

            }
        });

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

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(saopaulo)
                .zoom(13)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        return;


    }

    //CLASSE INTERNA QUE RECEBE AS INFORMAÇÕES NO BANCO  PARA CRIAR NO MAPA OS MARCADORES DAS FEIRAS NA CIDADE.
    class Background extends AsyncTask<String, String, String> {


        protected String doInBackground(String... params) {
            String db_data = params[0];
            String dataa = "";
            int tmp;

            try {
                URL url = new URL("https://branchh.tech/app_Feira.php");
                String urlParams = "data=" + db_data;

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();
                InputStream is = httpURLConnection.getInputStream();
                while ((tmp = is.read()) != -1) {
                    dataa += (char) tmp;
                }
                is.close();
                httpURLConnection.disconnect();

                return dataa;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }


        }

        @Override
        protected void onPostExecute(final String result) {


            try {
                JSONObject objJSON = new JSONObject(result);

                JSONArray arrayListMapas = objJSON.getJSONArray("result");

                feiraarray = new String[arrayListMapas.length()];
                enderecoarray = new String[arrayListMapas.length()];
                bairroarray = new String[arrayListMapas.length()];
                latitudearray = new String[arrayListMapas.length()];
                longitudearray = new String[arrayListMapas.length()];

                spinnercidade = findViewById(R.id.spinner2);



                for (i = 0; i < arrayListMapas.length(); i++) {

                    feiraarray[i] = arrayListMapas.getJSONObject(i).getString("Feira");
                    enderecoarray[i] = arrayListMapas.getJSONObject(i).getString("endereco");
                    bairroarray[i] = arrayListMapas.getJSONObject(i).getString("bairro");
                    latitudearray[i] = arrayListMapas.getJSONObject(i).getString("latitude");
                    longitudearray[i] = arrayListMapas.getJSONObject(i).getString("longitude");



                    //adapter =  new ArrayAdapter<String>(getApplicationContext(),R.layout.layout_spinner,bairroarray);


                    spinnercidade.setAdapter(adapter);

                    criandoMarcador(feiraarray[i], enderecoarray[i], bairroarray[i], latitudearray[i], longitudearray[i]);


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (result.equals("")) {

            }

        }

    }


    // CLASSE QUE VAI CRIAR MARCADORES DAS FEIRAS DA CIDADE
    protected void criandoMarcador(String feira, String endereco, String bairro, String latitude, String longitude) {


        mMap.setOnMarkerClickListener(


                new GoogleMap.OnMarkerClickListener() {


                    @Override
                    public boolean onMarkerClick(Marker marker) {


                        return false;
                    }


                });

        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude)))
                .title("Feira: " + feira)
                .snippet("Bairro: " + bairro)
                .anchor(0.5f, 0.5f)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_loc));


        mark2 = mMap.addMarker(markerOptions2);

    }



}


