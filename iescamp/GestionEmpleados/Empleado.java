package com.iescamp.GestionEmpleados;

public class Empleado extends Persona{

    private double salario;



    public Empleado(String nombre, int edad, double salario) {
        super(nombre, edad);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() +
                "salario=" + salario +
                '}';
    }


}
