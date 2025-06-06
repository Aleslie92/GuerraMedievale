import java.util.*;

public class Battaglia {

    public static List<Combattente> generaEsercitoNemico(int budget) {
        List<Combattente> esercito = new ArrayList<>();
        Random rand = new Random();

        while (budget >= 20) {
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
        List<Combattente> esercito1 = new ArrayList<>(c1.getCombattenti());
        List<Combattente> esercito2 = new ArrayList<>(c2.getCombattenti());

        int turno = 0;
        Random rand = new Random();

        while (esercitoVivo(esercito1) && esercitoVivo(esercito2)) {
            turno++;
            System.out.println("\n--- Turno " + turno + " ---");

            for (int i = 0; i < Math.min(esercito1.size(), esercito2.size()); i++) {
                Combattente a = esercito1.get(i);
                Combattente b = esercito2.get(i);

                if (a.isAlive()) {
                    int danno = a.attacca();
                    b.riceviDanno(danno);
                    System.out.println("[" + a.getDescrizione() + "] attacca -> [" + b.getDescrizione() + "] per "
                            + danno + " danni");
                    if (!b.isAlive()) {
                        System.out.println(">> " + b.getDescrizione() + " è stato ucciso!");
                        c1.guadagna(20);
                    }
                }

                if (b.isAlive()) {
                    int danno = b.attacca();
                    a.riceviDanno(danno);
                    System.out.println("[" + b.getDescrizione() + "] attacca -> [" + a.getDescrizione() + "] per "
                            + danno + " danni");
                    if (!a.isAlive()) {
                        System.out.println(">> " + a.getDescrizione() + " è stato ucciso!");
                        c2.guadagna(20);
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
