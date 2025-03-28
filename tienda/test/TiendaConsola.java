package iescamp.tienda.test;


import com.opencsv.exceptions.CsvException;
import iescamp.tienda.modelo.Articulos.Catalogo;
import iescamp.tienda.modelo.Articulos.Material;
import iescamp.tienda.modelo.Pedidos.Ventas;

import iescamp.tienda.modelo.Usuarios.*;

import java.io.IOException;
import java.util.ArrayList;

public class TiendaConsola {
    static Ventas ventas = new Ventas();
    static Catalogo catalogo = new Catalogo();
    static Clientela clientela = new Clientela();
    static Plantilla plantilla = new Plantilla();
    static ArrayList<Departamento> departamentos = new ArrayList<>();
    static ArrayList<Material> materiales = new ArrayList<>();
    static ArrayList<MetodoPago> metodosPago = new ArrayList<>();


    public static void main(String[] args) {


        mostrarMenu();


    }


    private static void mostrarMenu() {
        System.out.println("Menu" + "\n");
        System.out.println("1. Plantilla");
        System.out.println("2. Clientela");
        System.out.println("3. Catalogo");
        System.out.println("4. Ventas");
        System.out.println("5. Salir");

        System.out.println("Introduce una opcion: ");
        int opcion = ConsoleReader.readInt();

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

        int opcion = ConsoleReader.readInt();

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
                opcion = ConsoleReader.readInt();
                if (opcion == 1) {
                    Departamento departamento = ConsoleUtil.crearDepartamento();
                    departamentos.add(departamento);
                    plantilla.addEmpleado(ConsoleUtil.crearEmpleado(departamento));
                    menuPlantilla();
                } else if (opcion == 2) {
                    if (departamentos.isEmpty()) {
                        System.out.println("No hay departamentos todavía");
                        menuPlantilla();
                    }
                    int codigoDepartamento = ConsoleReader.readInt("Introduce el codigo del departamento");
                    for (Departamento departamento : departamentos) {
                        if (departamento.getCodigo() == codigoDepartamento) {
                            plantilla.addEmpleado(ConsoleUtil.crearEmpleado(departamento));
                            menuPlantilla();
                        }
                    }

                }


                break;


            case 3:
                menuPlantillaArchivos();
                break;
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
        int opcion = ConsoleReader.readInt();
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
                opcion = ConsoleReader.readInt();
                if (opcion == 1) {
                    MetodoPago metodoPago = ConsoleUtil.crearMetodoPago();
                    metodosPago.add(metodoPago);
                    clientela.addCliente(ConsoleUtil.crearCliente(metodoPago));
                } else if (opcion == 2) {
                    if (metodosPago.isEmpty()) {
                        System.out.println("No hay metodos de pago todavía");
                        menuClientela();
                    }
                    int codigoMetodoPago = ConsoleReader.readInt("Introduce el id del metodo de pago");
                    for (MetodoPago metodoPago : metodosPago) {
                        if (metodoPago.getCodigo() == codigoMetodoPago) {
                            clientela.addCliente(ConsoleUtil.crearCliente(metodoPago));
                            menuClientela();
                        }
                    }

                }
                clientela.addCliente(ConsoleUtil.crearCliente(ConsoleUtil.crearMetodoPago()));
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
        int opcion = ConsoleReader.readInt();
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
                FileUtil.serializarVentas(ventas);
                menuVentas();
                break;


            case 4:
                ventas = FileUtil.desSerializarVentas();
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
        int opcion = ConsoleReader.readInt();
        switch (opcion) {
            case 1:
                System.out.println(catalogo.ListarArticulos());
                menuCatalogo();
                break;
            case 2:
                int opcion_tipo = ConsoleReader.readInt("Introduce el tipo de articulo: \n1. Camisa \n2. Chaqueta \n3. Pantalon \n4. Zapato \n5. Bolso \n6. Salir");
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
        int opcion_CrearMaterial = ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearCamisa(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearCamisa(material));
                    menuCatalogo();
                }
            }
        }


    }


    private static void CrearChaqueta() {
        int opcion_CrearMaterial = ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearChaqueta(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearChaqueta(material));
                    menuCatalogo();
                }
            }
        }


    }

    private static void CrearPantalon() {
        int opcion_CrearMaterial = ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearPantalon(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearPantalon(material));
                    menuCatalogo();
                }
            }
        }


    }

    private static void CrearZapato() {
        int opcion_CrearMaterial = ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearZapato(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearZapato(material));
                    menuCatalogo();
                }
            }
        }


    }


    private static void CrearBolso() {
        int opcion_CrearMaterial = ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearBolso(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = ConsoleReader.readInt("Introduce el codigo del material");
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

        int opcion = ConsoleReader.readInt("Introduce una opcion...");

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

        int opcion = ConsoleReader.readInt("Introduce una opcion...");

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

        int opcion = ConsoleReader.readInt("Introduce una opcion...");

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





}
