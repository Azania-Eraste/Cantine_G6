package controllers;

import dao.ClientDAO;
import models.Client;

public class ClientController {
    private ClientDAO clientDAO;

    public ClientController() {
        this.clientDAO = new ClientDAO();
    }

    // Créer un nouveau client
    public void createClient(String nom, String prenom, String numero, String email, String identifiant) {
        int id = 0;
        Client client = new Client(id, nom, prenom, numero, email, identifiant);
        clientDAO.addClient(client);
    }

    // Lire un client par ID
    public Client getClientById(int id) {
        return clientDAO.getClientById(id);
    }

    // Mettre à jour les informations du client
    public void updateClient(int id, String nom, String prenom, String numero, String email, String identifiant) {
        Client client = new Client(id, nom, prenom, numero, email, identifiant);
        clientDAO.updateClient(client);
    }

    // Supprimer un client
    public void deleteClient(int id) {
        clientDAO.deleteClient(id);
    }
}
