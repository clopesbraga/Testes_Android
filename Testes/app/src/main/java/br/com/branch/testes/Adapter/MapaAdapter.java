package br.com.branch.testes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import br.com.branch.testes.ModeloTabelas.ModeloBanco;
import br.com.branch.testes.R;

/**
 * Created by Cleiton on 15/12/2017.
 */

public class MapaAdapter extends BaseAdapter {
    private Context ctx;
    private ArrayList<ModeloBanco> listamodelobanco;
    private TextView feira,endereco;
    private String feiras,enderecos,dias;
    private ModeloBanco modeloBanco = new ModeloBanco();
    View diasemana;


    public MapaAdapter(Context ctx, ArrayList<ModeloBanco> listamodelobanco) {
        this.ctx = ctx;
        this.listamodelobanco = listamodelobanco;

    }

    public void adicionaModeloBanco(ModeloBanco modeloBanco)
    {
        this.listamodelobanco.add(modeloBanco);
    }


    @Override
    public int getCount() {



        return listamodelobanco.size();


    }

    @Override
    public Object getItem(int position) {
        return listamodelobanco.get(position);
    }

    @Override
    public long getItemId(int position) {return listamodelobanco.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View layoutpersonalizado;



        modeloBanco = listamodelobanco.get(position);
        enderecos= modeloBanco.getEndereco();
        feiras= modeloBanco.getFeira();
        dias= modeloBanco.getDia();

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        switch (dias){

            case "TER" : diasemana = inflater.inflate(R.layout.layout_terca, parent,false);
                        feira= diasemana.findViewById(R.id.txtnomefeiraTerca);
                        endereco= diasemana.findViewById(R.id.txtenderecoTerca);
                        feira.setText(feiras);
                        endereco.setText(enderecos);
            break;

            case "QUA" : diasemana = inflater.inflate(R.layout.layout_quarta, parent,false);
                        feira= diasemana.findViewById(R.id.txtnomefeiraQuarta);
                        endereco= diasemana.findViewById(R.id.txtenderecoQuarta);
                        feira.setText(feiras);
                        endereco.setText(enderecos);
            break;

            case "QUI" : diasemana = inflater.inflate(R.layout.layout_quinta, parent,false);
                        feira= diasemana.findViewById(R.id.txtnomefeiraQuinta);
                        endereco= diasemana.findViewById(R.id.txtenderecoQuinta);
                        feira.setText(feiras);
                        endereco.setText(enderecos);
            break;

            case "SEX" : diasemana = inflater.inflate(R.layout.layout_sexta, parent,false);
                         feira= diasemana.findViewById(R.id.txtnomefeiraSexta);
                         endereco= diasemana.findViewById(R.id.txtenderecoSexta);
                         feira.setText(feiras);
                         endereco.setText(enderecos);


            break;

            case "SAB" : diasemana = inflater.inflate(R.layout.layout_sabado, parent,false);
                        feira= diasemana.findViewById(R.id.txtnomefeiraSabado);
                        endereco= diasemana.findViewById(R.id.txtenderecoSabado);
                        feira.setText(feiras);
                        endereco.setText(enderecos);

            break;

            case "DOM" : diasemana = inflater.inflate(R.layout.layout_domingo, parent,false);
                        feira= diasemana.findViewById(R.id.txtnomefeiraDomingo);
                        endereco= diasemana.findViewById(R.id.txtenderecoDomingo);
                        feira.setText(feiras);
                        endereco.setText(enderecos);

            break;

        }


        layoutpersonalizado=diasemana;





        return layoutpersonalizado;
    }




}
