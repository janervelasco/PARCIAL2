package co.edu.uniquindio.model;

import java.time.LocalDate;

public class Empresa {
    private String nombreEmpresa;
    private String nitEmpresa;
    private String ciudadEmpresa;
    private String telefonoEmpresa;
    private Camara[] listCamaras = new Camara[100];
    private Dron[] listDrones = new Dron[100];
    private KitIluminacion[] listKits = new KitIluminacion[100];
    private Cliente[] listClientes = new Cliente[100];
    private Reserva[] listReservas = new Reserva[100];
    private Operador[] listOperadores = new Operador[100];
    private Sede[] listSedes = new Sede[100];

    public Empresa(String nombreEmpresa, String nitEmpresa, String ciudadEmpresa, String telefonoEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.ciudadEmpresa = ciudadEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
    }

    // --- BÚSQUEDAS POR ÍNDICE ---
    public int encontrarIndexCamara(String codigoCamara) {
        for (int i = 0; i < listCamaras.length; i++) {
            if (listCamaras[i] != null && listCamaras[i].getCodigo().equals(codigoCamara)) {
                return i;
            }
        }
        return -1;
    }

    public int encontrarIndexDron(String codigoDron) {
        for (int i = 0; i < listDrones.length; i++) {
            if (listDrones[i] != null && listDrones[i].getCodigo().equals(codigoDron)) {
                return i;
            }
        }
        return -1;
    }

    public int encontrarIndexKit(String codigoKit) {
        for (int i = 0; i < listKits.length; i++) {
            if (listKits[i] != null && listKits[i].getCodigo().equals(codigoKit)) {
                return i;
            }
        }
        return -1;
    }

    public int encontrarIndexCliente(String identificacionCliente) {
        for (int i = 0; i < listClientes.length; i++) {
            if (listClientes[i] != null && listClientes[i].id().equals(identificacionCliente)) {
                return i;
            }
        }
        return -1;
    }

    public int encontrarIndexReserva(String codigoReserva) {
        for (int i = 0; i < listReservas.length; i++) {
            if (listReservas[i] != null && listReservas[i].getCodigoUnico().equals(codigoReserva)) {
                return i;
            }
        }
        return -1;
    }

    public int encontrarIndexOperador(String identificacionOperador) {
        for (int i = 0; i < listOperadores.length; i++) {
            if (listOperadores[i] != null && listOperadores[i].id().equals(identificacionOperador)) {
                return i;
            }
        }
        return -1;
    }

    public int encontrarIndexSede(String nombreSede) {
        for (int i = 0; i < listSedes.length; i++) {
            if (listSedes[i] != null && listSedes[i].getNombre().equals(nombreSede)) {
                return i;
            }
        }
        return -1;
    }

    // --- BÚSQUEDAS DE OBJETOS COMPLETOS ---
    public Camara buscarCamara(String codigoCamara) {
        int indiceEncontrado = encontrarIndexCamara(codigoCamara);
        return indiceEncontrado != -1 ? listCamaras[indiceEncontrado] : null;
    }

    public Dron buscarDron(String codigoDron) {
        int indiceEncontrado = encontrarIndexDron(codigoDron);
        return indiceEncontrado != -1 ? listDrones[indiceEncontrado] : null;
    }

    public KitIluminacion buscarKit(String codigoKit) {
        int indiceEncontrado = encontrarIndexKit(codigoKit);
        return indiceEncontrado != -1 ? listKits[indiceEncontrado] : null;
    }

    public Operador buscarOperador(String identificacionOperador) {
        int indiceEncontrado = encontrarIndexOperador(identificacionOperador);
        return indiceEncontrado != -1 ? listOperadores[indiceEncontrado] : null;
    }

    // --- REGISTROS ---
    public boolean agregarCamara(String codigoCamara, String marcaCamara, String modeloCamara, String resolucionMaxima, boolean lentesIntercambiables) {
        Camara nuevaCamara = new Camara(codigoCamara, marcaCamara, modeloCamara, 0.0, resolucionMaxima, lentesIntercambiables);
        if (encontrarIndexCamara(codigoCamara) == -1) {
            for (int i = 0; i < listCamaras.length; i++) {
                if (listCamaras[i] == null) {
                    listCamaras[i] = nuevaCamara;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean agregarDron(String codigoDron, String marcaDron, String modeloDron, int autonomiaMinutos, boolean bateriaAdicional) {
        Dron nuevoDron = new Dron(codigoDron, marcaDron, modeloDron, autonomiaMinutos, bateriaAdicional);
        if (encontrarIndexDron(codigoDron) == -1) {
            for (int i = 0; i < listDrones.length; i++) {
                if (listDrones[i] == null) {
                    listDrones[i] = nuevoDron;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean agregarKit(String codigoKit, String marcaKit, String modeloKit, int cantidadLuces, boolean controlInalambrico) {
        KitIluminacion nuevoKit = new KitIluminacion(codigoKit, marcaKit, modeloKit, cantidadLuces, controlInalambrico);
        if (encontrarIndexKit(codigoKit) == -1) {
            for (int i = 0; i < listKits.length; i++) {
                if (listKits[i] == null) {
                    listKits[i] = nuevoKit;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean registrarCliente(String identificacionCliente, String nombreCliente, String telefonoCliente, String correoCliente) {
        Cliente nuevoCliente = new Cliente(identificacionCliente, nombreCliente, telefonoCliente, correoCliente);
        if (encontrarIndexCliente(identificacionCliente) == -1) {
            for (int i = 0; i < listClientes.length; i++) {
                if (listClientes[i] == null) {
                    listClientes[i] = nuevoCliente;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean registrarOperador(String identificacionOperador, String nombreOperador, String telefonoOperador) {
        Operador nuevoOperador = new Operador(identificacionOperador, nombreOperador, telefonoOperador);
        if (encontrarIndexOperador(identificacionOperador) == -1) {
            for (int i = 0; i < listOperadores.length; i++) {
                if (listOperadores[i] == null) {
                    listOperadores[i] = nuevoOperador;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean registrarSede(String nombreSede, String direccionSede, String ciudadSede) {
        Sede nuevaSede = new Sede(nombreSede, direccionSede, ciudadSede);
        if (encontrarIndexSede(nombreSede) == -1) {
            for (int i = 0; i < listSedes.length; i++) {
                if (listSedes[i] == null) {
                    listSedes[i] = nuevaSede;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean registrarReserva(String codigoReserva, String identificacionCliente, LocalDate fechaReserva, Turno turnoReserva) {
        int indiceCliente = encontrarIndexCliente(identificacionCliente);
        if (encontrarIndexReserva(codigoReserva) == -1 && indiceCliente != -1) {
            Reserva nuevaReserva = new Reserva(codigoReserva, listClientes[indiceCliente], fechaReserva, turnoReserva);
            for (int i = 0; i < listReservas.length; i++) {
                if (listReservas[i] == null) {
                    listReservas[i] = nuevaReserva;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean agregarEquipoAReserva(String codigoReserva, EquipoAudiovisual equipoAudiovisual, int cantidadHoras) {
        int indiceReserva = encontrarIndexReserva(codigoReserva);
        return indiceReserva != -1 && listReservas[indiceReserva].agregarEquipoReserva(equipoAudiovisual, cantidadHoras);
    }

    public boolean asignarOperadorAReserva(String codigoReserva, Operador operadorAsignado) {
        int indiceReserva = encontrarIndexReserva(codigoReserva);
        if (indiceReserva != -1 && operadorAsignado != null) {
            listReservas[indiceReserva].setOperador(operadorAsignado);
            return true;
        }
        return false;
    }

    public boolean cambiarEstadoReserva(String codigoReserva, EstadoReserva nuevoEstado) {
        int indiceReserva = encontrarIndexReserva(codigoReserva);
        if (indiceReserva != -1) {
            listReservas[indiceReserva].setEstado(nuevoEstado);
            return true;
        }
        return false;
    }

    public double calcularCostoReserva(String codigoReserva) {
        int indiceReserva = encontrarIndexReserva(codigoReserva);
        if (indiceReserva != -1) {
            return listReservas[indiceReserva].calcularCostoTotal();
        }
        return 0.0;
    }

    // --- MÉTODOS DE CONSULTA Y MOSTRAR INFORMACIÓN ---
    public String mostrarCliente(String identificacionCliente) {
        int indiceCliente = encontrarIndexCliente(identificacionCliente);
        if (indiceCliente != -1) {
            Cliente clienteEncontrado = listClientes[indiceCliente];
            return "--- INFORMACIÓN DEL CLIENTE ---\n" +
                    "ID: " + clienteEncontrado.id() + "\n" +
                    "Nombre: " + clienteEncontrado.nombre() + "\n" +
                    "Teléfono: " + clienteEncontrado.telefono() + "\n" +
                    "Correo: " + clienteEncontrado.correo();
        }
        return "Cliente no encontrado.";
    }

    public String mostrarOperador(String identificacionOperador) {
        int indiceOperador = encontrarIndexOperador(identificacionOperador);
        if (indiceOperador != -1) {
            Operador operadorEncontrado = listOperadores[indiceOperador];
            return "--- INFORMACIÓN DEL OPERADOR ---\n" +
                    "ID: " + operadorEncontrado.id() + "\n" +
                    "Nombre: " + operadorEncontrado.nombre() + "\n" +
                    "Teléfono: " + operadorEncontrado.telefono();
        }
        return "Operador no encontrado.";
    }

    public String mostrarSede(String nombreSede) {
        int indiceSede = encontrarIndexSede(nombreSede);
        if (indiceSede != -1) {
            Sede sedeEncontrada = listSedes[indiceSede];
            return "--- INFORMACIÓN DE LA SEDE ---\n" +
                    "Nombre: " + sedeEncontrada.getNombre() + "\n" +
                    "Dirección: " + sedeEncontrada.getDireccion() + "\n" +
                    "Ciudad: " + sedeEncontrada.getCiudad();
        }
        return "Sede no encontrada.";
    }

    public String mostrarReserva(String codigoReserva) {
        int indiceReserva = encontrarIndexReserva(codigoReserva);
        if (indiceReserva != -1) {
            Reserva reservaEncontrada = listReservas[indiceReserva];
            String nombreOperadorAsignado = (reservaEncontrada.getOperador() != null) ? reservaEncontrada.getOperador().nombre() : "Sin operador asignado";
            return "--- INFORMACIÓN DE LA RESERVA ---\n" +
                    "Código: " + reservaEncontrada.getCodigoUnico() + "\n" +
                    "Cliente: " + reservaEncontrada.getCliente().nombre() + "\n" +
                    "Fecha: " + reservaEncontrada.getFecha() + "\n" +
                    "Turno: " + reservaEncontrada.getTurno() + "\n" +
                    "Estado: " + reservaEncontrada.getEstado() + "\n" +
                    "Operador: " + nombreOperadorAsignado + "\n" +
                    "Costo Total: $" + reservaEncontrada.calcularCostoTotal();
        }
        return "Reserva no encontrada.";
    }

    // Getters y Setters básicos
    public String getNombre() { return nombreEmpresa; }
    public void setNombre(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }
    public String getNit() { return nitEmpresa; }
    public void setNit(String nitEmpresa) { this.nitEmpresa = nitEmpresa; }
    public String getCiudad() { return ciudadEmpresa; }
    public void setCiudad(String ciudadEmpresa) { this.ciudadEmpresa = ciudadEmpresa; }
    public String getTelefono() { return telefonoEmpresa; }
    public void setTelefono(String telefonoEmpresa) { this.telefonoEmpresa = telefonoEmpresa; }
}