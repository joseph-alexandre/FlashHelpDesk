package View.LoginFuncionario;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class LoginFuncionarioController  {


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


}
