package co.edu.uniquindio.model;
import java.util.ArrayList;
import java.util.List;
public class Sede {

        private String nombre;
        private String ciudad;
        private String direccion;
        private List<EquipoAudiovisual> listaEquipos;
        private List<Operador> listaOperadores;

        // Constructor con parámetros
        public Sede(String nombre, String ciudad, String direccion) {
            this.nombre = nombre;
            this.ciudad = ciudad;
            this.direccion = direccion;
            this.listaEquipos = new ArrayList<>();
            this.listaOperadores = new ArrayList<>();
        }

        public void agregarEquipos(EquipoAudiovisual equipoAudiovisual) {
            this.listaEquipos.add(equipoAudiovisual);
        }
        public void agregarOperador(Operador operador) {
        this.listaOperadores.add(operador);
        }
        // Métodos Getters
        public String getNombre() {
            return nombre;
        }

        public String getCiudad() {
            return ciudad;
        }

        public String getDireccion() {
            return direccion;
        }

    public List<EquipoAudiovisual> getListaEquipos() {
        return listaEquipos;
    }

    public List<Operador> getListaOperador() {
        return listaOperadores;
    }
}

