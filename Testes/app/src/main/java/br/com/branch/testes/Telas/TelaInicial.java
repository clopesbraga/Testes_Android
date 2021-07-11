package br.com.branch.testes.Telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import br.com.branch.testes.R;

public class TelaInicial extends AppCompatActivity {


    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);



        /* INICIO DA ROTINA QUE INICIALIZA O SOFTWARE E MUDA PARA TELA SEGUINTE */
        Thread mythread = new Thread() {
            @Override
            public void run() {
                try {
                    while (splashActive && ms < splashTime) {
                        if (!paused)
                            ms = ms + 1000;
                        sleep(1000);
                    }
                } catch (Exception e) {
                    Log.e("Erro", e.getMessage());
                    finish();


                } finally {

                    Intent intent = new Intent(TelaInicial.this,TelaPrincipal.class);
                    startActivity(intent);

                }


            }


        };
        mythread.start();
        /* FIM DA ROTINA */



    }
}
