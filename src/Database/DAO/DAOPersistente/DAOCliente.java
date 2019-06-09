package Database.DAO.DAOPersistente;

import Database.Conexao.ConnectionFactory;
import Database.DAO.DAOInterface;
import Model.Cliente;
import Model.Mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente implements DAOInterface<Cliente> {


    @Override
    public boolean adicionar(Cliente cliente) {
        Connection conexao = ConnectionFactory.obterConexao();
        int quantidade = 1;
        try {
            String sql = "INSERT INTO cliente (nome, cpf, usuario, senha) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(quantidade++, cliente.getNome());
            preparedStatement.setString(quantidade++, cliente.getCpf());
            preparedStatement.setString(quantidade++, cliente.getUsuario());
            preparedStatement.setString(quantidade++, cliente.getSenha());
            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return false;

    }

    @Override
    public Cliente pegarPorId(int id) {
        Connection conexao = ConnectionFactory.obterConexao();

        String sql = "SELECT nome, cpf, usuario, senha FROM cliente WHERE ROWID = ?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setUsuario(rs.getString("usuario"));
                cliente.setSenha(rs.getString("senha"));
                return cliente;
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
        Cliente cliente = new Cliente();
        String sql = "DELETE FROM cliente WHERE ROWID = ?";
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
    public boolean alterar(Cliente cliente) {

        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "UPDATE cliente SET nome = ?, usuario = ?, senha = ? WHERE cpf = ?";
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getUsuario());
            preparedStatement.setString(3, cliente.getSenha());
            preparedStatement.setString(4, cliente.getCpf());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return false;
    }

    @Override
    public List<Cliente> listarTodos() {

        List<Cliente> clientes = new ArrayList<>();
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT nome, cpf, usuario, senha FROM cliente";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setUsuario(rs.getString("usuario"));
                cliente.setSenha(rs.getString("senha"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return clientes;
    }

}
