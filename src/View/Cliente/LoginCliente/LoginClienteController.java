package View.Cliente.LoginCliente;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginClienteController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Pane paneLogueComoCliente;

    @FXML
    private Text labelLogueComoCliente;

    @FXML
    private Pane paneLoginCliente;

    @FXML
    private JFXTextField JFXTextFieldUsuario;

    @FXML
    private JFXPasswordField JFXTextFieldSenha;

    @FXML
    private JFXButton buttonLogar;

    @FXML
    private Text labelNaoPossuiConta;

    @FXML
    private JFXButton buttonCadastrar;



    @FXML
    private void acaoBotaoCadastrar(ActionEvent actionEvent) throws IOException {
        Parent telaCadastroClienteParent = FXMLLoader.load(getClass().getResource("/View/Cliente/CadastroCliente/CadastroCliente.fxml"));
        Scene telaCadastroClienteScene = new Scene(telaCadastroClienteParent);
        Stage tela = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        tela.setScene(telaCadastroClienteScene);
        tela.show();
    }
}
