package iescamp.tienda.tienda.test;


import com.opencsv.exceptions.CsvException;
import iescamp.tienda.dao.AccesorioDAO;
import iescamp.tienda.dao.*;
import iescamp.tienda.modelo.Articulos.*;
import iescamp.tienda.modelo.Pedidos.Pedido;
import iescamp.tienda.modelo.Pedidos.Ventas;
import iescamp.tienda.modelo.Usuarios.*;
import iescamp.tienda.test.ConsoleReader;
import iescamp.tienda.test.ConsoleUtil;
import iescamp.tienda.test.FileUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiendaConsola {
    static Ventas ventas = new Ventas();
    static Catalogo catalogo = new Catalogo();
    static Clientela clientela = new Clientela();
    static Plantilla plantilla = new Plantilla();
    static ArrayList<Departamento> departamentos = new ArrayList<>();
    static ArrayList<Material> materiales = new ArrayList<>();
    static ArrayList<MetodoPago> metodosPago = new ArrayList<>();


    private static final ArticuloDAO articuloDAO = new ArticuloDAO();
    private static final RopaDAO ropaDAO = new RopaDAO();
    private static final AccesorioDAO accesorioDAO = new AccesorioDAO();
    private static final EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private static final ClienteDAO clienteDAO = new ClienteDAO();
    private static final PedidoDAO pedidoDAO = new PedidoDAO();


    public static void main(String[] args) {

        AccesorioDAO Adao = new AccesorioDAO();

        Bolso bolso;


        bolso = (Bolso) Adao.obtenerPorId(19);

        System.out.println(bolso);




        mostrarMenu();


    }


    private static void mostrarMenu() {
        System.out.println("Menu" + "\n");
        System.out.println("1. Plantilla");
        System.out.println("2. Clientela");
        System.out.println("3. Catalogo");
        System.out.println("4. Ventas");
        System.out.println("5. Opciones con la base de datos");
        System.out.println("6. Salir");


        System.out.println("Introduce una opcion: ");
        int opcion = iescamp.tienda.test.ConsoleReader.readInt();

        switch (opcion) {
            case 1:
                menuPlantilla();
                break;
            case 2:
                menuClientela();
                break;
            case 3:
                menuCatalogo();
                break;
            case 4:
                menuVentas();
                break;
            case 5:
                menuBaseDatos();
                break;
            case 6:
                System.out.println("Hasta luego");
                break;
            default:
                System.out.println("Opcion no valida");
                mostrarMenu();
        }
    }

    private static void menuPlantilla() {
        System.out.println("Menu Plantilla" + "\n");
        System.out.println("1. Listar empleados");
        System.out.println("2. Añadir empleado");
        System.out.println("3. Opciones de archivos");
        System.out.println("7. Volver al menu principal");
        System.out.println("Introduce una opcion: ");
        System.out.println("Introduce una opcion: ");

        int opcion = iescamp.tienda.test.ConsoleReader.readInt();

        switch (opcion) {
            case 1:
                if (plantilla.getEmpleados().isEmpty()) {
                    System.out.println("No hay empleados todavía");
                    menuPlantilla();
                }
                System.out.println(plantilla.listarEmpleados());
                menuPlantilla();
                break;
            case 2:

                System.out.println("1. Crear departamento tambien \n2. Añadir a un departamento ya existente");
                opcion = iescamp.tienda.test.ConsoleReader.readInt();
                if (opcion == 1) {
                    Departamento departamento = iescamp.tienda.test.ConsoleUtil.crearDepartamento();
                    departamentos.add(departamento);
                    plantilla.addEmpleado(iescamp.tienda.test.ConsoleUtil.crearEmpleado(departamento));
                    menuPlantilla();
                } else if (opcion == 2) {
                    if (departamentos.isEmpty()) {
                        System.out.println("No hay departamentos todavía");
                        menuPlantilla();
                    }
                    int codigoDepartamento = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del departamento");
                    for (Departamento departamento : departamentos) {
                        if (departamento.getCodigo() == codigoDepartamento) {
                            plantilla.addEmpleado(iescamp.tienda.test.ConsoleUtil.crearEmpleado(departamento));
                            menuPlantilla();
                        }
                    }

                }


                break;


            case 3:
                menuPlantillaArchivos();
                break;

            case   4:

            case 7:
                mostrarMenu();
                break;
            default:
                System.out.println("Opcion no valida");
                menuPlantilla();
        }

    }


    private static void menuClientela() {
        System.out.println("Menu Clientela" + "\n");
        System.out.println("1. Listar clientes");
        System.out.println("2. Añadir cliente");
        System.out.println("3. Opciones de archivos");
        System.out.println("5. Volver al menu principal");
        System.out.println("Introduce una opcion: ");
        int opcion = iescamp.tienda.test.ConsoleReader.readInt();
        switch (opcion) {
            case 1:
                if (clientela.getClientes().isEmpty()) {
                    System.out.println("No hay clientes todavía");
                    menuClientela();
                }
                System.out.println(clientela.listarClientes());
                break;
            case 2:

                System.out.println("1. Crear metodo de pago tambien \n2. Añadir a un metodo de pago ya existente");
                opcion = iescamp.tienda.test.ConsoleReader.readInt();
                if (opcion == 1) {
                    MetodoPago metodoPago = iescamp.tienda.test.ConsoleUtil.crearMetodoPago();
                    metodosPago.add(metodoPago);
                    clientela.addCliente(iescamp.tienda.test.ConsoleUtil.crearCliente(metodoPago));
                } else if (opcion == 2) {
                    if (metodosPago.isEmpty()) {
                        System.out.println("No hay metodos de pago todavía");
                        menuClientela();
                    }
                    int codigoMetodoPago = iescamp.tienda.test.ConsoleReader.readInt("Introduce el id del metodo de pago");
                    for (MetodoPago metodoPago : metodosPago) {
                        if (metodoPago.getCodigo() == codigoMetodoPago) {
                            clientela.addCliente(iescamp.tienda.test.ConsoleUtil.crearCliente(metodoPago));
                            menuClientela();
                        }
                    }

                }
                clientela.addCliente(iescamp.tienda.test.ConsoleUtil.crearCliente(iescamp.tienda.test.ConsoleUtil.crearMetodoPago()));
                menuClientela();

                break;

            case 3:
                try {
                    menuClientelaArchivos();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (CsvException e) {
                    throw new RuntimeException(e);
                }
                break;

            case 5:
                mostrarMenu();
                break;
            default:
                System.out.println("Opcion no valida");
                menuClientela();
        }
    }

    private static void menuVentas() {
        System.out.println("Menu Ventas" + "\n");
        System.out.println("1. Listar pedidos");

        System.out.println("3. Serializar Ventas");
        System.out.println("4. Volver al menu principal");
        System.out.println("Introduce una opcion: ");
        int opcion = iescamp.tienda.test.ConsoleReader.readInt();
        switch (opcion) {
            case 1:
                if (ventas.getPedidos().isEmpty()) {
                    System.out.println("No hay ventas todavía");
                    menuVentas();
                }
                System.out.println(ventas.listarPedidos());
                break;
            case 2:

                break;

            case 3:
                iescamp.tienda.test.FileUtil.serializarVentas(ventas);
                menuVentas();
                break;


            case 4:
                ventas = iescamp.tienda.test.FileUtil.desSerializarVentas();
                menuVentas();
                break;
            case 5:
                mostrarMenu();
                break;
            default:
                System.out.println("Opcion no valida");
                menuVentas();
        }
    }


    private static void menuCatalogo() {
        System.out.println("Menu Catalogo" + "\n");
        System.out.println("1. Listar articulos");
        System.out.println("2. Añadir articulo");
        System.out.println("3. Opciones de archivos");
        System.out.println("7. Volver al menu principal");
        System.out.println("Introduce una opcion: ");
        int opcion = iescamp.tienda.test.ConsoleReader.readInt();
        switch (opcion) {
            case 1:
                System.out.println(catalogo.ListarArticulos());
                menuCatalogo();
                break;
            case 2:
                int opcion_tipo = iescamp.tienda.test.ConsoleReader.readInt("Introduce el tipo de articulo: \n1. Camisa \n2. Chaqueta \n3. Pantalon \n4. Zapato \n5. Bolso \n6. Salir");
                switch (opcion_tipo) {
                    case 1:
                        CrearCamisa();
                        break;
                    case 2:
                        CrearChaqueta();
                        break;
                    case 3:
                        CrearPantalon();
                        break;
                    case 4:
                        CrearZapato();
                        break;
                    case 5:
                        CrearBolso();
                        break;
                    case 6:
                        menuCatalogo();
                }

            case 3:
                try {
                    menuCatalogoArchivos();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (CsvException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 7:

                mostrarMenu();
                break;
            default:
                System.out.println("Opcion no valida");
                menuCatalogo();
        }
    }

    private static void CrearCamisa() {
        int opcion_CrearMaterial = iescamp.tienda.test.ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = iescamp.tienda.test.ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(iescamp.tienda.test.ConsoleUtil.crearCamisa(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(iescamp.tienda.test.ConsoleUtil.crearCamisa(material));
                    menuCatalogo();
                }
            }
        }


    }


    private static void CrearChaqueta() {
        int opcion_CrearMaterial = iescamp.tienda.test.ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = iescamp.tienda.test.ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(iescamp.tienda.test.ConsoleUtil.crearChaqueta(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(iescamp.tienda.test.ConsoleUtil.crearChaqueta(material));
                    menuCatalogo();
                }
            }
        }


    }

    private static void CrearPantalon() {
        int opcion_CrearMaterial = iescamp.tienda.test.ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = iescamp.tienda.test.ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(iescamp.tienda.test.ConsoleUtil.crearPantalon(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(iescamp.tienda.test.ConsoleUtil.crearPantalon(material));
                    menuCatalogo();
                }
            }
        }


    }

    private static void CrearZapato() {
        int opcion_CrearMaterial = iescamp.tienda.test.ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = iescamp.tienda.test.ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(iescamp.tienda.test.ConsoleUtil.crearZapato(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(iescamp.tienda.test.ConsoleUtil.crearZapato(material));
                    menuCatalogo();
                }
            }
        }


    }


    private static void CrearBolso() {
        int opcion_CrearMaterial = iescamp.tienda.test.ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = iescamp.tienda.test.ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(iescamp.tienda.test.ConsoleUtil.crearBolso(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearBolso(material));
                    menuCatalogo();
                }
            }
        }


    }


    private static void menuCatalogoArchivos() throws IOException, CsvException {
        System.out.println("Opciones con archivos...");
        System.out.println("1. Serializar Catalogo");
        System.out.println("2. DesSerializar Catalogo");
        System.out.println("3. Serializar en Json");
        System.out.println("4. DesSerializar en Json");
        System.out.println("5. Guardar en CSV");
        System.out.println("6. Leer desde CSV");
        System.out.println("7. Salir");

        int opcion = iescamp.tienda.test.ConsoleReader.readInt("Introduce una opcion...");

        switch (opcion) {
            case 1:
                iescamp.tienda.test.FileUtil.serializarCatalogo(catalogo);
                menuCatalogoArchivos();
                break;

            case 2:
                catalogo = iescamp.tienda.test.FileUtil.desSerializarCatalogo();
                menuCatalogoArchivos();
                break;

            case 3:
                iescamp.tienda.test.FileUtil.serializarJsonCatalogo(catalogo);
                menuCatalogoArchivos();
                break;

            case 4:
                catalogo = iescamp.tienda.test.FileUtil.desSerializarJsonCatalogo();
                menuCatalogoArchivos();
                break;
            case 5:
                iescamp.tienda.test.FileUtil.guardarArticulosEnCsv(catalogo,"catalogo.csv");
                menuCatalogoArchivos();
                break;

            case 6:
                catalogo = iescamp.tienda.test.FileUtil.leerArticulosDesdeCsv("catalogo.csv");
                menuCatalogoArchivos();
                break;
            case 7:
                menuCatalogo();
        }

    }

    private static void menuClientelaArchivos() throws IOException, CsvException {
        System.out.println("Opciones con archivos...");
        System.out.println("1. Serializar Clientela");
        System.out.println("2. DesSerializar Clientela");
        System.out.println("3. Serializar en Json");
        System.out.println("4. DesSerializar en Json");
        System.out.println("5. Guardar en CSV");
        System.out.println("6. Leer desde CSV");
        System.out.println("7. Salir");

        int opcion = iescamp.tienda.test.ConsoleReader.readInt("Introduce una opcion...");

        switch (opcion) {
            case 1:
                iescamp.tienda.test.FileUtil.serializarClientela(clientela);
                menuClientelaArchivos();
                break;
            case 2:
                clientela = iescamp.tienda.test.FileUtil.desSerializarClientela();
                menuClientelaArchivos();
                break;
            case 3:
                iescamp.tienda.test.FileUtil.serializarJsonClientela(clientela);
                menuClientelaArchivos();
                break;
            case 4:
                clientela = iescamp.tienda.test.FileUtil.desSerializarClientela();
                menuClientelaArchivos();
                break;
            case 5:
                iescamp.tienda.test.FileUtil.guardarClientesEnCsv(clientela, "clientela.csv");
                menuClientelaArchivos();
                break;

            case 6:
                clientela = iescamp.tienda.test.FileUtil.leerClientesDesdeCsv("clientela.csv");
                menuClientelaArchivos();
                break;

            case 7:
                menuClientela();
        }


    }

    private static void menuPlantillaArchivos() {
        System.out.println("Opciones con archivos...");
        System.out.println("1. Serializar Plantilla");
        System.out.println("2. DesSerializar Plantilla");
        System.out.println("3. Serializar en Json");
        System.out.println("4. DesSerializar en Json");
        System.out.println("5. Guardar en CSV");
        System.out.println("6. Leer desde CSV");
        System.out.println("7. Salir");

        int opcion = iescamp.tienda.test.ConsoleReader.readInt("Introduce una opcion...");

        switch (opcion) {
            case 1:
                iescamp.tienda.test.FileUtil.serializarPlantilla(plantilla);
                menuPlantillaArchivos();
                break;
            case 2:
                plantilla = iescamp.tienda.test.FileUtil.desSerializarPlantilla();
                menuPlantillaArchivos();
                break;
            case 3:
                iescamp.tienda.test.FileUtil.serializarJsonPlantilla(plantilla);
                menuPlantillaArchivos();
                break;
            case 4:
                plantilla = iescamp.tienda.test.FileUtil.desSerializarJsonPlantilla();
                menuPlantillaArchivos();
                break;
            case 5:
                try {
                    iescamp.tienda.test.FileUtil.guardarEmpleadosEnCsv(plantilla, "plantilla.csv");
                    menuPlantillaArchivos();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case 6:
                plantilla = FileUtil.leerEmpleadosDesdeCsv("plantilla.csv");
                menuPlantillaArchivos();
                break;

            case 7:
                menuPlantilla();
        }

    }

    private static void menuBaseDatos(){
        System.out.println("Menu Base de Datos" + "\n");
        System.out.println("1. Base de Datos Articulos");
        System.out.println("2. Base de Datos Clientes");
        System.out.println("3. Base de Datos Empleados");
        System.out.println("4. Salir");
        int opcion = iescamp.tienda.test.ConsoleReader.readInt();

        switch (opcion) {
            case 1:
                menuBaseDatosArticulos();
                break;
            case 2:
                menuBaseDatosClientes();
                break;
            case 3:
                menuBaseDatosEmpleados();
                break;
            case 4:
                mostrarMenu();
                break;
        }
    }

    private static void menuBaseDatosEmpleados() {
        System.out.println("Menu Base de Datos Empleados" + "\n");
        System.out.println("1. Listar empleados");
        System.out.println("2. Buscar empleado por DNI");
        System.out.println("3. Validar contraseña");
        System.out.println("4. Salir");

        int opcion = iescamp.tienda.test.ConsoleReader.readInt();
        switch (opcion){
            case 1:
                List<Empleado> listEmpleados = empleadoDAO.obtenerTodos();
                for (Empleado empleado : listEmpleados) {
                    System.out.println(empleado);
                }
                menuBaseDatosEmpleados();
                break;

            case 2:
                System.out.println("Introduce el DNI del empleado");
                Empleado empleado = empleadoDAO.obtenerPorId(iescamp.tienda.test.ConsoleReader.readString());
                System.out.println(empleado);
                menuBaseDatosEmpleados();
                break;

            case 3:
                System.out.println("Introduce el email del empleado");
                String email = iescamp.tienda.test.ConsoleReader.readString();
                System.out.println("Introduce la contraseña");
                String pass = iescamp.tienda.test.ConsoleReader.readString();
                Empleado empleado1 = empleadoDAO.autenticarEmpleado(email, pass);
                boolean verif = empleado1 != null;
                if (verif) {
                    System.out.println("Contraseña correcta");
                } else {
                    System.out.println("Contraseña incorrecta");
                }
                menuBaseDatosEmpleados();
                break;

            case 4:
                menuBaseDatos();
                break;
        }
    }


    public static void menuBaseDatosClientes(){
        System.out.println("Menu Base de Datos Clientes" + "\n");
        System.out.println("1. Listar Clientes");
        System.out.println("2. Buscar Cliente por DNI");
        System.out.println("3. Validar Contraseña");
        System.out.println("4. Listar pedidos de un cliente");
        System.out.println("5. Salir");
        int opcion = iescamp.tienda.test.ConsoleReader.readInt();
        switch (opcion) {

            case 1:
                List<Cliente> listClientes = clienteDAO.obtenerTodos();
                for (Cliente cliente : listClientes) {
                    System.out.println(cliente);
                }
                menuBaseDatosClientes();
                break;

            case 2:
                System.out.println("Introduce el DNI del cliente");
                Cliente cliente = clienteDAO.obtenerPorId(iescamp.tienda.test.ConsoleReader.readString());
                System.out.println(cliente);
                menuBaseDatosClientes();
                break;

            case 3:
                System.out.println("Introduce el email del cliente:");
                String email = iescamp.tienda.test.ConsoleReader.readString();

                System.out.println("Introduce la contraseña:");
                String pass = iescamp.tienda.test.ConsoleReader.readString();

                Cliente clienteAutenticado = clienteDAO.autenticarCliente(email, pass);

                if (clienteAutenticado != null) {
                    System.out.println("Autenticación exitosa. Datos del cliente:");
                    System.out.println(clienteAutenticado);
                } else {
                    System.out.println("Error: Email o contraseña incorrectos.");
                }
                menuBaseDatosClientes();
                break;

            case 4:

                System.out.println("Introduce el DNI del cliente");
                Cliente cliente1 = clienteDAO.obtenerPorId(iescamp.tienda.test.ConsoleReader.readString());
                try {
                    List<Pedido> pedidos = pedidoDAO.obtenerPedidosPorCliente(cliente1);
                    for (Pedido pedido : pedidos) {
                        System.out.println(pedido);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                menuBaseDatosClientes();


                break;

            case 5:
                menuBaseDatos();
                break;
            default:
                System.out.println("Opcion no valida");
                menuBaseDatosClientes();
        }
    }

    private static void menuBaseDatosArticulos(){
        System.out.println("Menu Base de Datos Articulos" + "\n");
        System.out.println("1. Listar articulos");
        System.out.println("2. Listar Ropa por Tipo");
        System.out.println("3. Listar Accesorios por Tipo");
        System.out.println("4. Buscar articulo por cod_art (id)");
        System.out.println("5. Salir");
        int opcion = iescamp.tienda.test.ConsoleReader.readInt();

        switch (opcion) {
            case 1:



                for (Accesorio accesorio : accesorioDAO.obtenerTodos()) {
                    System.out.println(accesorio);
                }

                for (Ropa ropa : ropaDAO.obtenerTodos()) {
                    System.out.println(ropa);
                }


                menuBaseDatosArticulos();
                break;


            case 2:
                System.out.println("Camisa, Chaqueta o Pantalon?");

                List<Ropa> listRopa = ropaDAO.obtenerPorTipo(iescamp.tienda.test.ConsoleReader.readString());
                for (Ropa ropa : listRopa) {
                    System.out.println(ropa);
                }
                menuBaseDatosArticulos();
                break;

            case 3:
                System.out.println("Bolso o Zapato?");
                List<Accesorio> listaccesorio = accesorioDAO.obtenerPorTipo(iescamp.tienda.test.ConsoleReader.readString());
                for (Accesorio accesorio : listaccesorio) {
                    System.out.println(accesorio);
                }
                menuBaseDatosArticulos();
                break;

            case 4:
                System.out.println("Introduce el id del articulo");
                Articulo art = articuloDAO.obtenerPorId(ConsoleReader.readInt());
                if (art instanceof Ropa) {
                    System.out.println(ropaDAO.obtenerPorId(art.getCod_art()));
                } else {
                    System.out.println(accesorioDAO.obtenerPorId(art.getCod_art()));
                }
                menuBaseDatosArticulos();
                break;

                case 5:
                menuBaseDatos();
                break;
        }
    }
}