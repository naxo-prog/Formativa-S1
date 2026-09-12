package model;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;

public abstract class Pedido implements Cancelable, Despachable, Rastreable {

    private int idPedido;
    private String direccionEntrega;
    private double distanciaKm;
    private EstadoPedido estado;

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }


    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }


    public void mostrarResumen() {

        System.out.println("Pedido #" +
                String.format("%03d", idPedido));

        System.out.println("Dirección: " +
                direccionEntrega);

        System.out.println("Distancia: " +
                distanciaKm + " km");

        System.out.println("Estado: " +
                estado);

        System.out.println("Tiempo estimado: " +
                calcularTiempoEntrega() +
                " minutos");
    }


    public abstract int calcularTiempoEntrega();


    public void asignarRepartidor() {

        System.out.println(
                "Asignando repartidor..."
        );
    }


    public void asignarRepartidor(String nombre) {

        System.out.println(
                "Pedido asignado a " + nombre
        );
    }


    @Override
    public void despachar() {

        System.out.println(
                "Pedido #" + idPedido +
                        " despachado correctamente."
        );
    }


    @Override
    public void cancelar() {

        System.out.println(
                "Pedido #" + idPedido +
                        " cancelado exitosamente."
        );
    }


    @Override
    public void verHistorial() {

        System.out.println(
                "Historial del Pedido #" + idPedido
        );
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", distanciaKm=" + distanciaKm +
                ", estado=" + estado +
                '}';
    }
}