import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> Mano;
    private int Puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.Mano = new ArrayList<>();
        this.Puntaje = 0;
    }

    public void receiveCard(Carta card) {
        Mano.add(card);
    }

    public Carta playCard() {
        return Mano.remove(0);
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void incrementScore() {
        Puntaje++;
    }

    public String getNombre() {
        return nombre;
    }

    public void showHand() {
        for (Carta card : Mano) {
            System.out.println(card);
        }
    }
}
