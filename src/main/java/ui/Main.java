package ui;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

import java.util.ArrayList;

import Concurrente.Repartidor;
import Concurrente.ZonaDeCarga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       SISTEMA DE ENTREGAS SPEEDFAST");
        System.out.println("==========================================");

        PedidoComida comida =
                new PedidoComida(
                        101,
                        "Av. Italia 456",
                        4,
                        "Restaurante Sabores"
                );

        PedidoEncomienda encomienda =
                new PedidoEncomienda(
                        102,
                        "Av. Santa Rosa 567",
                        7,
                        3.5
                );

        PedidoExpress express =
                new PedidoExpress(
                        103,
                        "Av. Apoquindo 1500",
                        7,
                        true
                );

        System.out.println("\n========== PEDIDO COMIDA ==========");

        comida.mostrarResumen();

        comida.asignarRepartidor();

        comida.asignarRepartidor("Luis Díaz");

        reservarPedido(comida);

        comida.despachar();

        System.out.println("\n========== PEDIDO ENCOMIENDA ==========");

        encomienda.mostrarResumen();

        encomienda.asignarRepartidor();

        encomienda.asignarRepartidor("Daniela Tapia");

        reservarPedido(encomienda);

        encomienda.despachar();

        System.out.println("\n========== PEDIDO EXPRESS ==========");

        express.mostrarResumen();

        express.asignarRepartidor();

        express.asignarRepartidor("Carlos Soto");

        reservarPedido(express);

        express.cancelar();

        System.out.println("\n========== HISTORIAL ==========");

        ArrayList<Pedido> historial = new ArrayList<>();

        historial.add(comida);
        historial.add(encomienda);

        for (Pedido pedido : historial) {

            pedido.verHistorial();

            System.out.println(
                    "Pedido #" +
                            String.format("%03d",
                                    pedido.getIdPedido()) +
                            " - " +
                            pedido.getClass().getSimpleName() +
                            " - entregado"
            );
        }

        System.out.println("\n========== COMPARACIÓN ==========");

        Pedido[] pedidos = {
                comida,
                encomienda,
                express
        };

        for (Pedido pedido : pedidos) {

            System.out.println(
                    pedido.getClass().getSimpleName()
                            + " → "
                            + pedido.calcularTiempoEntrega()
                            + " minutos"
            );
        }


// ==========================================
// SIMULACIÓN CONCURRENTE Y SINCRONIZADA
// ==========================================

        System.out.println(
                "\n========== SIMULACIÓN CONCURRENTE =========="
        );


// CREAR PEDIDOS PARA LA ZONA DE CARGA

        PedidoComida comida1 =
                new PedidoComida(
                        201,
                        "Av. Providencia 100",
                        3,
                        "Restaurant La Buena Mesa"
                );

        PedidoExpress express1 =
                new PedidoExpress(
                        202,
                        "Av. Las Condes 250",
                        5,
                        true
                );

        PedidoEncomienda encomienda1 =
                new PedidoEncomienda(
                        203,
                        "Av. Vicuña Mackenna 800",
                        6,
                        2.5
                );

        PedidoComida comida2 =
                new PedidoComida(
                        204,
                        "Av. Grecia 1200",
                        8,
                        "Restaurant El Sabor"
                );

        PedidoExpress express2 =
                new PedidoExpress(
                        205,
                        "Av. Kennedy 1500",
                        4,
                        false
                );

        PedidoEncomienda encomienda2 =
                new PedidoEncomienda(
                        206,
                        "Av. Matta 450",
                        9,
                        5.0
                );


// CREAR ZONA DE CARGA COMPARTIDA

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();


// AGREGAR PEDIDOS A LA ZONA DE CARGA

        zonaDeCarga.agregarPedido(comida1);

        zonaDeCarga.agregarPedido(express1);

        zonaDeCarga.agregarPedido(encomienda1);

        zonaDeCarga.agregarPedido(comida2);

        zonaDeCarga.agregarPedido(express2);

        zonaDeCarga.agregarPedido(encomienda2);


// CREAR REPARTIDORES

        Repartidor camila =
                new Repartidor(
                        "Camila",
                        zonaDeCarga
                );

        Repartidor luis =
                new Repartidor(
                        "Luis",
                        zonaDeCarga
                );

        Repartidor pedro =
                new Repartidor(
                        "Pedro",
                        zonaDeCarga
                );


// CREAR POOL DE HILOS

        ExecutorService executor =
                Executors.newFixedThreadPool(3);


// EJECUTAR LOS REPARTIDORES

        executor.execute(camila);

        executor.execute(luis);

        executor.execute(pedro);


// CERRAR EL EXECUTOR

        executor.shutdown();

        try {

            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {

                System.out.println(
                        "La simulación tardó demasiado tiempo."
                );

                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            System.out.println(
                    "La ejecución principal fue interrumpida."
            );

            executor.shutdownNow();

            Thread.currentThread().interrupt();
        }


// MOSTRAR RESULTADO FINAL

        System.out.println(
                "\n========== TODOS LOS REPARTIDORES TERMINARON =========="
        );

        System.out.println(
                "\nTodos los pedidos han sido entregados correctamente."
        );

        zonaDeCarga.mostrarEstadoPedidos();


        System.out.println("\n==========================================");
        System.out.println("           FIN DEL SISTEMA");
        System.out.println("==========================================");
    }

    public static void reservarPedido(Pedido pedido) {

        System.out.println(
                "→ Pedido #" +
                        String.format("%03d",
                                pedido.getIdPedido()) +
                        " reservado correctamente."
        );
    }
}