package com.alpha.gestion_des_notes;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class GestionNotes {

    private List<Note> notes;

    public GestionNotes(List<Note> notes) {
        this.notes = notes;
    }

    public double getExamGrade(Examen exam, Etudiant etudiant, Instant t) {
        return notes.stream()
                .filter(n -> n.getExamen().equals(exam) && n.getEtudiant().equals(etudiant))
                .findFirst()
                .map(n -> n.getValeur(t))
                .orElse(0.0);
    }

    public double getCourseGrade(Cours cours, Etudiant etudiant, Instant t) {
        List<Note> notesCours = notes.stream()
                .filter(n -> n.getExamen().getCours().equals(cours)
                        && n.getEtudiant().equals(etudiant))
                .collect(Collectors.toList());

        double totalCoef = notesCours.stream().mapToDouble(n -> n.getExamen().getCoefficient()).sum();
        double total = notesCours.stream()
                .mapToDouble(n -> n.getValeur(t) * n.getExamen().getCoefficient())
                .sum();

        return totalCoef == 0 ? 0 : total / totalCoef;
    }
}

