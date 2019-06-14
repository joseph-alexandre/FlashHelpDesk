package View.Pizza.AlterarPizza;

import Database.DAO.DAOPersistente.DAOCliente;
import Database.DAO.DAOPersistente.DAOPizza;
import Model.Cliente;
import Model.Pizza;
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

public class AlteracaoPizzaController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text LabelCadastrarCliente;

    @FXML
    private JFXButton ButtonAlterar;

    @FXML
    private JFXButton ButtonVoltar;

    @FXML
    private JFXComboBox<String> JFXComboBoxPizza;

    @FXML
    private JFXTextField JFXTextFieldSabor;

    @FXML
    private JFXTextField JFXTextFieldPreco;


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
        DAOPizza daoPizza = new DAOPizza();
        for (Pizza pizza : daoPizza.listarTodos()){
            JFXComboBoxPizza.getItems().addAll(pizza.getSabor());
        }


    }

    @FXML
    private void pegarPizza(){
        DAOPizza daoPizza = new DAOPizza();
        Pizza pizza = daoPizza.pegarPeloNome(String.valueOf(JFXComboBoxPizza.getSelectionModel().getSelectedItem()));
        JFXTextFieldSabor.setText(pizza.getSabor());
        JFXTextFieldPreco.setText(String.valueOf(pizza.getPreco()));
    }

    @FXML
    private void acaoBotaoAlterarPizza(){
        DAOPizza daoPizza = new DAOPizza();
        Pizza pizza = daoPizza.pegarPeloNome(JFXComboBoxPizza.getSelectionModel().getSelectedItem());
        pizza.setSabor(JFXTextFieldSabor.getText());
        pizza.setPreco(Float.parseFloat(JFXTextFieldPreco.getText()));
        daoPizza.alterar(pizza);
        System.out.println(pizza.getId());

    }

}
