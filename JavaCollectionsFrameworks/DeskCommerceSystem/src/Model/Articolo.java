package Model;

public class Articolo implements Comparable<Articolo> {

    private String codice;
    private  String nome;
    private double prezzo;

    public Articolo(String codice, String nome, double prezzo) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        if (prezzo < 0){
            prezzo = 0;
            return  prezzo;
        }else
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return  false;
        if (!(obj instanceof Articolo)) return false;
        Articolo art = (Articolo) obj;
        return this.codice.equalsIgnoreCase(art.codice);
    }

    @Override
    public String toString() {
        return "Codice: "+codice+"\t Prodotto: "+nome+"\nPrezzo: "+this.getPrezzo()+"$\n";
    }

    @Override
    public int compareTo(Articolo o) {
        if (!(this.nome.compareTo(o.nome) == 0)) {
            if (this.nome.compareTo(o.nome) < 0) return -1;
            if (this.nome.compareTo(o.nome) > 0) return 1;
        }
        return 0;
    }
}
