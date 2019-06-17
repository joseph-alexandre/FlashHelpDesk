package View.Cliente.ListarClientes;

import Database.Conexao.ConnectionFactory;
import Database.DAO.DAOPersistente.DAOPersistenteCliente;
import Util.TreeTableView.ClientePojo;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListarClienteController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text LabelListarClientes;

    @FXML
    private JFXButton ButtonVoltar;

    private List<ClientePojo> clientes = new ArrayList<>();

    @FXML
    private JFXTreeTableView<ClientePojo> JFXTreeTableViewClientes;

    @FXML
    private JFXTreeTableColumn<ClientePojo, String> JFXTreeTableColumnNome = new JFXTreeTableColumn<>("Nome");

    @FXML
    private JFXTreeTableColumn<ClientePojo, String> JFXTreeTableColumnCpf = new JFXTreeTableColumn<>("CPF");

    @FXML
    private JFXTreeTableColumn<ClientePojo, String> JFXTreeTableColumnTelefone = new JFXTreeTableColumn<>("Telefone");

    private ObservableList<ClientePojo> observableList;

    private DAOPersistenteCliente daoCliente = new DAOPersistenteCliente();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarLista();
    }

    @FXML
    private void acaoBotaoVoltar(ActionEvent event) throws IOException {
        Parent telaInicialParent = FXMLLoader.load(getClass().getResource("/View/TelaInicial/TelaInicial.fxml"));
        Scene telaInicialScene = new Scene(telaInicialParent);
        Stage tela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tela.setScene(telaInicialScene);
        tela.show();
    }

    private void carregarLista() {
        JFXTreeTableColumnNome.setPrefWidth(120);
        JFXTreeTableColumnNome.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ClientePojo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ClientePojo, String> clientePojo) {
                return clientePojo.getValue().getValue().nomeProperty();
            }
        });

        JFXTreeTableColumnCpf.setPrefWidth(120);
        JFXTreeTableColumnCpf.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ClientePojo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ClientePojo, String> clientePojo) {
                return clientePojo.getValue().getValue().cpfProperty();
            }
        });

        JFXTreeTableColumnTelefone.setPrefWidth(120);
        JFXTreeTableColumnTelefone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ClientePojo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ClientePojo, String> clientePojo) {
                return clientePojo.getValue().getValue().telefoneProperty();
            }
        });


        observableList = FXCollections.observableArrayList();
        observableList.addAll(
               popularDados());

        final TreeItem<ClientePojo> root = new RecursiveTreeItem<ClientePojo>(observableList, RecursiveTreeObject::getChildren);
        JFXTreeTableViewClientes.getColumns().setAll(JFXTreeTableColumnNome, JFXTreeTableColumnCpf, JFXTreeTableColumnTelefone);
        JFXTreeTableViewClientes.setRoot(root);
        JFXTreeTableViewClientes.setShowRoot(false);

    }

    private List<ClientePojo> popularDados(){
        List<ClientePojo> clientes = new ArrayList<>();
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT nome, cpf, telefone FROM cliente";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                ClientePojo cliente = new ClientePojo(rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return clientes;
    }



}
