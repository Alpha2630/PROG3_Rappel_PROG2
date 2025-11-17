package com.alpha.gestion_des_notes;

import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private String nom;
    private List<String> groupes;


    public Promotion() {
        this.nom = nom;
        this.groupes = new ArrayList<>();
    }

    public void ajouterGroupe(String groupe) {
        groupes.add(groupe);
    }

    public List<String> getGroupes() {
        return new ArrayList<>(groupes); // Retourne une copie pour l'immutabilité
    }

    public String getNom() { return nom; }
}
