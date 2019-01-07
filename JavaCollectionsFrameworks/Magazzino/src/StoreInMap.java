import java.util.*;


public class StoreInMap {

    TreeMap<String,Prodotto> map;
    Set<Prodotto> set;



    public StoreInMap() {
        map = new TreeMap<String, Prodotto>();
    }


    public boolean inserimento(Prodotto p){
        if (map.containsKey(p.getCodice())){
            System.out.println("inserimento fallito prodotto -"+p.getCodice()+"- gia presente nella lista");
            return false;
        }else{
            map.put(p.getCodice(),p);
            return true;
        }
    }


    public  boolean cancellazione(String codice){
        if (!(map.containsKey(codice))){
            System.out.println("Prodotto con codice -"+codice+"- non presente in magazzino rimozione fallita\n");
            return false;
        }else{
            Prodotto eliminato = map.get(codice);
            map.remove(codice);
            System.out.println("-"+eliminato.getNome()+"- elemento rimosso\n");
            return true;
        }

    }


    public void inBaseNome(){

        Collection<Prodotto> col = map.values();

        set = new TreeSet<Prodotto>();
        set.addAll(col);
        System.out.println(set);

        //primo metodo
        /*List<Prodotto> list = (List<Prodotto>) col;
        Collections.sort(list);
        System.out.println(list);*/

    }



    public void  inBasePrice(){
        set = new TreeSet<>(new SortedByPrice());
        set.addAll(map.values());
        System.out.println(set);
    }



    public Prodotto ricerca(String codice){
        return map.get(codice);
    }

// 2 metodi successivi equivalenti

    public void inBaseCodice(){
        set = new TreeSet<Prodotto>(new SortedByCod());
        set.addAll(map.values());
        System.out.println(set);
    }
            // O

    public void stampaMagazzino(){
        //ordine crescente rispetto al codice
        System.out.println(map);
    }
}
