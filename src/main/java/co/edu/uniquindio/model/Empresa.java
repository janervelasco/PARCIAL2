package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;

    private Sede[] listSedes;
    private Cliente[] listClientes;
    private Operador[] listOperadores;


    public Empresa(String nombre, String nit, String direccion, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;

        listSedes = new Sede[10];
        listClientes = new Cliente[10];
        listOperadores = new Operador[10];

    }

//--------------------------------------------------------------------------------------------------------

    // REGISTRAR CLIENTE
    public boolean agregarCliente(String nombre, String telefono, String correo,
                                  String id) {
        Cliente nuevoCliente = new Cliente(nombre, telefono, correo, id);
        if (encontrarIndexCliente(nuevoCliente.getId()) == -1) {
            for (int i = 0; i < listClientes.length; i++) {
                if (listClientes[i] == null) {
                    listClientes[i] = nuevoCliente;
                    return true;
                }
            }
        }
        return false; // Ya existe o el arreglo está lleno
    }

    // REGISTRAR OPERADOR
    public boolean agregarOperador(String nombre,String id, Turno turno) {
        Cliente nuevoOperador = new Cliente(nombre,id, turno);
        if (encontrarIndexOperador(nuevoOperador.getId()) == -1) {
            for (int i = 0; i < listOperadores.length; i++) {
                if (listOperadores[i] == null) {
                    listOperadores[i] = nuevoOperador;
                    return true;
                }
            }
        }
        return false; // Ya existe o el arreglo está lleno
    }


    // ENCONTRAR INDEX CLIENTE
    public int encontrarIndexCliente(String id) {
        for (int i = 0; i < listClientes.length; i++) {
            if (listClientes[i] != null && listClientes[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    // ENCONTRAR INDEX OPERADOR
    public int encontrarIndexOperador(String id) {
        for (int i = 0; i < listOperadores.length; i++) {
            if (listOperadores[i] != null && listOperadores[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }


    public Cliente buscarCliente(String iDliente) {

        return null;
    }

    public boolean agregarReserva(Reserva nuevaReserva) {
        return false;
    }
}