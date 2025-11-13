package com.alpha.gestion_des_notes;

import java.time.LocalDateTime;

public class Tuteur extends Personne{
    private String description;
    public Tuteur(int id, String numeroTelephone, String email, LocalDateTime dateNaissance, String prenom, String nom) {
        super(id, numeroTelephone, email, dateNaissance, prenom, nom);
    }
    public String getDescription(){
        return description;
    }
}
