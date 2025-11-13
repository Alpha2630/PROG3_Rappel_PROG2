package com.alpha.gestion_des_notes;
import java.util.List;
import java.util.ArrayList;
import java.time.Instant;

public class Note {
    private Examen examen;
    private Etudiant etudiant;
    private double valeur;
    private List<HistoriqueNote> historique;

    public Note(List<HistoriqueNote> historique, double valeurInitial, Etudiant etudiant, Examen examen, String motifInitial) {
        this.historique = new ArrayList<>();
        this.valeur = valeurInitial;
        this.etudiant = etudiant;
        this.examen = examen;
        historique.add(new HistoriqueNote(Instant.now(), valeurInitial, motifInitial));
    }
    public void modifierNote(double nouvelleValeur, String motif){
        this.valeur = nouvelleValeur;
        historique.add(new HistoriqueNote(Instant.now(), nouvelleValeur, motif));
    }
    public double getValeur(Instant t) {
        return historique.stream()
                .filter(h -> !h.getDate().isAfter(t))
                .reduce((first, second) -> second)
                .map(HistoriqueNote::getValeur)
                .orElse(valeur);
    }

    public Etudiant getEtudiant() { return etudiant; }
    public Examen getExamen() { return examen; }
}
