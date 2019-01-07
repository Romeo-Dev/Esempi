import java.util.Comparator;

public class SortedByPrice implements Comparator<Prodotto> {

    @Override
    public int compare(Prodotto o1, Prodotto o2) {
        if (!(o1.getPrezzo() == o2.getPrezzo())){
            if (o1.getPrezzo() < o2.getPrezzo()) return -1;
            if (o1.getPrezzo() > o2.getPrezzo()) return 1;
        }
        return o1.compareTo(o2);
    }
}

