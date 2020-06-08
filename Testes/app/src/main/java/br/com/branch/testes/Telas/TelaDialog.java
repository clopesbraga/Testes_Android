package br.com.branch.testes.Telas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.Toast;

import br.com.branch.testes.R;

public class TelaDialog extends AppCompatActivity {

    NumberPicker contador, contador2;
    AlertDialog.Builder mensagem;
    int salvacontador;
    String salvatexto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dialog);




    }


    public void btnDailogOnClick (View view)
    {
        mensagem = new AlertDialog.Builder(this);
        LinearLayout LL = new LinearLayout(this);
        LL.setOrientation(LinearLayout.HORIZONTAL);

        int img=R.mipmap.ic_background;
        int img2=R.mipmap.ic_launcher;


        final NumberPicker contador = new NumberPicker(this);
        contador.setMinValue(1);
        contador.setMaxValue(10);

        final NumberPicker contador2 = new NumberPicker(this);
        contador2.setMinValue(1);
        contador2.setMaxValue(4);
        contador2.setDisplayedValues(new String[] {"UN", "KG","PCS","PCT"});

        final NumberPicker contador3 = new NumberPicker(this);
        contador3.setMinValue(1);
        contador3.setMaxValue(4);
        contador3.setBackgroundResource(img2);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50, 50);


        LinearLayout.LayoutParams numPicerParams = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        numPicerParams.weight = 1;
        LinearLayout.LayoutParams qPicerParams = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        qPicerParams.weight = 1;



        LL.setLayoutParams(params);
        LL.addView(contador,numPicerParams);
        LL.addView(contador2,qPicerParams);
        LL.addView(contador3,qPicerParams);

        //MONTAGEM DA CAIXA DE REGISTRO DE QUANTIDADES
        mensagem.setTitle("TESTE");
        mensagem.setMessage("MENSAGEM");
        mensagem.setView(LL);

        mensagem.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                salvacontador = contador.getValue();
                salvatexto = contador2.getDisplayedValues().toString();


            }


        });


        mensagem.show();

    }
}
