package View.Pizza.ListarPizza;

import Database.Conexao.ConnectionFactory;
import Database.DAO.DAOPersistente.DAOPersistentePizza;
import Util.TreeTableView.PizzaPojo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
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

public class ListarPizzaController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text LabelListarClientes;

    @FXML
    private JFXButton ButtonVoltar;

    @FXML
    private JFXTreeTableView<PizzaPojo> JFXTreeTableViewPizzas;

    @FXML
    private JFXTreeTableColumn<PizzaPojo, String> JFXTreeTableColumnSabor = new JFXTreeTableColumn<>("Sabor");

    @FXML
    private JFXTreeTableColumn<PizzaPojo, String> JFXTreeTableColumnPreco = new JFXTreeTableColumn<>("Preço");

    private ObservableList<PizzaPojo> observableList;

    private DAOPersistentePizza daoPizza = new DAOPersistentePizza();


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
        JFXTreeTableColumnSabor.setPrefWidth(222);
        JFXTreeTableColumnSabor.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PizzaPojo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PizzaPojo, String> pizzaPojo) {
                return pizzaPojo.getValue().getValue().saborProperty();
            }
        });

        JFXTreeTableColumnPreco.setPrefWidth(222);
        JFXTreeTableColumnPreco.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PizzaPojo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PizzaPojo, String> pizzaPojo) {
                return pizzaPojo.getValue().getValue().precoProperty();
            }
        });

        observableList = FXCollections.observableArrayList();
        observableList.addAll(popularDados());

        final TreeItem<PizzaPojo> root = new RecursiveTreeItem<PizzaPojo>(observableList, RecursiveTreeObject::getChildren);
        JFXTreeTableViewPizzas.getColumns().setAll(JFXTreeTableColumnSabor, JFXTreeTableColumnPreco);
        JFXTreeTableViewPizzas.setRoot(root);
        JFXTreeTableViewPizzas.setShowRoot(false);

    }

    private List<PizzaPojo> popularDados(){
        List<PizzaPojo> pizzas = new ArrayList<>();
        Connection conexao = ConnectionFactory.obterConexao();
        String sql = "SELECT sabor, preco  FROM pizza";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                PizzaPojo pizzaPojo = new PizzaPojo(rs.getString("sabor"), rs.getString("preco"));
                pizzas.add(pizzaPojo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConexao();
        }
        return pizzas;
    }



}
