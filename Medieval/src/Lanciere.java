import java.util.Random;

public class Lanciere extends Soldato {

    // lanciere attacco base 1
    // lanciere forte contro arciere
    // lanciere debole contro cavaliere
    public Lanciere(String nome, int salute, int forzaAttacco, boolean alive) {
        super(nome, salute, forzaAttacco, alive);
       
    }

         @Override
    public void attacca(Soldato soldato) {
        Random random = new Random();
        int critico =  random.nextInt(2);

        // se critta e l instanza del soldato è un counter di arciere
        if(critico == 2 && soldato instanceof Cavaliere) {
            soldato.salute  -= (this.forzaAttacco *2);
            if(soldato.salute <= 0 ) {
                soldato.alive = false;
            }
        }   
        // se è solo counter leva 2
            else if( critico ==1 && soldato instanceof Arciere) {
                soldato.salute -= 2 + this.forzaAttacco;
                if(soldato.salute <= 0 ) {
                soldato.alive = false;
            }
            }
        //se critta e non è counter leva solo il critico
            else if(critico == 2 && soldato instanceof Arciere) {
            soldato.salute  -= 2 + (this.forzaAttacco *2);
            if(soldato.salute <= 0 ) {
                soldato.alive = false;
            }
            }
        // se non critta e non è counter  il danno è base
            else if(critico == 1) {
             soldato.salute -= this.forzaAttacco;
             if(soldato.salute <= 0 ) {
                soldato.alive = false;
            }
        }
    }

         // Costo dell unità
         @Override
         public int getCosto() {
            return 1;
         }

         // Controllo se il soldato è vivo
         @Override
         public boolean isAlive() {
            return alive;
         }

         @Override
    public String getDescrizione() {
        return "Sono un Lanciere " + nome + " sto attaccando..";
    }

    

}
