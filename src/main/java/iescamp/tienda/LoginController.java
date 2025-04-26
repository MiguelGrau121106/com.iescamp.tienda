package iescamp.tienda;
import iescamp.tienda.modelo.Usuarios.Cliente;
import iescamp.tienda.modelo.dao.ClienteDAO;
import iescamp.tienda.modelo.dao.RopaDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {



    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfContrasenya;

    @FXML
    VBox vboxCentral;

    @FXML
    private Pane rootPane;

    @FXML
    private ImageView imagenFondo;

    private final double baseWidth = 800;
    private final double baseHeight = 600;
    private final Scale scale = new Scale();

    @FXML
    public void initialize() {
        // Escalar VBox
        vboxCentral.getTransforms().add(scale);

        // Listener para ajustar escala y centrado
        rootPane.widthProperty().addListener((obs, oldVal, newVal) -> updateLayout());
        rootPane.heightProperty().addListener((obs, oldVal, newVal) -> updateLayout());

        // Ajustar imagen de fondo centrada
        imagenFondo.boundsInParentProperty().addListener((obs, oldVal, newVal) -> centerImage());
        rootPane.widthProperty().addListener((obs, oldVal, newVal) -> centerImage());
        rootPane.heightProperty().addListener((obs, oldVal, newVal) -> centerImage());
    }

    private void updateLayout() {
        double scaleFactor = Math.min(rootPane.getWidth() / baseWidth, rootPane.getHeight() / baseHeight);
        scale.setX(scaleFactor);
        scale.setY(scaleFactor);
        centerVBox();
    }

    private void centerVBox() {
        double width = vboxCentral.getBoundsInParent().getWidth();
        double height = vboxCentral.getBoundsInParent().getHeight();
        vboxCentral.setLayoutX((rootPane.getWidth() - width) / 2);
        vboxCentral.setLayoutY((rootPane.getHeight() - height) / 2);
    }

    private void centerImage() {
        imagenFondo.setLayoutX((rootPane.getWidth() - imagenFondo.getBoundsInParent().getWidth()) / 2);
        imagenFondo.setLayoutY((rootPane.getHeight() - imagenFondo.getBoundsInParent().getHeight()) / 2);
    }



    @FXML
    private void iniciarSesion() {
        try {
            if (tfEmail.getText().isEmpty() || tfContrasenya.getText().isEmpty()) {
                return;
            }

            String email = tfEmail.getText();
            String contrasenya = tfContrasenya.getText();

            ClienteDAO clienteDAO = new ClienteDAO();

            Cliente cliente1 = clienteDAO.autenticarCliente(email, contrasenya);
            if (cliente1 != null)

            {


                FXMLLoader loader = new FXMLLoader(getClass().getResource("Portada.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) rootPane.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Portada");
            } else {

                // Mostrar mensaje de error
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
