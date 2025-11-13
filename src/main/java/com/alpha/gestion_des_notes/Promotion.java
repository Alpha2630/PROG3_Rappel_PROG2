package com.alpha.gestion_des_notes;

import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private String nom;
    private List<String> groupes;

    public void Promotion(String nom){
        this.nom = nom;
        this.groupes = new ArrayList<>();
    }
    public void ajouterGroupe(String groupe){
        groupes.add(groupe);
    }
}
