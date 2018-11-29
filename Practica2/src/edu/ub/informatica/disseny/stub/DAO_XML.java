package edu.ub.informatica.disseny.stub;

import model.*;

/**
 * Data manager per StUB. Crea les estructures de dades necessaries
 * per a manegar la capa de persistència de STUB.
 *
 */
public class DAO_XML implements DAO_STUB {

	private String serie;
	private String temporada;
	private String admin;
	private String client;
	private String episodi;
	private String valoracio;
	private String productora;
	private String artista; //director i actor
	private String subscripcio;
	private String visualitzacio;

	/* -------------------------------------------------------------------
	 * Metodes a implementar per vosaltres. En aquests metodes creareu els
	 * vostres objectes a partir de la informacio obtinguda del fitxer XML
	 *
	 * Podeu esborrar els prints si voleu. Tambe podeu canviar el tipus de
	 * dades que retorna el metode, es a dir que sou lliures de
	 * modificar-ho al gust, excepte les crides inicials que es fan.
	 * -------------------------------------------------------------------
	 */

	public DAO_XML(String nomFitxer) {
		STUBXMLParser parser = new STUBXMLParser(this);
		parser.parse(nomFitxer);
	}
	/**
	 * Obté les dades del fitxer XML passat per paràmetre
	 *
	 * @param nomFitxer ruta del fitxer XML del que obtenir les dades
	 */
	public void obtenirDades(String nomFitxer) {
		STUBXMLParser parser = new STUBXMLParser(this);
		parser.parse(nomFitxer);
	}

	/**
	 * Crea una nova serie a partir de la informacio obtinguda del fitxer XML
	 *
	 * @param id id de la serie. El podeu utilitzar o no
	 * @param title títol de la serie
	 * @param desc descripcio de la serie
	 */

	public Serie loadSerie(String id, String title, String desc) {

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nova serie.
		 */
		Serie serie = new Serie(id, title, desc);
		this.serie = title;
		return serie;
	}

	/**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 *
	 * @param idSerie
	 * @param numTemporada numero de la temporada
	 * @param numEpisodis numero d'episodis
	 *
	 */

	public Temporada loadTemporada(String idSerie, String numTemporada, String numEpisodis) {

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nova temporada.
		 */
		Temporada temp = new Temporada(idSerie, numTemporada, numEpisodis);
		this.temporada=numTemporada;
		return temp;
	}

	/**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 *  @param title titol de lepisodi
	 * @param duration duració de l'episodi
	 * @param idioma idioma de l'episodi V.O.
	 * @param description sinopsi de l'episodi
	 * @param data data d'estrena de l'episodi
	 * @param idSerie
	 * @param numTemporada
	 *
	 */

	public Episodio loadEpisodi(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada) {

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nou episodi.
		 */
		Episodio ep = new Episodio(title, duration, idioma, description, data, idSerie, numTemporada);
		this.episodi=title;
		return ep;
	}

	/**
	 * Crea un nou artista a partir de la informacio obtinguda del fitxer XML
	 *
	 * @param id id del artista. El podeu utilitzar o no
	 * @param nom nom del artista
	 * @param tipus tipus (director\actor) del artista
	 * @param idSerie serie a la qual treballa. El podeu utilitzar o no
	 * @param nacionalitat
	 */

	public Artista loadArtista(String id, String nom, String tipus, String idSerie, String nacionalitat) {

		/* TODO: Aqui feu el necessari per a crear els artistes per a la serie
		 */
		Artista artista = new Artista(id, nom, tipus, idSerie, nacionalitat);
		this.artista=nom;
		return artista;
	}


	/**
	 * Crea productora del fitxer XML
	 *
	 * @param id id de la productora
	 * @param nom nom de la productora
	 * @param idSerie id de la serie que va fer. El podeu utilitzar o no
	 */
	public Productora loadProductora(String id, String nom, String idSerie) {

		/* TODO: Aqui feu el necessari per a crear les productores per a les series
		 */
		Productora productora = new Productora(id, nom, idSerie);

		this.productora=nom;
		return productora;
	}

	/**
	 * Crea una valoracio a partir de la informacio obtinguda del fitxer XML
	 *  @param id id de la valoracio. El podeu utilitzar o no
	 * @param client identificador del client. El podeu utilitzar o no
	 * @param idSerie
	 * @param numTemporada
	 * @param puntuacio puntuacio donada al episodi
	 * @param data data en la que es va fer la puntuacio
	 */

	public Valoracio loadValoracio(String id, String client, String idSerie, String numTemporada, String episodi, String puntuacio, String data) {

		/* TODO: A partir d'aqui creeu la valoracio
		 */
		Valoracio valoracio = new Valoracio(id, client, idSerie, numTemporada, episodi, puntuacio, data);
		this.valoracio=puntuacio;
		return valoracio;
	}

	/**
	 * Crea un nou admin a partir de la informacio obtinguda del fitxer XML
	 *
	 * @param id id del administrador
	 * @param nom nom del administrador
	 * @param usuari usuari del administrador
	 * @param password password del administrador
	 */
	public Administrador loadAdmin(String id, String nom, String usuari, String password) {

		/* TODO: Creeu aqui el vostre admin
		 */
		Administrador admin = new Administrador(id, nom, usuari, password);
		this.admin=usuari;
		return admin;
	}

	/**
	 * Crea un nou client a partir de la informacio obtinguda del fitxer XML
	 *
	 * @param id id del client
	 * @param nom nom del client
	 * @param dni dni del client
	 * @param adreca adreça del client
	 * @param usuari usuari al sistema del client
	 * @param password password del client
	 *
	 */

	public Client loadClient(String id, String nom, String dni, String adreca, String usuari, String password) {

		/* TODO: Creeu aqui el vostre client
		 */
		Client client = new Client(id, nom, dni, adreca, usuari, password);
		this.client=usuari;
		return client;
	}

	/**
	 * Crea un nova subscripció a partir de la informació obtinguda del fitxer XML
	 *  @param id de la subscripció
	 * @param numTemporada
	 */
	public Subscripcio loadSubscripcio(String id, String client, String serie, String numTemporada, String episodi) {

		/* TODO: Creeu aqui la vostra subscripció
		 */
		Subscripcio subs = new Subscripcio(id, client, serie, numTemporada, episodi);
		this.subscripcio=episodi;
		return subs;
	}

	/**
	 * Crea un nova visualització a partir de la informació obtinguda del fitxer XML
	 *  @param id de la visualització
	 * @param numTemporada
	 * @param data de la visualització del episodi
	 */


	@Override
	public Visualitzacio loadVisualització(String id, String client, String serie, String numTemporada, String episodi, String data) {
		/* TODO: Creeu aqui la vostra subscripció
		 */
		Visualitzacio vis = new Visualitzacio(id, client, serie, numTemporada, episodi, data);
		this.visualitzacio=data;
		return vis;
	}



	public String getSerie() {
		return serie;
	}

	public String getTemporada() {
		return temporada;
	}

	public String getClient() {
		return client;
	}

	public String getAdmin() {
		return admin;
	}

	public String getEpisodi() {
		return episodi;
	}

	public String getValoracio() {
		return valoracio;
	}

	public String getProductora() {
		return productora;
	}

	public String getArtista() {
		return artista;
	}

	public String getSubscripcio() {
		return subscripcio;
	}

	public String getVisualitzacio() {
		return visualitzacio;
	}

}
