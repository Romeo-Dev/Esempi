package Model;

public class TestCommerce {
    public static void main(String[] args) {

        Magazzino mag = new Magazzino();
        // Articoli
        Articolo art1 = new Articolo("YZCFV","Caffe Borbone",2.92),
                art2 = new Articolo("RZVBM","Caffe lavazza",3.17),
                art3 = new Articolo("TZ130","Te verde",2.50),
                art4 = new Articolo("QWERTY","Caffe Dek",-2.75);

        // Operazioni us magazzino
        mag.aggiungiArticolo(art1,3);
        mag.aggiungiArticolo(art2,6);
        mag.aggiungiArticolo(art3,10);
        mag.aggiungiArticolo(art4,-3);

        //operation
        mag.stampaMagazzino();
        System.out.println("\nStampa della lista di prodotti che necessita rifornimento");
       System.out.println( mag.daRifornire(3));
    }

}
