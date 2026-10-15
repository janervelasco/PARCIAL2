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


    public Empresa( String nombre, String nit, String direccion , String telefono){
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;

        listSedes = new Sede[10];
        listClientes= new Cliente[10];
        listOperadores = new Operador[10];

    }

//--------------------------------------------------------------------------------------------------------

    // REGISTRAR CLIENTE
    public boolean agregarCliente(String nombre, String telefono, String correo,
                                  String id){
        Cliente nuevoCliente = new Cliente(nombre,telefono,correo,id);
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
    // ENCONTRAR INDEX CLIENTE
    public int encontrarIndexCliente(String id) {
        for (int i = 0; i < listClientes.length; i++) {
            if (listClientes[i] != null && listClientes[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }




}
