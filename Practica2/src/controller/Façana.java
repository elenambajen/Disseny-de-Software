package controller;

import edu.ub.informatica.disseny.stub.DAO_XML;
import model.*;

import java.util.ArrayList;

public class Façana {
    private DAO_XML ap;
    private CatalegSeries catalegSeries;
    private Client client;
    private LlistaClients llistaClients;

    public Façana(){
        this.ap = new DAO_XML("");
        this.catalegSeries = new CatalegSeries();
        this.llistaClients = new LlistaClients();
        this.client = new Client("4", "3", "1", "", "", "");
    }

    public ArrayList<String> getCataleg(){
        return catalegSeries.getNomSeries();
    }

    public void addCataleg(String id, String title, String desc){
        Serie s = ap.loadSerie(id, title, desc);
        catalegSeries.addSerie(s);
    }

    public void subscripcioEpisodi(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada){
        Episodio episodio = ap.loadEpisodi(title, duration, idioma, description, data, idSerie, numTemporada);
        Subscripcio subs = ap.loadSubscripcio(client.getId(), client.getNom(), episodio.getIdSerie(), numTemporada, episodio.getNom());
        episodio.setSubscripcio(subs);
        this.client.addEpisodi(episodio);
    }

    public void visualitzacioEpisodi(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada){
        Episodio ep = ap.loadEpisodi(title, duration, idioma, description, data, idSerie, numTemporada);
        Visualitzacio vis = ap.loadVisualització(idSerie, client.getNom(), ep.getIdSerie(), numTemporada, ep.getNom(), data);
        ep.setVist(vis);
        this.client.addEpisodi(ep);
    }


    public void valoracio(String id, String client, String idSerie, String numTemporada, String episodi, String puntuacio, String data){
        Valoracio val = ap.loadValoracio(id, client, idSerie, numTemporada, episodi, puntuacio, data);
        for (int i = 0; i < this.client.getCapitols().size(); i++){
            if (episodi.equals(this.client.getCapitols().get(i).getNom())){
                this.client.getCapitols().get(i).setNota(val);
                i = this.client.getCapitols().size();
            }
        }
    }

    public ArrayList<String> watchedList(){
        ArrayList<String> series = new ArrayList<>();
        for (int i = 0; i < this.client.getWatchedList().size(); i ++){
            series.add(this.client.getWatchedList().get(i).getTitle());
        }
        return series;
    }

    public ArrayList<String> watchNext(){
        ArrayList<String> series = new ArrayList<>();
        for (int i = 0; i < this.client.getWatchNext().size(); i ++){
            series.add(this.client.getWatchNext().get(i).getTitle());
        }
        return series;
    }

    public ArrayList<String> notStarted(){
        ArrayList<String> series = new ArrayList<>();
        for (int i = 0; i < this.client.getNotStartedYet().size(); i ++){
            series.add(this.client.getNotStartedYet().get(i).getTitle());
        }
        return series;
    }

    public boolean login (String nom, String password){
        LogIn login = new LogIn(nom, password, this.llistaClients);;
        if(login.entrar() == true){
            return true;
        }
        return false;
    }


    public boolean registrar(String id, String nom, String dni, String adreca, String usuari, String password){
        Client client = new Client(id, nom, dni, adreca, usuari, password);
        Registre registre = new Registre(client, this.llistaClients);
        if(registre.registre() == true){
            this.llistaClients.addClient(client);
            return true;
        }
        return false;
    }
}
