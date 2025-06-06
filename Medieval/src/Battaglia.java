import java.util.*;

public class Battaglia {

    public static List<Combattente> generaEsercitoNemico(int budget) {
        List<Combattente> esercito = new ArrayList<>();
        Random rand = new Random();

        while (budget >= 30) {
            int tipo = rand.nextInt(3); // 0: Cavaliere, 1: Arciere, 2: Lanciere
            Combattente soldato;

            switch (tipo) {
                case 0 -> soldato = new Cavaliere("Cav. IA", 100, 25);
                case 1 -> soldato = new Arciere("Arc. IA", 70, 20);
                default -> soldato = new Lanciere("Lanc. IA", 80, 22);
            }

            int costo = soldato.getCosto();
            if (costo <= budget) {
                esercito.add(soldato);
                budget -= costo;
            } else {
                break;
            }
        }

        return esercito;
    }

    public static boolean eseguiBattaglia(Comandante c1, Comandante c2) {
        List<Combattente> esercito1 = new ArrayList<>(c1.getEsercito());
        List<Combattente> esercito2 = new ArrayList<>(c2.getEsercito());

        int turno = 0;
        Random rand = new Random();

        while (esercitoVivo(esercito1) && esercitoVivo(esercito2)) {

            turno++;
            System.out.println("\n--- Turno " + turno + " ---");

            
            for (int i = 0; i < Math.max(esercito1.size(), esercito2.size()); i++) {
                
                // Determina quale esercito ha più soldati
        if(!esercito1.isEmpty() && !esercito2.isEmpty()) {
        
            // Esercito 1 ha più soldati
            Combattente a = esercito1.get(rand.nextInt(esercito1.size()));
            Combattente b = esercito2.get(rand.nextInt(esercito2.size()));

    if (a.isAlive() && b.isAlive()) {
    b.riceviDanno(a.attacca(b));
    if (!b.isAlive()) {
        System.out.println(">> " + b.getDescrizione() + " è stato ucciso!");
        esercito2.remove(b);
        c1.guadagna(20);
    }
}

if (a.isAlive() && b.isAlive()) {
    a.riceviDanno(b.attacca(a));
    if (!a.isAlive()) {
        System.out.println(">> " + a.getDescrizione() + " è stato ucciso!");
        esercito1.remove(a);
        c2.guadagna(20);
    }
}
       
        }
    }

            // Punti a fine turno
            if (esercitoVivo(esercito1))
                c1.guadagna(10);
            if (esercitoVivo(esercito2))
                c2.guadagna(10);

        }

        boolean c1Vince = esercitoVivo(esercito1);
        System.out.println("\n==> Risultato: " + (c1Vince ? c1.getNome() : c2.getNome()) + " ha vinto la battaglia!");

        return c1Vince;
    }

    private static boolean esercitoVivo(List<Combattente> esercito) {
        return esercito.stream().anyMatch(Combattente::isAlive);
    }

   
}
