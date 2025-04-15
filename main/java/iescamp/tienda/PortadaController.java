package iescamp.tienda;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

public class PortadaController implements Refrescable{

    @FXML
    private BorderPane root;

    @FXML
    public void initialize() {
        SessionManager.getInstancia().setRoot(root);
    }




    @FXML
    public void onInicio() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Portada.fxml"));
            Parent root2 = loader.load();
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(root2));
            stage.setTitle("Portada");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private ImageView menuButton;

    @FXML
    private VBox vboxMenu;

    @FXML
    public void onMenu(){

        if (((int) vboxMenu.getWidth()) > 1){



            vboxMenu.setPrefWidth(0);
            vboxMenu.setVisible(false);
        } else {


            vboxMenu.setPrefWidth(200);
            vboxMenu.setVisible(true);

        }

    }





    @FXML
    public void onRopa() {
        try {
            SessionManager.getInstancia().mostrar("articulos.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onAccesorios(){
        try {
            SessionManager.getInstancia().mostrar("articulos.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void refrescar() {


    }
}