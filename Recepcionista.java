import java.util.Random;

public class Recepcionista extends Thread {
    private String nome;
    private Hotel hotel;
    private Random random;

    public Recepcionista(String nome, Hotel hotel) {
        this.nome = nome;
        this.hotel = hotel;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(5000));
                Quarto quarto = hotel.checkIn();
                if (quarto != null) {
                    int numeroQuarto = quarto.getNumero();
                    System.out.println(nome + " alocou o quarto " + numeroQuarto + " para um hóspede.");
                    Thread.sleep(random.nextInt(10000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}