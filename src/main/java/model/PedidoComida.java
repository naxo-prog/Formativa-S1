package model;

public class PedidoComida extends Pedido {

    private String restaurante;

    public PedidoComida(int idPedido,
                        String direccionEntrega,
                        double distanciaKm,
                        String restaurante) {

        super(idPedido, direccionEntrega, distanciaKm);
        this.restaurante = restaurante;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public int calcularTiempoEntrega() {

        return (int) Math.round(
                15 + (2 * getDistanciaKm())
        );
    }

    @Override
    public void asignarRepartidor() {

        System.out.println(
                "[Pedido Comida]"
        );

        System.out.println(
                "Asignando repartidor..."
        );

        System.out.println(
                "→ Verificando mochila térmica... OK"
        );

        System.out.println(
                "→ Repartidor disponible para comida."
        );
    }

    @Override
    public void asignarRepartidor(String nombre) {

        System.out.println(
                "[Pedido Comida]"
        );

        System.out.println(
                "→ Mochila térmica verificada... OK"
        );

        System.out.println(
                "→ Pedido asignado a " + nombre
        );
    }
}