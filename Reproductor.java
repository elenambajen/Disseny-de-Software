
package controlador;

import edu.ub.prog2.utils.*;
import java.io.File;
import model.*;

/**
 *
 * @author Elena
 */
public class Reproductor extends ReproductorBasic{
    
    /**
     * 
     * @param escoltador 
     */
    
    public Reproductor(EscoltadorReproduccio escoltador){
        super(escoltador);
    }
    
    /**
     * 
     * @param fr
     * @throws AplicacioException 
     */
    
    public void reprodueix(FitxerReproduible fr) throws AplicacioException{
        fr.reproduir();
    }
    
    /**
     * 
     * @param audio
     * @param fitxerImatge
     * @throws AplicacioException 
     */
    
    public void reprodueix(Audio audio, File fitxerImatge) throws AplicacioException{
        audio.setImatge(fitxerImatge);
        audio.reproduir();
    }
    
}
