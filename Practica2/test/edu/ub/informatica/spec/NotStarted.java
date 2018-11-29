package edu.ub.informatica.spec;

import controller.Controlador;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(ConcordionRunner.class)
public class NotStarted {
    private Controlador c;

    @BeforeExample
    public void init(){
        c = new Controlador();
    }

    @Test
    public String notStarted(){
        if(c.notStarted().isEmpty()){
            return "Not Started Yet està buida";
        }
        return "Not Started Yet no estàbuida";
    }
}
