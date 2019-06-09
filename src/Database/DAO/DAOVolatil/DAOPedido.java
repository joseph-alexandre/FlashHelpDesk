package Database.DAO.DAOVolatil;

import Database.DAO.DAOInterface;
import Model.Pedido;
import Model.Produto;

import java.util.List;

public class DAOPedido implements DAOInterface<Produto> {

    private Pedido pedido;

    @Override
    public boolean adicionar(Produto produto) {

        return false;

    }

    @Override
    public Produto pegarPorId(int id) {
        return null;
    }

    @Override
    public boolean remover(int id) {
        return false;
    }

    @Override
    public boolean alterar(Produto produto) {
        return false;
    }

    @Override
    public List<Produto> listarTodos() {
        return null;
    }
}
