package br.com.branch.testes.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class TabelaImagem extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "imagem";
    public static final String ID = "_id";
    public static final String ENDERECO = "endereco";
    private static final int VERSAO = 2;


    public TabelaImagem(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql ="CREATE TABLE " +TABELA+"("+ID +" integer primary key autoincrement,"
                                               + ENDERECO +" text)";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

    }


}
