package Database.DAO.DAOPersistente;

import Database.Conexao.ConnectionFactory;
import Database.DAO.DAOInterface;
import Model.Cliente;
import Model.Funcionario;
import Model.Mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOFuncionario implements DAOInterface<Funcionario>  {

    @Override
    public boolean adicionar(Funcionario funcionario) {
        Connection conexao = ConnectionFactory.obterConexao();
        int quantidade = 1;
        try {
            String sql = "INSERT INTO funcionario (nome, cpf, usuario, senha, cod_empresa) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(quantidade++, funcionario.getNome());
            preparedStatement.setString(quantidade++, funcionario.getCpf());
            preparedStatement.setString(quantidade++, funcionario.getUsuario());
            preparedStatement.setString(quantidade++, funcionario.getSenha());
            preparedStatement.setString(quantidade++, funcionario.getCod_empresa());
            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return false;

    }

    @Override
    public Funcionario pegarPorId(int id) {

        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT nome, cpf, usuario, senha, cod_empresa FROM funcionario WHERE ROWID = ?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCod_empresa(rs.getString("cod_empresa"));
                return funcionario;
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
        Funcionario fun = new Funcionario();
        String sql = "DELETE FROM funcionario WHERE ROWID = ?";
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
    public boolean alterar(Funcionario funcionario) {

        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "UPDATE funcionario SET nome = ?, usuario = ?, senha = ? WHERE cod_empresa = ?";
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getUsuario());
            preparedStatement.setString(3, funcionario.getSenha());
            preparedStatement.setString(4, funcionario.getCod_empresa());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return false;
    }

    @Override
    public List<Funcionario> listarTodos() {

        List<Funcionario> funcionarios = new ArrayList<>();
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT nome, cpf, usuario, senha, cod_empresa FROM funcionario";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCod_empresa(rs.getString("cod_empresa"));
                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return funcionarios;
    }

}
