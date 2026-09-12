package model;

public class PedidoExpress extends Pedido {

    private boolean entregaInmediata;

    public PedidoExpress(int idPedido,
                         String direccionEntrega,
                         double distanciaKm,
                         boolean entregaInmediata) {

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
    public void asignarRepartidor() {

        System.out.println(
                "[Pedido Express]"
        );

        System.out.println(
                "Asignando repartidor..."
        );

        System.out.println(
                "→ Buscando repartidor más cercano..."
        );

        System.out.println(
                "→ Disponibilidad inmediata... OK"
        );
    }

    @Override
    public void asignarRepartidor(String nombre) {

        System.out.println(
                "[Pedido Express]"
        );

        System.out.println(
                "→ Disponibilidad inmediata... OK"
        );

        System.out.println(
                "→ Pedido asignado a " + nombre
        );
    }
}