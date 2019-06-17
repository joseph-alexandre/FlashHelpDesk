package View.Pizza.CadastroPizza;

import Database.DAO.DAOPersistente.DAOPersistentePizza;
import Model.Pizza;
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

public class CadastroPizzaController {


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text LabelCadastrarCliente;

    @FXML
    private JFXButton ButtonCadastrar;

    @FXML
    private JFXTextField JFXTextFieldSabor;

    @FXML
    private JFXTextField JFXTextFieldPreco;

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
        Pizza pizza = new Pizza();
        DAOPersistentePizza daoPizza = new DAOPersistentePizza();
        pizza.setSabor(JFXTextFieldSabor.getText());
        pizza.setPreco(Float.parseFloat(JFXTextFieldPreco.getText()));
        daoPizza.adicionar(pizza);
        System.out.println("Pizza adicionada com sucesso!");
    }



}
