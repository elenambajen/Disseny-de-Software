package edu.ub.informatica.spec;

import controller.Controlador;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(ConcordionRunner.class)
public class Login {
    private Controlador c;

    @BeforeExample
    public void init(){
        c = new Controlador();
    }

    @Test
    public String login(String nom, String password){
        if(c.login(nom, password) == true){
            return "Nom d'usuari i contrassenya correctes";
        }
        return "Nom d'usuari o contrassenya incorrecta";
    }
}
