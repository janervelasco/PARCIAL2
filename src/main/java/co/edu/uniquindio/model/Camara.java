package co.edu.uniquindio.model;


    public class Camara extends EquipoAudiovisual {
        private String resolucionMaxima;
        private boolean tieneEstabilizador;

        public Camara(String codigo, String modelo, String marca, Condicion condicion, String resolucionMaxima, boolean tieneEstabilizador) {
            super(codigo, modelo, marca, condicion);
            this.resolucionMaxima = resolucionMaxima;
            this.tieneEstabilizador = tieneEstabilizador;
        }

        @Override
        public double calcularCosto(int horas) {
            double costo = 12000 * horas; // $12.000 por cada hora de utilización[span_1](start_span)[span_1](end_span)
            if (tieneEstabilizador) {
                costo += 15000; // Se adicionan $15.000 si cuenta con estabilizador[span_2](start_span)[span_2](end_span)
            }
            return costo;
        }

        public String getResolucionMaxima() {
            return resolucionMaxima;
        }

        public boolean isTieneEstabilizador() {
            return tieneEstabilizador;
        }
    }
