package models;

public class Aposta {

    private Apostador apostador;
    private float m_aposta;
    private Evento.Resultado resultado;
    private Odd odd_fixada;

    public Aposta() {
        this.apostador = null;
        this.m_aposta = 0;
        this.resultado = null;
        this.odd_fixada = null;

    }

    public Aposta(Apostador apostador, float m_aposta, Evento.Resultado resultado, Odd odd_actual) {
        this.apostador = apostador;
        this.m_aposta = m_aposta;
        this.resultado = resultado;
        this.odd_fixada = odd_actual.clone();
    }

    // getter and setters
    public Apostador getApostador() {
        return apostador;
    }

    public Evento.Resultado getResultado() {
        return resultado;
    }

    public float getM_aposta() {
        return m_aposta;
    }

    public Odd getOdd_fixada() {
        return odd_fixada;
    }

    public void setOdd_fixada(Odd odd_fixada) {
        this.odd_fixada = odd_fixada.clone();
    }

    public void setM_aposta(float m_aposta) {
        this.m_aposta = m_aposta;
    }

    public void setApostador(Apostador apostador) {
        this.apostador = apostador;
    }

    public void setResultado(Evento.Resultado resultado) {
        this.resultado = resultado;
    }

    public float calculaPremio(Evento.Resultado resultado) {
        float premio = 0;
        if (resultado == this.resultado) {
            switch (this.resultado) {
                case VITORIA:
                    premio = (this.m_aposta * this.odd_fixada.getOdd1());
                    break;
                case EMPATE:
                    premio = (this.m_aposta * this.odd_fixada.getOddx());
                    break;
                case DERROTA:
                    premio = (this.m_aposta * this.odd_fixada.getOdd2());
                    break;
            }
        }
        return premio;
    }
}
