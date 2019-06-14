package View.Cliente.RemocaoCliente;

import Database.DAO.DAOPersistente.DAOCliente;
import Model.Cliente;
import Util.TreeTableView.ClientePojo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class RemocaoClienteController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text LabelCadastrarCliente;

    @FXML
    private JFXButton ButtonCadastrar;

    @FXML
    private JFXTextField JFXTextFieldCPF = new JFXTextField();

    @FXML
    private JFXTextField JFXTextFieldNome = new JFXTextField();

    @FXML
    private JFXTextField JFXTextFieldTelefone = new JFXTextField();

    @FXML
    private JFXTextField JFXTextFieldEndereco = new JFXTextField();

    @FXML
    private JFXButton ButtonVoltar;

    @FXML
    private JFXComboBox<String> JFXComboBoxClientes;

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
        DAOCliente daoCliente = new DAOCliente();

        for (Cliente cliente : daoCliente.listarTodos()){
            JFXComboBoxClientes.getItems().addAll(cliente.getNome());
        }


    }

    @FXML
    private void pegarCliente(){
        DAOCliente daoCliente = new DAOCliente();

        Cliente cliente = daoCliente.pegarPeloNome( JFXComboBoxClientes.getSelectionModel().getSelectedItem());
        JFXTextFieldNome.setText(cliente.getNome());
        JFXTextFieldCPF.setText(cliente.getCpf());
        JFXTextFieldEndereco.setText(cliente.getEndereco());
        JFXTextFieldTelefone.setText(cliente.getTelefone());
    }

    @FXML
    private void acaoBotaoRemoverCliente(){
        DAOCliente daoCliente = new DAOCliente();
        daoCliente.removerPeloNome(JFXTextFieldNome.getText());
        limparCampoRemovido();
    }

    private void limparCampoRemovido(){
        JFXTextFieldNome.setText("");
        JFXTextFieldCPF.setText("");
        JFXTextFieldEndereco.setText("");
        JFXTextFieldTelefone.setText("");
    }
}
