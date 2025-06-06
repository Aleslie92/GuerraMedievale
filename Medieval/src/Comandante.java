package Medieval

import java.util.ArrayList;
import java.util.List;

Army Manager;

public class Comandante {
    // ! Attributi
    private String nome;
    private int budget;
    private List<Combattente> combattenti = new ArrayList<>();
    private int guadagniTotali;

    // ! Costruttore
    public Comandante(String nome, int budget) {
        this.nome = nome;
        this.budget = budget;
    }

    // ! Getter, setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Combattente> getCombattenti() {
        return combattenti;
    }

    public void setCombattenti(List<Combattente> combattenti) {
        this.combattenti = combattenti;
    }

    public int getGuadagniTotali() {
        return guadagniTotali;
    }

    public void setGuadagniTotali(int guadagniTotali) {
        this.guadagniTotali = guadagniTotali;
    }

    // !Metodi
    // * Assolda un combattente */
    public void arruolaSoldato(Combattente c) {
        combattenti.add(c);
    }

    public void combatti(List<Combattente> nemici) {
        for (Combattente c : this.combattenti) {

        }
        for (Combattente n : nemici) {

        }

    }
}
