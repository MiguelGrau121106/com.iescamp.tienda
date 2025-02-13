package com.iescamp.GestionEmpleados;

public class Proyecto {


    private String nombreProyecto;
    private double presupuesto;

    public Proyecto(String nombreProyecto, double presupuesto) {
        this.nombreProyecto = nombreProyecto;
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "- Proyecto: " +
                 nombreProyecto +
                ", presupuesto: " + presupuesto;
    }
}
