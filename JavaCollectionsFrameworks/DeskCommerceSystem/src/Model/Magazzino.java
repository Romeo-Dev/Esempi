package Model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Magazzino {

    Map<Articolo,Integer> deposito;

    public Magazzino() {
       deposito = new TreeMap<Articolo,Integer>();
    }

    public void aggiungiArticolo(Articolo art, int qnt){

        if (deposito.isEmpty() || !deposito.containsKey(art)){
            if (qnt > 0)
            deposito.put(art,qnt);
            else
                deposito.put(art,0);
            return;
        }
        int result = deposito.get(art) + qnt;
        deposito.put(art,result);
        return;

    }

    public boolean rimuoviArticolo(Articolo art, int qnt){

        if (deposito.isEmpty() || !deposito.containsKey(art)){
            System.out.println("Il magazzino non ha questo articolo");
            return  false;
        }else{
            int result = deposito.get(art) - qnt;
            if(result > 0)
            deposito.put(art,result);
            else
            deposito.remove(art);
            return  true;
        }
    }

    public LinkedList<String> daRifornire(int soglia){

        if (deposito.isEmpty()) return null;
        LinkedList<String> rifornire = new LinkedList<>();
        for (Map.Entry<Articolo,Integer> entry: deposito.entrySet()) {
                if (entry.getValue() <= soglia){
                    Articolo art = entry.getKey();
                    String scarso = art.getNome();
                    rifornire.add(scarso);
                }
        }
        Collections.sort(rifornire);
        return rifornire;
    }

    public  void  stampaMagazzino(){
        System.out.println("Stampa dei prodotti del mio magazzino con la relativa quantita");
        for (Map.Entry<Articolo,Integer> entry: deposito.entrySet()) {
                System.out.println("\n"+entry.getKey()+"Quantita rimanente: \t"+entry.getValue());
        }
    }

}
