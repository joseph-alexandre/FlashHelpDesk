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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TelaInicialController{


    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Label LabelBemVindo;

    @FXML
    private Label LabelFacaSeuLogin;

    @FXML
    private JFXButton ButtonFuncionario;

    @FXML
    private JFXButton ButtonCliente;


    @FXML
    private void acaoBotaoFuncionario(ActionEvent actionEvent) throws Exception {
        Parent telaLoginFuncionarioParent = FXMLLoader.load(getClass().getResource("/View/LoginFuncionario/LoginFuncionario.fxml"));
        Scene telaLoginFuncionarioScene = new Scene(telaLoginFuncionarioParent);
        Stage tela = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaLoginFuncionarioScene);
        tela.show();
    }

    @FXML
    private void acaoBotaoCliente(ActionEvent actionEvent) throws Exception{
        Parent telaLoginClienteParent = FXMLLoader.load(getClass().getResource("/View/Cliente/LoginCliente/LoginCliente.fxml"));
        Scene telaLoginClienteScene = new Scene(telaLoginClienteParent);
        Stage tela = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaLoginClienteScene);
        tela.show();
    }

}
