package Database.DAO.DAOPersistente;

import Database.Conexao.ConnectionFactory;
import Database.DAO.DAOInterface;
import Model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOProduto implements DAOInterface<Produto> {

    @Override
    public boolean adicionar(Produto produto) {
        Connection conexao = ConnectionFactory.obterConexao();
        int quantidade = 1;
        try {
            String sql = "INSERT INTO produto (nome, cod_barras, preco) VALUES (?,?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(quantidade++, produto.getNome());
            preparedStatement.setString(quantidade++, produto.getCod_barras());
            preparedStatement.setString(quantidade++, String.valueOf(produto.getPreco()));

            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return false;
    }

    @Override
    public Produto pegarPorId(int id) {
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT nome, cod_barras, preco FROM produto WHERE ROWID = ?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setCod_barras(rs.getString("cod_barras"));
                produto.setPreco(Float.parseFloat(rs.getString("preco")));
                return produto;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return null;
    }

    @Override
    public boolean remover(int id) {

        Connection conexao = ConnectionFactory.obterConexao();
        Produto produto = new Produto();
        String sql = "DELETE FROM produto WHERE ROWID = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return false;

    }

    @Override
    public boolean alterar(Produto produto) {
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "UPDATE produto SET nome = ?, preco = ? WHERE cod_barras = ?";
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, String.valueOf(produto.getPreco()));
            preparedStatement.setString(3, produto.getCod_barras());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return false;

    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT nome, cod_barras, preco FROM produto";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setCod_barras(rs.getString("cod_barras"));
                produto.setPreco(Float.parseFloat(rs.getString("preco")));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return produtos;
    }
}
