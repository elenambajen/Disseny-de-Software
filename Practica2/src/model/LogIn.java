package model;

public class LogIn {
    private Client client;
    private String usuari, contrassenya;
    private LlistaClients llistaClients;

    public LogIn(String usuari, String contrassenya, LlistaClients llistaClients){
        this.usuari = usuari;
        this.contrassenya = contrassenya;
        this.llistaClients = llistaClients;
    }

    public boolean entrar(){
        for (int i = 0; i < llistaClients.getLlistaClients().size(); i++){
            Client c = llistaClients.getClient(i);
            if (usuari.equals(c.getUsuari()) && contrassenya.equals(c.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public Client getClient() {
        return client;
    }

    public String getUsuari(){
        return this.client.getUsuari();
    }

    public String getPassword(){
        return this.client.getPassword();
    }
}
