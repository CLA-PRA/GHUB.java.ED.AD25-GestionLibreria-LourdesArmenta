package miPrincipal.modelo;

import utilerias.Fecha;

public class Pedido {
    private Libro libro;
    private Fecha fechaPedido;

    public Pedido(Libro libro, Fecha fechaPedido) {
        this.libro = libro;
        this.fechaPedido = fechaPedido;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Fecha getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Fecha fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "libro=" + libro +
                ", fechaPedido=" + fechaPedido +
                '}';
    }
}