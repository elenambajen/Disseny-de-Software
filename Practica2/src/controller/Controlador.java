package controller;

import java.util.ArrayList;


public class Controlador {
    private Façana f;

    public Controlador(){
        f = new Façana();
    }

    public ArrayList<String> getCatalegSeries(){
        return f.getCataleg();
    }

    public void subscripcioEpisodi(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada){
        f.subscripcioEpisodi(title, duration, idioma, description, data, idSerie, numTemporada);
    }

    public void visualitzacioEpisodi(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada){
        f.visualitzacioEpisodi(title, duration, idioma, description, data, idSerie, numTemporada);
    }

    public void valoracio(String id, String client, String idSerie, String numTemporada, String episodi, String puntuacio, String data){
        f.valoracio(id, client, idSerie, numTemporada, episodi, puntuacio, data);
    }

    public ArrayList<String> watchedList(){
        return f.watchedList();
    }

    public ArrayList<String> watchNext(){
        return f.watchNext();
    }

    public ArrayList<String> notStarted(){
        return f.notStarted();
    }

    public boolean login(String nom, String password){
         return f.login(nom, password);
    }

    public boolean registre(String id, String nom, String dni, String adreca, String usuari, String password){
        if(f.registrar(id, nom, dni, adreca, usuari, password)){
            return true;
        }
        return false;
    }
}
