package hu.petrik.bejegyzesProjekt;

import java.time.LocalDate;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDate letrejott;
    private LocalDate szerkesztve;

    Bejegyzes(String szerzo, String tartalom){
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDate.now();
        this.szerkesztve = LocalDate.now();
    }

    public String getSzerzo(){
        return this.szerzo;
    }

    public String getTartalom(){
        return this.tartalom;
    }

    public void setTartalom(String tartalom){

        this.szerkesztve = LocalDate.now();
        this.tartalom = tartalom;
    }

    public int getLikeok(){
        return this.likeok;
    }

    public LocalDate getLetrejott(){
        return this.letrejott;
    }

    public LocalDate getSzerkesztve(){
        return this.szerkesztve;
    }

    public void like(){
        this.likeok += 1;
    }

    @Override
    public String toString() {
        return String.format("%s-%d-%s\nSzerkesztve: %s\n%s",this.szerzo,this.getLikeok(),this.getLetrejott(),this.getSzerkesztve(),this.getTartalom());
    }
}
