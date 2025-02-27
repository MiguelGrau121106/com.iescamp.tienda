package iescamp.tienda.modelo.Articulos;

import iescamp.tienda.modelo.Articulos.*;

import java.util.Objects;

public class Articulo {
    private Material material;
    private int cod_art;
    private boolean activo;

    private String imagen;
    private String nombre;
    private double precio;
    private String marca;
    private String descripcion;




    private String color;


    // getter y setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getCod_art() {
        return cod_art;
    }

    public void setCod_art(int cod_art) {
        this.cod_art = cod_art;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }



    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // equals

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Articulo articulo = (Articulo) object;
        return cod_art == articulo.cod_art && activo == articulo.activo && Double.compare(precio, articulo.precio) == 0 && Objects.equals(material, articulo.material) &&  Objects.equals(imagen, articulo.imagen) && Objects.equals(nombre, articulo.nombre) && Objects.equals(marca, articulo.marca) && Objects.equals(descripcion, articulo.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, cod_art, activo, imagen, nombre, precio, marca, descripcion);
    }

    // constructor

    public Articulo(Material material, int cod_art, boolean activo, String color, String imagen, String nombre, double precio, String marca, String descripcion) {
        this.material = material;
        this.cod_art = cod_art;
        this.activo = activo;

        this.color = color;


        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
    }
}
