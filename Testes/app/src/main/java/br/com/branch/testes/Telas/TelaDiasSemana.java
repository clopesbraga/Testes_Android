package br.com.branch.testes.Telas;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

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

import br.com.branch.testes.Adapter.MapaAdapter;
import br.com.branch.testes.ModeloTabelas.ModeloBanco;
import br.com.branch.testes.R;
import br.com.branch.testes.Telas.ui.main.SectionsPagerAdapter;

public class TelaDiasSemana extends AppCompatActivity {

    ArrayAdapter adapter,adapter2;
    Spinner spinnercidade, spinbairro;
    int i;


    // VARIAVEIS USADAS PARA TRAZER AS INFORMAÇÕES DO BANCO
    String[] feiraarray;
    String[] enderecorroarray;
    String[] diaarray;

    ModeloBanco modeloBanco = new ModeloBanco();
    ArrayList<ModeloBanco> listamodelobanco;
    ViewPager viewPager;
    MapaAdapter adapterlist;
    ListView listSemana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dias_semana);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        spinnercidade = findViewById(R.id.spincidade);
        spinbairro = findViewById(R.id.spinbairro);
        //listSemana = findViewById(R.id.listTab1);


        adapter = ArrayAdapter.createFromResource(getApplication(), R.array.cidades, android.R.layout.simple_spinner_dropdown_item);
        spinnercidade.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Mensagem enviada", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Background background = new Background();
                background.execute(spinnercidade.getSelectedItem().toString(),spinbairro.getSelectedItem().toString());

            }
        });
    }

    public void onResume() {
        super.onResume();


        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (spinnercidade.getSelectedItemPosition()) {

                    case 0:
                        adapter2 = ArrayAdapter.createFromResource(getApplication(), R.array.sp_bairros, android.R.layout.simple_spinner_dropdown_item);
                        spinbairro.setAdapter(adapter2);
                        break;

                    case 1:
                        adapter2 = ArrayAdapter.createFromResource(getApplication(), R.array.guaru_bairros, android.R.layout.simple_spinner_dropdown_item);
                        spinbairro.setAdapter(adapter2);

                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        };
        spinnercidade.setOnItemSelectedListener(escolha);
    }





    //CLASSE INTERNA QUE RECEBE AS INFORMAÇÕES NO BANCO  PARA CRIAR NO MAPA OS MARCADORES DAS FEIRAS NA CIDADE.
     class Background extends AsyncTask<String, String, String> {


        protected String doInBackground(String... params) {
            String db_cidade = params[0];
            String db_bairro = params[1];
            String dataa = "";
            int tmp;

            try {
                URL url = new URL("https://branchh.tech/Testes/app_ListSemana.php");
                String urlParams ="cidade="+db_cidade+"&bairro="+db_bairro;

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

                feiraarray =       new String[arrayListMapas.length()];
                enderecorroarray = new String[arrayListMapas.length()];
                diaarray =         new String[arrayListMapas.length()];

                listamodelobanco = new ArrayList<ModeloBanco>();
                adapterlist= new MapaAdapter(getApplication(),listamodelobanco);


                for (i = 0; i < arrayListMapas.length(); i++) {

                    feiraarray[i] = arrayListMapas.getJSONObject(i).getString("Feira");
                    enderecorroarray[i] = arrayListMapas.getJSONObject(i).getString("endereco");
                    diaarray [i] = arrayListMapas.getJSONObject(i).getString("dia");


                    switch (diaarray[i]){

                        case "TER": listSemana = findViewById(R.id.listTab1);break;

                        case "QUA": listSemana = findViewById(R.id.listTab2);break;

                        case "QUI": listSemana = findViewById(R.id.listTab3);break;

                        case "SEX": listSemana = findViewById(R.id.listTab4);break;

                        case "SAB": listSemana = findViewById(R.id.listTab5);break;

                        case "DOM": listSemana = findViewById(R.id.listTab6);break;

                    }


                    modeloBanco.setFeira(feiraarray[i]);
                    modeloBanco.setEndereco(enderecorroarray[i]);
                    modeloBanco.setDia(diaarray[i]);


                    listSemana.setAdapter(adapterlist);
                    listamodelobanco.add(modeloBanco);
                    adapterlist.notifyDataSetChanged();
                    listSemana.setSelection(adapter.getCount() - 1);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (result.equals("")) {

            }

        }

    }




}