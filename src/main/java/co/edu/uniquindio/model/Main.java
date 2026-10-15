package co.edu.uniquindio.model;
import javax.swing.*;
public class Main{
    private static Empresa miEmpresa;
    public static void main(String[] args){

        miEmpresa = new Empresa("PixelRent","123456789","armenia", "213213213");

        int option = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Este es el menu de la empresa pixelRent" +
                    "\n Seleccione una opcion: " +
                    "\n 1. Registrar." +
                    "\n 2. Gestión de reservas." +
                    "\n 3. Consultas y calculos." +

                    "\n 0. Salir del sistema"));


            switch (option) {


                case 1:
                    int option1 = 0;
                    do{
                        option1= Integer.parseInt(JOptionPane.showInputDialog("para registrar seleccione una opción:"+
                                "\nSeleccione una opción:"+
                                "\n 1. Registrar cliente."+
                                "\n 2. Registrar operador."+
                                "\n 3. Registrar sede."+
                                "\n 4. Registrar equipos."+
                                "\n 5. Crear Reserva"+
                                "\n 0. Salir del sistema"));
                        switch (option1){
                            case 1:
                                registrarCliente();
                                break;
                            case 2:
                                registrarOperador();
                                break;
                            case 3:
                                registrarSede();
                                break;
                            case 4:
                                registrarEquipo();
                                break;
                            case 5:
                                crearReserva();
                                break;
                            case 0:
                                JOptionPane.showMessageDialog(null, "el programa finalizo.");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "la opción es invalida.");
                                break;
                        }
                    }while (option1 != 0);
                    break;

            }
        }while (option != 0);
    }

    private static void registrarCliente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
        // Aquí puedes invocar el método de tu clase Empresa para guardarlo
        JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
    }

    private static void registrarOperador() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del operador:");
        String id = JOptionPane.showInputDialog("Ingrese el ID del operador:");
        JOptionPane.showMessageDialog(null, "Operador registrado con éxito.");
    }

    private static void registrarSede() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la sede:");
        JOptionPane.showMessageDialog(null, "Sede registrada con éxito.");
    }

    private static void registrarEquipo() {
        JOptionPane.showMessageDialog(null, "Módulo de registro de equipos.");
    }

    private static void crearReserva() {
        // 1. Pedimos los datos fundamentales para instanciar la Reserva
        String codigoUnico = JOptionPane.showInputDialog("Ingrese el código único de la reserva:");
        String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha (Formato: AAAA-MM-DD):");
        java.time.LocalDate fecha = java.time.LocalDate.parse(fechaStr);

        String turnoStr = JOptionPane.showInputDialog("Ingrese el turno (MAÑANA, TARDE, NOCHE):");
        Turno turno = Turno.valueOf(turnoStr.toUpperCase());

        String cedulaCliente = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");

        // Buscamos el cliente en la empresa (asegúrate de tener este método en Empresa)
        Cliente cliente = miEmpresa.buscarCliente(cedulaCliente);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "¡Error! El cliente no está registrado en el sistema.");
            return;
        }

        // 2. Creamos la reserva usando exactamente el constructor que definimos
        // Nota: El operador se deja en null al inicio ya que se puede asignar después si incluye dron.
        Reserva nuevaReserva = new Reserva(codigoUnico, fecha, cliente, null, EstadoReserva.SOLICITADO, turno);

        // 3. Intentamos agregarla a la empresa
        boolean registrada = miEmpresa.agregarReserva(nuevaReserva);

        if (registrada) {
            JOptionPane.showMessageDialog(null, "¡Reserva creada con éxito en estado SOLICITADO!");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo crear la reserva (Código repetido o datos inválidos).");
        }
    }
}
