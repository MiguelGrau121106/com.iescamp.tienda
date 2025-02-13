package com.iescamp.GestionEmpleados;

import java.util.ArrayList;

public class Gerente extends Empleado{


    private ArrayList<Proyecto> proyectos = new ArrayList<>();

    public Gerente(String nombre, int edad, double salario) {
        super(nombre, edad, salario);
    }

    public void asignarProyecto(Proyecto p){
        proyectos.add(p);
    }

    public void mostrarProyectos() {
        for (Proyecto p : proyectos) {
            if (p instanceof ProyectoSistemas) {
                ((ProyectoSistemas) p).mostrarDetallesSistemas();

            } else if (p instanceof ProyectoSoftware) {
                ((ProyectoSoftware) p).mostrarDetallesSoftware();
            } else  {
                System.out.println(p);
            }
        }
    }



    @Override
    public String toString() {
        return  super.toString() +
                "numero de proyectos=" + proyectos.size() +
                '}';
    }
}
