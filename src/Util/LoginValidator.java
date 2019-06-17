package Util;

import Database.DAO.DAOPersistente.DAOPersistenteFuncionario;
import Model.Funcionario;

public class LoginValidator {


    public static boolean validarLogin(String usuario, String senha) {
        DAOPersistenteFuncionario daoFuncionario = new DAOPersistenteFuncionario();
        try {
            Funcionario funcionario = daoFuncionario.pegarPeloUsuario(usuario);
            if (usuario.equals(funcionario.getUsuario()) && senha.equals(funcionario.getSenha())) {
                System.out.println("Logado com sucesso.");
                return true;
            }

        } catch (NullPointerException e) {
            System.out.println("LoginValidator incorreto.");
        }
        return false;
    }

}
