package model;

public class PedidoExpress extends Pedido {

    private boolean entregaInmediata;

    public PedidoExpress(int idPedido, String direccionEntrega,
                         double distanciaKm, boolean entregaInmediata) {

        super(idPedido, direccionEntrega, distanciaKm);
        this.entregaInmediata = entregaInmediata;
    }

    public boolean isEntregaInmediata() {
        return entregaInmediata;
    }

    public void setEntregaInmediata(boolean entregaInmediata) {
        this.entregaInmediata = entregaInmediata;
    }

    @Override
    public int calcularTiempoEntrega() {

        int tiempo = 10;

        if (getDistanciaKm() > 5) {
            tiempo += 5;
        }

        return tiempo;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("PedidoExpress #" +
                String.format("%03d", getIdPedido()));

        System.out.println("Dirección: " +
                getDireccionEntrega());

        System.out.println("Distancia: " +
                getDistanciaKm() + " km");

        System.out.println("Entrega inmediata: " +
                (entregaInmediata ? "Sí" : "No"));

        System.out.println("Tiempo estimado de entrega: " +
                calcularTiempoEntrega() + " minutos");
    }
}
