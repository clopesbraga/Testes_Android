package br.com.branch.testes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.branch.testes.Banco.TabelaImagem;
import br.com.branch.testes.Banco.TabelaLogin;
import br.com.branch.testes.ModeloTabelas.ModeloTabelaImagem;

public class DAOImagem {

    private SQLiteDatabase db;
    private TabelaImagem tabelaImagem;

    public DAOImagem(Context context){
        tabelaImagem = new TabelaImagem(context);
    }

    public long inserir(String imagem )
    {


        long resultado;
        ContentValues valores;

        db = tabelaImagem.getWritableDatabase();
        valores = new ContentValues();
        valores.put(TabelaImagem.ENDERECO,imagem);

        resultado = db.insert(TabelaImagem.TABELA, null, valores);
        db.close();


        return resultado;
    }




    public String listar()
    {

        Cursor cursor;

        String[] campos =  {tabelaImagem.ENDERECO};
        db = tabelaImagem.getReadableDatabase();
        cursor = db.query(tabelaImagem.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return String.valueOf(cursor);


    }
}
