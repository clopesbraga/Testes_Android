package br.com.branch.testes.Telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.branch.testes.R;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
    }

    public void AcessoOnclick(View acesso)
    {
        switch(acesso.getId())
        {
            case R.id.btn01: Intent iBancoDaos = new Intent(this, TelaBancoDados.class);
            startActivity(iBancoDaos); break;

            case R.id.bt02: Intent iLista = new Intent(this, TelaListaEdittext.class);
                startActivity(iLista); break;

            case R.id.bt04: Intent iMap = new Intent(this, TelaMapa.class);
                startActivity(iMap); break;

            case R.id.bt05: Intent iDailog = new Intent(this, TelaDialog.class);
                startActivity(iDailog); break;

            case R.id.bt06: Intent iApresentacao = new Intent(this, TelaApresentacao.class);
            startActivity(iApresentacao); break;

            case R.id.bt07: Intent iBuscaCoord = new Intent(this, TelaBuscaCoordenadas.class);
                startActivity(iBuscaCoord); break;

            case R.id.bt08: Intent iTrocaimagem = new Intent(this, TelaTrocaImagem.class);
                startActivity(iTrocaimagem); break;

            case R.id.bt09: Intent iPropaganda = new Intent(this, TelaPropaganda.class);
                startActivity(iPropaganda); break;

            case R.id.bt10: Intent iLocBairro = new Intent(this, TelaLocaBairro.class);
                startActivity(iLocBairro); break;

            case R.id.bt11: Intent iNovaLoc = new Intent(this, TelaFeirasSemanais.class);
            startActivity(iNovaLoc); break;

            case R.id.bt12: Intent iAvlic = new Intent(this, TelaAvalicao.class);
            startActivity(iAvlic); break;

            case R.id.bt13: Intent iMedia = new Intent(this, TelaCalcMedia.class);
                startActivity(iMedia); break;
        }
    }
}
