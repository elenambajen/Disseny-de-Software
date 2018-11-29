package model;

public class Registre {
    private Client client;
    private LlistaClients llistaClients;

    public Registre(Client client, LlistaClients llistaClients){
        this.llistaClients = llistaClients;
        this.client = client;
    }
    public boolean registre(){
        for (int i = 0; i < llistaClients.getLlistaClients().size(); i++){
            Client c = llistaClients.getClient(i);
            if (client.getUsuari().equals(c.getUsuari())) { return false; }
        }
        return true;
    }
}
