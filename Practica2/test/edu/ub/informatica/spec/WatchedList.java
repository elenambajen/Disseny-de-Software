package edu.ub.informatica.spec;

import controller.Controlador;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(ConcordionRunner.class)
public class WatchedList {
    private Controlador c;

    @BeforeExample
    public void init(){
        c = new Controlador();
    }

    @Test
    public String WatchedList(){

        if(c.watchedList().isEmpty()){
            return "La WatchedList està buida";
        }
        return "La WatchedList no està buida";
    }

}
