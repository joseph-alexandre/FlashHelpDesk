package View.Cliente.AlterarCliente;

import Database.DAO.DAOPersistente.DAOPersistenteCliente;
import Model.Cliente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AlteracaoClienteController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text LabelCadastrarCliente;

    @FXML
    private JFXButton ButtonAlterar;

    @FXML
    private JFXButton ButtonVoltar;

    @FXML
    private JFXComboBox<String> JFXComboBoxCliente;

    @FXML
    private JFXTextField JFXTextFieldCPF = new JFXTextField();

    @FXML
    private JFXTextField JFXTextFieldNome = new JFXTextField();

    @FXML
    private JFXTextField JFXTextFieldTelefone = new JFXTextField();

    @FXML
    private JFXTextField JFXTextFieldEndereco = new JFXTextField();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarComboBox();
    }

    @FXML
    private void acaoBotaoVoltar(ActionEvent event) throws IOException {
        Parent telaInicialParent = FXMLLoader.load(getClass().getResource("/View/TelaInicial/TelaInicial.fxml"));
        Scene telaInicialScene = new Scene(telaInicialParent);
        Stage tela = (Stage) ((Node)event.getSource()).getScene().getWindow();
        tela.setScene(telaInicialScene);
        tela.show();
    }


    @FXML
    private void carregarComboBox(){
        DAOPersistenteCliente daoCliente = new DAOPersistenteCliente();

        for (Cliente cliente : daoCliente.listarTodos()){
            JFXComboBoxCliente.getItems().addAll(cliente.getNome());
        }


    }

    @FXML
    private void pegarCliente(){
        DAOPersistenteCliente daoCliente = new DAOPersistenteCliente();

        Cliente cliente = daoCliente.pegarPeloNome( JFXComboBoxCliente.getSelectionModel().getSelectedItem());
        JFXTextFieldNome.setText(cliente.getNome());
        JFXTextFieldCPF.setText(cliente.getCpf());
        JFXTextFieldEndereco.setText(cliente.getEndereco());
        JFXTextFieldTelefone.setText(cliente.getTelefone());
    }

    @FXML
    private void acaoBotaoAlterarCliente(){
        DAOPersistenteCliente daoCliente = new DAOPersistenteCliente();
        Cliente cliente = daoCliente.pegarPeloNome(JFXComboBoxCliente.getSelectionModel().getSelectedItem());
        cliente.setNome(JFXTextFieldNome.getText());
        cliente.setEndereco(JFXTextFieldEndereco.getText());
        cliente.setTelefone(JFXTextFieldTelefone.getText());
        daoCliente.alterar(cliente);

    }

}
