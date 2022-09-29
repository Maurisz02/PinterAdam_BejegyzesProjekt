package hu.petrik.bejegyzesProjekt;

import java.io.IOException;
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

        for (int i = 0; i < db;i++){
            System.out.println("Add meg a nevedet!");
            String nev = sc.next();
            System.out.println("Add meg a tratalmat!");
            String tartalom = sc.next();
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

        System.out.println(bejegyzesList);

    }
}
