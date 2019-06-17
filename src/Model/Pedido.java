package Model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Pizza> pizzas;
    private float valorTotal;
    private Cliente cliente;
    private StatusPagamento statusPagamento;

    public Pedido() {
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public float getValorTotal() {
        valorTotal = calcularValorTotal();
        return valorTotal;
    }

    private float calcularValorTotal() {
        float valor = 0;
        for (Pizza pizza: pizzas){
            valor += pizza.getPreco();
        }
        return valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido: " +
                "\nPizza(s): " + pizzas +
                "\nValorTotal: " + getValorTotal() + "\nPedido efetuado por " + cliente.getNome() + " de CPF: " + cliente.getCpf();
    }


}
