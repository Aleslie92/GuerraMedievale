public class Lanciere extends Soldato {
    public Lanciere(String nome, int salute, int forzaAttacco) {
        super(nome, salute, forzaAttacco);
    }

    @Override
    public int getCosto() {
        return 35;
    }

    // Nessun effetto speciale (per ora)
}
