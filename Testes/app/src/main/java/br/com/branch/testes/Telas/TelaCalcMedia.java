package br.com.branch.testes.Telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import br.com.branch.testes.R;

public class TelaCalcMedia extends AppCompatActivity {

    private TextView txtValor1,txtValor2,txtValor3,txtValorResultado;
    private EditText edtValor1,edtValor2,edtValor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calc_media);

        txtValor1=(TextView) findViewById(R.id.txtValor1);
        txtValor2=(TextView) findViewById(R.id.txtValor2);
        txtValor3=(TextView) findViewById(R.id.txtValor3);




        edtValor1=(EditText) findViewById(R.id.edtValor1);
        edtValor2=(EditText) findViewById(R.id.edtValor2);
        edtValor3=(EditText) findViewById(R.id.edtValor3);

    }

    @Override
    protected void onResume() {
        super.onResume();

        txtValorResultado=(TextView) findViewById(R.id.txtValorResultado);
        txtValorResultado.setText(String.valueOf(calcMedia()));

    }

    public int calcMedia(){

        int valor1,valor2,valor3;
        int resultado;

        valor1= Integer.parseInt(edtValor1.getText().toString());
        valor2= Integer.parseInt(edtValor2.getText().toString());
        valor3= Integer.parseInt(edtValor3.getText().toString());

        resultado = (valor1+valor2+valor3)/3;

        return resultado;

    }


}
