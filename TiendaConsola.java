package iescamp.tienda.test;


import com.opencsv.exceptions.CsvException;
import iescamp.tienda.dao.*;
import iescamp.tienda.modelo.Articulos.*;
import iescamp.tienda.modelo.Pedidos.Pedido;
import iescamp.tienda.modelo.Pedidos.Ventas;
import iescamp.tienda.modelo.Usuarios.*;

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



    private static final RopaDAO ropaDAO = new RopaDAO();
    private static final AccesorioDAO accesorioDAO = new AccesorioDAO();
    private static final EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private static final ClienteDAO clienteDAO = new ClienteDAO();
    private static final PedidoDAO pedidoDAO = new PedidoDAO();
    private static final MaterialDAO materialDAO = new MaterialDAO();
    private static final MetodoPagoDAO metodoPagoDAO = new MetodoPagoDAO();
    private static final DepartamentoDAO departamentoDAO = new DepartamentoDAO();


    public static void main(String[] args) {
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
        System.out.println("4. Volver al menu principal");
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

                System.out.println("1. Crear departamento  \n2. Añadir a un departamento ya existente");
                opcion = iescamp.tienda.test.ConsoleReader.readInt();
                if (opcion == 1) {
                    Departamento departamento = ConsoleUtil.crearDepartamento();
                    departamentos.add(departamento);
                    plantilla.addEmpleado(ConsoleUtil.crearEmpleado(departamento));
                    //Muestra el empleado creado
                    System.out.println("Empleado creado: " + plantilla.getEmpleados().get(plantilla.getEmpleados().size() - 1));
                    menuPlantilla();
                } else if (opcion == 2) {
                    if (departamentos.isEmpty()) {
                        System.out.println("No hay departamentos todavía");
                        menuPlantilla();
                    }
                    int codigoDepartamento = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del departamento");
                    boolean encontrado = false;
                    for (Departamento departamento : departamentos) {
                        if (departamento.getCodigo() == codigoDepartamento) {
                            plantilla.addEmpleado(ConsoleUtil.crearEmpleado(departamento));
                            encontrado = true;
                            //Muestra el empleado creado
                            System.out.println("Empleado creado: " + plantilla.getEmpleados().get(plantilla.getEmpleados().size() - 1));
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró ningún departamento con ese código.");
                    }
                    menuPlantilla();
                }
                break;

            case 3:
                menuPlantillaArchivos();
                break;

            case 4:
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
                System.out.println("1. Crear metodo de pago \n2. Añadir a un metodo de pago ya existente");
                opcion = iescamp.tienda.test.ConsoleReader.readInt();
                if (opcion == 1) {
                    MetodoPago metodoPago = ConsoleUtil.crearMetodoPago();
                    metodosPago.add(metodoPago);
                    clientela.addCliente(ConsoleUtil.crearCliente(metodoPago));
                    //Muestra el cliente creado
                    System.out.println("Cliente creado: " + clientela.getClientes().get(clientela.getClientes().size() - 1));
                    menuClientela();

                } else if (opcion == 2) {
                    if (metodosPago.isEmpty()) {
                        System.out.println("No hay metodos de pago todavía");
                        menuClientela();
                    }
                    int codigoMetodoPago = iescamp.tienda.test.ConsoleReader.readInt("Introduce el id del metodo de pago");
                    boolean encontrado = false;
                    for (MetodoPago metodoPago : metodosPago) {
                        if (metodoPago.getCodigo() == codigoMetodoPago) {
                            clientela.addCliente(ConsoleUtil.crearCliente(metodoPago));
                            encontrado = true;
                            //Muestra el cliente creado
                            System.out.println("Cliente creado: " + clientela.getClientes().get(clientela.getClientes().size() - 1));
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró ningún metodo de pago con ese id.");
                    }
                    menuClientela();
                }
                break;

            case 3:
                try {
                    menuClientelaArchivos();
                } catch (IOException | CsvException e) {
                    System.out.println("Error al trabajar con archivos: " + e.getMessage());
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
        System.out.println("2. Serializar Ventas");
        System.out.println("3. DesSerializar Ventas");
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
                FileUtil.serializarVentas(ventas);
                menuVentas();
                break;

            case 3:
                ventas = FileUtil.desSerializarVentas();
                menuVentas();
                break;

            case 4:
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
        System.out.println("4. Volver al menu principal");
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
                } catch (IOException | CsvException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 4:
                mostrarMenu();
                break;
            default:
                System.out.println("Opcion no valida");
                menuCatalogo();
        }
    }

    private static void CrearCamisa() {
        int opcion_CrearMaterial = iescamp.tienda.test.ConsoleReader.readInt("1.Crear el material \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearCamisa(material));
            //Muestra el articulo creado
            System.out.println("Articulo creado: " + catalogo.getArticulos().get(catalogo.getArticulos().size() - 1));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del material");
            boolean encontrado = false;
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearCamisa(material));
                    encontrado = true;
                    //Muestra el articulo creado
                    System.out.println("Articulo creado: " + catalogo.getArticulos().get(catalogo.getArticulos().size() - 1));
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ningún material con ese codigo.");
            }
            menuCatalogo();
        }
    }


    private static void CrearChaqueta() {
        int opcion_CrearMaterial = iescamp.tienda.test.ConsoleReader.readInt("1.Crear el material \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearChaqueta(material));
            //Muestra el articulo creado
            System.out.println("Articulo creado: " + catalogo.getArticulos().get(catalogo.getArticulos().size() - 1));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del material");
            boolean encontrado = false;
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearChaqueta(material));
                    encontrado = true;
                    //Muestra el articulo creado
                    System.out.println("Articulo creado: " + catalogo.getArticulos().get(catalogo.getArticulos().size() - 1));

                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ningún material con ese codigo.");
            }
            menuCatalogo();
        }
    }

    private static void CrearPantalon() {
        int opcion_CrearMaterial = iescamp.tienda.test.ConsoleReader.readInt("1.Crear el material  \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearPantalon(material));
            //Muestra el articulo creado
            System.out.println("Articulo creado: " + catalogo.getArticulos().get(catalogo.getArticulos().size() - 1));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del material");
            boolean encontrado = false;
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearPantalon(material));
                    encontrado = true;
                    //Muestra el articulo creado
                    System.out.println("Articulo creado: " + catalogo.getArticulos().get(catalogo.getArticulos().size() - 1));
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ningún material con ese codigo.");
            }
            menuCatalogo();
        }
    }

    private static void CrearZapato() {
        int opcion_CrearMaterial = iescamp.tienda.test.ConsoleReader.readInt("1.Crear el material \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearZapato(material));
            //Muestra el articulo creado
            System.out.println("Articulo creado: " + catalogo.getArticulos().get(catalogo.getArticulos().size() - 1));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del material");
            boolean encontrado = false;
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearZapato(material));
                    encontrado = true;
                    //Muestra el articulo creado
                    System.out.println("Articulo creado: " + catalogo.getArticulos().get(catalogo.getArticulos().size() - 1));
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ningún material con ese codigo.");
            }
            menuCatalogo();
        }
    }


    private static void CrearBolso() {
        int opcion_CrearMaterial = iescamp.tienda.test.ConsoleReader.readInt("1.Crear el material \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearBolso(material));
            //Muestra el articulo creado
            System.out.println("Articulo creado: " + catalogo.getArticulos().get(catalogo.getArticulos().size() - 1));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = iescamp.tienda.test.ConsoleReader.readInt("Introduce el codigo del material");
            boolean encontrado = false;
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearBolso(material));
                    encontrado = true;
                    //Muestra el articulo creado
                    System.out.println("Articulo creado: " + catalogo.getArticulos().get(catalogo.getArticulos().size() - 1));
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ningún material con ese codigo.");
            }
            menuCatalogo();
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
                FileUtil.serializarCatalogo(catalogo);
                menuCatalogoArchivos();
                break;

            case 2:
                catalogo = FileUtil.desSerializarCatalogo();
                menuCatalogoArchivos();
                break;

            case 3:
                FileUtil.serializarJsonCatalogo(catalogo);
                menuCatalogoArchivos();
                break;

            case 4:
                catalogo = FileUtil.desSerializarJsonCatalogo();
                menuCatalogoArchivos();
                break;
            case 5:
                FileUtil.guardarArticulosEnCsv(catalogo,"catalogo.csv");
                menuCatalogoArchivos();
                break;

            case 6:
                catalogo = FileUtil.leerArticulosDesdeCsv("catalogo.csv");
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
                FileUtil.serializarClientela(clientela);
                menuClientelaArchivos();
                break;
            case 2:
                clientela = FileUtil.desSerializarClientela();
                menuClientelaArchivos();
                break;
            case 3:
                FileUtil.serializarJsonClientela(clientela);
                menuClientelaArchivos();
                break;
            case 4:
                clientela = FileUtil.desSerializarClientela();
                menuClientelaArchivos();
                break;
            case 5:
                FileUtil.guardarClientesEnCsv(clientela, "clientela.csv");
                menuClientelaArchivos();
                break;

            case 6:
                clientela = FileUtil.leerClientesDesdeCsv("clientela.csv");
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
                FileUtil.serializarPlantilla(plantilla);
                menuPlantillaArchivos();
                break;
            case 2:
                plantilla = FileUtil.desSerializarPlantilla();
                menuPlantillaArchivos();
                break;
            case 3:
                FileUtil.serializarJsonPlantilla(plantilla);
                menuPlantillaArchivos();
                break;
            case 4:
                plantilla = FileUtil.desSerializarJsonPlantilla();
                menuPlantillaArchivos();
                break;
            case 5:
                try {
                    FileUtil.guardarEmpleadosEnCsv(plantilla, "plantilla.csv");
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
        System.out.println("1. Listar empleados");;
        System.out.println("2. Listar empleado por DNI");
        System.out.println("3. Cargar Empleado desde BD en plantilla");
        System.out.println("4. Añadir empleado");
        System.out.println("5. Modificar empleado");
        System.out.println("6. Validar contraseña");
        System.out.println("7. Eliminar empleado");
        System.out.println("8. Salir");

        int opcion = ConsoleReader.readInt();
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
                Empleado empleado = empleadoDAO.obtenerPorId(ConsoleReader.readString());
                if (empleado != null) {
                    System.out.println("Empleado encontrado: " + empleado);
                } else {
                    System.out.println("Empleado no encontrado.");
                }
                menuBaseDatosEmpleados();
                break;

            case 3:
                plantilla.setEmpleados((ArrayList<Empleado>) empleadoDAO.obtenerTodos());

                System.out.println("Empleados cargados en la plantilla.");
                menuBaseDatosEmpleados();
                break;
            case 4:
                System.out.println("1. Crear departamento \n2. Añadir a un departamento existente");
                int opcionCrearDepartamento = ConsoleReader.readInt();
                if (opcionCrearDepartamento == 1) {
                    Departamento departamento = ConsoleUtil.crearDepartamento();
                    departamentos.add(departamento);
                    departamentoDAO.insertar(departamento);
                    Empleado empleado1 = ConsoleUtil.crearEmpleado(departamento);
                    empleadoDAO.insertar(empleado1);
                    plantilla.addEmpleado(empleado1);
                    //Muestra el empleado creado
                    System.out.println("Empleado creado: " + plantilla.getEmpleados().get(plantilla.getEmpleados().size() - 1));
                    menuBaseDatosEmpleados();
                } else if (opcionCrearDepartamento == 2) {
                    if (departamentos.isEmpty()) {
                        System.out.println("No hay departamentos todavía");
                        menuBaseDatosEmpleados();
                    }
                    int codigoDepartamento = ConsoleReader.readInt("Introduce el codigo del departamento");
                    boolean encontrado = false;
                    for (Departamento departamento : departamentos) {
                        if (departamento.getCodigo() == codigoDepartamento) {
                            plantilla.addEmpleado(ConsoleUtil.crearEmpleado(departamento));
                            encontrado = true;
                            //Muestra el empleado creado
                            System.out.println("Empleado creado: " + plantilla.getEmpleados().get(plantilla.getEmpleados().size() - 1));
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró ningún departamento con ese codigo.");
                    }
                    menuBaseDatosEmpleados();
                }
                break;


            case 5:
                System.out.println("Introduce el DNI del empleado a modificar:");
                String dniMod = ConsoleReader.readString();
                Empleado empMod = empleadoDAO.obtenerPorId(dniMod);
                if (empMod != null) {
                    Empleado empleado2 = ConsoleUtil.crearEmpleado(ConsoleUtil.crearDepartamento());
                    empleadoDAO.actualizar(empMod);
                    plantilla.ActualizarEmpleado(empMod);
                    System.out.println("Empleado modificado y plantilla recargada.");
                } else {
                    System.out.println("Empleado no encontrado.");
                }
                menuBaseDatosEmpleados();
                break;

            case 6:
                System.out.println("Introduce el correo electrónico:");
                String correo = ConsoleReader.readString();
                System.out.println("Introduce la contraseña:");
                String contrasena = ConsoleReader.readString();
                Empleado empleadoAutenticado = empleadoDAO.autenticarEmpleado(correo, contrasena);
                if (empleadoAutenticado != null) {
                    System.out.println("Contraseña válida. Bienvenido " + empleadoAutenticado.getNombre());
                } else {
                    System.out.println("Credenciales inválidas.");
                }
                menuBaseDatosEmpleados();
                break;
            case 7:
                System.out.println("Introduce el DNI del empleado a eliminar:");
                String dniEliminar = ConsoleReader.readString();
                Empleado empEliminar = empleadoDAO.obtenerPorId(dniEliminar);
                if (empEliminar != null) {
                    empleadoDAO.eliminar(dniEliminar);
                    plantilla.eliminarEmpleado(empEliminar);
                    System.out.println("Empleado eliminado.");
                } else {
                    System.out.println("Empleado no encontrado.");
                }
                menuBaseDatosEmpleados();
                break;
            case 8:
                menuBaseDatos();
                break;
        }
    }


    public static void menuBaseDatosClientes() {
        System.out.println("Menu Base de Datos Clientes\n");
        System.out.println("1. Listar Clientes");
        System.out.println("2. Buscar Cliente por DNI");
        System.out.println("3. Validar Contraseña");
        System.out.println("4. Listar pedidos de un cliente");
        System.out.println("5. Cargar Cliente desde BD en plantilla");
        System.out.println("6. Añadir Cliente");
        System.out.println("7. Modificar Cliente por DNI");
        System.out.println("8. Modificar Cliente por correo");
        System.out.println("9. Volver");

        int opcion = ConsoleReader.readInt();

        switch (opcion) {
            case 1:
                List<Cliente> listClientes = clienteDAO.obtenerTodos();
                for (Cliente cliente : listClientes) {
                    System.out.println(cliente);
                }
                break;

            case 2:
                System.out.println("Introduce el DNI del cliente:");
                Cliente clienteDni = clienteDAO.obtenerPorId(ConsoleReader.readString());
                System.out.println(clienteDni != null ? clienteDni : "Cliente no encontrado.");
                break;

            case 3:
                System.out.println("Introduce el email del cliente:");
                String email = ConsoleReader.readString();
                System.out.println("Introduce la contraseña:");
                String pass = ConsoleReader.readString();

                Cliente clienteAutenticado = clienteDAO.autenticarCliente(email, pass);

                if (clienteAutenticado != null) {
                    System.out.println("Autenticación exitosa. Datos del cliente:");
                    System.out.println(clienteAutenticado);
                } else {
                    System.out.println("Error: Email o contraseña incorrectos.");
                }
                break;

            case 4:
                System.out.println("Introduce el DNI del cliente:");
                String dniPedidos = ConsoleReader.readString();
                Cliente clientePedidos = clienteDAO.obtenerPorId(dniPedidos);
                if (clientePedidos != null) {
                    try {
                        List<Pedido> pedidos = pedidoDAO.obtenerPedidosPorCliente(clientePedidos);
                        for (Pedido pedido : pedidos) {
                            System.out.println(pedido);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener los pedidos del cliente.");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Cliente no encontrado.");
                }
                break;
            case 5:
                clientela.setClientes((ArrayList<Cliente>) clienteDAO.obtenerTodos());

                System.out.println("Clientes cargados en la plantilla.");
                menuBaseDatosClientes();
                break;

            case 6:
                System.out.println("Crear metodo de pago tambien o añadir a uno existente?");
                System.out.println("1. Crear \n2. Añadir");
                int opcionCrear = ConsoleReader.readInt();
                if (opcionCrear == 1) {
                    MetodoPago metodoPago = ConsoleUtil.crearMetodoPago();
                    metodoPagoDAO.insertar(metodoPago);
                    metodosPago.add(metodoPago);
                    Cliente cliente = ConsoleUtil.crearCliente(metodoPago);
                    clientela.addCliente(cliente);
                    clienteDAO.insertar(cliente);
                    System.out.println("Cliente añadido y plantilla recargada.");
                } else if (opcionCrear == 2) {
                    System.out.println("Introduce el nombre del metodo de pago: ");
                    MetodoPago metodoPago = metodoPagoDAO.obtenerPorDescripcion(ConsoleReader.readString());
                    Cliente cliente = ConsoleUtil.crearCliente(metodoPago);
                    clientela.addCliente(cliente);
                    clienteDAO.insertar(cliente);
                    System.out.println("Cliente añadido y plantilla recargada.");
                }
                menuBaseDatosClientes();
                break;

            case 7:
                System.out.println("¿El Metodo de Pago ya existe?1. SI 2. NO");
                int opcionMod = ConsoleReader.readInt();
                MetodoPago metodoPago;
                if (opcionMod == 1) {
                    System.out.println("Introduce el nombre del metodo de pago:");
                    metodoPago = metodoPagoDAO.obtenerPorDescripcion(ConsoleReader.readString());
                    System.out.println(metodoPago);
                } else {
                    metodoPago = ConsoleUtil.crearMetodoPago();
                    metodoPagoDAO.insertar(metodoPago);
                    metodosPago.add(metodoPago);
                }
                System.out.println("Introduce el DNI del cliente a modificar:");
                String dniMod = ConsoleReader.readString();
                Cliente clienteMod = clienteDAO.obtenerPorId(dniMod);
                if (clienteMod != null) {

                    Cliente actualizado = ConsoleUtil.crearCliente(metodoPago);
                    clienteDAO.actualizar(actualizado);
                    clientela.updateCliente(actualizado);
                } else {
                    System.out.println("Cliente no encontrado.");
                }
                menuBaseDatosClientes();
                break;

            case 8:
                System.out.println("¿El metodo de pago ya existe? 1. SI 2. NO");
                int opcionMod2 = ConsoleReader.readInt();
                MetodoPago metodoPago2;
                if (opcionMod2 == 1) {
                    System.out.println("Introduce el nombre del metodo de pago:");
                    metodoPago2 = metodoPagoDAO.obtenerPorDescripcion(ConsoleReader.readString());
                    System.out.println(metodoPago2);
                } else {
                    metodoPago2 = ConsoleUtil.crearMetodoPago();
                    metodoPagoDAO.insertar(metodoPago2);
                    metodosPago.add(metodoPago2);
                }
                System.out.println("Introduce el correo del cliente a modificar:");
                String correoMod = ConsoleReader.readString();
                Cliente clienteMod2 = clienteDAO.obtenerPorEmail(correoMod);
                if (clienteMod2 != null) {
                    Cliente actualizado = ConsoleUtil.crearCliente(metodoPago2);
                    clienteDAO.actualizar(actualizado);
                    clientela.updateCliente(actualizado);
                } else {
                    System.out.println("Cliente no encontrado.");
                }
                menuBaseDatosClientes();
                break;

            case 9:
                menuBaseDatos();
                return;

            default:
                System.out.println("Opción no válida.");
        }
        menuBaseDatosClientes();
    }


    private static void menuBaseDatosArticulos(){
        System.out.println("Menu Base de Datos Articulos" + "\n");
        System.out.println("1. Listar articulos");
        System.out.println("2. Listar Ropa por Tipo");
        System.out.println("3. Listar Accesorios por Tipo");
        System.out.println("4. Buscar articulo por cod_art (id)");
        System.out.println("5. Añadir articulo");
        System.out.println("6. Cargar todos los Articulos desde BD en Catalogo");
        System.out.println("7. Modificar articulo");
        System.out.println("8. Eliminar articulo");
        System.out.println("9. Salir");
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
                Articulo art = ropaDAO.obtenerPorId(ConsoleReader.readInt());
                if (art == null) {
                    art = accesorioDAO.obtenerPorId(ConsoleReader.readInt());
                    if (art != null) {
                        System.out.println(art);
                    } else {
                        System.out.println("Articulo no encontrado");
                    }
                }
                menuBaseDatosArticulos();
                break;
            case 5:
                System.out.println("1. Crear Ropa \n2. Crear Accesorio");
                int opcionCrear = ConsoleReader.readInt();
                if (opcionCrear == 1) {
                    System.out.println("1. Camisa \n2. Chaqueta \n3. Pantalon");
                    int tipoRopa = ConsoleReader.readInt();
                    switch (tipoRopa) {
                        case 1:
                            System.out.println("El material ya existe? \n1. Si \n2. No");
                            int opcionMaterial = ConsoleReader.readInt();
                            if (opcionMaterial == 1) {
                                System.out.println("Introduce el nombre del material");
                                Material material = materialDAO.obtenerPorDenominacion(ConsoleReader.readString());
                                if (material != null) {
                                    Camisa camisa = ConsoleUtil.crearCamisa(material);
                                    catalogo.addArticulo(camisa);
                                    ropaDAO.insertar(camisa);
                                    System.out.println("Camisa insertada correctamente");

                                } else {
                                    System.out.println("Material no encontrado");
                                    menuBaseDatosArticulos();
                                }

                            } else if (opcionMaterial == 2) {
                                Material material = ConsoleUtil.crearMaterial();
                                materiales.add(material);
                                materialDAO.insertar(material);
                                System.out.println("Material insertado correctamente");
                                Camisa camisa = ConsoleUtil.crearCamisa(material);
                                catalogo.addArticulo(camisa);
                                ropaDAO.insertar(camisa);
                                System.out.println("Camisa insertada correctamente");

                            }
                            menuBaseDatosArticulos();
                            break;
                        case 2:
                            System.out.println("El material ya existe? \n1. Si \n2. No");
                            int opcionMaterialChaqueta = ConsoleReader.readInt();
                            if (opcionMaterialChaqueta == 1) {
                                System.out.println("Introduce el nombre del material");
                                Material material = materialDAO.obtenerPorDenominacion(ConsoleReader.readString());
                                if (material != null) {
                                    Chaqueta chaqueta = ConsoleUtil.crearChaqueta(material);
                                    catalogo.addArticulo(chaqueta);
                                    ropaDAO.insertar(chaqueta);
                                    System.out.println("Chaqueta insertada correctamente");

                                } else {
                                    System.out.println("Material no encontrado");
                                    menuBaseDatosArticulos();
                                }

                            } else if (opcionMaterialChaqueta == 2) {
                                Material material = ConsoleUtil.crearMaterial();
                                materiales.add(material);
                                materialDAO.insertar(material);
                                System.out.println("Material insertado correctamente");
                                Chaqueta chaqueta = ConsoleUtil.crearChaqueta(material);
                                catalogo.addArticulo(chaqueta);
                                ropaDAO.insertar(chaqueta);
                                System.out.println("Chaqueta insertada correctamente");

                            }
                            break;
                        case 3:
                            System.out.println("El material ya existe? \n1. Si \n2. No");
                            int opcionMaterialPantalon = ConsoleReader.readInt();
                            if (opcionMaterialPantalon == 1) {
                                System.out.println("Introduce el nombre del material");
                                Material material = materialDAO.obtenerPorDenominacion(ConsoleReader.readString());
                                if (material != null) {
                                    Pantalon pantalon = ConsoleUtil.crearPantalon(material);
                                    catalogo.addArticulo(pantalon);
                                    ropaDAO.insertar(pantalon);
                                    System.out.println("Pantalon insertado correctamente");

                                } else {
                                    System.out.println("Material no encontrado");
                                    menuBaseDatosArticulos();
                                }

                            } else if (opcionMaterialPantalon == 2) {
                                Material material = ConsoleUtil.crearMaterial();
                                materiales.add(material);
                                materialDAO.insertar(material);
                                System.out.println("Material insertado correctamente");
                                Pantalon pantalon = ConsoleUtil.crearPantalon(material);
                                catalogo.addArticulo(pantalon);
                                ropaDAO.insertar(pantalon);
                                System.out.println("Pantalon insertado correctamente");

                            }
                            break;
                    }

                } else if (opcionCrear == 2) {
                    System.out.println("1. Bolso \n2. Zapato");
                    int tipoAccesorio = ConsoleReader.readInt();
                    switch (tipoAccesorio) {
                        case 1:
                            System.out.println("El material ya existe? \n1. Si \n2. No");
                            int opcionMaterialBolso = ConsoleReader.readInt();
                            if (opcionMaterialBolso == 1) {
                                System.out.println("Introduce el nombre del material");
                                Material material = materialDAO.obtenerPorDenominacion(ConsoleReader.readString());
                                if (material != null) {
                                    Bolso bolso = ConsoleUtil.crearBolso(material);
                                    catalogo.addArticulo(bolso);
                                    accesorioDAO.insertar(bolso);
                                    System.out.println("Bolso insertado correctamente");

                                } else {
                                    System.out.println("Material no encontrado");
                                    menuBaseDatosArticulos();
                                }

                            } else if (opcionMaterialBolso == 2) {
                                Material material = ConsoleUtil.crearMaterial();
                                materiales.add(material);
                                materialDAO.insertar(material);
                                System.out.println("Material insertado correctamente");
                                Bolso bolso = ConsoleUtil.crearBolso(material);
                                catalogo.addArticulo(bolso);
                                accesorioDAO.insertar(bolso);
                                System.out.println("Bolso insertado correctamente");

                            }
                            menuBaseDatosArticulos();
                            break;
                        case 2:
                            System.out.println("El material ya existe? \n1. Si \n2. No");
                            int opcionMaterialZapato = ConsoleReader.readInt();
                            if (opcionMaterialZapato == 1) {
                                System.out.println("Introduce el nombre del material");
                                Material material = materialDAO.obtenerPorDenominacion(ConsoleReader.readString());
                                if (material != null) {
                                    Zapatos zapato = ConsoleUtil.crearZapato(material);
                                    catalogo.addArticulo(zapato);
                                    accesorioDAO.insertar(zapato);
                                    System.out.println("Zapato insertado correctamente");

                                } else {
                                    System.out.println("Material no encontrado");
                                    menuBaseDatosArticulos();
                                }

                            } else if (opcionMaterialZapato == 2) {
                                Material material = ConsoleUtil.crearMaterial();
                                materiales.add(material);
                                materialDAO.insertar(material);
                                System.out.println("Material insertado correctamente");
                                Zapatos zapato = ConsoleUtil.crearZapato(material);
                                catalogo.addArticulo(zapato);
                                accesorioDAO.insertar(zapato);
                                System.out.println("Zapato insertado correctamente");

                }
                            menuBaseDatosArticulos();
                            break;
                    }

                }

                case 6:
                ArrayList<Articulo> articulos;
                articulos = new ArrayList<>();
                articulos.addAll(ropaDAO.obtenerTodos());
                articulos.addAll(accesorioDAO.obtenerTodos());

                catalogo.setArticulos(articulos);
                    System.out.println("Articulos cargados correctamente");
                menuBaseDatosArticulos();
                break;

                case 7:
                    System.out.println("Introduce el id del articulo");
                    Articulo articulo = ropaDAO.obtenerPorId(ConsoleReader.readInt());
                    if (articulo == null) {
                        articulo = accesorioDAO.obtenerPorId(ConsoleReader.readInt());
                        if (articulo != null) {
                            System.out.println(articulo);
                        } else {
                            System.out.println("Articulo no encontrado");
                        }
                    }

                    System.out.println("1. Accesorio /n 2.Ropa?");
                    int tipoArticulo = ConsoleReader.readInt();
                    if (tipoArticulo == 1){
                        System.out.println("1. Bolso \n2. Zapato");
                        int tipoAccesorio = ConsoleReader.readInt();
                        switch (tipoAccesorio) {
                            case 1:
                                System.out.println("El material ya existe? \n1. Si \n2. No");
                                int opcionMaterialBolso = ConsoleReader.readInt();
                                if (opcionMaterialBolso == 1) {
                                    System.out.println("Introduce el nombre del material");
                                    Material material = materialDAO.obtenerPorDenominacion(ConsoleReader.readString());
                                    if (material != null) {
                                        Bolso bolso = ConsoleUtil.crearBolso(material);
                                        catalogo.updateArticulo(bolso);
                                        accesorioDAO.actualizar(bolso);
                                        System.out.println("Bolso actualizado correctamente");

                                    } else {
                                        System.out.println("Material no encontrado");
                                        menuBaseDatosArticulos();
                                    }

                                } else if (opcionMaterialBolso == 2) {
                                    Material material = ConsoleUtil.crearMaterial();
                                    materiales.add(material);
                                    materialDAO.insertar(material);
                                    System.out.println("Material insertado correctamente");
                                    Bolso bolso = ConsoleUtil.crearBolso(material);
                                    catalogo.updateArticulo(bolso);
                                    accesorioDAO.actualizar(bolso);
                                    System.out.println("Bolso actualizado correctamente");
                                }
                                break;

                            case 2:
                                System.out.println("El material ya existe? \n1. Si \n2. No");
                                int opcionMaterialZapato = ConsoleReader.readInt();
                                if (opcionMaterialZapato == 1) {
                                    System.out.println("Introduce el nombre del material");
                                    Material material = materialDAO.obtenerPorDenominacion(ConsoleReader.readString());
                                    if (material != null) {
                                        Zapatos zapato = ConsoleUtil.crearZapato(material);
                                        catalogo.updateArticulo(zapato);
                                        accesorioDAO.actualizar(zapato);
                                        System.out.println("Zapato actualizado correctamente");

                                    } else {
                                        System.out.println("Material no encontrado");
                                        menuBaseDatosArticulos();
                                    }

                                } else if (opcionMaterialZapato == 2) {
                                    Material material = ConsoleUtil.crearMaterial();
                                    materiales.add(material);
                                    materialDAO.insertar(material);
                                    System.out.println("Material insertado correctamente");
                                    Zapatos zapato = ConsoleUtil.crearZapato(material);
                                    catalogo.updateArticulo(zapato);
                                    accesorioDAO.actualizar(zapato);
                                    System.out.println("Zapato actualizado correctamente");

                                }
                                break;
                        }

                    } else if (tipoArticulo == 2){
                        System.out.println("1. Camisa \n2. Chaqueta \n3. Pantalon");
                        int tipoRopa = ConsoleReader.readInt();
                        switch (tipoRopa) {
                            case 1:
                                System.out.println("El material ya existe? \n1. Si \n2. No");
                                int opcionMaterial = ConsoleReader.readInt();
                                if (opcionMaterial == 1) {
                                    System.out.println("Introduce el nombre del material");
                                    Material material = materialDAO.obtenerPorDenominacion(ConsoleReader.readString());
                                    if (material != null) {
                                        Camisa camisa = ConsoleUtil.crearCamisa(material);
                                        catalogo.updateArticulo(camisa);
                                        ropaDAO.actualizar(camisa);
                                        System.out.println("Camisa actualizada correctamente");

                                    } else {
                                        System.out.println("Material no encontrado");
                                        menuBaseDatosArticulos();
                                    }

                                } else if (opcionMaterial == 2) {
                                    Material material = ConsoleUtil.crearMaterial();
                                    materiales.add(material);
                                    materialDAO.insertar(material);
                                    System.out.println("Material insertado correctamente");
                                    Camisa camisa = ConsoleUtil.crearCamisa(material);
                                    catalogo.updateArticulo(camisa);
                                    ropaDAO.actualizar(camisa);
                                    System.out.println("Camisa actualizada correctamente");

                                }
                                break;
                            case 2:
                                System.out.println("El material ya existe? \n1. Si \n2. No");
                                int opcionMaterialChaqueta = ConsoleReader.readInt();
                                if (opcionMaterialChaqueta == 1) {
                                    System.out.println("Introduce el nombre del material");
                                    Material material = materialDAO.obtenerPorDenominacion(ConsoleReader.readString());
                                    if (material != null) {
                                        Chaqueta chaqueta = ConsoleUtil.crearChaqueta(material);
                                        catalogo.updateArticulo(chaqueta);
                                        ropaDAO.actualizar(chaqueta);
                                        System.out.println("Chaqueta actualizada correctamente");

                                    } else {
                                        System.out.println("Material no encontrado");
                                        menuBaseDatosArticulos();
                                    }

                                } else if (opcionMaterialChaqueta == 2) {
                                    Material material = ConsoleUtil.crearMaterial();
                                    materiales.add(material);
                                    materialDAO.insertar(material);
                                    System.out.println("Material insertado correctamente");
                                    Chaqueta chaqueta = ConsoleUtil.crearChaqueta(material);
                                    catalogo.updateArticulo(chaqueta);
                                    ropaDAO.actualizar(chaqueta);
                                    System.out.println("Chaqueta actualizada correctamente");

                                }
                                break;
                            case 3:
                                System.out.println("El material ya existe? \n1. Si \n2. No");
                                int opcionMaterialPantalon = ConsoleReader.readInt();
                                if (opcionMaterialPantalon == 1) {
                                    System.out.println("Introduce el nombre del material");
                                    Material material = materialDAO.obtenerPorDenominacion(ConsoleReader.readString());
                                    if (material != null) {
                                        Pantalon pantalon = ConsoleUtil.crearPantalon(material);
                                        catalogo.updateArticulo(pantalon);
                                        ropaDAO.actualizar(pantalon);
                                        System.out.println("Pantalon actualizado correctamente");

                                    } else {
                                        System.out.println("Material no encontrado");
                                        menuBaseDatosArticulos();
                                    }

                                } else if (opcionMaterialPantalon == 2) {
                                    Material material = ConsoleUtil.crearMaterial();
                                    materiales.add(material);
                                    materialDAO.insertar(material);
                                    System.out.println("Material insertado correctamente");
                                    Pantalon pantalon = ConsoleUtil.crearPantalon(material);
                                    catalogo.updateArticulo(pantalon);
                                    ropaDAO.actualizar(pantalon);
                                    System.out.println("Pantalon actualizado correctamente");

                                }
                                break;
                        }

                    }
                    menuBaseDatosArticulos();
                    break;

                    case 8:
                System.out.println("Introduce el id del articulo");
                ropaDAO.eliminar(ConsoleReader.readInt());
                        System.out.println("Articulo eliminado correctamente");
                    menuBaseDatosArticulos();
                break;

                case 9:
                menuBaseDatos();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}