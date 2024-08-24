import java.util.ArrayList;
import java.util.Scanner;

public class JuegoDeCartas {
    private ArrayList<Jugador> jugador;
    private Juego simbolo;
    private int NúmeroDeRondas;

    public JuegoDeCartas(int NúmeroDeJugadores, int NúmeroDeRondas) {
        this.jugador = new ArrayList<>();
        this.simbolo = new Juego();
        this.NúmeroDeRondas = NúmeroDeRondas;

        for (int i = 1; i <= NúmeroDeJugadores; i++) {
            jugador.add(new Jugador("Jugador " + i));
        }

        simbolo.shuffle();
    }

    public void RepartirCartas(int NúmeroDeCartas) {
        for (Jugador jugador : jugador) {
            for (int i = 0; i < NúmeroDeCartas; i++) {
                jugador.receiveCard(simbolo.dealCard());
            }
        }
    }

    public void playRound() {
        Jugador roundWinner = null;
        Carta highestCard = null;

        for (Jugador jugador : jugador) {
            Carta playedCard = jugador.playCard();
            System.out.println(jugador.getNombre() + " juega: " + playedCard);

            if (highestCard == null || playedCard.getValor() > highestCard.getValor()) {
                highestCard = playedCard;
                roundWinner = jugador;
            } else if (playedCard.getValor() == highestCard.getValor()) {
                roundWinner = null; // Empate
            }
        }

        if (roundWinner != null) {
            roundWinner.incrementScore();
            System.out.println(roundWinner.getNombre() + " gana la ronda!\n");
        } else {
            System.out.println("Empate! Ningún punto se otorga esta ronda.\n");
        }
    }

    public void startGame() {
        RepartirCartas(5);

        for (int i = 0; i < NúmeroDeRondas; i++) {
            System.out.println("Ronda " + (i + 1) + ":");
            playRound();
        }

        displayFinalResults();
    }

    public void displayFinalResults() {
        Jugador gameWinner = null;
        int highestScore = 0;

        System.out.println("Resultados finales:");
        for (Jugador jugador : jugador) {
            System.out.println(jugador.getNombre() + ": " + jugador.getPuntaje() + " puntos");

            if (jugador.getPuntaje() > highestScore) {
                highestScore = jugador.getPuntaje();
                gameWinner = jugador;
            } else if (jugador.getPuntaje() == highestScore) {
                gameWinner = null; // Empate
            }
        }

        if (gameWinner != null) {
            System.out.println("\n" + gameWinner.getNombre() + " gana el juego!");
        } else {
            System.out.println("\nEl juego terminó en empate!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el número de jugadores: ");
        int numberOfPlayers = scanner.nextInt();

        System.out.print("Ingresa el número de rondas: ");
        int numberOfRounds = scanner.nextInt();

        JuegoDeCartas game = new JuegoDeCartas(numberOfPlayers, numberOfRounds);
        game.startGame();
    }
}
