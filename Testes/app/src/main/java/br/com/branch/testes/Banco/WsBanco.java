package br.com.branch.testes.Banco;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WsBanco extends Activity
{
    Context ctx;

    public WsBanco(Context ctx){

         this.ctx = ctx;

    }

    public void postRegistrar(String usuario , String senha)
    {
        Background b=new Background();
        b.execute(usuario,senha);

    }

    class Background extends AsyncTask<String, String, String> {

        protected String doInBackground(String... params) {
            String db_usuario =  params[0];
            String db_senha = params[1];
            String dataa = "";
            int tmp;

            try {
                URL url = new URL("https://outlier.000webhostapp.com/Testes/app_register.php");
                String urlParams = "usuario="+db_usuario+"&senha="+db_senha;

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
                s="Gravacao salva com sucesso!.";
            }
            Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
        }

    }


}
