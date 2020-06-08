package br.com.branch.testes.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class TabelaProdutos extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "produto";
    public static final String ID = "_id";
    public static final String PRODUTO = "usuario";
    private static final int VERSAO = 1;


    public TabelaProdutos(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql ="CREATE TABLE " +TABELA+"("+ID +" integer primary key autoincrement,"
                                               + PRODUTO +"text"+")";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

    }


}
