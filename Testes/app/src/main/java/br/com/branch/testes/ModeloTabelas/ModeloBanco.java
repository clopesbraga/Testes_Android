package br.com.branch.testes.ModeloTabelas;

/**
 * Created by Cleiton on 26/11/2017.
 */

public class ModeloBanco
{

    private String nome;
    private String bairro;
    private String endereco;
    private String feira;
    private String dia;
    private int _id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getFeira() {return feira; }

    public void setFeira(String feira) { this.feira = feira; }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
