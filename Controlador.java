
package controlador;

import edu.ub.prog2.utils.*;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author Elena
 */
public class Controlador implements InControlador{
    private Dades dades;
    private final Reproductor player;
    private final EscoltadorReproduccio escoltador;
    
    /**
     * 
     */
    
    public Controlador(){
        dades = new Dades();
        escoltador = new EscoltadorReproduccio();
        player = new Reproductor(escoltador);
    }
    
    /**
     * 
     * @param path
     * @param nomVideo
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @throws AplicacioException 
     */
    
    @Override
    public void afegirVideo(String path, String nomVideo, String codec, 
                            float durada, int alcada, int amplada, float fps) 
                throws AplicacioException{
        dades.addVideo(path, nomVideo, codec,durada, alcada, amplada, fps, player);
    }
    
    /**
     * 
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param codec
     * @param durada
     * @param kbps
     * @throws AplicacioException 
     */
    
    @Override
    public void afegirAudio(String cami, String camiImatge, String nomAudio, 
                            String codec, float durada, int kbps) 
                throws AplicacioException{
        dades.addAudio(cami, camiImatge, nomAudio, codec, durada, kbps, player);
    }
    
    
    /**
     * 
     * @return 
     */
    
    @Override
    public List<String> mostrarBiblioteca(){
        // llista dels retorns de toString() dels fitxers
        try{
            return dades.mostrarBiblio();
        }catch(AplicacioException ex){
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @param id
     * @throws AplicacioException
     */
    
    @Override
    public void esborrarFitxer(int id) throws AplicacioException{
        // id és la posició a llista de getBiblioteca()
        dades.esborrarFitxer(id);
    }
    
    /**
     * 
     * @param camiDesti
     * @throws AplicacioException 
     */
    
    @Override
    public void guardarDadesDisc(String camiDesti) throws AplicacioException{
        File file = new File(camiDesti);
        dades.save(file);
    }
    
    /**
     *
     * @param camiOrigen
     * @throws AplicacioException
     */
    
    @Override
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException{
        File file = new File(camiOrigen);
        this.dades = dades.load(file);
        dades.setReproductor(player);
        setAleatori(dades.getAleatori());
        setCicle(dades.getCicle());
        
    }
    
    // LLIURAMENT 3
    
    /**
     * 
     * @param i
     * @throws AplicacioException 
     */
    
    @Override
    public void reproduirFitxer(int i) throws AplicacioException{
        if(i < 0 || i > dades.getBiblioteca().getSize()) throw new AplicacioException("Posicio no trobada");
        obrirFinestraReproductor();
        FitxerReproduible fitxRep = (FitxerReproduible) (dades.getBiblioteca().getAt(i));
        if(fitxRep instanceof Video) player.reprodueix((Video) fitxRep);
        else player.reprodueix((Audio) fitxRep, ((Audio) fitxRep).getImatge());
    }
    
    /**
     * 
     * @param titol
     * @param i
     * @throws AplicacioException 
     */
    
    public void reproduirFitxerAlbum(String titol, int i) throws AplicacioException{
        AlbumFitxersMultimedia album = dades.getAlbumEx(titol);
        if(i < 0 || i > album.getSize()) throw new AplicacioException("Posicio no trobada");
        obrirFinestraReproductor();
        FitxerReproduible fitxRep = (FitxerReproduible) (album.getAt(i));
        if(fitxRep instanceof Video) player.reprodueix((Video) fitxRep);
        else player.reprodueix((Audio) fitxRep, ((Audio) fitxRep).getImatge());
    }
    
    /**
     * 
     * @param string
     * @throws AplicacioException 
     */
    
    @Override
    public void afegirAlbum(String string) throws AplicacioException{
        dades.addAlbum(string);
    }
    
    /**
     * 
     * @param string
     * @param i
     * @throws AplicacioException 
     */
    
    public void afegirAlbum(String string, int i) throws AplicacioException{
        dades.addAlbum(string, i);
    }  
    
    /**
     * 
     * @return 
     */
    
    @Override
    public List<String> mostrarLlistatAlbums(){
        return dades.mostrarAlbums();
    }
    
    /**
     * 
     * @param string
     * @throws AplicacioException 
     */

    @Override
    public void esborrarAlbum(String string) throws AplicacioException{
        dades.borraAlbum(string);
    }
    
    /**
     * 
     * @param string
     * @return
     */

    @Override
    public boolean existeixAlbum(String string){
        return dades.existAlbum(string);
    }
    
    /**
     * 
     * @param string
     * @param i
     * @throws AplicacioException 
     */
    
    @Override
    public void afegirFitxer(String string, int i) throws AplicacioException{
        dades.addFitxer(string, i);
    }
    
    /**
     * 
     * @param string
     * @return
     * @throws AplicacioException 
     */

    @Override
    public List<String> mostrarAlbum(String string) throws AplicacioException{
        return dades.mostra(string);
    }
    
    /**
     * 
     * @param string
     * @param i
     * @throws AplicacioException 
     */

    @Override
    public void esborrarFitxer(String string, int i) throws AplicacioException{
        dades.esborrarFitxer(string, i);
    }
    
    /**
     * 
     */
    
    @Override
    public void obrirFinestraReproductor(){
        this.player.open();
    }
    
    /**
     * 
     * @throws AplicacioException 
     */

    @Override
    public void tancarFinestraReproductor() throws AplicacioException{
        this.player.open();
        this.player.close();
    }
    
    /**
     * 
     * @throws AplicacioException 
     */

    @Override
    public void reproduirCarpeta() throws AplicacioException{
        obrirFinestraReproductor();
        escoltador.iniciarReproduccio(dades.getBiblioteca());
    }
    
    /**
     * 
     * @param string
     * @throws AplicacioException 
     */
    
    @Override
    public void reproduirCarpeta(String string) throws AplicacioException{ 
        if(existeixAlbum(string)){
            obrirFinestraReproductor();
            escoltador.iniciarReproduccio(dades.getAlbum(string));
        }else throw new AplicacioException("Album no existeix");
    }
    
    /**
     * 
     * @throws AplicacioException 
     */

    @Override
    public void reemprenReproduccio() throws AplicacioException{
        try{
            obrirFinestraReproductor();
            player.resume();
        }catch(ClassCastException ex){
            aturaReproduccio();
        }
    }
    
    /**
     * 
     * @throws AplicacioException 
     */

    @Override
    public void pausaReproduccio() throws AplicacioException{
        obrirFinestraReproductor();
        try{
            player.pause();
        }catch(ClassCastException ex){
            aturaReproduccio();
        }
    }
    
    /**
     * 
     * @throws AplicacioException 
     */

    @Override
    public void aturaReproduccio() throws AplicacioException{
        try{
            obrirFinestraReproductor();
            player.stop();
            escoltador.setPos(-1);
            tancarFinestraReproductor();
        }catch(ClassCastException ex){
            escoltador.setPos(-1);
            tancarFinestraReproductor();
        }
    }
    
    /**
     * 
     * @throws AplicacioException 
     */

    @Override
    public void saltaReproduccio() throws AplicacioException{
        try{
            obrirFinestraReproductor();
            escoltador.onEndFile();
        }catch(NullPointerException ex){
            aturaReproduccio();
        }
    }
    
    /**
     * 
     * @param b 
     */
    
    public void setAleatori(boolean b){
        escoltador.reproduccioAleatoria = b;
        dades.setAleatori(b);
    }
    
    /**
     * 
     * @param b 
     */
    
    public void setCicle(boolean b){
        escoltador.reproduccioCiclica = b;
        dades.setCicle(b);
    }
    
    /**
     * 
     * @return  
     */
    
    public boolean getAleatori(){
        return dades.getAleatori();
    }
    
    /**
     * 
     * @return  
     */
    
    public boolean getCilce(){
        return dades.getCicle();
    }
    
    /**
     * 
     * @return 
     */
    
    public boolean carpetaBuida(){
        return dades.getBiblioteca().isEmpty();       
    }
    
    /**
     * 
     * @return 
     */
    
    public boolean reproduint(){
        return escoltador.reproduint();       
    }
    
}