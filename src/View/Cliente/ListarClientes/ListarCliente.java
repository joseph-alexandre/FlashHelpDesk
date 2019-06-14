package View.Cliente.ListarClientes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListarCliente extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ListarCliente.fxml"));
        primaryStage.setTitle("LunchDesk");
        primaryStage.setScene(new Scene(root));
//        primaryStage.getIcons().add(new Image("file:resources/icons/burguer.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
