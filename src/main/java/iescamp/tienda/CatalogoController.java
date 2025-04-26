package iescamp.tienda;


import iescamp.tienda.modelo.Articulos.Accesorio;
import iescamp.tienda.modelo.Articulos.Articulo;
import iescamp.tienda.modelo.Articulos.Ropa;
import iescamp.tienda.modelo.dao.AccesorioDAO;
import iescamp.tienda.modelo.dao.ArticuloDAO;
import iescamp.tienda.modelo.dao.RopaDAO;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;


public class CatalogoController implements Refrescable {


    @FXML
    private VBox contenedorItems;

    @FXML
    private ComboBox<String> FiltroTipo;
    @FXML
    private ScrollPane scrollPane;

    RopaDAO ropaDAO = new RopaDAO();
    AccesorioDAO accesorioDAO = new AccesorioDAO();
    ArticuloDAO articuloDAO = new ArticuloDAO();


    private GridPane grid = new GridPane();
    private List<Articulo> todosLosArticulos = new ArrayList<>();
    private List<Ropa> todaLaRopa = new ArrayList<>();
    private List<Accesorio> todosLosAccesorios = new ArrayList<>();
    private static final int CURSOS_POR_PAGINA = 9;
    private int paginaActual = 0;

    @Override
    public void refrescar() {
        try {
            cargarContenido("Todos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarContenido(String tipo) {
        List<Articulo> todosLosArticulos = articuloDAO.obtenerTodos();


        FiltroTipo.getItems().clear();
        FiltroTipo.getItems().add("Todos");
        FiltroTipo.getItems().add("Ropa");
        FiltroTipo.getItems().add("Accesorios");
        FiltroTipo.setOnAction(e -> aplicarFiltro(FiltroTipo.getValue()));
        FiltroTipo.setValue("Todos");
        aplicarFiltro("Todos");

        scrollPane.vvalueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.doubleValue() == 1.0) {
                cargarMasCursos();
            }
        });


    }


    private void aplicarFiltro(String tipo) {
        paginaActual = 0;
        grid.getChildren().clear();
        if (tipo.equals("Todos")) {
            todosLosArticulos = articuloDAO.obtenerTodos();
        } else if (tipo.equals("Ropa")) {
            todosLosArticulos = new ArrayList<>(ropaDAO.obtenerTodos());
        } else if (tipo.equals("Accesorios")) {
            todosLosArticulos = new ArrayList<>(accesorioDAO.obtenerTodos());
        }

        cargarMasCursos();
        contenedorItems.getChildren().setAll(grid);

    }

    private void cargarMasCursos() {
        int inicio = paginaActual * CURSOS_POR_PAGINA;
        int fin = Math.min(inicio + CURSOS_POR_PAGINA, todosLosArticulos.size());
        grid.setAlignment(Pos.CENTER);
        int columna = grid.getChildren().size() % 3;
        int fila = grid.getChildren().size() / 3;
        for (int i = inicio; i < fin; i++) {

            if (todosLosArticulos.get(i) instanceof Ropa) {
                Ropa ropa = (Ropa) todosLosArticulos.get(i);

                VBox tarjeta = new VBox(5);
                tarjeta.setPadding(new Insets(10));

                tarjeta.setAlignment(Pos.CENTER);
                Label nombre = new Label(ropa.getNombre());
                ImageView imagen = new ImageView("https://picsum.photos/seed/" + ropa.getNombre() + "/100/100");
                imagen.setFitWidth(100);
                imagen.setFitHeight(100);
                Label precio = new Label(String.valueOf(ropa.getPrecio()));
                Button anyadirAlCarrito = new Button("Añadir al carrito");
                anyadirAlCarrito.setOnAction(e -> System.out.println("Acceso a: " + ropa.getNombre()));
                tarjeta.getChildren().addAll(imagen, nombre, precio, anyadirAlCarrito);
                grid.add(tarjeta, columna, fila);
                columna++;
                if (columna == 3) {
                    columna = 0;
                    fila++;

                }
            } else if (todosLosArticulos.get(i) instanceof Accesorio) {
                Accesorio accesorio = (Accesorio) todosLosArticulos.get(i);

                VBox tarjeta = new VBox(5);
                tarjeta.setPadding(new Insets(10));

                tarjeta.setAlignment(Pos.CENTER);
                Label nombre = new Label(accesorio.getNombre());
                ImageView imagen = new ImageView("https://picsum.photos/seed/" + accesorio.getNombre() + "/100/100");
                imagen.setFitWidth(100);
                imagen.setFitHeight(100);
                Label precio = new Label(String.valueOf(accesorio.getPrecio()));
                Button anyadirAlCarrito = new Button("Añadir al carrito");
                anyadirAlCarrito.setOnAction(e -> System.out.println("Acceso a: " + accesorio.getNombre()));
                tarjeta.getChildren().addAll(imagen, nombre, precio, anyadirAlCarrito);
                grid.add(tarjeta, columna, fila);
                columna++;
                if (columna == 3) {
                    columna = 0;
                    fila++;

                }


            }


            paginaActual++;
        }

    }
}
