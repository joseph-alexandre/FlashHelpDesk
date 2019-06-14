//package Util;
//
//import Database.DAO.DAOPersistente.DAOCliente;
//import Model.Cliente;
//
//public class Login {
//
//
//    public static boolean validarLogin(String usuario, String senha) {
//        DAOCliente daoCliente = new DAOCliente();
//        try {
//            Cliente cliente = daoCliente.pegarPorUsuario(usuario);
//            if (usuario.equals(cliente.getUsuario()) && senha.equals(cliente.getSenha())) {
//                System.out.println("Logado com sucesso.");
//                return true;
//            }
//
//        } catch (NullPointerException e) {
//            System.out.println("Login incorreto.");
//        }
//        return false;
//    }
//
//}
