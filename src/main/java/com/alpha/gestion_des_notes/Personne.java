package com.alpha.gestion_des_notes;

import java.time.LocalDateTime;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private LocalDateTime dateNaissance;
    private String email;
    private String numeroTelephone;

    public Personne(int id, String numeroTelephone, String email, LocalDateTime dateNaissance, String prenom, String nom) {
        this.id = id;
        this.numeroTelephone = numeroTelephone;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.prenom = prenom;
        this.nom = nom;
    }
}
