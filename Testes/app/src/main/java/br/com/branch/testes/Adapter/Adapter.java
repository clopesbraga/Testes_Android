package br.com.branch.testes.Adapter;

import android.content.ComponentName;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.branch.testes.ModeloTabelas.ModeloTabelaProdutos;
import br.com.branch.testes.R;

public class Adapter extends BaseAdapter {

    Context ctx;
    ArrayList<ModeloTabelaProdutos> listaprodutos;
    TextView txtid;
    EditText editText;
    CheckBox checkBox;


    ModeloTabelaProdutos modeloTabelaProdutos = new ModeloTabelaProdutos();


    public Adapter(Context ctx , ArrayList<ModeloTabelaProdutos> listaprodutos) {

        this.ctx = ctx;
        this.listaprodutos= listaprodutos;
    }

    public Adapter(ComponentName callingActivity, ArrayList<ModeloTabelaProdutos> tabelaProdutos) {
    }


    @Override
    public int getCount() {
        return listaprodutos.size();
    }

    @Override
    public Object getItem(int position) {return listaprodutos.get(position); }

    @Override
    public long getItemId(int position) {

        return listaprodutos.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View layoutpersonalizado;

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutpersonalizado = inflater.inflate(R.layout.layout_lista2, null);


        txtid =    layoutpersonalizado.findViewById(R.id.txtid);
        editText = layoutpersonalizado.findViewById(R.id.edtList);
        checkBox = layoutpersonalizado.findViewById(R.id.cbList);

        txtid.setText(modeloTabelaProdutos.get_id());


        checkBox.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                CheckBox checked= (CheckBox) v;
                switch (v.getId())
                {

                    case R.id.cbList:
                        if(checked.isChecked()){



                        }


                }
        }

        });
        return layoutpersonalizado;


    }




}
