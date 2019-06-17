package Model;

public class Pizza {
    private int id;
    private String sabor;
    private float preco;

    public Pizza(String sabor, float preco) {
        this.sabor = sabor;
        this.preco = preco;
    }

    public Pizza() {
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pizza de " + sabor;
    }

}
