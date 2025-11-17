package com.alpha.gestion_des_notes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tuteur extends Personne {
    private String relation;

    public Tuteur(int id, String nom, String prenom, LocalDate dateNaissance, String email, String telephone, String relation) {
        super(id, nom, prenom, dateNaissance.atStartOfDay(), email, telephone);
        this.relation = relation;
    }

    public String getRelation() { return relation; }

    @Override
    public String toString() {
        return super.toString() + " - Relation: " + relation;
    }
}
