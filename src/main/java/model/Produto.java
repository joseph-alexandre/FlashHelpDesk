package model;

public class Produto {

    private String nome, cod_barras;
    private float preco;

    public Produto(String nome, String cod_barras, float preco) {
        this.nome = nome;
        this.cod_barras = cod_barras;
        this.preco = preco;
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod_barras() {
        return cod_barras;
    }

    public void setCod_barras(String cod_barras) {
        this.cod_barras = cod_barras;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "[Nome: " + nome + ", Código de barras: " + cod_barras + ", Preço: " + preco + "]";
    }

}
