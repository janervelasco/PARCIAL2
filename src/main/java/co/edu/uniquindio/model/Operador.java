package co.edu.uniquindio.model;

public class Operador {

        private String nombre;
        private String id;
        private Turno turno;

        // Constructor con parámetros
        public Operador(String nombre, String id, Turno turno) {
            this.nombre = nombre;
            this.id = id;
            this.turno = turno;
        }

        // Métodos Getters
        public String getNombre() {
            return nombre;
        }

        public String getId() {
            return id;
        }

        public Turno getTurno() {
            return turno;
        }
    }

