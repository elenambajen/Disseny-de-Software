package model;

import java.util.ArrayList;

public class LlistaClients {
    private ArrayList<Client> llistaClients;

    public LlistaClients(){
        this.llistaClients = new ArrayList<>();
    }

    public void addClient(Client client){
        this.llistaClients.add(client);
    }

    public ArrayList<Client> getLlistaClients(){
        return this.llistaClients;
    }

    public Client getClient(int i){
        return this.llistaClients.get(i);
    }
}
