import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // GIOCO MEDIEVALE
        Comandante comandante = new Comandante("Alessandro", 500);
        System.out.println("Comandante: " + comandante.getNome());
        System.out.println("Budget iniziale: " + comandante.getBudget());
        // Arruolamento di soldati
        comandante.arruolaSoldato(new Cavaliere("Giovanna D'arco", 100, 20));
        comandante.arruolaSoldato(new Arciere("Robin Hood", 80, 15));
        comandante.arruolaSoldato(new Arciere("Mario", 80, 15));
        comandante.arruolaSoldato(new Arciere("Ciao", 80, 15));

        
        
        System.out.println("Esercito arruolato: ");
        for (Combattente c : comandante.getEsercito()) {
            System.out.println(c.getDescrizione());
        }
        // Simulazione di una battaglia

        List<Combattente> esercitoNemico = Battaglia.generaEsercitoNemico(120);
        System.out.println("Esercito nemico generato: ");
        for (Combattente c : esercitoNemico) {
            System.out.println(c.getDescrizione());
        }

        // Esecuzione della battaglia
        Comandante comandanteNemico = new Comandante("Nemico", 120);
        for (Combattente c : esercitoNemico) {
            comandanteNemico.arruolaSoldato(c);
        }

        boolean vittoria = Battaglia.eseguiBattaglia(comandante, comandanteNemico);

        if (vittoria) {
            System.out.println("Il comandante " + comandante.getNome() + " ha vinto la battaglia!");
        } else {
            System.out.println("Il comandante " + comandante.getNome() + " è stato sconfitto.");
        }
    }
}
