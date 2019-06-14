package View.TelaInicial;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaInicialController {


    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Label LabelBemVindo;

    @FXML
    private Label LabelFacaSeuLogin;

    @FXML
    private JFXButton ButtonAdicionarPizza;

    @FXML
    private Text LabelPizza;

    @FXML
    private JFXButton ButtonExcluirPizza;

    @FXML
    private JFXButton ButtonAlterarPizza;

    @FXML
    private JFXButton ButtonListarPizza;

    @FXML
    private Text LabelCliente;

    @FXML
    private JFXButton ButtonAdicionarCliente;

    @FXML
    private JFXButton ButtonExcluirCliente;

    @FXML
    private JFXButton ButtonAlterarCliente;

    @FXML
    private JFXButton ButtonListarCliente;

    @FXML
    private Text LabelPedido;

    @FXML
    private JFXButton ButtonAdicionarPedido;

    @FXML
    private JFXButton ButtonExcluirPedido;

    @FXML
    private JFXButton ButtonAlterarPedido;

    @FXML
    private JFXButton ButtonListarPedido;

    @FXML
    private JFXButton ButtonSair;


    //    Botões de ação Cliente
    @FXML
    private void acaoBotaoCadastrarCliente(ActionEvent actionEvent) throws Exception {
        Parent telaCadastroClienteParent = FXMLLoader.load(getClass().getResource("/View/Cliente/CadastroCliente/CadastroCliente.fxml"));
        Scene telaCadastroClienteScene = new Scene(telaCadastroClienteParent);
        Stage tela = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaCadastroClienteScene);
        tela.show();
    }

    @FXML
    private void acaoBotaoListarCliente(ActionEvent actionEvent) throws Exception {
        Parent telaListarClienteParent = FXMLLoader.load(getClass().getResource("/View/Cliente/ListarClientes/ListarCliente.fxml"));
        Scene telaListarClienteScene = new Scene(telaListarClienteParent);
        Stage tela = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaListarClienteScene);
        tela.show();
    }

    @FXML
    private void acaoBotaoRemoverCliente(ActionEvent actionEvent) throws Exception {
        Parent telaRemoverClienteParent = FXMLLoader.load(getClass().getResource("/View/Cliente/RemocaoCliente/RemocaoCliente.fxml"));
        Scene telaRemoverClienteScene = new Scene(telaRemoverClienteParent);
        Stage tela = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaRemoverClienteScene);
        tela.show();
    }

    @FXML
    private void acaoBotaoAlterarCliente(ActionEvent actionEvent) throws Exception {
        Parent telaAlterarClienteParent = FXMLLoader.load(getClass().getResource("/View/Cliente/AlterarCliente/AlteracaoCliente.fxml"));
        Scene telaAlterarClienteScene = new Scene(telaAlterarClienteParent);
        Stage tela = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaAlterarClienteScene);
        tela.show();
    }

//    ---------------------------------------------------

    @FXML
    private void acaoBotaoCadastrarPizza(ActionEvent actionEvent) throws Exception {
        Parent telaCadastroPizza = FXMLLoader.load(getClass().getResource("/View/Pizza/CadastroPizza/CadastroPizza.fxml"));
        Scene telaCadastroPizzaScene = new Scene(telaCadastroPizza);
        Stage tela = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaCadastroPizzaScene);
        tela.show();
    }

    @FXML
    private void acaoBotaoListarPizza(ActionEvent actionEvent) throws Exception {
        Parent telaListarPizzaParent = FXMLLoader.load(getClass().getResource("/View/Pizza/ListarPizza/ListarPizza.fxml"));
        Scene telaListarPizzaScene = new Scene(telaListarPizzaParent);
        Stage tela = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaListarPizzaScene);
        tela.show();
    }

    @FXML
    private void acaoBotaoAlterarPizza(ActionEvent actionEvent) throws Exception {
        Parent telaAlterarPizzaParent = FXMLLoader.load(getClass().getResource("/View/Pizza/AlterarPizza/AlteracaoPizza.fxml"));
        Scene telaAlterarPizzaScene = new Scene(telaAlterarPizzaParent);
        Stage tela = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaAlterarPizzaScene);
        tela.show();
    }

    @FXML
    private void acaoBotaoRemoverPizza(ActionEvent actionEvent) throws Exception {
        Parent telaRemoverPizzaParent = FXMLLoader.load(getClass().getResource("/View/Pizza/RemocaoPizza/RemoverPizza.fxml"));
        Scene telaRemoverPizzaScene = new Scene(telaRemoverPizzaParent);
        Stage tela = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaRemoverPizzaScene);
        tela.show();
    }




}
