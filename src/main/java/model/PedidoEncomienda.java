package model;

public class PedidoEncomienda extends Pedido {

    private double pesoKg;

    public PedidoEncomienda(int idPedido,
                            String direccionEntrega,
                            double distanciaKm,
                            double pesoKg) {

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

        return (int) Math.round(
                20 + (1.5 * getDistanciaKm())
        );
    }

    @Override
    public void asignarRepartidor() {

        System.out.println(
                "[Pedido Encomienda]"
        );

        System.out.println(
                "Asignando repartidor..."
        );

        System.out.println(
                "→ Validando peso y embalaje... OK"
        );
    }

    @Override
    public void asignarRepartidor(String nombre) {

        System.out.println(
                "[Pedido Encomienda]"
        );

        System.out.println(
                "→ Peso y embalaje validados... OK"
        );

        System.out.println(
                "→ Pedido asignado a " + nombre
        );
    }
}