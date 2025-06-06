import java.util.Random;

public class Arciere extends Soldato {
    public Arciere(String nome, int salute, int forzaAttacco) {
        super(nome, salute, forzaAttacco);
    }

    @Override
    public int getCosto() {
        return 30;
    }

    // Doppio colpo con possibilità
    // @Override
    // public int attacca(Combattente combattente) {
    // if (Math.random() < 0.3) {
    // return (int) (forzaAttacco * 1.30); // 30% bonus
    // }
    // return super.attacca();
    // }

    @Override
    public int attacca(Combattente soldato) {

        int critico = (int) (Math.random() * 2 + 1);
        // se critta e l instanza del soldato è counterata togli il critico + la
        // debolezza + attacco base
        if (critico == 2 && soldato instanceof Cavaliere) {
            System.out.println("[" + this.getDescrizione() + "] attacca -> [" + soldato.getDescrizione() + "]"
                    + (2 + (this.forzaAttacco * 2)) + "danno critico + debolezza");
            return 2 + (this.forzaAttacco * 2);
        }
        // se è solo counter leva 2
        else if (critico == 1 && soldato instanceof Cavaliere) {
            System.out.println("[" + this.getDescrizione() + "] attacca -> [" + soldato.getDescrizione() + "]"
                    + (2 + this.forzaAttacco) + "danno debolezza");
            return 2 + this.forzaAttacco;
        }
        // se critta e non è counter leva solo il critico
        else if (critico == 2) {
            System.out.println("[" + this.getDescrizione() + "] attacca -> [" + soldato.getDescrizione() + "]"
                    + (this.forzaAttacco * 2) + "danno critico");
            return (this.forzaAttacco * 2);
        } else {
            System.out.println("[" + this.getDescrizione() + "] attacca -> [" + soldato.getDescrizione() + "]"
                    + super.attacca(soldato) + "danno base");
            return super.attacca(soldato);
        }
    }
}
