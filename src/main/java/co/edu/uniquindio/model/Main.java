package co.edu.uniquindio.model;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    private static Empresa miEmpresa = new Empresa("PixelRent", "123456789", "Armenia", "310000000");

    public static void main(String[] args) {
        int option = 0;
        do {
            try {
                String optStr = JOptionPane.showInputDialog(
                        "\n--- MENÚ PRINCIPAL PIXELRENT ---\n" +
                                "1. Menú de Registros\n" +
                                "2. Gestión de Reservas y Costos\n" +
                                "3. Consultar información\n"
                                "0. Salir del sistema"
                );
                if (optStr == null) break;
                option = Integer.parseInt(optStr);

                switch (option) {
                    case 1: menuRegistros(); break;
                    case 2: menuGestionReservas(); break;
                    case 3: menuConsultas(); break;
                    case 0: JOptionPane.showMessageDialog(null, "¡Saliendo del sistema!"); break;
                    default: JOptionPane.showMessageDialog(null, "Opción inválida."); break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } while (option != 0);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void menuRegistros() {
        String subOptStr = JOptionPane.showInputDialog(
                "\n--- MENÚ DE REGISTROS ---\n" +
                        "1. Registrar Equipo\n" +
                        "2. Registrar Cliente\n" +
                        "3. Registrar Operador\n" +
                        "4. Registrar Sede\n" +
                        "5. Registrar Reserva\n" +
                        "0. Volver"
        );
        if (subOptStr == null) return;
        int subOpt = Integer.parseInt(subOptStr);

        switch (subOpt) {
            case 1: registrarEquipo(); break;
            case 2: registrarCliente(); break;
            case 3: registrarOperador(); break;
            case 4: registrarSede(); break;
            case 5: registrarReserva(); break;
            case 0: break;
            default: JOptionPane.showMessageDialog(null, "Opción inválida."); break;
        }
    }

    private static void registrarEquipo() {
        String tipoStr = JOptionPane.showInputDialog("Tipo de equipo:\n1. Cámara\n2. Dron\n3. Kit de Iluminación");
        if (tipoStr == null) return;
        int tipo = Integer.parseInt(tipoStr);

        String cod = JOptionPane.showInputDialog("Código:");
        String marca = JOptionPane.showInputDialog("Marca:");
        String modelo = JOptionPane.showInputDialog("Modelo:");

        switch (tipo) {
            case 1:
                String res = JOptionPane.showInputDialog("Resolución máx:");
                boolean lentes = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Lentes intercambiables? (true/false):"));
                if (miEmpresa.agregarCamara(cod, marca, modelo, res, lentes)) {
                    JOptionPane.showMessageDialog(null, "¡Cámara registrada!");
                } else { JOptionPane.showMessageDialog(null, "Error al registrar cámara."); }
                break;
            case 2:
                int aut = Integer.parseInt(JOptionPane.showInputDialog("Autonomía (min):"));
                boolean bat = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Batería adicional? (true/false):"));
                if (miEmpresa.agregarDron(cod, marca, modelo, aut, bat)) {
                    JOptionPane.showMessageDialog(null, "¡Dron registrado!");
                } else { JOptionPane.showMessageDialog(null, "Error al registrar dron."); }
                break;
            case 3:
                int luces = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de luces:"));
                double pot = Double.parseDouble(JOptionPane.showInputDialog("Potencia total:"));
                if (miEmpresa.agregarKit(cod, marca, modelo, luces, pot)) {
                    JOptionPane.showMessageDialog(null, "¡Kit registrado!");
                } else { JOptionPane.showMessageDialog(null, "Error al registrar kit."); }
                break;
        }
    }

    private static void registrarCliente() {
        String id = JOptionPane.showInputDialog("ID / Cédula:");
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String tel = JOptionPane.showInputDialog("Teléfono:");
        String correo = JOptionPane.showInputDialog("Correo:");
        if (miEmpresa.registrarCliente(id, nombre, tel, correo)) {
            JOptionPane.showMessageDialog(null, "¡Cliente registrado con éxito!");
        } else { JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente."); }
    }

    private static void registrarOperador() {
        String id = JOptionPane.showInputDialog("ID del operador:");
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String tel = JOptionPane.showInputDialog("Teléfono:");
        if (miEmpresa.registrarOperador(id, nombre, tel)) {
            JOptionPane.showMessageDialog(null, "¡Operador registrado con éxito!");
        } else { JOptionPane.showMessageDialog(null, "No se pudo registrar el operador."); }
    }

    private static void registrarSede() {
        String codigo = JOptionPane.showInputDialog("Código de sede:");
        String nombre = JOptionPane.showInputDialog("Nombre de sede:");
        String direccion = JOptionPane.showInputDialog("Dirección:");
        if (miEmpresa.registrarSede(codigo, nombre, direccion)) {
            JOptionPane.showMessageDialog(null, "¡Sede registrada con éxito!");
        } else { JOptionPane.showMessageDialog(null, "No se pudo registrar la sede."); }
    }

    private static void registrarReserva() {
        String codigo = JOptionPane.showInputDialog("Código único de reserva:");
        String idCliente = JOptionPane.showInputDialog("ID del cliente:");
        LocalDate fecha = LocalDate.parse(JOptionPane.showInputDialog("Fecha (YYYY-MM-DD):"));
        Turno turno = Turno.valueOf(JOptionPane.showInputDialog("Turno (MAÑANA, TARDE, NOCHE):").toUpperCase());

        if (miEmpresa.registrarReserva(codigo, idCliente, fecha, turno)) {
            JOptionPane.showMessageDialog(null, "¡Reserva creada con éxito!");
        } else { JOptionPane.showMessageDialog(null, "Error al crear la reserva."); }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void menuGestionReservas() {
        String subOptStr = JOptionPane.showInputDialog(
                "\n--- GESTIÓN DE RESERVAS ---\n" +
                        "1. Agregar equipo a reserva\n" +
                        "2. Cambiar estado de reserva\n" +
                        "3. Calcular costo total de reserva\n" +
                        "0. Volver"
        );
        if (subOptStr == null) return;
        int subOpt = Integer.parseInt(subOptStr);

        String codReserva = JOptionPane.showInputDialog("Código de la reserva:");

        switch (subOpt) {
            case 1:
                String codEq = JOptionPane.showInputDialog("Código del equipo:");
                int horas = Integer.parseInt(JOptionPane.showInputDialog("Horas de uso:"));
                int tipoEq = Integer.parseInt(JOptionPane.showInputDialog("Tipo (1. Cámara, 2. Dron, 3. Kit):"));

                EquipoAudiovisual eq = null;
                if (tipoEq == 1) eq = miEmpresa.buscarCamara(codEq);
                else if (tipoEq == 2) eq = miEmpresa.buscarDron(codEq);
                else if (tipoEq == 3) eq = miEmpresa.buscarKit(codEq);

                if (eq != null && miEmpresa.agregarEquipoAReserva(codReserva, eq, horas)) {
                    JOptionPane.showMessageDialog(null, "¡Equipo agregado a la reserva!");
                } else { JOptionPane.showMessageDialog(null, "No se pudo agregar el equipo."); }
                break;
            case 2:
                EstadoReserva nuevoEstado = EstadoReserva.valueOf(JOptionPane.showInputDialog("Nuevo estado (SOLICITADO, CONFIRMADO, CANCELADO, FINALIZADO):").toUpperCase());
                if (miEmpresa.cambiarEstadoReserva(codReserva, nuevoEstado)) {
                    JOptionPane.showMessageDialog(null, "¡Estado actualizado con éxito!");
                } else { JOptionPane.showMessageDialog(null, "No se pudo actualizar el estado."); }
                break;
            case 3:
                double costoTotal = miEmpresa.calcularCostoReserva(codReserva);
                JOptionPane.showMessageDialog(null, "El costo total de la reserva es: $" + costoTotal);
                break;
            case 0:
                break;
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    public static void menuConsultas(){
        String subOptStr = JOptionPane.showInputDialog(
                "\n--- MENÚ DE CONSULTAS ---\n" +
                        "1. Consultar información cliente\n" +
                        "2. Consultar información operador\n" +
                        "3. Consultar información sede\n" +
                        "4. Consultar información reserva\n" +
                        "0. Volver"
        );
        if (subOptStr == null) return;
        int subOpt = Integer.parseInt(subOptStr);
        switch (subOpt) {
            case 1: solicitarIdCliente(); break;
            case 2: solicitarIdOperador(); break;
            case 3: solicitarIdSede(); break;
            case 4: solicitarIdReserva(); break;
            case 0: break;
            default: JOptionPane.showMessageDialog(null, "Opción inválida."); break;
        }
    }

    private static void solicitarIdCliente() {
        String idClienteMostrar = JOptionPane.showInputDialog("Ingrese el Id del cliente que quiere ver: ");

        String resultado = miEmpresa.mostrarCliente(idClienteMostrar);

        JOptionPane.showMessageDialog(null, resultado);

    }
}