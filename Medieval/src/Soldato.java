public abstract class Soldato implements Combattente {

    private String nome;
    private int salute;
    protected int forzaAttacco;
    

    public Soldato(String nome, int salute, int forzaAttacco) {
        this.nome = nome;
        this.salute = salute;
        this.forzaAttacco = forzaAttacco;
    }

    public String getNome() {
        return nome;
    }

    public int getSalute() {
        return salute;
    }

    public int getForzaAttacco() {
        return forzaAttacco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalute(int salute) {
        this.salute = salute;
    }

    public void setForzaAttacco(int forzaAttacco) {
        this.forzaAttacco = forzaAttacco;
    }

    @Override
    public int attacca(Combattente combattente) {
        return forzaAttacco;
    }

    @Override
    public void riceviDanno(int danno) {
        salute -= danno;
    }

    @Override
    public boolean isAlive() {
        return salute > 0;
    }

    @Override
    public String getDescrizione() {
        return nome + " (HP: " + salute + ", ATK: " + forzaAttacco + ")";
    }

    @Override
    public String toString() {
        return "Soldato [nome=" + nome + ", salute=" + salute + ", forzaAttacco=" + forzaAttacco + "]";
    }

}
