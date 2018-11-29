package model;

public class Episodio {
    private Visualitzacio vist;
    private Valoracio nota;
    private String title, data, duration, idioma, description, idSerie, numTemporada;
    private Subscripcio subscripcio;


    public Episodio (String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada){
        this.title = title;
        this.duration = duration;
        this.idioma = idioma;
        this.description = description;
        this.data = data;
        this.idSerie = idSerie;
        this.numTemporada = numTemporada;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setNota(Valoracio nota){
        this.nota = nota;
    }

    public void setVist(Visualitzacio vist){
        this.vist = vist;
    }

    public void setSubscripcio(Subscripcio subscripcio){
        this.subscripcio = subscripcio;
    }

    public void setNom(String nom) {
        this.title = nom;
    }

    public String getNom() {
        return title;
    }

    public String getIdSerie() {
        return idSerie;
    }
}
