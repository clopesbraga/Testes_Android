package br.com.branch.testes.Servicos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import br.com.branch.testes.ModeloTabelas.ModeloBanco;

public class ServListarDadosRecebidos {

    int i;
    String[] feiraarray;
    String[] enderecorroarray;
    String[] diaarray;
    ModeloBanco modeloBanco = new ModeloBanco();
    ArrayList<ModeloBanco> listamodelobanco;

    public void capturarResultadoDaWeb(String resultado) throws JSONException {

        try {

            JSONObject objJSON = new JSONObject(resultado);
            JSONArray arrayListaDados = objJSON.getJSONArray("result");

            feiraarray = new String[arrayListaDados.length()];
            enderecorroarray = new String[arrayListaDados.length()];
            diaarray = new String[arrayListaDados.length()];


            for (i = 0; i < arrayListaDados.length(); i++) {

                modeloBanco.setFeira(feiraarray[i]);
                modeloBanco.setEndereco(enderecorroarray[i]);
                modeloBanco.setDia(diaarray[i]);


                listamodelobanco.add(modeloBanco);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}