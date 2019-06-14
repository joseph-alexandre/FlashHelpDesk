module PizzaDesk {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.jfoenix;
    requires javafx.graphics;
    requires java.sql;

    opens View.TelaInicial;
    opens View.LoginFuncionario;
    opens View.Cliente.CadastroCliente;
    opens View.Cliente.ListarClientes;
    opens View.Cliente.RemocaoCliente;
    opens View.Cliente.AlterarCliente;
    opens View.Pizza.CadastroPizza;
    opens View.Pizza.ListarPizza;
    opens View.Pizza.AlterarPizza;
    opens View.Pizza.RemocaoPizza;
}