import java.util.Random;

public class Lanciere extends Soldato {
    public Lanciere(String nome, int salute, int forzaAttacco) {
        super(nome, salute, forzaAttacco);
    }

    @Override
    public int getCosto() {
        return 35;
    }

    // Nessun effetto speciale (per ora)
    public int attacca(Combattente soldato) {
        Random random = new Random();
        int critico = random.nextInt(2);
        // se critta e l instanza del soldato è counterata togli il critico + la
        // debolezza + attacco base
        if (critico == 2 && soldato instanceof Arciere) {
            System.out.println("[" + this.getDescrizione() + "] attacca -> [" + soldato.getDescrizione() + "]"
                    + (2 + (this.forzaAttacco * 2)) + "danno critico + debolezza");
            return 2 + (this.forzaAttacco * 2);
        }
        // se è solo counter leva 2
        else if (critico == 1 && soldato instanceof Arciere) {
            System.out.println("[" + this.getDescrizione() + "] attacca -> [" + soldato.getDescrizione() + "]"
                    + (2 + this.forzaAttacco) + "danno debolezza");
            return 2 + this.forzaAttacco;
        }
        // se critta e non è counter leva solo il critico
        else if (critico == 2) {
            System.out.println("[" + this.getDescrizione() + "] attacca -> [" + soldato.getDescrizione() + "]"
                    + (this.forzaAttacco * 2) + "danno critico");
            return (this.forzaAttacco * 2);
        }
        // se non critta e non è counter il danno è base
        else {
            System.out.println("[" + this.getDescrizione() + "] attacca -> [" + soldato.getDescrizione() + "]"
                    + super.attacca(soldato) + "danno base");
            return super.attacca(soldato);
        }
    }
}
