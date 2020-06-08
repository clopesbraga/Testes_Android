package br.com.branch.testes.Telas;

import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.branch.testes.Banco.TabelaLogin;
import br.com.branch.testes.DAO.DAOLogin;
import br.com.branch.testes.R;

public class TelaBancoDados extends AppCompatActivity {

    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_banco_dados);

        Button btnGravar = (Button) findViewById(R.id.btnGravar);


    }

    public void onResume()
    {
        super.onResume();


        final Handler handler = new Handler();
        handler.post(new Runnable(){

            @Override
            public void run(){



                handler.postDelayed(this, 5000); // TEMPO ONDE SERA ATUALZADA
            }

        });

        DAOLogin crud =  new DAOLogin(getBaseContext());

        Cursor cursor =  crud.listar();

        String[] nomeCampos = new String[] {TabelaLogin.ID, TabelaLogin.USUARIO,TabelaLogin.SENHA};
        int[] idViews = new int[] {R.id.txtid, R.id.txtusuario,R.id.txtsenha};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.layout_lista,cursor,nomeCampos,idViews, 0);
        lista = (ListView)findViewById(R.id.listBanco);
        lista.setAdapter(adaptador);
        lista.setSelection(adaptador.getCount() - 1);

    }

    public void gravarOnCliclick (View v)
    {
        DAOLogin crud =  new DAOLogin(getBaseContext());

        EditText usuario = (EditText) findViewById(R.id.edtUsuario);
        EditText senha = (EditText) findViewById(R.id.edtSenha);

        crud.inserir(usuario.getText().toString(),senha.getText().toString());

        usuario.setText("");
        senha.setText("");
    }
}