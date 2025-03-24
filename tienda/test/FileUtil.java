package iescamp.tienda.test;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import iescamp.tienda.modelo.Articulos.Articulo;
import iescamp.tienda.modelo.Articulos.Catalogo;
import iescamp.tienda.modelo.Articulos.*;
import iescamp.tienda.modelo.Pedidos.Ventas;
import iescamp.tienda.modelo.Usuarios.Clientela;
import iescamp.tienda.modelo.Usuarios.*;
import iescamp.tienda.modelo.Pedidos.*;
import iescamp.tienda.modelo.Usuarios.Plantilla;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class FileUtil {



    public static void serializarCatalogo(Catalogo catalogo) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream("catalogo.dat"))) {
            oos.writeObject(catalogo);
            System.out.println("Objeto serializado");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void serializarVentas(Ventas ventas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream("ventas.dat"))) {
            oos.writeObject(ventas);
            System.out.println("Objeto serializado");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serializarClientela(Clientela clientela) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream("clientela.dat"))) {
            oos.writeObject(clientela);
            System.out.println("Objeto serializado");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serializarPlantilla(Plantilla plantilla) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream("plantilla.dat"))) {
            oos.writeObject(plantilla);
            System.out.println("Objeto serializado");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static Catalogo desSerializarCatalogo() {
        try (ObjectInputStream ois = new ObjectInputStream(new
                FileInputStream("catalogo.dat"))) {
            Catalogo catalogo = (Catalogo) ois.readObject();
            System.out.println("Catalogo deserializado ");
            return catalogo;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar catalogo");
            e.printStackTrace();
            return null;
        }
    }


    public static Ventas desSerializarVentas() {
        try (ObjectInputStream ois = new ObjectInputStream(new
                FileInputStream("ventas.dat"))) {
            Ventas ventas = (Ventas) ois.readObject();
            System.out.println("Ventas deserializado ");
            return ventas;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar ventas");
            e.printStackTrace();
            return null;
        }
    }


    public static Clientela desSerializarClientela() {
        try (ObjectInputStream ois = new ObjectInputStream(new
                FileInputStream("clientela.dat"))) {
            Clientela clientela = (Clientela) ois.readObject();
            System.out.println("Clientela deserializado ");
            return clientela;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar clientela");
            e.printStackTrace();
            return null;
        }
    }


    public static Plantilla desSerializarPlantilla() {
        try (ObjectInputStream ois = new ObjectInputStream(new
                FileInputStream("plantilla.dat"))) {
            Plantilla plantilla = (Plantilla) ois.readObject();
            System.out.println("Plantilla deserializado ");
            return plantilla;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar plantilla");
            e.printStackTrace();
            return null;
        }
    }


    public static void serializarJsonPlantilla(Plantilla plantilla) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            mapper.writeValue(new File("plantilla.json"), plantilla);
            System.out.println("Archivo JSON creado.");
        } catch (IOException e) {

            System.out.println("Error al escribir el archivo JSON.");
            e.printStackTrace();
        }


    }


    public static Plantilla desSerializarJsonPlantilla() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            Plantilla plantilla = mapper.readValue(new File("plantilla.json"), Plantilla.class);
            System.out.println("Archivo JSON leido.");
            return plantilla;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON.");
            e.printStackTrace();
            return null;
        }
    }

    public static void serializarJsonCatalogo(Catalogo catalogo) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            mapper.writeValue(new File("catalogo.json"), catalogo);
            System.out.println("Archivo JSON creado.");
        } catch (IOException e) {

            System.out.println("Error al escribir el archivo JSON.");
            e.printStackTrace();
        }
    }


    public static Catalogo desSerializarJsonCatalogo() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {

            Catalogo catalogo = mapper.readValue(new File("catalogo.json"), Catalogo.class);
            System.out.println("Archivo JSON leido.");
            return catalogo;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON.");
            e.printStackTrace();
            return null;
        }
    }


    public static void serializarJsonVentas(Ventas ventas) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            mapper.writeValue(new File("ventas.json"), ventas);
            System.out.println("Archivo JSON creado.");
        } catch (IOException e) {

            System.out.println("Error al escribir el archivo JSON.");
            e.printStackTrace();

            }
    }

    public static Ventas desSerializarJsonVentas() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            Ventas ventas = mapper.readValue(new File("ventas.json"), Ventas.class);
            System.out.println("Archivo JSON leido.");
            return ventas;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON.");
            e.printStackTrace();
            return null;
        }
    }

    public static void serializarJsonClientela(Clientela clientela) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            mapper.writeValue(new File("clientela.json"), clientela);
            System.out.println("Archivo JSON creado.");
        } catch (IOException e) {

            System.out.println("Error al escribir el archivo JSON.");
            e.printStackTrace();

        }

    }

    public static Clientela desSerializarJsonClientela(){

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            Clientela clientela = mapper.readValue(new File("ventas.json"), Clientela.class);
            System.out.println("Archivo JSON leido.");
            return clientela;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON.");
            e.printStackTrace();
            return null;
        }
    }



    // Empleados
    public static void guardarEmpleadosEnCsv(List<Empleado> empleados, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"DNI", "Nombre", "Apellidos", "Dirección", "Correo Electrónico", "Teléfono", "Fecha Nacimiento", "Contraseña", "Activo", "Privilegios", "Departamento"});
            for (Empleado e : empleados) {
                writer.writeNext(new String[]{
                        e.getDNI(), e.getNombre(), e.getApellidos(), e.getDireccion(), e.getCorreoElectronico(),
                        e.getTelefono(), e.getFechaNacimiento().toString(), e.getPass(),
                        String.valueOf(e.isActivo()), String.valueOf(e.isPrivilegio()),
                        e.getDepartamento().getNombre()
                });
            }
        }
    }

    public static List<Empleado> leerEmpleadosDesdeCsv(String filePath) throws IOException, CsvException {
        List<Empleado> empleados = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> datos = reader.readAll();
            datos.remove(0); // Eliminar encabezado
            for (String[] fila : datos) {
                Empleado empleado = new Empleado(
                        fila[0], fila[1], fila[2], fila[3], fila[4], fila[5],
                        LocalDate.parse(fila[6]), fila[7], Boolean.parseBoolean(fila[8]),
                        Boolean.parseBoolean(fila[9]), new Departamento(0, fila[10])
                );
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    // Clientes
    public static void guardarClientesEnCsv(List<Cliente> clientes, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"DNI", "Nombre", "Apellidos", "Dirección", "Correo Electrónico", "Teléfono", "Fecha Nacimiento", "Contraseña", "Activo", "Dirección Envío", "Saldo Cuenta", "Tarjeta Fidelidad", "Pedidos Realizados", "Código Método Pago", "Descripción Método Pago"});
            for (Cliente c : clientes) {
                writer.writeNext(new String[]{
                        c.getDNI(), c.getNombre(), c.getApellidos(), c.getDireccion(), c.getCorreoElectronico(),
                        c.getTelefono(), c.getFechaNacimiento().toString(), c.getPass(),
                        String.valueOf(c.isActivo()), c.getDireccionEnvio(), String.valueOf(c.getSaldoCuenta()),
                        String.valueOf(c.isTieneTarjetaFidelidad()), String.valueOf(c.getNumeroPedidosRealizados()),
                        String.valueOf(c.getMetodoPago().getCodigo()), c.getMetodoPago().getDescripcion()
                });
            }
        }
    }

    public static List<Cliente> leerClientesDesdeCsv(String filePath) throws IOException, CsvException {
        List<Cliente> clientes = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> datos = reader.readAll();
            datos.remove(0); // Eliminar encabezado
            for (String[] fila : datos) {
                Cliente cliente = new Cliente(
                        fila[0], fila[1], fila[2], fila[3], fila[4], fila[5],
                        LocalDate.parse(fila[6]), fila[7], Boolean.parseBoolean(fila[8]),
                        fila[9], Float.parseFloat(fila[10]), Boolean.parseBoolean(fila[11]),
                        Integer.parseInt(fila[12]), new MetodoPago(Integer.parseInt(fila[13]), fila[14])
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    // Articulos
    public static void guardarArticulosEnCsv(List<Articulo> articulos, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"Código", "Nombre", "Descripción", "Marca", "Precio", "Color", "Imagen", "Activo", "Código Material", "Denominación Material"});
            for (Articulo a : articulos) {
                writer.writeNext(new String[]{
                        String.valueOf(a.getCod_art()), a.getNombre(), a.getDescripcion(),
                        a.getMarca(), String.valueOf(a.getPrecio()), a.getColor(),
                        a.getImagen(), String.valueOf(a.isActivo()),
                        String.valueOf(a.getMaterial().getCodigo()), a.getMaterial().getDenominacion()
                });
            }
        }
    }

    public static List<Articulo> leerArticulosDesdeCsv(String filePath) throws IOException, CsvException {
        List<Articulo> articulos = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> datos = reader.readAll();
            datos.remove(0); // Eliminar encabezado
            for (String[] fila : datos) {

                Articulo articulo = new Articulo(new Material(Integer.parseInt(fila[8]), fila[9]), Integer.parseInt(fila[0]), Boolean.parseBoolean(fila[7]), fila[5], fila[6], fila[1], Double.parseDouble(fila[4]), fila[3], fila[2]);
                articulos.add(articulo);
            }
        }
        return articulos;
    }


}




