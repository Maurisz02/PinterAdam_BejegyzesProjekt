package hu.petrik.bejegyzesProjekt;

import java.time.LocalDate;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDate letrejott;
    private LocalDate szerkesztve;
    private boolean isChanged;

    Bejegyzes(String szerzo, String tartalom){
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDate.now();
        this.szerkesztve = LocalDate.now();
        this.isChanged = false;
    }

    public String getSzerzo(){
        return this.szerzo;
    }

    public String getTartalom(){
        return this.tartalom;
    }

    public void setTartalom(String tartalom){

        this.szerkesztve = LocalDate.now();
        this.isChanged = true;
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

    public boolean getIsChanged(){
        return this.isChanged;
    }


    @Override
    public String toString() {
        if (this.getIsChanged()){
            return String.format("%s-%d-%s\nSzerkesztve: %s\n%s\n",this.szerzo,this.getLikeok(),this.getLetrejott(),this.getSzerkesztve(),this.getTartalom());
        }else{
            return String.format("%s-%d-%s\n%s\n",this.szerzo,this.getLikeok(),this.getLetrejott(),this.getTartalom());
        }

    }
}
