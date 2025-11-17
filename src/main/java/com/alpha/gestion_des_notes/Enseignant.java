package com.alpha.gestion_des_notes;

import java.time.LocalDateTime;

public class Enseignant extends Personne{
    private String specialite;

    public Enseignant(int id, String numeroTelephone, String email, LocalDateTime dateNaissance, String prenom, String nom, String specialite) {
        super(id, numeroTelephone, email, dateNaissance, prenom, nom);
        this.specialite = specialite;
    }
    public String getSpecialite() { return specialite; }

}
