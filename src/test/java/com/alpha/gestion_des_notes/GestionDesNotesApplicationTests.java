package com.alpha.gestion_des_notes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionDesNotesApplicationTests {

    private Enseignant enseignant;
    private Tuteur tuteur;
    private Etudiant etudiant;
    private Cours cours;
    private Examen examen;
    private Promotion promotion;

    @BeforeEach
    void setUp() {

        enseignant = new Enseignant(
                1,
                "0123456789",
                "prof.dupont@ecole.com",
                LocalDateTime.of(1980, 5, 15, 0, 0),
                "Jean",
                "Dupont",
                "Informatique"
        );

        // Création d'un tuteur
        tuteur = new Tuteur(
                2,
                "Martin",
                "Pierre",
                LocalDate.of(1975, 3, 20),
                "p.martin@email.com",
                "0987654321",
                "Père"
        );

        etudiant = new Etudiant(
                3,
                "0654321987",
                "etudiant.martin@ecole.com",
                LocalDateTime.of(2000, 8, 10, 0, 0),
                "Luc",
                "Martin",
                "Groupe A",
                tuteur
        );

        cours = new Cours(
                1,
                enseignant,
                3,
                "Programmation Java"
        );


        examen = new Examen(
                1,
                "Examen Final Java",
                cours,
                LocalDateTime.of(2024, 6, 15, 9, 0),
                2
        );


        promotion = new Promotion();
        promotion.ajouterGroupe("Groupe A");
        promotion.ajouterGroupe("Groupe B");
    }

    @Test
    void testCreationPersonne() {
        assertEquals(1, enseignant.getId());
        assertEquals("Jean", enseignant.getPrenom());
        assertEquals("Dupont", enseignant.getNom());
        assertEquals("prof.dupont@ecole.com", enseignant.getEmail());
        assertEquals("0123456789", enseignant.getNumeroTelephone());
    }

    @Test
    void testCreationEnseignant() {
        assertEquals("Informatique", enseignant.getSpecialite());
    }

    @Test
    void testCreationTuteur() {
        assertEquals("Martin", tuteur.getNom());
        assertEquals("Pierre", tuteur.getPrenom());
        assertEquals("Père", tuteur.getRelation());
        assertEquals("p.martin@email.com", tuteur.getEmail());
    }

    @Test
    void testCreationEtudiant() {
        assertEquals("Groupe A", etudiant.getGroupe());
        assertEquals(tuteur, etudiant.getTuteur());
        assertEquals("Luc", etudiant.getPrenom());
        assertEquals("Martin", etudiant.getNom());
    }

    @Test
    void testCreationCours() {
        assertEquals("Programmation Java", cours.getLabel());
        assertEquals(3, cours.getCredit());
        assertEquals(enseignant, cours.getEnseignant());
        assertEquals(1, cours.getId());
    }

    @Test
    void testCreationExamen() {
        assertEquals("Examen Final Java", examen.getTitre());
        assertEquals(2, examen.getCoefficient());
        assertEquals(cours, examen.getCours());
        assertEquals(LocalDateTime.of(2024, 6, 15, 9, 0), examen.getDateExamen());
    }

    @Test
    void testCreationNote() {
        List<HistoriqueNote> historique = new ArrayList<>();
        Note note = new Note(historique, 15.5, etudiant, examen, "Note initiale");

        assertEquals(15.5, note.getValeur(Instant.now()));
        assertEquals(etudiant, note.getEtudiant());
        assertEquals(examen, note.getExamen());
    }

    @Test
    void testModificationNote() {
        List<HistoriqueNote> historique = new ArrayList<>();
        Note note = new Note(historique, 15.5, etudiant, examen, "Note initiale");

        double valeurInitiale = note.getValeur(Instant.now());
        note.modifierNote(16.0, "Réévaluation");

        assertNotEquals(valeurInitiale, note.getValeur(Instant.now()));
        assertEquals(16.0, note.getValeur(Instant.now()));
    }

    @Test
    void testHistoriqueNote() {
        List<HistoriqueNote> historique = new ArrayList<>();
        Note note = new Note(historique, 15.5, etudiant, examen, "Note initiale");

        Instant avantModification = Instant.now();


        note.modifierNote(16.0, "Réévaluation");


        assertEquals(15.5, note.getValeur(avantModification));
        assertEquals(16.0, note.getValeur(Instant.now()));
    }

    @Test
    void testPromotion() {
        promotion.ajouterGroupe("Groupe C");

    }

    @Test
    void testRelationEtudiantTuteur() {
        assertEquals(tuteur, etudiant.getTuteur());
        assertEquals("Père", etudiant.getTuteur().getRelation());
    }

    @Test
    void testCoursEnseignant() {
        assertEquals(enseignant, cours.getEnseignant());
        assertEquals("Informatique", cours.getEnseignant().getSpecialite());
    }

    @Test
    void testExamenCours() {
        assertEquals(cours, examen.getCours());
        assertEquals("Programmation Java", examen.getCours().getLabel());
    }

    @Test
    void testNoteEtudiantExamen() {
        List<HistoriqueNote> historique = new ArrayList<>();
        Note note = new Note(historique, 14.0, etudiant, examen, "Test");

        assertEquals(etudiant, note.getEtudiant());
        assertEquals(examen, note.getExamen());
        assertEquals("Groupe A", note.getEtudiant().getGroupe());
        assertEquals("Examen Final Java", note.getExamen().getTitre());
    }

    @Test
    void testValeursLimitesNotes() {
        List<HistoriqueNote> historique = new ArrayList<>();

        Note noteMin = new Note(historique, 0.0, etudiant, examen, "Note minimale");
        assertEquals(0.0, noteMin.getValeur(Instant.now()));


        Note noteMax = new Note(historique, 20.0, etudiant, examen, "Note maximale");
        assertEquals(20.0, noteMax.getValeur(Instant.now()));


        noteMin.modifierNote(10.5, "Rattrapage");
        assertEquals(10.5, noteMin.getValeur(Instant.now()));
    }

    @Test
    void testIntegrationComplete() {

        List<HistoriqueNote> historique = new ArrayList<>();
        Note note = new Note(historique, 12.5, etudiant, examen, "Première notation");

        assertEquals(12.5, note.getValeur(Instant.now()));
        assertEquals("Luc", note.getEtudiant().getPrenom());
        assertEquals("Martin", note.getEtudiant().getNom());
        assertEquals("Groupe A", note.getEtudiant().getGroupe());
        assertEquals("Père", note.getEtudiant().getTuteur().getRelation());
        assertEquals("Examen Final Java", note.getExamen().getTitre());
        assertEquals("Programmation Java", note.getExamen().getCours().getLabel());
        assertEquals("Jean", note.getExamen().getCours().getEnseignant().getPrenom());
    }
}