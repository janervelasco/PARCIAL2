package co.edu.uniquindio.model;

public class Empresa {

    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;

    private Sede[] listSedes;
    private Cliente[] listClientes;
    private Operador[] listOperadores;
    private Reserva[] listReservas;
    private Camara[] listCamaras;
    private Dron[] listDrones;
    private KitIluminacion[] listKits;

    public Empresa(String nombre, String nit, String direccion, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;

        listSedes = new Sede[10];
        listClientes = new Cliente[10];
        listOperadores = new Operador[10];
        listReservas = new Reserva[10];
        listCamaras = new Camara[10];
        listDrones = new Dron[10];
        listKits = new KitIluminacion[10];
    }

    // --- CLIENTES ---
    public boolean agregarCliente(String id, String nombre, String telefono, String correo, String pais) {
        Cliente nuevoCliente = new Cliente(id, nombre, telefono, correo, pais);
        if (encontrarIndexCliente(id) == -1) {
            for (int i = 0; i < listClientes.length; i++) {
                if (listClientes[i] == null) {
                    listClientes[i] = nuevoCliente;
                    return true;
                }
            }
        }
        return false;
    }

    public int encontrarIndexCliente(String id) {
        for (int i = 0; i < listClientes.length; i++) {
            if (listClientes[i] != null && listClientes[i].id().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Cliente buscarCliente(String id) {
        int index = encontrarIndexCliente(id);
        return (index != -1) ? listClientes[index] : null;
    }

    // --- OPERADORES ---
    public boolean agregarOperador(String nombre, String id, Turno turno) {
        Operador nuevoOperador = new Operador(nombre, id, turno);
        if (encontrarIndexOperador(id) == -1) {
            for (int i = 0; i < listOperadores.length; i++) {
                if (listOperadores[i] == null) {
                    listOperadores[i] = nuevoOperador;
                    return true;
                }
            }
        }
        return false;
    }

    public int encontrarIndexOperador(String id) {
        for (int i = 0; i < listOperadores.length; i++) {
            if (listOperadores[i] != null && listOperadores[i].id().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // --- SEDES ---
    public boolean agregarSede(Sede nuevaSede) {
        if (encontrarIndexSede(nuevaSede.getNombre()) == -1) {
            for (int i = 0; i < listSedes.length; i++) {
                if (listSedes[i] == null) {
                    listSedes[i] = nuevaSede;
                    return true;
                }
            }
        }
        return false;
    }

    public int encontrarIndexSede(String nombreSede) {
        for (int i = 0; i < listSedes.length; i++) {
            if (listSedes[i] != null && listSedes[i].getNombre().equalsIgnoreCase(nombreSede)) {
                return i;
            }
        }
        return -1;
    }

    // --- CÁMARAS ---
    public boolean agregarCamara(String codigo, String marca, String modelo, double costoDia, String resolucionMax, boolean lentes) {
        Camara nuevaCamara = new Camara(codigo, marca, modelo, costoDia, resolucionMax, lentes);
        if (encontrarIndexCamara(codigo) == -1) {
            for (int i = 0; i < listCamaras.length; i++) {
                if (listCamaras[i] == null) {
                    listCamaras[i] = nuevaCamara;
                    return true;
                }
            }
        }
        return false;
    }

    public int encontrarIndexCamara(String codigo) {
        for (int i = 0; i < listCamaras.length; i++) {
            if (listCamaras[i] != null && listCamaras[i].getCodigo().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    // --- DRONES ---
    public boolean agregarDron(String codigo, String marca, String modelo, double costoDia, int autonomia, boolean bateria) {
        Dron nuevoDron = new Dron(codigo, marca, modelo, costoDia, autonomia, bateria);
        if (encontrarIndexDron(codigo) == -1) {
            for (int i = 0; i < listDrones.length; i++) {
                if (listDrones[i] == null) {
                    listDrones[i] = nuevoDron;
                    return true;
                }
            }
        }
        return false;
    }

    public int encontrarIndexDron(String codigo) {
        for (int i = 0; i < listDrones.length; i++) {
            if (listDrones[i] != null && listDrones[i].getCodigo().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    // --- KITS DE ILUMINACIÓN ---
    public boolean agregarKit(String codigo, String marca, String modelo, double costoDia, int luces, double potencia) {
        KitIluminacion nuevoKit = new KitIluminacion(codigo, marca, modelo, costoDia, luces, potencia);
        if (encontrarIndexKit(codigo) == -1) {
            for (int i = 0; i < listKits.length; i++) {
                if (listKits[i] == null) {
                    listKits[i] = nuevoKit;
                    return true;
                }
            }
        }
        return false;
    }

    public int encontrarIndexKit(String codigo) {
        for (int i = 0; i < listKits.length; i++) {
            if (listKits[i] != null && listKits[i].getCodigo().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    // --- RESERVAS ---
    public boolean agregarReserva(Reserva nuevaReserva) {
        for (int i = 0; i < listReservas.length; i++) {
            if (listReservas[i] == null) {
                listReservas[i] = nuevaReserva;
                return true;
            }
        }
        return false;
    }
}