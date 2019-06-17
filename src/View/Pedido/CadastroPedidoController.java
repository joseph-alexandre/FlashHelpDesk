package View.Pedido;

import Database.DAO.DAOPersistente.DAOPersistenteCliente;
import Database.DAO.DAOPersistente.DAOPersistentePizza;
import Database.DAO.DAOVolatil.DAOPedido;
import Model.Cliente;
import Model.Pizza;
import Util.TreeTableView.PizzaPojo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroPedidoController implements Initializable {

    @FXML
    private JFXButton ButtonCadastrar;

    @FXML
    private JFXButton ButtonVoltar;

    @FXML
    private JFXComboBox<String> JFXComboBoxCliente;

    @FXML
    private JFXComboBox<String> JFXComboBoxPizzas;

    @FXML
    private JFXTextField JFXTextFieldNome = new JFXTextField();

    @FXML
    private JFXTextField JFXTextFieldTelefone = new JFXTextField();

    @FXML
    private JFXTextField JFXTextFieldEndereco = new JFXTextField();

    @FXML
    private JFXTreeTableView<PizzaPojo> JFXTreeTableViewPizzas;

    @FXML
    private Text LabelTotalAPagar;

    @FXML
    private JFXButton ButtonAdicionar;

    @FXML
    private JFXButton ButtonExcluir;

    private float totalAPagar;

    private List<Pizza> pizzas = new ArrayList<>();

    private DAOPedido daoPedido = new DAOPedido();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarComboBoxClientes();
        carregarComboBoxPizzas();
    }

    @FXML
    private void acaoBotaoVoltar(ActionEvent event) throws IOException {
        Parent telaInicialParent = FXMLLoader.load(getClass().getResource("/View/TelaInicial/TelaInicial.fxml"));
        Scene telaInicialScene = new Scene(telaInicialParent);
        Stage tela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tela.setScene(telaInicialScene);
        tela.show();
    }

    @FXML
    private void carregarComboBoxClientes() {
        DAOPersistenteCliente daoCliente = new DAOPersistenteCliente();

        for (Cliente cliente : daoCliente.listarTodos()) {
            JFXComboBoxCliente.getItems().addAll(cliente.getNome());
        }

    }

    @FXML
    private void pegarCliente() {
        DAOPersistenteCliente daoCliente = new DAOPersistenteCliente();
        Cliente cliente = daoCliente.pegarPeloNome(JFXComboBoxCliente.getSelectionModel().getSelectedItem());
        JFXTextFieldNome.setText(cliente.getNome());
        JFXTextFieldEndereco.setText(cliente.getEndereco());
        JFXTextFieldTelefone.setText(cliente.getTelefone());
    }

    @FXML
    private void carregarComboBoxPizzas() {
        DAOPersistentePizza daoPizza = new DAOPersistentePizza();
        for (Pizza pizza : daoPizza.listarTodos()) {
            JFXComboBoxPizzas.getItems().addAll(pizza.getSabor());
        }


    }


}
