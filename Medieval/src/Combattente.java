public interface Combattente {

    int attacca();

    void riceviDanno(int danno);

    boolean isAlive();

    int getCosto();

    String getDescrizione();
}
