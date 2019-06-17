package Database.DAO.DAOPersistente;

import Database.Conexao.ConnectionFactory;
import Database.DAO.DAOPersistenteInterface;
import Model.Pizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPersistentePizza implements DAOPersistenteInterface<Pizza> {

    @Override
    public boolean adicionar(Pizza pizza) {
        Connection conexao = ConnectionFactory.obterConexao();
        int quantidade = 1;
        try {
            String sql = "INSERT INTO pizza (sabor, preco) VALUES (?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(quantidade++, pizza.getSabor());
            preparedStatement.setString(quantidade++, String.valueOf(pizza.getPreco()));
            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return false;
    }

    @Override
    public Pizza pegarPeloNome(String nome) {
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT sabor, preco, id_pizza FROM pizza WHERE sabor = ?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                Pizza pizza = new Pizza();
                pizza.setSabor(rs.getString("sabor"));
                pizza.setPreco(Float.parseFloat(rs.getString("preco")));
                pizza.setId(rs.getInt("id_pizza"));
                return pizza;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return null;
    }

    @Override
    public boolean removerPeloNome(String nome) {

        Connection conexao = ConnectionFactory.obterConexao();
        Pizza produto = new Pizza();
        String sql = "DELETE FROM pizza WHERE sabor = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return false;

    }

    @Override
    public boolean alterar(Pizza pizza) {
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "UPDATE pizza SET sabor = ?, preco = ? WHERE id_pizza = ?";
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, pizza.getSabor());
            preparedStatement.setString(2, String.valueOf(pizza.getPreco()));
            preparedStatement.setInt(3, pizza.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return false;

    }

    @Override
    public List<Pizza> listarTodos() {
        List<Pizza> pizzas = new ArrayList<>();
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT id_pizza, sabor, preco FROM pizza";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                Pizza pizza = new Pizza();
                pizza.setId(rs.getInt("id_pizza"));
                pizza.setSabor(rs.getString("sabor"));
                pizza.setPreco(Float.parseFloat(rs.getString("preco")));
                pizzas.add(pizza);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return pizzas;
    }
}
