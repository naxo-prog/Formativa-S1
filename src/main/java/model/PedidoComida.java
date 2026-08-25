package model;

public class PedidoComida extends Pedido {

    private String restaurante;

    public PedidoComida(int idPedido, String direccionEntrega,
                        double distanciaKm, String restaurante) {

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
        return (int) Math.round(15 + (2 * getDistanciaKm()));
    }

    @Override
    public void mostrarResumen() {
        System.out.println("PedidoComida #" +
                String.format("%03d", getIdPedido()));

        System.out.println("Dirección: " + getDireccionEntrega());

        System.out.println("Distancia: " +
                getDistanciaKm() + " km");

        System.out.println("Restaurante: " + restaurante);

        System.out.println("Tiempo estimado de entrega: " +
                calcularTiempoEntrega() + " minutos");
    }
}
