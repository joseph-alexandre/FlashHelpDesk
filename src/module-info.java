module LunchDesk {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.jfoenix;
    requires javafx.graphics;
    requires java.sql;

    opens View.Cliente.LoginCliente;
    opens View.TelaInicial;
    opens View.LoginFuncionario;
    opens View.Cliente.CadastroCliente;
    opens View.Cliente.FormularioPedido;
}