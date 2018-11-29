/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.stub;

import model.*;


/**
 *
 * @author anna
 */
public interface DAO_STUB {
    public Serie loadSerie(String id, String title, String desc);
    public Temporada loadTemporada(String idSerie, String numTemporada, String numEpisodis);
    public Episodio loadEpisodi(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada);
    public Artista loadArtista(String id, String nom, String tipus, String idSerie, String nacionalitat);
    public Productora loadProductora(String id, String nom, String idSerie);
    public Administrador loadAdmin(String id, String nom, String usuari, String password);
    public Client loadClient(String id, String nom, String dni, String adreca, String usuari, String password);
    public Subscripcio loadSubscripcio(String id, String client, String serie, String numTemporada, String episodi);
    public Visualitzacio loadVisualització(String id, String client, String serie, String numTemporada, String episodi, String data);
    public Valoracio loadValoracio(String id, String client, String idSerie, String numTemporada, String episodi, String puntuacio, String data);

}
