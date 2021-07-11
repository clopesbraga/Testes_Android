package br.com.branch.testes.Telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.branch.testes.R;

import static br.com.branch.testes.R.drawable.ic_seta_grafico1_background;

public class TelaCalcMedia extends AppCompatActivity {

    private TextView txtResultadoAntigo,txtValorResultado,txtsetaGrafico;
    private EditText edtValor1,edtValor2,edtValor3;
    private int valor1,valor2,valor3,calculado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calc_media);

        txtResultadoAntigo=(TextView) findViewById(R.id.txtResultadoAntigo);
        txtValorResultado=(TextView) findViewById(R.id.txtValorResultado);
        txtsetaGrafico = (TextView) findViewById(R.id.txtMostrarPorcentagem);

        edtValor1=(EditText) findViewById(R.id.edtValor1);
        edtValor2=(EditText) findViewById(R.id.edtValor2);
        edtValor3=(EditText) findViewById(R.id.edtValor3);

    }

    @Override
    protected void onResume() {
        super.onResume();

        edtValor1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(java.lang.CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(java.lang.CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                valor1 +=Integer.parseInt(s.toString());
            }
        });
        edtValor2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(java.lang.CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(java.lang.CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                valor2=Integer.parseInt(s.toString());
            }
        });
        edtValor3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(java.lang.CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(java.lang.CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                valor3=Integer.parseInt(s.toString());
            }
        });

    }

    public void btnCalcMediaOnClick(View view){
        calcMedia(valor1,valor2,valor3);
        txtValorResultado.setText(String.valueOf(mostrarResultado()));
        mostarImagem(mostrarResultado());
        limparCamposDosValores ();

    }

    public void calcMedia(int valor1,int valor2,int valor3){
        calculado = (valor1+valor2+valor3)/3;

    }

    public  int mostrarResultado(){
        return calculado;

    }


    public void mostarImagem(int resultado){

            txtResultadoAntigo.setText("2");
            if(resultado>Integer.parseInt(txtResultadoAntigo.getText().toString())){

                txtsetaGrafico.setBackgroundResource(R.mipmap.ic_seta_grafico1_foreground);
            }
            if(resultado<Integer.parseInt(txtResultadoAntigo.getText().toString())){

                txtsetaGrafico.setBackgroundResource(R.mipmap.ic_seta_grafico2_foreground);

            }
            if(resultado==Integer.parseInt(txtResultadoAntigo.getText().toString())){

                txtsetaGrafico.setBackgroundResource(R.mipmap.ic_seta_grafico1_foreground);

            }

        }

        public void limparCamposDosValores (){

            edtValor1.clearFocus();
            edtValor2.clearFocus();
            edtValor3.clearFocus();

        }

    }
