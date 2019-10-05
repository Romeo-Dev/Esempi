public class TestMusic {

    public static void main(String[] args){

        Playlist playlist = new Playlist();

        Song s1 = new Song("Diamond Heart","Alan Walker","Breath",2007),
                s2 = new Song("Burn Out","Martin Garrix","Tomorrow",2010),
                s3 = new Song("High on life","Martin Garrix","Tomorrow",2010),
                s4 = new Song("Come no","Baby k","Estate",2010),
                s5 = new Song("Till i collapse","Eminem","Recovery",2010),
                s6 = new Song("Solo","Clean Bandit","Acqua",2013),
                s7 = new Song("Not Afraid","Eminem","Recovery",2010);


        playlist.inserimento(s1);
        playlist.inserimento(s2);
        playlist.inserimento(s3);
        playlist.inserimento(s4);
        playlist.inserimento(s5);
        playlist.inserimento(s6);
        playlist.inserimento(s7);
        playlist.inserimento(s1);

        System.out.println("Per ogni anno quante canzoni ho: ");
        System.out.println(playlist.occByAnno()+"\n");
        System.out.println("Per ogni anno listami le canzoni che sono uscite: ");
        System.out.println(playlist.raggruppaPerAnno()+"\n");
        System.out.println("Per ogni artista listami le sue canzoni");
        System.out.println(playlist.iMieiArtisti()+"\n");


    }


}
