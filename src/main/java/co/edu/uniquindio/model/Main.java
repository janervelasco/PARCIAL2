package co.edu.uniquindio.model;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    private static Empresa empresaPixelRent = new Empresa("PixelRent", "123456789", "Armenia", "310000000");

    public static void main(String[] args) {
        int opcionPrincipal = 0;
        do {
            try {
                String entradaOpcionPrincipal = JOptionPane.showInputDialog(
                        "\n--- MENÚ PRINCIPAL PIXELRENT ---\n" +
                                "1. Menú de Registros\n" +
                                "2. Gestión de Reservas y Costos\n" +
                                "3. Consultar información\n" +
                                "0. Salir del sistema"
                );
                if (entradaOpcionPrincipal == null) break;
                opcionPrincipal = Integer.parseInt(entradaOpcionPrincipal);

                switch (opcionPrincipal) {
                    case 1: menuRegistros(); break;
                    case 2: menuGestionReservas(); break;
                    case 3: menuConsultas(); break;
                    case 0: JOptionPane.showMessageDialog(null, "¡Saliendo del sistema!"); break;
                    default: JOptionPane.showMessageDialog(null, "Opción inválida."); break;
                }
            } catch (Exception excepcion) {
                JOptionPane.showMessageDialog(null, "Error: " + excepcion.getMessage());
            }
        } while (opcionPrincipal != 0);
    }

    private static void menuRegistros() {
        String entradaSubOpcion = JOptionPane.showInputDialog(
                "\n--- MENÚ DE REGISTROS ---\n" +
                        "1. Registrar Equipo\n" +
                        "2. Registrar Cliente\n" +
                        "3. Registrar Operador\n" +
                        "4. Registrar Sede\n" +
                        "5. Registrar Reserva\n" +
                        "0. Volver"
        );
        if (entradaSubOpcion == null) return;
        int subOpcion = Integer.parseInt(entradaSubOpcion);

        switch (subOpcion) {
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
        String tipoEquipoTexto = JOptionPane.showInputDialog(
                "Tipo de equipo:\n" +
                        "1. Cámara\n" +
                        "2. Dron\n" +
                        "3. Kit de Iluminación"
        );
        if (tipoEquipoTexto == null) return;
        int tipoEquipo = Integer.parseInt(tipoEquipoTexto);

        String codigoEquipo = JOptionPane.showInputDialog("Código:");
        String marcaEquipo = JOptionPane.showInputDialog("Marca:");
        String modeloEquipo = JOptionPane.showInputDialog("Modelo:");

        switch (tipoEquipo) {
            case 1:
                String resolucionMaxima = JOptionPane.showInputDialog("Resolución máx:");
                boolean lentesIntercambiables = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Lentes intercambiables? (true/false):"));
                if (empresaPixelRent.agregarCamara(codigoEquipo, marcaEquipo, modeloEquipo, resolucionMaxima, lentesIntercambiables)) {
                    JOptionPane.showMessageDialog(null, "¡Cámara registrada!");
                } else { JOptionPane.showMessageDialog(null, "Error al registrar cámara."); }
                break;
            case 2:
                int autonomiaMinutos = Integer.parseInt(JOptionPane.showInputDialog("Autonomía (min):"));
                boolean bateriaAdicional = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Batería adicional? (true/false):"));
                if (empresaPixelRent.agregarDron(codigoEquipo, marcaEquipo, modeloEquipo, autonomiaMinutos, bateriaAdicional)) {
                    JOptionPane.showMessageDialog(null, "¡Dron registrado!");
                } else { JOptionPane.showMessageDialog(null, "Error al registrar dron."); }
                break;
            case 3:
                int cantidadLuces = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de luces:"));
                double potenciaTotal = Double.parseDouble(JOptionPane.showInputDialog("Potencia total:"));
                if (empresaPixelRent.agregarKit(codigoEquipo, marcaEquipo, modeloEquipo, cantidadLuces, potenciaTotal)) {
                    JOptionPane.showMessageDialog(null, "¡Kit registrado!");
                } else { JOptionPane.showMessageDialog(null, "Error al registrar kit."); }
                break;
        }
    }

    private static void registrarCliente() {
        String identificacionCliente = JOptionPane.showInputDialog("ID / Cédula:");
        String nombreCliente = JOptionPane.showInputDialog("Nombre:");
        String telefonoCliente = JOptionPane.showInputDialog("Teléfono:");
        String correoCliente = JOptionPane.showInputDialog("Correo:");
        if (empresaPixelRent.registrarCliente(identificacionCliente, nombreCliente, telefonoCliente, correoCliente)) {
            JOptionPane.showMessageDialog(null, "¡Cliente registrado con éxito!");
        } else { JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente."); }
    }

    private static void registrarOperador() {
        String identificacionOperador = JOptionPane.showInputDialog("ID del operador:");
        String nombreOperador = JOptionPane.showInputDialog("Nombre:");
        String telefonoOperador = JOptionPane.showInputDialog("Teléfono:");
        if (empresaPixelRent.registrarOperador(identificacionOperador, nombreOperador, telefonoOperador)) {
            JOptionPane.showMessageDialog(null, "¡Operador registrado con éxito!");
        } else { JOptionPane.showMessageDialog(null, "No se pudo registrar el operador."); }
    }

    private static void registrarSede() {
        String nombreSede = JOptionPane.showInputDialog("Nombre de la sede:");
        String direccionSede = JOptionPane.showInputDialog("Dirección:");
        String ciudadSede = JOptionPane.showInputDialog("Ciudad:");
        if (empresaPixelRent.registrarSede(nombreSede, direccionSede, ciudadSede)) {
            JOptionPane.showMessageDialog(null, "¡Sede registrada con éxito!");
        } else { JOptionPane.showMessageDialog(null, "No se pudo registrar la sede."); }
    }

    private static void registrarReserva() {
        String codigoReserva = JOptionPane.showInputDialog("Código único de reserva:");
        String identificacionCliente = JOptionPane.showInputDialog("ID del cliente:");
        LocalDate fechaReserva = LocalDate.parse(JOptionPane.showInputDialog("Fecha (YYYY-MM-DD):"));
        Turno turnoReserva = Turno.valueOf(JOptionPane.showInputDialog("Turno (MAÑANA, TARDE, NOCHE):").toUpperCase());

        if (empresaPixelRent.registrarReserva(codigoReserva, identificacionCliente, fechaReserva, turnoReserva)) {
            JOptionPane.showMessageDialog(null, "¡Reserva creada con éxito!");
        } else { JOptionPane.showMessageDialog(null, "Error al crear la reserva."); }
    }

    private static void menuGestionReservas() {
        String entradaSubOpcion = JOptionPane.showInputDialog(
                "\n--- GESTIÓN DE RESERVAS ---\n" +
                        "1. Agregar equipo a reserva\n" +
                        "2. Asignar operador a reserva\n" +
                        "3. Cambiar estado de reserva\n" +
                        "4. Calcular costo total de reserva\n" +
                        "0. Volver"
        );
        if (entradaSubOpcion == null) return;
        int subOpcion = Integer.parseInt(entradaSubOpcion);

        if (subOpcion == 0) return;

        String codigoReserva = JOptionPane.showInputDialog("Código de la reserva:");

        switch (subOpcion) {
            case 1:
                String codigoEquipo = JOptionPane.showInputDialog("Código del equipo:");
                int cantidadHoras = Integer.parseInt(JOptionPane.showInputDialog("Horas de uso:"));
                int tipoEquipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo (1. Cámara, 2. Dron, 3. Kit):"));

                EquipoAudiovisual equipoEncontrado = null;
                if (tipoEquipo == 1) equipoEncontrado = empresaPixelRent.buscarCamara(codigoEquipo);
                else if (tipoEquipo == 2) equipoEncontrado = empresaPixelRent.buscarDron(codigoEquipo);
                else if (tipoEquipo == 3) equipoEncontrado = empresaPixelRent.buscarKit(codigoEquipo);

                if (equipoEncontrado != null && empresaPixelRent.agregarEquipoAReserva(codigoReserva, equipoEncontrado, cantidadHoras)) {
                    JOptionPane.showMessageDialog(null, "¡Equipo agregado a la reserva!");
                } else { JOptionPane.showMessageDialog(null, "No se pudo agregar el equipo."); }
                break;
            case 2:
                String identificacionOperador = JOptionPane.showInputDialog("ID del operador a asignar:");
                Operador operadorEncontrado = empresaPixelRent.buscarOperador(identificacionOperador);
                if (operadorEncontrado != null && empresaPixelRent.asignarOperadorAReserva(codigoReserva, operadorEncontrado)) {
                    JOptionPane.showMessageDialog(null, "¡Operador asignado a la reserva con éxito!");
                } else { JOptionPane.showMessageDialog(null, "No se pudo asignar el operador."); }
                break;
            case 3:
                EstadoReserva nuevoEstado = EstadoReserva.valueOf(JOptionPane.showInputDialog("Nuevo estado (SOLICITADO, CONFIRMADO, CANCELADO, FINALIZADO):").toUpperCase());
                if (empresaPixelRent.cambiarEstadoReserva(codigoReserva, nuevoEstado)) {
                    JOptionPane.showMessageDialog(null, "¡Estado actualizado con éxito!");
                } else { JOptionPane.showMessageDialog(null, "No se pudo actualizar el estado."); }
                break;
            case 4:
                double costoTotalReserva = empresaPixelRent.calcularCostoReserva(codigoReserva);
                JOptionPane.showMessageDialog(null, "El costo total de la reserva es: $" + costoTotalReserva);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
        }
    }

    public static void menuConsultas() {
        String entradaSubOpcion = JOptionPane.showInputDialog(
                "\n--- MENÚ DE CONSULTAS ---\n" +
                        "1. Consultar información cliente\n" +
                        "2. Consultar información operador\n" +
                        "3. Consultar información sede\n" +
                        "4. Consultar información reserva\n" +
                        "0. Volver"
        );
        if (entradaSubOpcion == null) return;
        int subOpcion = Integer.parseInt(entradaSubOpcion);

        switch (subOpcion) {
            case 1: solicitarIdCliente(); break;
            case 2: solicitarIdOperador(); break;
            case 3: solicitarIdSede(); break;
            case 4: solicitarIdReserva(); break;
            case 0: break;
            default: JOptionPane.showMessageDialog(null, "Opción inválida."); break;
        }
    }

    private static void solicitarIdCliente() {
        String idClienteMostrar = JOptionPane.showInputDialog("Ingrese el ID del cliente que quiere ver: ");
        String resultado = empresaPixelRent.mostrarCliente(idClienteMostrar);
        JOptionPane.showMessageDialog(null, resultado);
    }

    private static void solicitarIdOperador() {
        String idOperadorMostrar = JOptionPane.showInputDialog("Ingrese el ID del operador que quiere ver: ");
        String resultado = empresaPixelRent.mostrarOperador(idOperadorMostrar);
        JOptionPane.showMessageDialog(null, resultado);
    }

    private static void solicitarIdSede() {
        String idSedeMostrar = JOptionPane.showInputDialog("Ingrese el nombre de la sede que quiere ver: ");
        String resultado = empresaPixelRent.mostrarSede(idSedeMostrar);
        JOptionPane.showMessageDialog(null, resultado);
    }

    private static void solicitarIdReserva() {
        String idReservaMostrar = JOptionPane.showInputDialog("Ingrese el código de la reserva que quiere ver: ");
        String resultado = empresaPixelRent.mostrarReserva(idReservaMostrar);
        JOptionPane.showMessageDialog(null, resultado);
    }
}