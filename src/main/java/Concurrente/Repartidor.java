package Concurrente;

import model.EstadoPedido;
import model.Pedido;

import java.util.Random;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {

        Random random = new Random();

        System.out.println(
                "\n========================================"
        );

        System.out.println(
                "Repartidor " + nombre + " inició su jornada."
        );

        System.out.println(
                "========================================"
        );

        while (true) {

            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {

                System.out.println(
                        "\n>>> Repartidor " + nombre +
                                " no encontró más pedidos disponibles."
                );

                break;
            }

            System.out.println(
                    "→ " + nombre +
                            " retiró el Pedido #" +
                            pedido.getIdPedido()
            );

            System.out.println(
                    "[Repartidor: " + nombre +
                            "] Entregando " +
                            pedido.getClass().getSimpleName() +
                            " #" + pedido.getIdPedido() +
                            "..."
            );

            try {

                // Simula un tiempo aleatorio de entrega
                int tiempoEspera = 1000 + random.nextInt(3000);

                Thread.sleep(tiempoEspera);

                pedido.setEstado(EstadoPedido.ENTREGADO);

                System.out.println(
                        "[Repartidor: " + nombre +
                                "] Pedido #" +
                                pedido.getIdPedido() +
                                " entregado correctamente."
                );

            } catch (InterruptedException e) {

                System.out.println(
                        "[Repartidor: " + nombre +
                                "] La entrega fue interrumpida."
                );

                Thread.currentThread().interrupt();

                return;
            }
        }

        System.out.println(
                "\n>>> Repartidor " + nombre +
                        " terminó su jornada."
        );
    }
}