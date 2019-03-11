package Model;

import java.util.TreeMap;

public class Cliente {
    private String nome,cognome;
    TreeMap<String,Integer> carrello;
    private double balance;


    public Cliente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.balance = 0;
        carrello = new TreeMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public double getBalance() {
        if (balance < 0)
            return balance = 0;
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void aggiungiAlCarrello(Articolo art,int qnt){
        if (carrello.isEmpty()|| !carrello.containsKey(art.getNome())){
            carrello.put(art.getNome(),qnt);
            return;
        }else{
            int result = carrello.get(art.getNome()) + qnt;
            carrello.put(art.getNome(),result);
            return;
        }
    }
}
