package model;

import java.util.ArrayList;

public class Serie {
    ArrayList <Temporada> llistaTemporades;
    private boolean acabada;
    private boolean vistaTota;
    private String title, id, desc;

    public Serie(String id, String title, String desc){
        this.title = title;
        this.id = id;
        this.desc = desc;
        this.llistaTemporades = new ArrayList<Temporada>();
    }

    public String getTitle(){
        return this.title;
    }

    public void setAcabada(boolean acabada) {
        this.acabada = acabada;
    }

    public boolean getAcabada() {
        return acabada;
    }

    public void setVistaTota(boolean vistaTota) {
        this.vistaTota = vistaTota;
    }

    public boolean getVistaTota() {
        return vistaTota;
    }
}
