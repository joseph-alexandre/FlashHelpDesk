package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private StatusPedido status;

    public Pedido(ArrayList<Produto> produtos, StatusPedido status) {
        this.produtos = produtos;
        this.status = status;
    }

    public Pedido() {
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void addProdutos(Produto produto) {
            produtos.add(produto);
    }

    public float getTotal() {
        float total = 0;
        for (Produto produto: this.produtos){
            total += produto.getPreco();
        }
        return total;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Itens: "+ produtos + ". " + "Status do pedido: " + getStatus() + ".";
    }

}
