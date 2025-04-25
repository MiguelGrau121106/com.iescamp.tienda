package iescamp.tienda;
import iescamp.tienda.modelo.Usuarios.Cliente;
import iescamp.tienda.modelo.dao.ClienteDAO;
import iescamp.tienda.modelo.dao.RopaDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML private AnchorPane apRoot;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfContrasenya;






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
                Stage stage = (Stage) apRoot.getScene().getWindow();
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
