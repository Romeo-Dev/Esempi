public class Prodotto implements Comparable<Prodotto>{
    private String codice, nome;
    private double prezzo;


    public Prodotto(String codice, String nome, double prezzo) {
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
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof  Prodotto)) return false;
        Prodotto p = (Prodotto) obj;
        return this.codice.equalsIgnoreCase(p.codice);
    }

    @Override
    public String toString() {
        return " Codice: "+this.codice+"\n"+
                "Prodotto:   "+this.nome+"\t"+"Prezzo: "+this.prezzo+"$\n"+
                "--------------------------------------------------------->\n";
    }

    @Override
    public int compareTo(Prodotto o) {
        if (!(this.nome.compareTo(o.nome) == 0)){
            if (this.nome.compareTo(o.nome) < 0) return -1;
            if (this.nome.compareTo(o.nome) > 0) return 1;
        }
        return 0;
    }
}
