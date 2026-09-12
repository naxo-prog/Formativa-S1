# 🚚 SpeedFast - Sistema de Gestión de Entregas

## 📋 Descripción del proyecto

SpeedFast es una aplicación desarrollada en Java que simula un sistema de gestión y entrega de pedidos.

El sistema permite trabajar con diferentes tipos de pedidos mediante Programación Orientada a Objetos y, además, incorpora programación concurrente para simular el trabajo simultáneo de varios repartidores.

Durante la ejecución, los repartidores comparten una zona de carga desde la cual retiran pedidos y realizan las entregas de forma concurrente.

---

## 🎯 Objetivos

El proyecto permite aplicar los siguientes conceptos:

- Programación Orientada a Objetos.
- Abstracción.
- Herencia.
- Encapsulación.
- Polimorfismo.
- Sobrecarga de métodos.
- Sobrescritura de métodos.
- Interfaces.
- Enumeraciones (`enum`).
- Programación concurrente.
- Implementación de `Runnable`.
- Uso de `ExecutorService`.
- Sincronización mediante `synchronized`.

---

## 🏗️ Estructura del proyecto

```text
src
└── main
    ├── java
    │   ├── Concurrente
    │   │   ├── Repartidor.java
    │   │   └── ZonaDeCarga.java
    │   │
    │   ├── interfaces
    │   │   ├── Cancelable.java
    │   │   ├── Despachable.java
    │   │   └── Rastreable.java
    │   │
    │   ├── model
    │   │   ├── EstadoPedido.java
    │   │   ├── Pedido.java
    │   │   ├── PedidoComida.java
    │   │   ├── PedidoEncomienda.java
    │   │   └── PedidoExpress.java
    │   │
    │   └── ui
    │       └── Main.java
    │
    └── resources