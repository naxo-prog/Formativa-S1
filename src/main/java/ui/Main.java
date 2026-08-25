package ui;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("          SISTEMA SPEEDFAST");
        System.out.println("       TIEMPOS DE ENTREGA");
        System.out.println("==========================================");

        PedidoComida pedidoComida =
                new PedidoComida(
                        1,
                        "Av. Italia 456",
                        4,
                        "Restaurante Sabores"
                );

        PedidoEncomienda pedidoEncomienda =
                new PedidoEncomienda(
                        2,
                        "Av. Independencia 123",
                        6,
                        3.5
                );

        PedidoExpress pedidoExpress =
                new PedidoExpress(
                        3,
                        "Av. Apoquindo 1500",
                        7,
                        true
                );

        System.out.println("\n--- PEDIDO DE COMIDA ---");
        pedidoComida.mostrarResumen();

        System.out.println("\n--- PEDIDO DE ENCOMIENDA ---");
        pedidoEncomienda.mostrarResumen();

        System.out.println("\n--- PEDIDO EXPRESS ---");
        pedidoExpress.mostrarResumen();

        System.out.println("\n==========================================");
        System.out.println("       COMPARACIÓN DE TIEMPOS");
        System.out.println("==========================================");

        System.out.println(
                "Comida: " +
                        pedidoComida.calcularTiempoEntrega() +
                        " minutos"
        );

        System.out.println(
                "Encomienda: " +
                        pedidoEncomienda.calcularTiempoEntrega() +
                        " minutos"
        );

        System.out.println(
                "Express: " +
                        pedidoExpress.calcularTiempoEntrega() +
                        " minutos"
        );

        System.out.println("\n==========================================");
        System.out.println("          PRUEBA DE POLIMORFISMO");
        System.out.println("==========================================");

        Pedido[] pedidos = {
                pedidoComida,
                pedidoEncomienda,
                pedidoExpress
        };

        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();

            System.out.println(
                    "Tiempo calculado: " +
                            pedido.calcularTiempoEntrega() +
                            " minutos"
            );

            System.out.println("------------------------------------------");
        }
    }
}