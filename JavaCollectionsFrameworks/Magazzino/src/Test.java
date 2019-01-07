public class Test {

    public static void  main(String[] args){


        StoreInMap magazzino = new StoreInMap();

        //--------------AGGIUNGO PRODOTTI -----------------------

        Prodotto p1 = new Prodotto("AB123","Lenovo Yoga",400),
                 p2 = new Prodotto("AB234","Lenovo Thinkpad",350),
                p3 = new Prodotto("AB345","Hp Omen",896),
                p4 = new Prodotto("AB456","Dell inspirion",1350),
                p5 = new Prodotto("AB567","MacBook pro",1750),
                p6 = new Prodotto("CD123","Lenovo X01 Carbon",1200),
                p7 = new Prodotto("AB777","Hp Pavillion n6",613),
                p8 = new Prodotto("AB789","Monitor LG 2k v-sync",750),
                p9 = new Prodotto("CD456","Lenovo T430",300),
                p10 = new Prodotto("CD542","MacBook Air",800),
                p11 = new Prodotto("D542A","Lenovo T420",260),
                p12 = new Prodotto("DD123","Asus gtx 980",350),
                p13 = new Prodotto("AD456","Asus Zenbook pro",1400),
                p14 = new Prodotto("FF59","Logitech 62000 dpi",60),
                p15 = new Prodotto("RM413","Cuffie Headset Corsair Wireless",100),
                p22 = new Prodotto("RM111","Ipad 9 i3U4600",550),
                p16 = new Prodotto("RM110","Ryzen amd ",400),
                p23 = new Prodotto("AB234","Scheda video gtx 970",252);

        //---------------------Aggiungo i prodotti al magazzino-----------------------------------

        magazzino.inserimento(p1);
        magazzino.inserimento(p2);
        magazzino.inserimento(p13);
        magazzino.inserimento(p12);
        magazzino.inserimento(p2);
        magazzino.inserimento(p3);
        magazzino.inserimento(p4);
        magazzino.inserimento(p14);
        magazzino.inserimento(p16);
        magazzino.inserimento(p6);
        magazzino.inserimento(p7);
        magazzino.inserimento(p8);
        magazzino.inserimento(p9);
        magazzino.inserimento(p10);
        magazzino.inserimento(p12);
        magazzino.inserimento(p13);
        magazzino.inserimento(p15);
        magazzino.inserimento(p16);
        magazzino.inserimento(p5);
        magazzino.inserimento(p22);
        magazzino.inserimento(p23);

    /*Appunti:in realta in output abbiamo una lista di prodotti che non sono presenti nella
    * nostra mappa ma che hanno lo stesso codice associato e pertanto il meodo funge
    * e blocca l inserimento di prodotto avente lo stesso codice di un altro inserito.
    * Per tanto quando si cerca di inserire lo stesso riferimento piu volte il metodo continua
    * a funzionare bloccando l inserimento.*/

    System.out.println();

    //-----------------------Metodi di Magazzino--------------------------------------------


        //metodo che ricerca un elemento all interno della mappa
        System.out.println("Ricerca elementi in magazzino che hanno codici CD123 e AB234\n");
        System.out.println(magazzino.ricerca("CD123"));
        System.out.println(magazzino.ricerca("AB234"));
        //----------------------------------------------------------
        System.out.println();

        //--------------------STAMPA---------------------
        System.out.println("Stampo a video i prodotti in magazzino\n");
        // commentare e decommentare la scelta di ordinamento oppure farle restare entrambe
        // rispetto codice
                //magazzino.stampaMagazzino();
        // rispetto nome
                magazzino.inBaseNome();

        //--------------------------------------------------------------
        System.out.println();
        //------------------Rimozionoe prodotti----------------------------------------
        System.out.println("cancellzione dei prodotti con codice RM111=Ipad e AB567=MacBook + betaTest\n");

        magazzino.cancellazione("AABBCC");
        magazzino.cancellazione("RM111");
        magazzino.cancellazione("ZZ123");
        magazzino.cancellazione("AB567");

        magazzino.stampaMagazzino();

    }
}
