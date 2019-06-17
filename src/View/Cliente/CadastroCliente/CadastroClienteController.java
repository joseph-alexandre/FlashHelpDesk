package View.Cliente.CadastroCliente;

import Database.DAO.DAOPersistente.DAOPersistenteCliente;
import Model.Cliente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroClienteController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text LabelCadastrarCliente;

    @FXML
    private JFXTextField JFXTextFieldCPF;

    @FXML
    private JFXButton ButtonCadastrar;

    @FXML
    private JFXTextField JFXTextFieldNome;

    @FXML
    private JFXTextField JFXTextFieldTelefone;

    @FXML
    private JFXTextField JFXTextFieldEndereco;

    @FXML
    private JFXButton ButtonVoltar;

    @FXML
    private void acaoBotaoVoltar(ActionEvent event) throws IOException {
        Parent telaInicialParent = FXMLLoader.load(getClass().getResource("/View/TelaInicial/TelaInicial.fxml"));
        Scene telaInicialScene = new Scene(telaInicialParent);
        Stage tela = (Stage) ((Node)event.getSource()).getScene().getWindow();
        tela.setScene(telaInicialScene);
        tela.show();
    }

    @FXML
    private void acaoBotaoCadastrar(ActionEvent event) throws IOException{
        Cliente cliente = new Cliente();
        DAOPersistenteCliente daoCliente = new DAOPersistenteCliente();
        cliente.setNome(JFXTextFieldNome.getText());
        cliente.setCpf(JFXTextFieldCPF.getText());
        cliente.setEndereco(JFXTextFieldEndereco.getText());
        cliente.setTelefone(JFXTextFieldTelefone.getText());
        daoCliente.adicionar(cliente);
    }



}
