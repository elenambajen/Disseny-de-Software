package model;

public class Protagonista extends Artista{
    private String nomSerie;

    public Protagonista(String id, String nom, String tipus, String idSerie, String nacionalitat, String nomSerie){
        super(id, nom, tipus, idSerie, nacionalitat);
        this.nomSerie = nomSerie;

    }
}
