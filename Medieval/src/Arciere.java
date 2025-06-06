public class Arciere extends Soldato {
    public Arciere(String nome, int salute, int forzaAttacco) {
        super(nome, salute, forzaAttacco);
    }

    @Override
    public int getCosto() {
        return 30;
    }

    // Doppio colpo con possibilità
    @Override
    public int attacca() {
        if (Math.random() < 0.3) {
            return forzaAttacco + 5; // 30% bonus
        }
        return super.attacca();
    }
}
