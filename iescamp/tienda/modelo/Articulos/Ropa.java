package iescamp.tienda.modelo.Articulos;

import java.util.Objects;


public class Ropa extends Articulo{
   
    
    //Getter y Setter

public class Ropa extends Articulo {
    private int talla;
    private String tipoCierre;

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }


    public Ropa(Material material, int cod_art, boolean activo, String color, String imagen, String nombre, double precio, String marca, String descripcion, int talla, String tipoCierre) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion);
        this.talla = talla;
        this.tipoCierre = tipoCierre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ropa ropa = (Ropa) o;
        return talla == ropa.talla  && Objects.equals(tipoCierre, ropa.tipoCierre);
        if (!super.equals(o)) return false;

     
    }

    @Override
    public int hashCode() {

        return Objects.hash(talla, color, tipoCierre);

    }
}
