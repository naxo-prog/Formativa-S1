package model;

public class PedidoEncomienda extends Pedido {

    private double pesoKg;

    public PedidoEncomienda(int idPedido, String direccionEntrega,
                            double distanciaKm, double pesoKg) {

        super(idPedido, direccionEntrega, distanciaKm);
        this.pesoKg = pesoKg;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + (1.5 * getDistanciaKm()));
    }

    @Override
    public void mostrarResumen() {
        System.out.println("PedidoEncomienda #" +
                String.format("%03d", getIdPedido()));

        System.out.println("Dirección: " +
                getDireccionEntrega());

        System.out.println("Distancia: " +
                getDistanciaKm() + " km");

        System.out.println("Peso: " +
                pesoKg + " kg");

        System.out.println("Tiempo estimado de entrega: " +
                calcularTiempoEntrega() + " minutos");
    }
}