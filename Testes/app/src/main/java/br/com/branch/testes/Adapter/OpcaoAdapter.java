package br.com.branch.testes.Adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.branch.testes.ModeloTabelas.ModeloTabelaProdutos;
import br.com.branch.testes.R;

import static android.support.v4.app.ActivityCompat.startActivityForResult;


public class OpcaoAdapter extends BaseAdapter {

    Context ctx;

    private static final int PICK_IMAGE = 1234;


    public OpcaoAdapter(Context ctx) {

        this.ctx = ctx;


    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View layouteste;

        // CARREGA O LAYOUT NO ADAPTER
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layouteste = inflater.inflate(R.layout.layout_opcao_imagem, parent,false);


        Button btfoto = layouteste.findViewById(R.id.btfoto);
        Button btimagem = layouteste.findViewById(R.id.btimagem);





        btfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ABRIR A OPÇÃO PARA CAPTURAR AS IMAGNES PARA SEREM USADAS NO LOGIN
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // FIM DO TRECHO



            }
        });




        return layouteste;
    }




}
