package model;

import java.util.ArrayList;

public class CatalegSeries {
    private ArrayList<Serie> catalegSerie;

    public CatalegSeries(){
        this.catalegSerie = new ArrayList<>();
    }

    public ArrayList<String> getNomSeries(){
        ArrayList<String>  aux = new ArrayList<>();
        for (int i = 0; i < this.catalegSerie.size(); i++){
            aux.add(catalegSerie.get(i).getTitle());
        }
        return aux;
    }

    public void addSerie(Serie s){
        this.catalegSerie.add(s);
    }



}
