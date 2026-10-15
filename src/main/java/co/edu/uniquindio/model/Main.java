package co.edu.uniquindio.model;
import javax.swing.*;
public class Main {
    private static Empresa miEmpresa;

    public static void main(String[] args) {

        miEmpresa = new Empresa("PixelRent", "123456789", "armenia", "213213213");

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
                    do {
                        option1 = Integer.parseInt(JOptionPane.showInputDialog("para registrar seleccione una opción:" +
                                "\nSeleccione una opción:" +
                                "\n 1. Registrar cliente." +
                                "\n 2. Registrar operador." +
                                "\n 3. Registrar sede." +
                                "\n 4. Registrar equipos." +
                                "\n 5. Crear Reserva" +
                                "\n 0. Salir del sistema"));
                        switch (option1) {
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
                    } while (option1 != 0);
                    break;
                case 2:
                    int option2 = 0;
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("Gestión de Reservas" +
                                "\nSeleccione una opción:" +
                                "\n 1. Agregar equipos audiovisuales a una reserva." +
                                "\n 2. Asignar operador." +
                                "\n 3. Confirmar reserva." +
                                "\n 4. Cambiar estado de reserva." +
                                "\n 0. Salir del sistema"));
                        switch (option2) {
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 0:
                                JOptionPane.showMessageDialog(null, "el programa finalizo.");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "la opción es invalida.");
                                break;
                        }
                    } while (option2 != 0);
                    break;
                case 3:
                    int option3 = 0;
                    do {
                        option3 = Integer.parseInt(JOptionPane.showInputDialog("Consultas y Cálculos" +
                                "\nSeleccione una opción:" +
                                "\n 1. Consultar equipos Audiovisuales disponibles." +
                                "\n 2. Consultar reservas confirmadas por cliente." +
                                "\n 3. Calcular y consultar valor total de una reserva." +
                                "\n 0. Salir del sistema"));
                        switch (option3) {
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:
                                
                                break;
                            case 0:
                                JOptionPane.showMessageDialog(null, "el programa finalizo.");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "la opción es invalida.");
                                break;
                        }
                    } while (option3 != 0);
                    break;
            }
        } while (option != 0);
    }

//----------------------------------------------------------------------------------------------------------------------
    //REGISTRAR

    private static void registrarCliente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String telefono = JOptionPane.showInputDialog("Ingrese el numero de telefono:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo:");
        String id = JOptionPane.showInputDialog("Ingrese el número de identificación:");

        boolean resultado = miEmpresa.agregarCliente(nombre,telefono,correo,id);
        if(resultado){
            JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
        }
        else{
            JOptionPane.showMessageDialog(null, "no se hizo el registro");
        }

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

//------------------------------------------------------------------------------------------------------------------
    //CREAR RESERVA

    private static void crearReserva() {
        // 1. Pedimos los datos fundamentales para instanciar la Reserva
        String codigoUnico = JOptionPane.showInputDialog("Ingrese el código único de la reserva:");
        String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha (Formato: AAAA-MM-DD):");
        java.time.LocalDate fecha = java.time.LocalDate.parse(fechaStr);

        String turnoStr = JOptionPane.showInputDialog("Ingrese el turno (MAÑANA, TARDE, NOCHE):");
        Turno turno = Turno.valueOf(turnoStr.toUpperCase());

        String IDliente = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");

        // Buscamos el cliente en la empresa
        Cliente cliente = miEmpresa.buscarCliente(IDliente);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "¡Error! El cliente no está registrado en el sistema.");
            return;
        }

        // 2. Creamos la reserva (¡sin escribir "operador:"!)
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