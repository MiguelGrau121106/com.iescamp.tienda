package iescamp.tienda;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Stack;

public class SessionManager {
    private static SessionManager instancia;

    private String usuario;


    private BorderPane root;

    private final Stack<String> historial = new Stack<>();

    public static void setInstancia(SessionManager instancia) {
        SessionManager.instancia = instancia;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    private SessionManager() {
    }

    public static SessionManager getInstancia() {
        if (instancia == null) {
            instancia = new SessionManager();
        }
        return instancia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }



    public void mostrar(String rutaFxml) throws IOException {
        if (root == null) return;
        Node actual = root.getCenter(); //localizamos la zona central del BorderPane
        if (actual != null && actual.getUserData() != null) {
            historial.push((String) actual.getUserData()); //Esto almacena la rutaFxml del
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFxml)); //cargamos l
        Node vista = loader.load();
        vista.setUserData(rutaFxml); //memorizamos la ruta de la nueva vista
        Object controller = loader.getController(); //Si el controlador de esa vista tiene
        if (controller instanceof Refrescable refrescable) {
            refrescable.refrescar();
        }
        root.setCenter(vista); //colocamos la nueva vista en el centro de la pantalla.
    }







    public void volverAtras() throws IOException {
        if (root == null || historial.isEmpty()) return;
        String anterior = historial.pop(); //esto elimina de la pila la ultima rutafxml in
        mostrar(anterior);
    }

    public boolean sePuedeVolverAtras() { //util si queréis deshabilitar el botón de atrás
        return !historial.isEmpty();
    }

    public void cerrarSesion() {
        this.usuario = null;
        historial.clear(); //limpiamos el historial al cerrar sesión
        root.setCenter(null); //opcional, para limpiar la vista actual
    }
}
