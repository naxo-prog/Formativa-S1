package ui;
import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       SISTEMA DE REPARTOS SPEEDFAST");
        System.out.println("==========================================");

        PedidoComida pedidoComida =
                new PedidoComida(1001, "Av. Los Alerces 123");

        PedidoEncomienda pedidoEncomienda =
                new PedidoEncomienda(1002, "Av. Costanera 456");

        PedidoExpress pedidoExpress =
                new PedidoExpress(1003, "Calle Los Lagos 789");

        System.out.println("\n--- SOBRESCRITURA ---");

        pedidoComida.asignarRepartidor();

        System.out.println();

        pedidoEncomienda.asignarRepartidor();

        System.out.println();

        pedidoExpress.asignarRepartidor();

        System.out.println("\n--- SOBRECARGA ---");

        pedidoComida.asignarRepartidor("Juan Pérez");

        System.out.println();

        pedidoEncomienda.asignarRepartidor("Camila Soto");

        System.out.println();

        pedidoExpress.asignarRepartidor("Luis Díaz");

        System.out.println("\n--- POLIMORFISMO ---");

        Pedido pedido1 = new PedidoComida(
                2001,
                "Calle Principal 100"
        );

        Pedido pedido2 = new PedidoEncomienda(
                2002,
                "Calle Central 200"
        );

        Pedido pedido3 = new PedidoExpress(
                2003,
                "Calle Norte 300"
        );

        pedido1.asignarRepartidor();

        System.out.println();

        pedido2.asignarRepartidor();

        System.out.println();

        pedido3.asignarRepartidor();

        System.out.println("\n==========================================");
        System.out.println("        FIN DE LA EJECUCIÓN");
        System.out.println("==========================================");
    }
}