package Concurrente;

import model.EstadoPedido;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {

    private List<Pedido> pedidos;

    public ZonaDeCarga() {
        pedidos = new ArrayList<>();
    }

    public synchronized void agregarPedido(Pedido pedido) {

        pedidos.add(pedido);

        System.out.println(
                "→ Pedido #" + pedido.getIdPedido() +
                        " agregado a la zona de carga."
        );
    }

    public synchronized Pedido retirarPedido() {

        for (Pedido pedido : pedidos) {

            if (pedido.getEstado() == EstadoPedido.PENDIENTE) {

                pedido.setEstado(EstadoPedido.EN_REPARTO);

                return pedido;
            }
        }

        return null;
    }

    public void mostrarEstadoPedidos() {

        System.out.println(
                "\n========== ESTADO FINAL DE PEDIDOS =========="
        );

        for (Pedido pedido : pedidos) {

            System.out.println(
                    "Pedido #" +
                            pedido.getIdPedido() +
                            " → " +
                            pedido.getEstado()
            );
        }
    }
}