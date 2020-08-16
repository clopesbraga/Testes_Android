package br.com.branch.testes.Servicos;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class ServEnvioDeDados extends AsyncTask<String, String, String> {

    String resultado_recebido;
    ServListarDadosRecebidos servListarDadosRecebidos = new ServListarDadosRecebidos();

    public void enviarDadosParaWeb(String cidade, String bairro)
    {

        doInBackground(cidade,bairro);

    }


        protected String doInBackground(String... params) {

            String db_cidade = params[0];
            String db_bairro = params[1];
            String dataa = "";
            int tmp;


            try {
                URL url = new URL("http://branchh.tech/Testes/app_ListSemana.php");
                String urlParams = "cidade=" + db_cidade + "&bairro=" + db_bairro;

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

            resultado_recebido = result;
            try
            {
                servListarDadosRecebidos.capturarResultadoDaWeb(result);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }




    }







