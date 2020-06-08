package br.com.branch.testes.Telas;

import android.app.ProgressDialog;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.branch.testes.R;

public class TelaBuscaCoordenadas extends AppCompatActivity {


    String[] idarray,feiraarray,enderecoarray,bairroarray,cidadearray,diaarray;
    String localidade, latitude, longitude;
    Double lat,lon;
    int i;

    private ProgressDialog objProcessando;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_buscacoordenadas);




    }

    @Override
    protected void onResume() {
        super.onResume();

        Background b = new Background();
        b.execute("49");

    }


    class Background extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            objProcessando = new ProgressDialog(TelaBuscaCoordenadas.this);
            objProcessando.setTitle("Recebendo informações do banco");
            objProcessando.setMessage("Aguarde...");
            objProcessando.show();
        }

        protected String doInBackground(String... params) {
            String db_id = params[0];
            String dataa = "";
            int tmp;

            try {
                URL url = new URL("https://branchh.tech/Testes/app_ListTesteFeira.php");
                String urlParams ="cidade="+db_id;

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
                JSONArray arrayListFeiras = objJSON.getJSONArray("result");

                //idarray = new String[arrayListFeiras.length()];
                feiraarray = new String[arrayListFeiras.length()];
                enderecoarray = new String[arrayListFeiras.length()];
                bairroarray = new String[arrayListFeiras.length()];
                cidadearray = new String[arrayListFeiras.length()];
                diaarray = new String[arrayListFeiras.length()];

                for (i = 0; i < arrayListFeiras.length(); i++) {

                    try {



                        //idarray[i]=         arrayListFeiras.getJSONObject(i).getString("_id");
                        feiraarray[i] =     arrayListFeiras.getJSONObject(i).getString("Feira");
                        enderecoarray[i] =  arrayListFeiras.getJSONObject(i).getString("Endereco");
                        bairroarray[i] =    arrayListFeiras.getJSONObject(i).getString("Bairro");
                        cidadearray[i] =    arrayListFeiras.getJSONObject(i).getString("Cidade");
                        diaarray[i] =       arrayListFeiras.getJSONObject(i).getString("Dia");


                        Geocoder gc = new Geocoder(getApplicationContext());
                        List<Address> list = null;
                        //list = gc.getFromLocation(latitude, longitude, 1);
                        list = gc.getFromLocationName(enderecoarray[i], 1);
                        Address add = list.get(0);
                        lat= add.getLatitude();
                        lon = add.getLongitude();
                        localidade = add.getSubLocality(); // TRAZ O BAIRRO ONDE OUVE A PROMOÇÃO.

                        latitude = String.valueOf(lat);
                        longitude = String.valueOf(lon);


                        Background2 b2=new Background2();
                        b2.execute(feiraarray[i], latitude, longitude,enderecoarray[i],bairroarray[i],cidadearray[i],diaarray[i]);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }catch (JSONException e) {
                e.printStackTrace();
            }


            if (result.equals("")) {

                objProcessando.cancel();

            }


        }
    }


    class Background2 extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            objProcessando = new ProgressDialog(TelaBuscaCoordenadas.this);
            objProcessando.setTitle("Enviando Registros");
            objProcessando.setMessage("Aguarde...");
            objProcessando.show();
        }

        protected String doInBackground(String... params) {
            String db_feiras =   params[0];
            String db_lat =      params[1];
            String db_lon =      params[2];
            String db_endereco = params[3];
            String db_bairro =   params[4];
            String db_cidade =   params[5];
            String db_dia =      params[6];
            String dataa = "";
            int tmp;

            try {
                URL url = new URL("https://branchh.tech/Testes/app_register.php");
                String urlParams ="Feira="+db_feiras+"&Latitude="+db_lat +"&Longitude="+db_lon+"&endereco="+db_endereco+"&bairro="+db_bairro+"&cidade="+db_cidade+"&dia="+db_dia;

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
        protected void onPostExecute(String s) {
            if(s.equals("")){

                objProcessando.cancel();
            }

        }

    }
}
