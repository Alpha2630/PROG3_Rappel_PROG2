package com.alpha.gestion_des_notes;

import java.time.Instant;

public class HistoriqueNote {
    private Instant date;
    private double valeur;
    private String motif;

    public HistoriqueNote(Instant date, double valeur, String motif) {
        this.date = date;
        this.valeur = valeur;
        this.motif = motif;
    }

    public Instant getDate() { return date; }
    public double getValeur() { return valeur; }
    public String getMotif() { return motif; }
}
