package edu.ub.informatica.spec;

import controller.Controlador;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(ConcordionRunner.class)
public class WatchNext {
    private Controlador c;

    @BeforeExample
    public void init(){
        c = new Controlador();
    }

    @Test
    public String watchNext(){
        if(c.watchNext().isEmpty()){
            return "Watch Next està buida";
        }
        return "Watch Next no està buida";
    }
}
