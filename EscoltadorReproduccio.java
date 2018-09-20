
package controlador;

import edu.ub.prog2.utils.EscoltadorReproduccioBasic;
import model.*;

/**
 *
 * @author mariel
 */
public class EscoltadorReproduccio extends EscoltadorReproduccioBasic{
    
    private CarpetaFitxers llistaReproduint;
    private boolean[] llistaCtrl;
    public boolean reproduccioCiclica, reproduccioAleatoria;
    private int pos = -1;
    private Reproductor player;
    
    /**
     * 
     */
    
    public EscoltadorReproduccio(){
        this.llistaReproduint = null;
        this.reproduccioAleatoria = false;
        this.reproduccioCiclica = true;
        this.llistaCtrl = null;
    }
    
    /**
     * 
     * @param llistaReproduint 
     */
    
    public void iniciarReproduccio(CarpetaFitxers llistaReproduint){ 
        this.llistaReproduint = llistaReproduint;
        this.llistaCtrl = new boolean[llistaReproduint.getSize()];
        
        next();
    }
    
    /**
     * 
     */
    
    @Override
    protected void onEndFile(){
        if(hasNext()) next();
        else{
            player.stop();
            llistaCtrl = null;
            llistaReproduint = null;
        }
    }
    
    /**
     * 
     */
    
    @Override
    protected void next(){
        if(llistaCtrlPlena()) buidaLlistaCtrl();
        
        if(reproduccioAleatoria){
            pos = (int) Math.round(Math.random()*(llistaCtrl.length - 1));
            while(llistaCtrl[pos]){
                pos++;
                pos = (pos + llistaCtrl.length) % llistaCtrl.length;
            }
        }else pos++;
        
        if(reproduccioCiclica) pos = (pos + llistaCtrl.length) % llistaCtrl.length;
        
        try{
            llistaCtrl[pos] = true;
            ((FitxerReproduible) this.llistaReproduint.getAt(pos)).reproduir();
        }catch(NullPointerException ex){
            onEndFile();
        }
    }
    
    /**
     * 
     * @return 
     */

    @Override
    protected boolean hasNext(){
        if(reproduccioCiclica) return true;
        else{
            if(!reproduccioAleatoria) return !(llistaCtrl[llistaCtrl.length - 1]);
            else{
                for(int i = 0; i < llistaCtrl.length; i++){
                    if(!llistaCtrl[i]) return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 
     * @return 
     */
    
    public boolean getAleatori(){
        return this.reproduccioAleatoria;
    }
    
    /**
     * 
     * @return 
     */
    
    public boolean getCicle(){
        return this.reproduccioCiclica;
    }
    
    /**
     * 
     * @param pos 
     */
    
    public void setPos(int pos){
        this.pos = pos;
    }
    
    /**
     * 
     * @return 
     */
    
    public boolean llistaCtrlPlena(){
        for(int i = 0; i < llistaCtrl.length; i++){
            if((!llistaCtrl[i])) return false;
        }
        return true;
    }
    
    /**
     * 
     */
    
    public void buidaLlistaCtrl(){
        llistaCtrl = new boolean[this.llistaCtrl.length];
    }
    
    /**
     * 
     * @return 
     */
    
    public boolean reproduint(){
        return llistaReproduint != null;       
    } 
    
}
