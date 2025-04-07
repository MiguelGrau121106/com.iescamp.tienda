package iescamp.tienda.modelo.Pedidos;

public enum EstadoPedido {
    EN_PROCESO("En proceso"), COMPLETADO("Completado"), CANCELADO("Cancelado");

    private final String descripcion;

    EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static EstadoPedido DesdeString(String estado) {

        for (EstadoPedido e : EstadoPedido.values()) {
            if (e.getDescripcion().equalsIgnoreCase(estado)) {
                return e;
            }
        }
        return null;
    }
}
