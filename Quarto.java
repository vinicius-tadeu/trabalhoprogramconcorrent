public class Quarto {
    private int numero;
    private boolean ocupado;
    private int capacidade;
    private boolean chaveNaRecepcao;

    public Quarto(int numero) {
        this.numero = numero;
        this.ocupado = false;
        this.capacidade = 0;
        this.chaveNaRecepcao = true; // Inicialmente a chave está na recepção
    }

    public synchronized void ocupar() {
        if (capacidade < 4) { // Verifica se o quarto não está cheio
            ocupado = true;
            capacidade++;
            chaveNaRecepcao = false; // Ao ocupar, a chave não está mais na recepção
            System.out.println("Quarto " + numero + " ocupado. Capacidade: " + capacidade);
        } else {
            System.out.println("Quarto " + numero + " está cheio. Não é possível ocupar.");
        }
    }

    public synchronized void desocupar() {
        ocupado = false;
        capacidade = 0; // Reinicia a capacidade ao desocupar
        chaveNaRecepcao = true; // Ao desocupar, a chave volta para a recepção
        System.out.println("Quarto " + numero + " desocupado. Chave devolvida à recepção.");
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public boolean isChaveNaRecepcao() {
        return chaveNaRecepcao;
    }

    public int getNumero() {
        return numero;
    }

    public void limpar() {
        System.out.println("Limpando o quarto " + numero + "...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("O quarto " + numero + " foi limpo.");
    }
}