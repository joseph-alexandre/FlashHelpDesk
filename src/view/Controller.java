package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private void acaoDoBotao(ActionEvent event){
        System.out.println("You clicked me!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
