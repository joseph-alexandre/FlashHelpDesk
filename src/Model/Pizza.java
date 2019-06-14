package Model;

import Database.DAO.DAOPersistente.DAOCliente;
import Database.DAO.DAOPersistente.DAOPizza;

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

    public static void main(String[] args) {

        Pizza pizza = new Pizza();
        pizza.setPreco(35f);
        pizza.setSabor("Calabresa");
        DAOPizza daoPizza = new DAOPizza();

//        daoPizza.adicionar(pizza);
//        System.out.println(daoPizza.listarTodos());
//        Pizza calabresa = daoPizza.pegarPorId(1);
//        System.out.println(calabresa.getPreco());
    }
}
