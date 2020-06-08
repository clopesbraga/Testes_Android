package br.com.branch.testes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.branch.testes.Banco.TabelaLogin;
import br.com.branch.testes.Banco.TabelaProdutos;
import br.com.branch.testes.Banco.WsBanco;

public class DAOProdutos {

    private SQLiteDatabase db;
    private TabelaProdutos tabelaprodutos;
    private WsBanco wbanco;
    private Context context;

    public DAOProdutos(Context context){
        tabelaprodutos = new TabelaProdutos(context);
    }

    public long inserir(String usuario , String senha)
    {
        long resultado;
        ContentValues valores;

        db = tabelaprodutos.getWritableDatabase();
        valores = new ContentValues();
        valores.put(TabelaProdutos.PRODUTO,usuario);

        resultado = db.insert(TabelaLogin.TABELA, null, valores);
        db.close();

        //qwbanco = new WsBanco(context);
           // wbanco.postRegistrar(usuario,senha);

        return resultado;
    }


    public Cursor listar()
    {

        Cursor cursor;

        String[] campos =  {tabelaprodutos.ID, tabelaprodutos.PRODUTO};
        db = tabelaprodutos.getReadableDatabase();
        cursor = db.query(tabelaprodutos.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;


    }
}
