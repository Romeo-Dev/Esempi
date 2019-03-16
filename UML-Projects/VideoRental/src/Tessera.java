public class Tessera {
    private String codice;
    private  double saldo;

    public Tessera(String codice, double saldo) {
        this.codice = codice;
        this.saldo = saldo;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "codice='" + codice + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
