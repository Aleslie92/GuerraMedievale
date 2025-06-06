public abstract class Soldato implements Combattente {

 private String nome;
 private int salute;
 private int forzaAttacco;
 
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
 public String toString() {
    return "Soldato [nome=" + nome + ", salute=" + salute + ", forzaAttacco=" + forzaAttacco + "]";
 }


public abstract void attacca();

public abstract void riceviDanno(double danno);

public abstract boolean isAlive();

public abstract void getDescrizione();
 
}