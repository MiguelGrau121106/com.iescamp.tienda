package iescamp.tienda.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(reader.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
            }
        }
    }

    public static int readInt(String msg) {
        System.out.println(msg);
        return readInt();

    }

    public static int readInt(int inicio, int fin) {
        while (true) {
            int a = readInt();
            if (a>=inicio && a <=fin)
                return a;
            else
                System.out.println("Entrada no válida. Intenta de nuevo.");
        }
    }

    public static int readInt(String msg, int inicio, int fin) {
        System.out.println(msg);
        return readInt(inicio, fin);

    }

    public static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(reader.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
            }
        }
    }
    public static double readDouble(String msg){
        System.out.println(msg);
        return(readDouble());

    }

    public static float readFloat() {
        while (true) {
            try {
                return Float.parseFloat(reader.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
            }
        }
    }
    public static float readFloat(String msg){
        System.out.println(msg);
        return(readFloat());

    }


    public static boolean readBoolean() {
        while (true) {
            String cadena = readString();
            if ("true".equalsIgnoreCase(cadena)) {
                return true;
            } else if ("false".equalsIgnoreCase(cadena)) {
                return false;
            } else {
                System.out.println("Entrada no válida. Por favor, introduce solo 'true' o 'false'.");
            }
        }
    }
    public static boolean readBoolean(String msg){
        System.out.println(msg);
        return(readBoolean());

    }

    public static String readString() {
        while (true) {
            try {
                return reader.readLine().trim();
            } catch (IOException e) {
                System.out.println("Error de lectura. Intenta de nuevo.");
            }
        }
    }

    public static String readString(String msg){
        System.out.println(msg);
        return readString();
    }
}
