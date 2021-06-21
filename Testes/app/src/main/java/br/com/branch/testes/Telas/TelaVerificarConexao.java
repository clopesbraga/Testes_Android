package br.com.branch.testes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class
TelaVerificarConexao extends AppCompatActivity {


    TextView txtMensagemConexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_verificar_conexao);

        txtMensagemConexao = findViewById(R.id.txtTipoConexao);


    }

    protected void onResume() {
        super.onResume();

        verificarStatusConexao();

    }


    protected void verificarStatusConexao() {

        //INICIA A VERIFICACAO DO APARELHO
        ConnectivityManager verificarTipoConexao = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (verificarTipoConexao.getNetworkInfo(0).isConnected()) {
            txtMensagemConexao.setText("CONEXAO DADOS");
        } else if (verificarTipoConexao.getNetworkInfo(1).isConnected()) {
            txtMensagemConexao.setText("CONEXAO WIRELESS");
        }else txtMensagemConexao.setText("SEM CONEXAO");


    }


}