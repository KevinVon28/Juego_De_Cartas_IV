import java.util.ArrayList;
import java.util.Collections;

public class Juego {
    private ArrayList<Carta> cartas;

    public Juego() {
        String[] simbolos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        cartas = new ArrayList<>();

        for (String suit : simbolos) {
            for (int valor = 1; valor <= 13; valor++) {
                cartas.add(new Carta(suit, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cartas);
    }

    public Carta dealCard() {
        return cartas.remove(0);
    }

    public int remainingCards() {
        return cartas.size();
    }
}