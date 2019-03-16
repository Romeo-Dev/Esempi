public class Cliente implements Comparable<Cliente> {
    private String nome;
    private  String cognome;
    private String email;
    private String tel;
    Tessera tessera;

    public Cliente(String nome, String cognome, String email, String tel) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.tel = tel;
        this.tessera = null;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Cliente)) return false;
        Cliente cl = (Cliente) obj;
        return this.email.equalsIgnoreCase(cl.email);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Cliente cliente) {
        if (this.cognome.compareTo(cliente.cognome) != 0){
            if (this.cognome.compareTo(cliente.cognome) < 0) return -1;
            if (this.cognome.compareTo(cliente.cognome) > 0) return 1;
        }
        if (this.nome.compareTo(cliente.nome) != 0){
            if (this.nome.compareTo(cliente.nome) < 0) return -1;
                if (this.nome.compareTo(cliente.nome) > 0) return 1;
        }
        return 0;
    }

    public void acquistaTessera(Tessera t,double importo){
        if (importo < 10){
            System.out.println("La quota di 10$ non e stata raggiunta acquisto non riuscito");
            return;
        }
        this.tessera = t;
        this.tessera.setSaldo(importo);
        System.out.println("Tessera acquistata consuccesso: "+this.tessera);
    }

    public void caricaTessera(double importo){
        if (this.tessera == null){
            System.out.println("Tessera non acquistata procedere all acquisto e poi eventualmente caricare");
        }
        this.tessera.setSaldo(this.tessera.getSaldo() + importo);
    }

    public  void stampaTessera(){
        System.out.println("\t"+this.cognome +"\n"+ this.tessera);
    }
    //TODO:iniziare a gestire i film con le relative copie idea base film contiene linkedlist di copie



}
