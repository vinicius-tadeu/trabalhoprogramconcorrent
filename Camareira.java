import java.util.Random;

public class Camareira extends Thread {
    private String nome;
    private Hotel hotel;

    public Camareira(String nome, Hotel hotel) {
        this.nome = nome;
        this.hotel = hotel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(10000)); // Simula tempo de limpeza
                hotel.realizarLimpeza(this, hotel.getQuartos().get(random.nextInt(hotel.getQuartos().size())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNome() {
        return nome;
    }
}
