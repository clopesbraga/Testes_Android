package br.com.branch.testes.Telas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.branch.testes.Adapter.Adapter;
import br.com.branch.testes.ModeloTabelas.ModeloTabelaProdutos;
import br.com.branch.testes.R;


public class TelaListaEdittext extends AppCompatActivity {

    Adapter adapter;
    ArrayList<ModeloTabelaProdutos> listaprodutos;
    ModeloTabelaProdutos modeloTabelaProdutos;
    Context ctx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_edittext);


    }


  @Override
    protected  void onResume(){
        super.onResume();

        listaprodutos = new ArrayList<ModeloTabelaProdutos>();
        adapter = new Adapter(getCallingActivity(),listaprodutos);
        ListView listVerLista = (ListView) findViewById(R.id.ListVerLista);

        modeloTabelaProdutos = new ModeloTabelaProdutos();

      //modeloTabelaProdutos.set_id(1);
      modeloTabelaProdutos.setProduto("Ameixa");

        listVerLista.setAdapter(adapter);
        listaprodutos.add(modeloTabelaProdutos);
        adapter.notifyDataSetChanged();
        listVerLista.setSelection(adapter.getCount()-1);






  }



}
