public class Carta {
    private String simbolo;  // El palo de la carta (corazones, diamantes, tréboles, picas)
    private int valor;    // El valor de la carta (1 al 13)

    public Carta(String suit, int value) {
        this.simbolo = suit;
        this.valor= value;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " de " + simbolo;
    }
}