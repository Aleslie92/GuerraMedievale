import java.util.Random;

public class Arciere extends Soldato {
    
    // se il danno viene fatto da un counter il danno viene aumento di 2
    // attacco base arcere 3
    // arcere forte contro cavaliere
    // arcere debole contro lanciere
    
    public Arciere(String nome, int salute, int forzaAttacco,boolean alive) {
        super(nome, salute, forzaAttacco,alive); 
        
    }
    
    @Override
    public void attacca(Soldato soldato) {
        Random random = new Random();
        int critico =  random.nextInt(2);
        
        // se critta e l instanza del soldato è  counterata togli il critico + la debolezza + attacco base
        if(critico == 2 && soldato instanceof Cavaliere) {
            soldato.salute -= 2 + (this.forzaAttacco *2);
            if(soldato.salute <= 0 ) {
                soldato.alive = false;
            }
        }   
        // se è solo counter leva 2
        else if( critico ==1 && soldato instanceof Cavaliere) {
            soldato.salute -= 2 + this.forzaAttacco;
            if(soldato.salute <= 0 ) {
                soldato.alive = false;
            }
        }
        //se critta e non è counter leva solo il critico
        else if(critico == 2 && soldato instanceof Lanciere) {
            soldato.salute  -=  (this.forzaAttacco *2);
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

    /*@Override
    public void riceviDanno(Soldato soldato) {
        
    if(soldato instanceof Cavaliere) {
        this.salute -= soldato.attacca();
        }
        } */
       

       // Costo dell unità
       @Override
       public int getCosto() {
           return 2;
       }

       // Controllo se il soldato è vivo
       @Override
       public boolean isAlive() {
           return alive;
        }

        // Descrizione del soldato
        @Override
        public String getDescrizione() {
        return "Sono un Arecere " + nome + " sto attaccando..";
    }
}