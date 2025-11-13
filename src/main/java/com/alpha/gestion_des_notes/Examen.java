package com.alpha.gestion_des_notes;

import java.time.LocalDateTime;

public class Examen {
    private int id;
    private String titre;
    private Cours cour;
    private LocalDateTime dateExamen;
    private int coefficient;

    public Examen(int id, String titre, Cours cour, LocalDateTime dateExamen, int coefficient) {
        this.id = id;
        this.titre = titre;
        this.cour = cour;
        this.dateExamen = dateExamen;
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public LocalDateTime getDateExamen() {
        return dateExamen;
    }

    public Cours getCours() {
        return cour;
    }

    public String getTitre() {
        return titre;
    }

    public int getId() {
        return id;
    }
}
