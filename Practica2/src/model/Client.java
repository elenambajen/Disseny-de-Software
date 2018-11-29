package model;

import java.util.ArrayList;

public class Client {
    private String nom, id, dni, adreca, usuari, password;
    private ArrayList<Episodio> capitols;
    private ArrayList<Serie> watchedList;
    private ArrayList<Serie> watchNext;
    private ArrayList<Serie> notStartedYet;

    public Client(String id, String nom, String dni, String adreca, String usuari, String password){
        this.nom = nom;
        this.id = id;
        this.dni = dni;
        this.adreca = adreca;
        this.usuari = usuari;
        this.password = password;
        this.capitols = new ArrayList<>();
        this.watchedList = new ArrayList<>();
        this.watchNext = new ArrayList<>();
        this.notStartedYet = new ArrayList<>();
    }

    public String getUsuari() {
        return usuari;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getId() {
        return id;
    }

    public void addEpisodi(Episodio episodi){ this.capitols.add(episodi); }

    public ArrayList<Episodio> getCapitols(){ return this.capitols; }

    public void addWatchedList(Serie serie){ this.watchedList.add(serie); }

    public ArrayList<Serie> getWatchedList(){ return this.watchedList; }

    public ArrayList<Serie> getWatchNext(){ return this.watchNext; }

    public ArrayList<Serie> getNotStartedYet(){ return this.notStartedYet; }

    public void addNext(Serie serie){
        this.watchNext.add(serie);
    }

    public void addNotStarted(Serie serie){
        this.notStartedYet.add(serie);
    }

}
