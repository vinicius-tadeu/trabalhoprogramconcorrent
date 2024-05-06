import java.util.Random;

public class Recepcionista extends Thread {
    private String nome;
    private Hotel hotel;

    public Recepcionista(String nome, Hotel hotel) {
        this.nome = nome;
        this.hotel = hotel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(5000)); // Simula o tempo de atendimento do recepcionista
                Quarto quarto = hotel.checkIn();
                if (quarto != null) {
                    System.out.println(nome + " alocou o quarto " + quarto.getNumero() + " para um hóspede.");
                    Thread.sleep(random.nextInt(10000)); // Simula o tempo de check-in
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
