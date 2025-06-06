import java.util.*;

public class Comandante {
    private String nome;
    private int budget;
    private List<Combattente> esercito = new ArrayList<>();
    private int guadagniTotali = 0;

    public Comandante(String nome, int budgetIniziale) {
        this.nome = nome;
        this.budget = budgetIniziale;
    }

    public void arruolaSoldato(Combattente c) {
        if (c.getCosto() <= budget) {
            esercito.add(c);
            budget -= c.getCosto();
        } else {
            System.out.println("Budget insufficiente per " + c.getDescrizione());
        }
    }

    public void guadagna(int soldi) {
        budget += soldi;
        guadagniTotali += soldi;
    }

    public void perdiSoldi(int costo) {
        budget -= costo;
    }

    public boolean èSconfitto() {
        return esercito.stream().noneMatch(Combattente::isAlive);
    }

    public List<Combattente> getEsercito() {
        return esercito;
    }

    public int getBudget() {
        return budget;
    }

    public String getNome() {
        return nome;
    }

    public void resetEsercito() {
        esercito.clear();
    }
}
