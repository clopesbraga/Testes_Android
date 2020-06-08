package br.com.branch.testes.Telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import br.com.branch.testes.R;

public class TelaApresentacao extends AppCompatActivity implements View.OnClickListener
{


    ShowcaseView showcaseView;   // VARIAVEL QUE TRATA DAS FUNÇÕES DO TUTORIAL
    private Target t1,t2,t3,t4;
    int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_apresentacao);

        t1=new ViewTarget(R.id.mens1,this);
        t2=new ViewTarget(R.id.mens2,this);
        t3=new ViewTarget(R.id.mens3,this);




    }

    public void apOnClick (View view)
    {

        switch(view.getId())
        {

            case R.id.btAp01:

                showcaseView = new ShowcaseView.Builder(this)
                    .setTarget(Target.NONE)
                    .setOnClickListener(this)
                    .setContentTitle("TESTES ANDROID")
                    .setContentText("Tutorial")
                    .setStyle(R.style.CustomShowcaseTheme)
                    .build();
                showcaseView.setButtonText("Proximo");


                break;

            case R.id.btAp02:

                showcaseView = new ShowcaseView.Builder(this)
                        .setTarget(Target.NONE)
                        .setOnClickListener(this)
                        .setContentTitle("TESTES ANDROID")
                        .setContentText("Tutorial")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
                showcaseView.setButtonText("Proximo");
                break;


            case R.id.btAp03:

                showcaseView = new ShowcaseView.Builder(this)
                        .setTarget(Target.NONE)
                        .setOnClickListener(this)
                        .setContentTitle("TESTES ANDROID")
                        .setContentText("Tutorial")
                        .setStyle(R.style.CustomShowcaseTheme3)
                        .build();
                showcaseView.setButtonText("Proximo");
                break;

            case R.id.btAp04:

                showcaseView = new ShowcaseView.Builder(this)
                        .setTarget(Target.NONE)
                        .setOnClickListener(this)
                        .setContentTitle("TESTES ANDROID")
                        .setContentText("Tutorial")
                        .setStyle(R.style.CustomShowcaseTheme4)
                        .build();
                showcaseView.setButtonText("Proximo");
                break;
        }

    }



    @Override
    public void onClick(View v)
    {
        switch (contador)
        {

            case 0:
                showcaseView.setShowcase(t1, true);
                showcaseView.setContentTitle("Mensagem Teste 1");
                showcaseView.setContentText("Primeira Mensagem de Teste");
                break;

            case 1:
                showcaseView.setShowcase(t2, true);
                showcaseView.setContentTitle("Mensagem Teste 2");
                showcaseView.setContentText("Segunda Mensagem de Teste");
                break;

            case 2:
                showcaseView.setShowcase(t3, true);
                showcaseView.setContentTitle("Mensagem Teste 3");
                showcaseView.setContentText("Terceira Mensagem de Teste");
                break;

            case 3:
                showcaseView.hide();
        }
        contador++;

        return;

    }
}
