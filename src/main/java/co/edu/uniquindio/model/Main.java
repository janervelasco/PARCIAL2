package co.edu.uniquindio.model;

import javax.swing.*;

public class Main {
    private static Empresa miEmpresa;

    public static void main(String[] args) {
        miEmpresa = new Empresa("PixelRent", "123456789", "Armenia", "3100000000");

        int option = 0;
        do {
            try {
                String optStr = JOptionPane.showInputDialog(
                        "=== MENÚ PRINCIPAL PIXELRENT ===" +
                                "\nSeleccione una opción:" +
                                "\n 1. Menú de Registros" +
                                "\n 2. Gestión de reservas y Costos" +
                                "\n 0. Salir del sistema"
                );
                if (optStr == null) break;
                option = Integer.parseInt(optStr);

                switch (option) {
                    case 1:
                        menuRegistros();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Módulo de reservas en desarrollo.");
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "¡Muchos éxitos en el parcial!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida.");
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
            }
        } while (option != 0);
    }

    private static void menuRegistros() {
        int optReg = 0;
        do {
            try {
                String input = JOptionPane.showInputDialog(
                        "=== MENÚ DE REGISTROS ===" +
                                "\n 1. Registrar Cliente" +
                                "\n 2. Registrar Operador" +
                                "\n 3. Registrar Sede" +
                                "\n 4. Registrar Equipos (Cámara, Dron, Kit)" +
                                "\n 0. Volver al Menú Principal"
                );
                if (input == null) break;
                optReg = Integer.parseInt(input);

                switch (optReg) {
                    case 1: registrarCliente(); break;
                    case 2: registrarOperador(); break;
                    case 3: registrarSede(); break;
                    case 4: registrarEquipo(); break;
                    case 0: break;
                    default: JOptionPane.showMessageDialog(null, "Opción inválida."); break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en los datos del menú.");
            }
        } while (optReg != 0);
    }

    private static void registrarCliente() {
        try {
            String id = JOptionPane.showInputDialog("Cédula del cliente:");
            if (id == null) return;
            String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
            String tel = JOptionPane.showInputDialog("Teléfono:");
            String correo = JOptionPane.showInputDialog("Correo:");
            String pais = JOptionPane.showInputDialog("País:");

            if (miEmpresa.agregarCliente(id, nombre, tel, correo, pais)) {
                JOptionPane.showMessageDialog(null, "¡Cliente registrado con éxito!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar (Ya existe o cupo lleno).");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente.");
        }
    }

    private static void registrarOperador() {
        try {
            String id = JOptionPane.showInputDialog("ID del operador:");
            if (id == null) return;
            String nombre = JOptionPane.showInputDialog("Nombre del operador:");
            if (nombre == null) return;
            String turnoStr = JOptionPane.showInputDialog("Ingrese el turno (MAÑANA, TARDE, NOCHE):");
            if (turnoStr == null) return;

            String limpio = turnoStr.trim().toUpperCase();
            Turno turno;
            if (limpio.equals("MAÑANA") || limpio.equals("MANANA")) {
                turno = Turno.MANIANA;
            } else if (limpio.equals("TARDE")) {
                turno = Turno.TARDE;
            } else if (limpio.equals("NOCHE")) {
                turno = Turno.NOCHE;
            } else {
                throw new IllegalArgumentException();
            }

            if (miEmpresa.agregarOperador(nombre, id, turno)) {
                JOptionPane.showMessageDialog(null, "¡Operador registrado con éxito!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar (Ya existe o cupo lleno).");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Turno inválido. Escriba MAÑANA, TARDE o NOCHE.");
        }
    }

    private static void registrarSede() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre de la sede:");
            if (nombre == null) return;
            String dir = JOptionPane.showInputDialog("Dirección:");
            String ciudad = JOptionPane.showInputDialog("Ciudad:");

            Sede nuevaSede = new Sede(nombre, dir, ciudad);
            if (miEmpresa.agregarSede(nuevaSede)) {
                JOptionPane.showMessageDialog(null, "¡Sede registrada con éxito!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la sede.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la sede.");
        }
    }

    private static void registrarEquipo() {
        try {
            String tipoStr = JOptionPane.showInputDialog(
                    "=== SELECCIONE EQUIPO ===" +
                            "\n1. Cámara" +
                            "\n2. Dron" +
                            "\n3. Kit de Iluminación"
            );
            if (tipoStr == null) return;
            int tipo = Integer.parseInt(tipoStr);

            switch (tipo) {
                case 1:
                    String codC = JOptionPane.showInputDialog("Código cámara:");
                    String marcC = JOptionPane.showInputDialog("Marca:");
                    String modC = JOptionPane.showInputDialog("Modelo:");
                    double costoC = Double.parseDouble(JOptionPane.showInputDialog("Costo por día:"));
                    String res = JOptionPane.showInputDialog("Resolución máx:");
                    boolean lentes = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Lentes intercambiables? (true/false):"));

                    if (miEmpresa.agregarCamara(codC, marcC, modC, costoC, res, lentes)) {
                        JOptionPane.showMessageDialog(null, "¡Cámara registrada con éxito!");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar la cámara.");
                    }
                    break;
                case 2:
                    String codD = JOptionPane.showInputDialog("Código dron:");
                    String marcD = JOptionPane.showInputDialog("Marca:");
                    String modD = JOptionPane.showInputDialog("Modelo:");
                    double costoD = Double.parseDouble(JOptionPane.showInputDialog("Costo por día:"));
                    int aut = Integer.parseInt(JOptionPane.showInputDialog("Autonomía en minutos:"));
                    boolean bat = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Batería adicional? (true/false):"));

                    if (miEmpresa.agregarDron(codD, marcD, modD, costoD, aut, bat)) {
                        JOptionPane.showMessageDialog(null, "¡Dron registrado con éxito!");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar el dron.");
                    }
                    break;
                case 3:
                    String codK = JOptionPane.showInputDialog("Código kit:");
                    String marcK = JOptionPane.showInputDialog("Marca:");
                    String modK = JOptionPane.showInputDialog("Modelo:");
                    double costoK = Double.parseDouble(JOptionPane.showInputDialog("Costo por día:"));
                    int luces = Integer.parseInt(JOptionPane.showInputDialog("Número de luces:"));
                    double pot = Double.parseDouble(JOptionPane.showInputDialog("Potencia total Watts:"));

                    if (miEmpresa.agregarKit(codK, marcK, modK, costoK, luces, pot)) {
                        JOptionPane.showMessageDialog(null, "¡Kit registrado con éxito!");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar el kit.");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en los datos numéricos o booleanos del equipo.");
        }
    }
}