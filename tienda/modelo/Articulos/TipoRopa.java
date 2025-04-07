package iescamp.tienda.modelo.Articulos;

public enum TipoRopa {

    CAMISA("Camisa"), CHAQUETA("Chaqueta"), PANTALON("Pantalón");

    private final String descripcion;

    TipoRopa(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipoRopa DesdeString(String tipo) {

        for (TipoRopa t : TipoRopa.values()) {
            if (t.getDescripcion().equalsIgnoreCase(tipo)) {
                return t;
            }
        }
        return null;
    }


}
