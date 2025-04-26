package iescamp.tienda;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;


import java.io.IOException;

public class PortadaController implements Refrescable{

    @FXML
    private BorderPane root;

    @FXML
    private HBox hbHeader, hbFooter, hbCenter;

    @FXML
    private VBox imgRopa, imgAccesorios, vboxMenu;

    @FXML
    private ImageView imgSecondHand, menuButton, imgLupa, imgUser, imgCarro;

    @FXML
    public void initialize() {
        SessionManager.getInstancia().setRoot(root);
        SessionManager.getInstancia().setRoot(root);

        // Ajustar tamaño de los elementos según el tamaño de la ventana
        root.widthProperty().addListener((obs, oldVal, newVal) -> adjustLayout(newVal.doubleValue()));
        root.heightProperty().addListener((obs, oldVal, newVal) -> adjustLayout(root.getWidth()));

        // También puedes ajustar tamaños iniciales de elementos si es necesario
        adjustLayout(root.getWidth());
    }

    // Método para ajustar el tamaño de los elementos basados en el tamaño de la ventana
    private void adjustLayout(double width) {
        double scaleFactor = width / 1280; // Ajusta la referencia de tamaño que consideres
        adjustImageViews(scaleFactor);
    }

    // Ajustar tamaños de las imágenes
    private void adjustImageViews(double scaleFactor) {
        if (imgSecondHand != null) {
            imgSecondHand.setFitWidth(439 * scaleFactor);
            imgSecondHand.setFitHeight(61 * scaleFactor);
        }

        if (menuButton != null) {
            menuButton.setFitWidth(43 * scaleFactor);
            menuButton.setFitHeight(39 * scaleFactor);
        }

        if (imgLupa != null) {
            imgLupa.setFitWidth(52 * scaleFactor);
            imgLupa.setFitHeight(47 * scaleFactor);
        }

        if (imgUser != null) {
            imgUser.setFitWidth(43 * scaleFactor);
            imgUser.setFitHeight(43 * scaleFactor);
        }

        if (imgCarro != null) {
            imgCarro.setFitWidth(56 * scaleFactor);
            imgCarro.setFitHeight(53 * scaleFactor);
        }
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
            SessionManager.getInstancia().mostrar("catalogo.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onAccesorios(){
        try {
            SessionManager.getInstancia().mostrar("catalogo.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void refrescar() {


    }
}