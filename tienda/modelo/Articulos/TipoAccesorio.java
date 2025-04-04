package iescamp.tienda.tienda.modelo.Articulos;

public enum TipoAccesorio {

    BOLSO("Bolso"), ZAPATOS("Zapatos");

    private final String descripcion;

    TipoAccesorio(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipoAccesorio DesdeString(String tipo) {

        for (TipoAccesorio t : TipoAccesorio.values()) {
            if (t.getDescripcion().equalsIgnoreCase(tipo)) {
                return t;
            }
        }
        return null;
    }



}
