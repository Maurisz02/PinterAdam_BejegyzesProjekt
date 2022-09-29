package hu.petrik.bejegyzesProjekt;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Bejegyzes b1 = new Bejegyzes("Maurisz","Ez a tartalom");
        Bejegyzes b2 = new Bejegyzes("Jamblebee","Ez kemeny harc lesz");

        Bejegyzesek bejegyzesList = new Bejegyzesek(new Bejegyzes[]{b1,b2});

        Scanner sc = new Scanner(System.in);

        System.out.println("Hány darab bejegyzést szeretnél közzéteni?");
        int db = 0;
        try{
            db = sc.nextInt();
            if (db<0){
                System.out.println("Negatív számot nem lehet megadni");
            }
        }catch (Exception e){
            System.err.println("Nem egész számot adtál meg!");
        }
        sc.nextLine();

        for (int i = 0; i < db;i++){
            System.out.println("Add meg a nevedet!");
            String nev = sc.nextLine();
            System.out.println("Add meg a tratalmat!");
            String tartalom = sc.nextLine();
            Bejegyzes b3 = new Bejegyzes(nev,tartalom);
            bejegyzesList.getBejegyzesek().add(b3);
        }

        Bejegyzesek bejegyzesekLista1 = null;

        try{
            bejegyzesekLista1 = new Bejegyzesek("bejegyzesek.csv");
            bejegyzesList.getBejegyzesek().addAll(bejegyzesekLista1.getBejegyzesek());
        }catch (IOException e){
            System.err.println("Ismeretlen hiba történt a fájl beolvasás folyamán");
        }

        for (int i = 0; i < bejegyzesList.getBejegyzesek().size()*20;i++){
            int bejegyzesekSzama = bejegyzesList.getBejegyzesek().size();
            int rnd = new Random().nextInt(bejegyzesekSzama-1+1)+1;
            bejegyzesList.getBejegyzesek().get(rnd-1).like();
        }

        System.out.println("Módositsd a 2. szöveg tartalmát!");
        String ujTartalom = sc.nextLine();


        bejegyzesList.getBejegyzesek().get(1).setTartalom(ujTartalom);

        System.out.println(bejegyzesList);

        int max = 0;
        boolean isBigger = false;
        for (int i = 0; i < bejegyzesList.getBejegyzesek().size();i++){
            if (bejegyzesList.getBejegyzesek().get(i).getLikeok()>max){
                max = bejegyzesList.getBejegyzesek().get(i).getLikeok();
            }
            if (bejegyzesList.getBejegyzesek().get(i).getLikeok()>35){
                isBigger = true;
            }
        }

        System.out.println("Legkedveltebb bejegyzés like száma: "+max);

        if (isBigger){
            System.out.println("Van olyan bejegyzés, amely 35-nél több likeot kapott");
        }else{
            System.out.println("Nincs olyan bejegyzés, amely 35-nél több likeot kapott");
        }


    }
}
