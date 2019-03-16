import java.util.LinkedList;
import java.util.List;

public class Film implements Comparable<Film> {

    private String codice_seriale,titolo,genere,anno;
    List<Copia> copie;

    public Film(String codice_seriale, String titolo, String genere, String anno) {
        this.codice_seriale = codice_seriale;
        this.titolo = titolo;
        this.genere = genere;
        this.anno = anno;
        copie = new LinkedList<Copia>();
    }

    public String getCodice_seriale() {
        return codice_seriale;
    }

    public void setCodice_seriale(String codice_seriale) {
        this.codice_seriale = codice_seriale;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Film)) return false;
        Film f =(Film) o;
        return this.codice_seriale.equalsIgnoreCase(f.codice_seriale);
    }

    @Override
    public String toString() {
        return "Titolo: "+this.titolo+"\t"+this.codice_seriale+"\n"+
                "Genere: "+this.genere+"\tAnno di produzione: "+this.anno;
    }

    @Override
    public int compareTo(Film film) {
        if (!(this.titolo.compareTo(film.titolo) == 0)){
            if (!(this.titolo.compareTo(film.titolo) < 0)) return -1;
                if (!(this.titolo.compareTo(film.titolo) > 0)) return 1;
        }
        if (!(this.anno.compareTo(film.anno) == 0)){
            if (!(this.anno.compareTo(film.anno) < 0)) return -1;
                if (!(this.anno.compareTo(film.anno) > 0)) return 1;
        }
        return 0;
    }
}
