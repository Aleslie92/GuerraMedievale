public class Cavaliere extends Soldato {
    public Cavaliere(String nome, int salute, int forzaAttacco) {
        super(nome, salute, forzaAttacco);
    }

    @Override
    public int getCosto() {
        return 40;
    }

    // Colpo critico casuale
    @Override
    public int attacca() {
        if (Math.random() < 0.2) {
            return forzaAttacco * 2; // 20% critico
        }
        return super.attacca();
    }
}
