/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jeudedame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe représentant un tour de jeu dans une partie de dames
 * Gère les déplacements, les captures et la validation des coups
 * @author jujus
 */
public class TourDeJeu {
    
    // Attributs
    private Joueur joueurActif;
    private Point2D positionDepart;
    private Point2D positionArrivee;
    private List<Point2D> capturesEffectuees;
    private boolean estCapture;
    private boolean estCaptureMultiple;
    private boolean transformationEnDame;
    private int numeroTour;
    
    /**
     * Constructeur par défaut
     */
    public TourDeJeu() {
        this.joueurActif = null;
        this.positionDepart = null;
        this.positionArrivee = null;
        this.capturesEffectuees = new ArrayList<>();
        this.estCapture = false;
        this.estCaptureMultiple = false;
        this.transformationEnDame = false;
        this.numeroTour = 0;
    }
    
    /**
     * Constructeur avec paramètres
     * @param joueurActif Le joueur qui effectue le tour
     * @param numeroTour Le numéro du tour
     */
    public TourDeJeu(Joueur joueurActif, int numeroTour) {
        this.joueurActif = joueurActif;
        this.positionDepart = null;
        this.positionArrivee = null;
        this.capturesEffectuees = new ArrayList<>();
        this.estCapture = false;
        this.estCaptureMultiple = false;
        this.transformationEnDame = false;
        this.numeroTour = numeroTour;
    }
    
    /**
     * Constructeur complet
     * @param joueurActif Le joueur qui effectue le tour
     * @param positionDepart La position de départ de la pièce
     * @param positionArrivee La position d'arrivée de la pièce
     * @param numeroTour Le numéro du tour
     */
    public TourDeJeu(Joueur joueurActif, Point2D positionDepart, Point2D positionArrivee, int numeroTour) {
        this.joueurActif = joueurActif;
        this.positionDepart = positionDepart;
        this.positionArrivee = positionArrivee;
        this.capturesEffectuees = new ArrayList<>();
        this.estCapture = false;
        this.estCaptureMultiple = false;
        this.transformationEnDame = false;
        this.numeroTour = numeroTour;
    }
    
    // Getters
    /**
     * Obtient le joueur actif
     * @return Le joueur qui joue ce tour
     */
    public Joueur getJoueurActif() {
        return joueurActif;
    }
    
    /**
     * Obtient la position de départ
     * @return La position de départ de la pièce
     */
    public Point2D getPositionDepart() {
        return positionDepart;
    }
    
    /**
     * Obtient la position d'arrivée
     * @return La position d'arrivée de la pièce
     */
    public Point2D getPositionArrivee() {
        return positionArrivee;
    }
    
    /**
     * Obtient la liste des captures effectuées
     * @return La liste des positions des pièces capturées
     */
    public List<Point2D> getCapturesEffectuees() {
        return capturesEffectuees;
    }
    
    /**
     * Vérifie si le coup est une capture
     * @return true si c'est une capture, false sinon
     */
    public boolean isEstCapture() {
        return estCapture;
    }
    
    /**
     * Vérifie si c'est une capture multiple
     * @return true si c'est une capture multiple, false sinon
     */
    public boolean isEstCaptureMultiple() {
        return estCaptureMultiple;
    }
    
    /**
     * Vérifie s'il y a eu transformation en dame
     * @return true si transformation en dame, false sinon
     */
    public boolean isTransformationEnDame() {
        return transformationEnDame;
    }
    
    /**
     * Obtient le numéro du tour
     * @return Le numéro du tour
     */
    public int getNumeroTour() {
        return numeroTour;
    }
    
    /**
     * Obtient le nombre de captures effectuées
     * @return Le nombre de pièces capturées
     */
    public int getNombreCaptures() {
        return capturesEffectuees.size();
    }
    
    // Setters
    /**
     * Définit le joueur actif
     * @param joueurActif Le joueur qui joue
     */
    public void setJoueurActif(Joueur joueurActif) {
        this.joueurActif = joueurActif;
    }
    
    /**
     * Définit la position de départ
     * @param positionDepart La position de départ
     */
    public void setPositionDepart(Point2D positionDepart) {
        this.positionDepart = positionDepart;
    }
    
    /**
     * Définit la position d'arrivée
     * @param positionArrivee La position d'arrivée
     */
    public void setPositionArrivee(Point2D positionArrivee) {
        this.positionArrivee = positionArrivee;
    }
    
    /**
     * Définit si le coup est une capture
     * @param estCapture true si c'est une capture
     */
    public void setEstCapture(boolean estCapture) {
        this.estCapture = estCapture;
    }
    
    /**
     * Définit si c'est une capture multiple
     * @param estCaptureMultiple true si c'est une capture multiple
     */
    public void setEstCaptureMultiple(boolean estCaptureMultiple) {
        this.estCaptureMultiple = estCaptureMultiple;
    }
    
    /**
     * Définit s'il y a transformation en dame
     * @param transformationEnDame true s'il y a transformation
     */
    public void setTransformationEnDame(boolean transformationEnDame) {
        this.transformationEnDame = transformationEnDame;
    }
    
    /**
     * Définit le numéro du tour
     * @param numeroTour Le numéro du tour
     */
    public void setNumeroTour(int numeroTour) {
        this.numeroTour = numeroTour;
    }
    
    // Méthodes métier
    /**
     * Enregistre un déplacement simple (sans capture)
     * @param depart Position de départ
     * @param arrivee Position d'arrivée
     */
    public void enregistrerDeplacement(Point2D depart, Point2D arrivee) {
        this.positionDepart = depart;
        this.positionArrivee = arrivee;
        this.estCapture = false;
        this.estCaptureMultiple = false;
    }
    
    /**
     * Enregistre une capture
     * @param depart Position de départ
     * @param arrivee Position d'arrivée
     * @param positionCapture Position de la pièce capturée
     */
    public void enregistrerCapture(Point2D depart, Point2D arrivee, Point2D positionCapture) {
        this.positionDepart = depart;
        this.positionArrivee = arrivee;
        this.capturesEffectuees.add(positionCapture);
        this.estCapture = true;
        this.estCaptureMultiple = capturesEffectuees.size() > 1;
    }
    
    /**
     * Ajoute une capture supplémentaire (pour les captures multiples)
     * @param positionCapture Position de la pièce capturée
     */
    public void ajouterCapture(Point2D positionCapture) {
        this.capturesEffectuees.add(positionCapture);
        this.estCapture = true;
        this.estCaptureMultiple = capturesEffectuees.size() > 1;
    }
    
    /**
     * Marque qu'une transformation en dame a eu lieu
     */
    public void marquerTransformationEnDame() {
        this.transformationEnDame = true;
    }
    
    /**
     * Vérifie si le tour est valide (a les informations minimales requises)
     * @return true si le tour est valide, false sinon
     */
    public boolean estValide() {
        return joueurActif != null && 
               positionDepart != null && 
               positionArrivee != null;
    }
    
    /**
     * Réinitialise le tour
     */
    public void reinitialiser() {
        this.positionDepart = null;
        this.positionArrivee = null;
        this.capturesEffectuees.clear();
        this.estCapture = false;
        this.estCaptureMultiple = false;
        this.transformationEnDame = false;
    }
    
    /**
     * Annule le tour (pour un système d'annulation)
     */
    public void annuler() {
        reinitialiser();
    }
    
    /**
     * Calcule la distance du déplacement
     * @return La distance entre la position de départ et d'arrivée
     */
    public double calculerDistanceDeplacement() {
        if (positionDepart == null || positionArrivee == null) {
            return 0.0;
        }
        int dx = Math.abs(positionArrivee.getX() - positionDepart.getX());
        int dy = Math.abs(positionArrivee.getY() - positionDepart.getY());
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    /**
     * Génère une description textuelle du mouvement
     * @return Une description du mouvement au format notation algébrique
     */
    public String genererNotation() {
        if (!estValide()) {
            return "Coup invalide";
        }
        
        StringBuilder notation = new StringBuilder();
        notation.append(positionDepart.toString());
        
        if (estCapture) {
            notation.append("x"); // x pour capture
        } else {
            notation.append("-"); // - pour déplacement simple
        }
        
        notation.append(positionArrivee.toString());
        
        if (estCaptureMultiple) {
            notation.append(" (x").append(capturesEffectuees.size()).append(")");
        }
        
        if (transformationEnDame) {
            notation.append("D"); // D pour Dame
        }
        
        return notation.toString();
    }
    
    /**
     * Retourne une représentation textuelle du tour
     * @return Une chaîne décrivant le tour
     */
    @Override
    public String toString() {
        return "Tour #" + numeroTour + 
               " - Joueur: " + (joueurActif != null ? joueurActif.getNom() : "inconnu") +
               " (" + (joueurActif != null ? joueurActif.getCouleur() : "?") + ")" +
               " | Coup: " + genererNotation() +
               (estCapture ? " | Captures: " + getNombreCaptures() : "") +
               (transformationEnDame ? " | Promotion en Dame" : "");
    }
    
    /**
     * Compare deux tours de jeu
     * @param obj L'objet à comparer
     * @return true si les tours sont identiques, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TourDeJeu tour = (TourDeJeu) obj;
        return numeroTour == tour.numeroTour &&
               joueurActif.equals(tour.joueurActif) &&
               positionDepart.equals(tour.positionDepart) &&
               positionArrivee.equals(tour.positionArrivee);
    }
    
    /**
     * Affiche la grille du jeu de dames
     * Note: Cette méthode sera idéalement déplacée dans la classe Partie.java
     * mais est placée ici temporairement pour permettre l'affichage pendant un tour
     * @param pions La liste des pions sur le plateau
     */
    private void afficherGrille(ArrayList<Pion> pions) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         GRILLE DE JEU DE DAMES        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║    A  B  C  D  E  F  G  H  I  J       ║");
        System.out.println("╟────────────────────────────────────────╢");
        
        for (int i = 0; i < 10; i++) {
            System.out.print("║ " + (i + 1));
            if (i < 9) System.out.print(" ");
            
            for (int j = 0; j < 10; j++) {
                System.out.print(" ");
                
                // Chercher s'il y a un pion à cette position
                Pion pionAPosition = trouverPionAPosition(pions, i, j);
                
                if (pionAPosition == null) {
                    // Case vide - alternance noir/blanc
                    if ((i + j) % 2 == 0) {
                        System.out.print("▢ "); // Case blanche
                    } else {
                        System.out.print("▪ "); // Case noire
                    }
                } else {
                    // Affichage de la pièce
                    System.out.print(pionAPosition.toString() + " ");
                }
            }
            System.out.println("   ║");
        }
        
        System.out.println("╚════════════════════════════════════════╝");
    }
    
    /**
     * Trouve un pion à une position donnée dans la liste
     * @param pions La liste des pions
     * @param x La coordonnée x (ligne)
     * @param y La coordonnée y (colonne)
     * @return Le pion à cette position ou null si aucun
     */
    private Pion trouverPionAPosition(ArrayList<Pion> pions, int x, int y) {
        for (Pion pion : pions) {
            if (pion.getPosition().getX() == x && pion.getPosition().getY() == y) {
               return pion;
            }
        }
        return null;
    }
    
    /**
     * Affiche le menu d'options pour le joueur
     */
    private void afficherMenuOptions() {
        System.out.println("\n┌─────────────── OPTIONS ───────────────┐");
        System.out.println("│ 1. Déplacer une pièce                 │");
        System.out.println("│ 2. Voir les coups possibles           │");
        System.out.println("│ 3. Abandonner la partie               │");
        System.out.println("│ 4. Sauvegarder et quitter             │");
        System.out.println("└───────────────────────────────────────┘");
    }
    
    /**
     * Lit et valide une position entrée par le joueur
     * Format attendu: lettre + chiffre (ex: A3, B5)
     * @param scanner Le scanner pour lire l'entrée
     * @param message Le message à afficher
     * @return La position saisie ou null si invalide
     */
    private Point2D lirePosition(Scanner scanner, String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim().toUpperCase();
        
        if (input.length() < 2 || input.length() > 3) {
            System.out.println("❌ Format invalide. Utilisez le format lettre+chiffre (ex: A3)");
            return null;
        }
        
        char colonne = input.charAt(0);
        String ligneStr = input.substring(1);
        
        // Validation de la colonne (A-J)
        if (colonne < 'A' || colonne > 'J') {
            System.out.println("❌ Colonne invalide. Utilisez A à J.");
            return null;
        }
        
        // Validation de la ligne (1-10)
        try {
            int ligne = Integer.parseInt(ligneStr);
            if (ligne < 1 || ligne > 10) {
                System.out.println("❌ Ligne invalide. Utilisez 1 à 10.");
                return null;
            }
            
            // Conversion en indices de tableau (0-9)
            int x = ligne - 1;
            int y = colonne - 'A';
            
            return new Point2D(x, y);
        } catch (NumberFormatException e) {
            System.out.println("❌ Numéro de ligne invalide.");
            return null;
        }
    }
    
    /**
     * Joue un tour de jeu complet avec interaction utilisateur
     * Cette méthode affiche la grille, propose des choix au joueur,
     * valide les entrées et exécute le coup
     * 
     * @param pions La liste des pions sur le plateau (géré par Partie.java)
     * @param scanner Le scanner pour lire les entrées utilisateur
     * @return true si le tour s'est bien déroulé, false si abandon/erreur
     */
    public boolean jouerTour(ArrayList<Pion> pions, Scanner scanner) {
        if (joueurActif == null) {
            System.out.println("❌ Erreur: Aucun joueur actif défini.");
            return false;
        }
        
        // Affichage de l'en-tête du tour
        System.out.println("\n" + "═".repeat(50));
        System.out.println("🎮 TOUR #" + numeroTour);
        System.out.println("═".repeat(50));
        System.out.println("👤 Joueur: " + joueurActif.getNom() + 
                         " (" + joueurActif.getCouleur() + ")");
        
        // Affichage de la grille
        afficherGrille(pions);
        
        // Menu d'options
        afficherMenuOptions();
        
        boolean tourTermine = false;
        while (!tourTermine) {
            System.out.print("\n➤ Choisissez une option (1-4): ");
            String choix = scanner.nextLine().trim();
            
            switch (choix) {
                case "1":
                    // Déplacer une pièce
                    tourTermine = effectuerDeplacement(pions, scanner);
                    break;
                    
                case "2":
                    // Afficher les coups possibles (à implémenter avec la logique du jeu)
                    System.out.println("\n📋 Coups possibles:");
                    System.out.println("   (Cette fonctionnalité sera implémentée avec la classe Partie)");
                    afficherGrille(pions);
                    break;
                    
                case "3":
                    // Abandonner
                    System.out.print("\n⚠️  Êtes-vous sûr de vouloir abandonner? (O/N): ");
                    String confirmation = scanner.nextLine().trim().toUpperCase();
                    if (confirmation.equals("O") || confirmation.equals("OUI")) {
                        System.out.println("🏳️  " + joueurActif.getNom() + " abandonne la partie.");
                        return false;
                    }
                    break;
                    
                case "4":
                    // Sauvegarder et quitter
                    System.out.println("💾 Sauvegarde de la partie...");
                    System.out.println("   (Fonctionnalité à implémenter avec Sauvegarde.java)");
                    return false;
                    
                default:
                    System.out.println("❌ Option invalide. Choisissez entre 1 et 4.");
            }
        }
        
        return true;
    }
    
    /**
     * Effectue le déplacement d'une pièce
     * @param pions La liste des pions sur le plateau
     * @param scanner Le scanner pour lire les entrées
     * @return true si le déplacement est effectué, false sinon
     */
    private boolean effectuerDeplacement(ArrayList<Pion> pions, Scanner scanner) {
        System.out.println("\n🎯 Déplacement d'une pièce");
        System.out.println("─".repeat(40));
        
        // Lecture de la position de départ
        Point2D depart = null;
        while (depart == null) {
            depart = lirePosition(scanner, "📍 Position de départ (ex: A3) ou 'A' pour annuler: ");
            if (depart == null) {
                System.out.print("   Réessayer ou taper 'A' pour annuler: ");
                String retry = scanner.nextLine().trim().toUpperCase();
                if (retry.equals("A")) {
                    return false;
                }
            } else {
                // Vérifier qu'il y a bien une pièce à cette position
                Pion pionDepart = trouverPionAPosition(pions, depart.getX(), depart.getY());
                if (pionDepart == null) {
                    System.out.println("❌ Aucune pièce à cette position.");
                    depart = null;
                }
                // TODO: Vérifier que la pièce appartient au joueur actif
            }
        }
        
        // Lecture de la position d'arrivée
        Point2D arrivee = null;
        while (arrivee == null) {
            arrivee = lirePosition(scanner, "📍 Position d'arrivée (ex: B4) ou 'A' pour annuler: ");
            if (arrivee == null) {
                System.out.print("   Réessayer ou taper 'A' pour annuler: ");
                String retry = scanner.nextLine().trim().toUpperCase();
                if (retry.equals("A")) {
                    return false;
                }
            } else {
                // Vérifier que la case d'arrivée est vide
                Pion pionArrivee = trouverPionAPosition(pions, arrivee.getX(), arrivee.getY());
                if (pionArrivee != null) {
                    System.out.println("❌ La case d'arrivée est occupée.");
                    arrivee = null;
                }
            }
        }
        
        // Enregistrement du déplacement
        this.positionDepart = depart;
        this.positionArrivee = arrivee;
        
        // TODO: Validation du coup avec les règles du jeu
        // TODO: Vérification des captures
        // TODO: Exécution du déplacement sur le plateau
        // TODO: Vérification de la transformation en dame
        
        System.out.println("\n✅ Déplacement enregistré: " + genererNotation());
        System.out.println("   Note: La validation et l'exécution seront gérées par Partie.java");
        
        return true;
    }
}
