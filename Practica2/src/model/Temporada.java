package model;

import java.util.ArrayList;

public class Temporada {
    private ArrayList <Episodio> llistaEpisodis;
    private boolean vista;
    private String idSerie, numTemporada, numEpisodi;

    public Temporada (String idSerie, String numTemporada, String numEpisodis){
        this.llistaEpisodis = new ArrayList<>();
        this.numTemporada = numTemporada;
        this.idSerie = idSerie;
        this.numEpisodi = numEpisodis;
    }

    public void addEpisodi(Episodio episodi){
        this.llistaEpisodis.add(episodi);
    }

    public void setVista(boolean vista) {
        this.vista = vista;
    }

    public boolean getVista() {
        return vista;
    }

    public ArrayList<Episodio> getLlistaEpisodis(){
        return this.llistaEpisodis;
    }
}
