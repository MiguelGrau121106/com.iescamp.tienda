package iescamp.tienda.test;

import com.opencsv.exceptions.CsvException;
import iescamp.tienda.modelo.Articulos.Articulo;
import iescamp.tienda.modelo.Articulos.Material;
import iescamp.tienda.modelo.Usuarios.Cliente;
import iescamp.tienda.modelo.Usuarios.Empleado;
import iescamp.tienda.modelo.Usuarios.Departamento;
import iescamp.tienda.modelo.Usuarios.MetodoPago;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFileUtil {
    private static final String EMPLEADOS_FILE_PATH = "empleados.csv";
    private static final String CLIENTES_FILE_PATH = "clientes.csv";
    private static final String ARTICULOS_FILE_PATH = "articulos.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Articulo> articulos = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\nMenú de Gestión");
            System.out.println("1. Guardar empleados en CSV");
            System.out.println("2. Leer empleados desde CSV");
            System.out.println("3. Guardar clientes en CSV");
            System.out.println("4. Leer clientes desde CSV");
            System.out.println("5. Guardar artículos en CSV");
            System.out.println("6. Leer artículos desde CSV");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    empleados = crearEmpleadosEjemplo();
                    try {
                        fileUtil.guardarEmpleadosEnCsv(empleados, EMPLEADOS_FILE_PATH);
                        System.out.println("Empleados guardados correctamente en " + EMPLEADOS_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Error al guardar empleados: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        empleados = fileUtil.leerEmpleadosDesdeCsv(EMPLEADOS_FILE_PATH);
                        System.out.println("Empleados cargados desde CSV:");
                        empleados.forEach(System.out::println);
                    } catch (IOException | CsvException e) {
                        System.out.println("Error al leer empleados: " + e.getMessage());
                    }
                    break;
                case 3:
                    clientes = crearClientesEjemplo();
                    try {
                        fileUtil.guardarClientesEnCsv(clientes, CLIENTES_FILE_PATH);
                        System.out.println("Clientes guardados correctamente en " + CLIENTES_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Error al guardar clientes: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        clientes = fileUtil.leerClientesDesdeCsv(CLIENTES_FILE_PATH);
                        System.out.println("Clientes cargados desde CSV:");
                        clientes.forEach(System.out::println);
                    } catch (IOException | CsvException e) {
                        System.out.println("Error al leer clientes: " + e.getMessage());
                    }
                    break;
                case 5:
                    articulos = crearArticulosEjemplo();
                    try {
                        fileUtil.guardarArticulosEnCsv(articulos, ARTICULOS_FILE_PATH);
                        System.out.println("Artículos guardados correctamente en " + ARTICULOS_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Error al guardar artículos: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        articulos = fileUtil.leerArticulosDesdeCsv(ARTICULOS_FILE_PATH);
                        System.out.println("Artículos cargados desde CSV:");
                        articulos.forEach(System.out::println);
                    } catch (IOException | CsvException e) {
                        System.out.println("Error al leer artículos: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static List<Empleado> crearEmpleadosEjemplo() {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("12345678A", "Juan", "Pérez", "Calle Falsa 123", "juan@example.com", "600123456",
                LocalDate.of(1990, 5, 10), "password", true, true, new Departamento(1, "Ventas")));
        return empleados;
    }

    private static List<Cliente> crearClientesEjemplo() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("11223344C", "Carlos", "Ruiz", "Plaza Mayor 7", "carlos@example.com", "601112233",
                LocalDate.of(1995, 3, 15), "password", true, "Calle Comercio 1", 150.50f, true, 5, new MetodoPago(1, "Tarjeta de Crédito")));
        return clientes;
    }

    private static List<Articulo> crearArticulosEjemplo() {
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo(new Material(1, "Algodon"), 101, true, "Rojo", "imagen1.jpg", "Camiseta", 50, "NIKE", "Alta Calidad"));
        return articulos;
    }
}
