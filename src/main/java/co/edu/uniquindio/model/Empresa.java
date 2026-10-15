package co.edu.uniquindio.model;

import java.time.LocalDate;

public class Empresa {
    private String nombre;
    private String nit;
    private String ciudad;
    private String telefono;


    private Camara[] listCamaras = new Camara[100];
    private Dron[] listDrones = new Dron[100];
    private KitIluminacion[] listKits = new KitIluminacion[100];
    private Cliente[] listClientes = new Cliente[100];
    private Reserva[] listReservas = new Reserva[100];
    private Operador[] listOperadores = new Operador[100];
    private Sede[] listSedes = new Sede[100];

    public Empresa(String nombre, String nit, String ciudad, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

//----------------------------------------------------------------------------------------------------------------------

    // --- BÚSQUEDAS POR ÍNDICE ---
    public int encontrarIndexCamara(String codigo) {
        for (int i = 0; i < listCamaras.length; i++) {
            if (listCamaras[i] != null && listCamaras[i].getCodigo().equals(codigo)) return i;
        }
        return -1;
    }

    public int encontrarIndexDron(String codigo) {
        for (int i = 0; i < listDrones.length; i++) {
            if (listDrones[i] != null && listDrones[i].getCodigo().equals(codigo)) return i;
        }
        return -1;
    }

    public int encontrarIndexKit(String codigo) {
        for (int i = 0; i < listKits.length; i++) {
            if (listKits[i] != null && listKits[i].getCodigo().equals(codigo)) return i;
        }
        return -1;
    }

    public int encontrarIndexCliente(String id) {
        for (int i = 0; i < listClientes.length; i++) {
            if (listClientes[i] != null && listClientes[i].id().equals(id)) return i;
        }
        return -1;
    }

    public int encontrarIndexReserva(String codigo) {
        for (int i = 0; i < listReservas.length; i++) {
            if (listReservas[i] != null && listReservas[i].getCodigoUnico().equals(codigo)) return i;
        }
        return -1;
    }

    public int encontrarIndexOperador(String id) {
        for (int i = 0; i < listOperadores.length; i++) {
            if (listOperadores[i] != null && listOperadores[i].id().equals(id)) return i;
        }
        return -1;
    }

    public int encontrarIndexSede(String nombre) {
        for (int i = 0; i < listSedes.length; i++) {
            if (listSedes[i] != null && listSedes[i].getNombre().equals(nombre)) return i;
        }
        return -1;
    }

//----------------------------------------------------------------------------------------------------------------------

    // --- BÚSQUEDAS DE OBJETOS COMPLETOS ---
    public Camara buscarCamara(String codigo) {
        int idx = encontrarIndexCamara(codigo);
        return idx != -1 ? listCamaras[idx] : null;
    }

    public Dron buscarDron(String codigo) {
        int idx = encontrarIndexDron(codigo);
        return idx != -1 ? listDrones[idx] : null;
    }

    public KitIluminacion buscarKit(String codigo) {
        int idx = encontrarIndexKit(codigo);
        return idx != -1 ? listKits[idx] : null;
    }

    public Operador buscarOperador(String id) {
        int idx = encontrarIndexOperador(id);
        return idx != -1 ? listOperadores[idx] : null;
    }

//----------------------------------------------------------------------------------------------------------------------

    // --- REGISTROS ---
    public boolean agregarCamara(String codigo, String marca, String modelo, String resolucionMax, boolean lentes) {
        Camara nueva = new Camara(codigo, marca, modelo, 0.0, resolucionMax, lentes);
        if (encontrarIndexCamara(codigo) == -1) {
            for (int i = 0; i < listCamaras.length; i++) {
                if (listCamaras[i] == null) { listCamaras[i] = nueva; return true; }
            }
        }
        return false;
    }

    public boolean agregarDron(String codigo, String marca, String modelo, int autonomia, boolean bateria) {
        Dron nuevo = new Dron(codigo, marca, modelo, 0.0, autonomia, bateria);
        if (encontrarIndexDron(codigo) == -1) {
            for (int i = 0; i < listDrones.length; i++) {
                if (listDrones[i] == null) { listDrones[i] = nuevo; return true; }
            }
        }
        return false;
    }

    public boolean agregarKit(String codigo, String marca, String modelo, int luces, double potencia) {
        KitIluminacion nuevo = new KitIluminacion(codigo, marca, modelo, 0.0, luces, potencia);
        if (encontrarIndexKit(codigo) == -1) {
            for (int i = 0; i < listKits.length; i++) {
                if (listKits[i] == null) { listKits[i] = nuevo; return true; }
            }
        }
        return false;
    }

    public boolean registrarCliente(String id, String nombre, String telefono, String correo) {
        Cliente nuevo = new Cliente(id, nombre, telefono, correo);
        if (encontrarIndexCliente(id) == -1) {
            for (int i = 0; i < listClientes.length; i++) {
                if (listClientes[i] == null) { listClientes[i] = nuevo; return true; }
            }
        }
        return false;
    }

    public boolean registrarOperador(String id, String nombre, String telefono) {
        Operador nuevo = new Operador(id, nombre, telefono);
        if (encontrarIndexOperador(id) == -1) {
            for (int i = 0; i < listOperadores.length; i++) {
                if (listOperadores[i] == null) { listOperadores[i] = nuevo; return true; }
            }
        }
        return false;
    }

    public boolean registrarSede(String codigo, String nombre, String direccion) {
        Sede nueva = new Sede(codigo, nombre, direccion);
        if (encontrarIndexSede(codigo) == -1) {
            for (int i = 0; i < listSedes.length; i++) {
                if (listSedes[i] == null) { listSedes[i] = nueva; return true; }
            }
        }
        return false;
    }

    public boolean registrarReserva(String codigo, String idCliente, LocalDate fecha, Turno turno) {
        int idxCliente = encontrarIndexCliente(idCliente);
        if (encontrarIndexReserva(codigo) == -1 && idxCliente != -1) {
            Reserva nueva = new Reserva(codigo, listClientes[idxCliente], fecha, turno);
            for (int i = 0; i < listReservas.length; i++) {
                if (listReservas[i] == null) { listReservas[i] = nueva; return true; }
            }
        }
        return false;
    }

//----------------------------------------------------------------------------------------------------------------------

    // --- GESTIÓN DE RESERVA ---
    public boolean agregarEquipoAReserva(String codigoReserva, EquipoAudiovisual equipo, int horas) {
        int idx = encontrarIndexReserva(codigoReserva);
        return idx != -1 && listReservas[idx].agregarEquipoReserva(equipo, horas);
    }

    public boolean cambiarEstadoReserva(String codigoReserva, EstadoReserva nuevoEstado) {
        int idx = encontrarIndexReserva(codigoReserva);
        if (idx != -1) {
            listReservas[idx].setEstado(nuevoEstado);
            return true;
        }
        return false;
    }

    public double calcularCostoReserva(String codigoReserva) {
        int idx = encontrarIndexReserva(codigoReserva);
        if (idx != -1) {
            return listReservas[idx].calcularCostoTotal(); // Asegúrate de tener este método en Reserva o implementarlo
        }
        return 0.0;
    }

//----------------------------------------------------------------------------------------------------------------------
    public String mostrarCliente(String idClienteMostrar) {
        String mensaje = "";
        int index = encontrarIndexCliente(idClienteMostrar);

        if (index != -1) {
            Cliente clienteEncontrado = listClientes[index];

            mensaje = "Mascota encontrada:\n" +
                    "\nNombre: " + clienteEncontrado.getN() +
                    "\nRaza: " + mascotaEncontrada.getRaza() +
                    "\nEspecie: " + mascotaEncontrada.getEspecie() +
                    "\nEdad: " + mascotaEncontrada.getEdad();
        } else {
            mensaje = "La mascota no se encuentra en la lista.";
        }

        return mensaje;
    }
}