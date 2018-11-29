package model;

public class Valoracio {
    private String id, client, idSerie, numTemporada, episodi, puntuacio, data;

    public Valoracio(String id, String client, String idSerie, String numTemporada, String episodi, String puntuacio, String data){
        this.client = client;
        this.data = data;
        this.episodi = episodi;
        this.id = id;
        this.idSerie = idSerie;
        this.numTemporada = numTemporada;
        this.puntuacio = puntuacio;
    }


}
