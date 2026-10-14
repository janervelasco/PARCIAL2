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
}