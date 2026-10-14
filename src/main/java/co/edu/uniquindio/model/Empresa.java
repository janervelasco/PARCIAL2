package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private List<sede> listaSedes;
    private List<cliente> listaClientes;
    private List<operador> listaOperadores;


    public empresa( String nombre, String nit, String direccion , String telefono){
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;

        this.listaSedes = new ArrayList<>();
        this.listaOperadores = new ArrayList<>();
        this.listaClientes = new ArrayList<>();

    }

//--------------------------------------------------------------------------------------------------------

    // REGISTRAR CLIENTE
    public boolean agregarCliente(String documento, String nombreCompleto, String telefono,
                                  String email, String pais){
        cliente nuevoCliente = new cliente(documento, nombreCompleto, telefono, email, pais);
        if (encontrarIndexCliente(nuevoCliente.getDocumento()) == -1) {
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
    public int encontrarIndexCliente(String cedulaBuscar) {
        for (int i = 0; i < listClientes.length; i++) {
            if (listClientes[i] != null && listClientes[i].getDocumento().equals(cedulaBuscar)) {
                return i;
            }
        }
        return -1;
    }

}
