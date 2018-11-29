package model;

public class Visualitzacio {
    private String id, client, serie, numTemporada, episodi, data;
    private Episodio episodio;

    public Visualitzacio(String id, String client, String serie, String numTemporada, String episodi, String data){
        this.client = client;
        this.data = data;
        this.episodi = episodi;
        this.id = id;
        this.serie = serie;
        this.numTemporada = numTemporada;
    }


}
