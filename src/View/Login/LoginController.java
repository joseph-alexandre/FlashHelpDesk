package View.Login;

import Util.LoginValidator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Pane paneLogueComoFuncionario;

    @FXML
    private Text LabelLogueComoFuncionario;

    @FXML
    private Pane paneLogin;

    @FXML
    private JFXTextField JFXTextFieldUsuario;

    @FXML
    private JFXPasswordField JFXTextFieldSenha;

    @FXML
    private JFXButton buttonLogar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void acaoBotaoLogar(ActionEvent actionEvent) throws IOException {

        if (LoginValidator.validarLogin(JFXTextFieldUsuario.getText(), JFXTextFieldSenha.getText())){
            Parent telaInicialParent = FXMLLoader.load(getClass().getResource("/View/TelaInicial/TelaInicial.fxml"));
            Scene telaInicialScene = new Scene(telaInicialParent);
            Stage tela = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            tela.setScene(telaInicialScene);
            tela.show();
        }

    }
}
