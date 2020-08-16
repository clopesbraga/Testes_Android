package br.com.branch.testes.TabelasSemana;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import br.com.branch.testes.Adapter.MapaAdapter;
import br.com.branch.testes.ModeloTabelas.ModeloBanco;
import br.com.branch.testes.R;
import br.com.branch.testes.Telas.TelaFeirasSemanais;


public class Tab1 extends Fragment {

    ArrayAdapter adapter,adapter2;
    Spinner spinnercidade, spinbairro;
    View myview;

    ArrayList<ModeloBanco> listamodelobanco;
    ViewPager viewPager;
    MapaAdapter adapterlist;
    ListView listSemana;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         myview= inflater.inflate(R.layout.layout_tab1, container, false);


        spinnercidade = myview.findViewById(R.id.spincidade);
        spinbairro = myview.findViewById(R.id.spinbairro);
        listSemana = myview.findViewById(R.id.listTab1);


        //adapter = ArrayAdapter.createFromResource(myview.getContext(), R.array.cidades, android.R.layout.simple_spinner_dropdown_item);
        //spinnercidade.setAdapter(adapter);


        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Mensagem enviada", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();




            }
        });*/


       /* final TelaFeirasSemanais tabelabase= new TelaFeirasSemanais();


        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (spinnercidade.getSelectedItemPosition()) {

                    case 0:
                        adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.sp_bairros, android.R.layout.simple_spinner_dropdown_item);
                        spinbairro.setAdapter(adapter2);
                        break;

                    case 1:
                        adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.guaru_bairros, android.R.layout.simple_spinner_dropdown_item);
                        spinbairro.setAdapter(adapter2);

                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        };*/

        return myview;
    }



}
