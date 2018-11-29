package edu.ub.informatica.spec;

import controller.Controlador;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class Registre {
    private Controlador c;

    @BeforeExample
    public void init(){
        c = new Controlador();
    }

    @Test
    public String registrar(String id, String nom, String dni, String adreca, String usuari, String password){
        if(c.registre(id, nom, dni, adreca, usuari, password) == true){
            return "Un nou client afegit";
        }
        return "Aquest nom d'usuari ja existeix";
    }
}
