package com.alpha.gestion_des_notes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Etudiant extends Personne {

    private String groupe;
    private Tuteur tuteur;


    public Etudiant(int id, String numeroTelephone, String email, LocalDateTime dateNaissance, String prenom, String nom, String groupe, Tuteur tuteur) {
        super(id, numeroTelephone, email, dateNaissance, prenom, nom);
        this.groupe = groupe;
        this.tuteur = tuteur;
    }

    public String getGroupe() {
        return groupe;
    }

    public Tuteur getTuteur() {
        return tuteur;
    }
}
