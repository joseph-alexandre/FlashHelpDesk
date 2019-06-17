package Database.DAO.DAOVolatil;

import Model.Cliente;
import Model.Mesa;
import Model.Pedido;
import Model.Pizza;

import java.util.List;

public class DAOPedido {

    private Pedido pedido;
    private List<Pizza> pizzas;

    public DAOPedido() {
        pedido = new Pedido();
    }

    public boolean adicionarPizzaNoPedido(Pizza pizza) {
        try {
            pizzas.add(pizza);
            pedido.setPizzas(pizzas);
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean removerPizzaNoPedido(Pizza pizza){
        try {
            pizzas.remove(pizza);
            return true;
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean adicionarClienteNoPedido(Cliente cliente){
        try {
            pedido.setCliente(cliente);
            return true;
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean removerClienteNoPedido(Cliente cliente){
        try {
            pedido.setCliente(null);
            return true;
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public List<Pizza> pegarPizzas() {
        return pedido.getPizzas();
    }

    public Cliente pegarClienteDoPedido(){
        try {
            return pedido.getCliente();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }


}
