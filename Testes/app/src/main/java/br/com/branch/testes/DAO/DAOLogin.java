package br.com.branch.testes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.branch.testes.Banco.TabelaLogin;
import br.com.branch.testes.Banco.TabelaProdutos;
import br.com.branch.testes.Banco.WsBanco;

public class DAOLogin {

    private SQLiteDatabase db;
    private TabelaLogin tabelalogin;
    private TabelaProdutos tabelaProdutos;
    private WsBanco wbanco;
    private Context context;

    public DAOLogin(Context context){
        tabelalogin = new TabelaLogin(context);
    }

    public long inserir(String usuario , String senha)
    {
        long resultado;
        ContentValues valores;

        db = tabelalogin.getWritableDatabase();
        valores = new ContentValues();
        valores.put(TabelaLogin.USUARIO,usuario);
        valores.put(TabelaLogin.SENHA,senha);

        resultado = db.insert(TabelaLogin.TABELA, null, valores);
        db.close();

        wbanco = new WsBanco(context);
            wbanco.postRegistrar(usuario,senha);

        return resultado;
    }




    public Cursor listar()
    {

        Cursor cursor;

        String[] campos =  {tabelalogin.ID, tabelalogin.USUARIO, tabelalogin.SENHA};
        db = tabelalogin.getReadableDatabase();
        cursor = db.query(tabelalogin.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;


    }
}
