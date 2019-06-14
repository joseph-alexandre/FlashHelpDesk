package Model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Pizza> pizzas;
    private float valorTotal;
    private Cliente cliente;

    public Pedido(List<Pizza> pizzas, Cliente cliente) {
        this.pizzas = pizzas;
        this.cliente = cliente;
    }

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

    @Override
    public String toString() {
        return "Pedido: " +
                "\nPizza(s): " + pizzas +
                "\nValorTotal: " + getValorTotal() + "\nPedido efetuado por " + cliente.getNome() + " de CPF: " + cliente.getCpf();
    }

    public static void main(String[] args) {


        Cliente cliente = new Cliente();
        cliente.setNome("John");
        cliente.setCpf("23923230-322323");
        cliente.setTelefone("843034340");
        cliente.setEndereco("Rua das palmeiras");

        ArrayList<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Frango", 35f));
        pizzas.add(new Pizza("Calabresa", 35f));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setPizzas(pizzas);
        System.out.println(pedido);

    }
}
