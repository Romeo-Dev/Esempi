import java.util.Comparator;

public class SortedByCod implements Comparator<Prodotto> {


    @Override
    public int compare(Prodotto o1, Prodotto o2) {
        if (!(o1.getCodice().compareTo(o2.getCodice()) == 0)){
            if (o1.getCodice().compareTo(o2.getCodice()) < 0) return -1;
            if (o1.getCodice().compareTo(o2.getCodice()) > 0) return 1;
        }
        return o1.compareTo(o2);
    }
}
