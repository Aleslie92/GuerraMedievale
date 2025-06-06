public interface Combattente {

    int attacca(Combattente combattente);

    void riceviDanno(int danno);

    boolean isAlive();

    int getCosto();

    String getDescrizione();
}
