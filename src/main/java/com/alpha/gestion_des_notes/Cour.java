package com.alpha.gestion_des_notes;

public class Cour {
    private int id;
    private String label;
    private int credit;
    private Enseignant enseignant;

    public Cour(int id, Enseignant enseignant, int credit, String label) {
        this.id = id;
        this.enseignant = enseignant;
        this.credit = credit;
        this.label = label;
    }

    public int getCredit() {
        return credit;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public String getLabel() {
        return label;
    }

    public int getId() {
        return id;
    }
}
