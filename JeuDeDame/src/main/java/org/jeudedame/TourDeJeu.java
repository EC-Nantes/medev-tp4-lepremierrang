/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jeudedame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe représentant un tour de jeu dans une partie de dames
 * Gère l'interaction avec le joueur pour effectuer son coup
 * @author jujus
 */
public class TourDeJeu {
    
    // Attributs
    private Joueur joueurActif;
    private Point2D positionDepart;
    private Point2D positionArrivee;
    private int numeroTour;
    
    /**
     * Constructeur par défaut
     */
    public TourDeJeu() {
        this.joueurActif = null;
        this.positionDepart = null;
        this.positionArrivee = null;
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
     * Obtient le numéro du tour
     * @return Le numéro du tour
     */
    public int getNumeroTour() {
        return numeroTour;
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
     * Définit le numéro du tour
     * @param numeroTour Le numéro du tour
     */
    public void setNumeroTour(int numeroTour) {
        this.numeroTour = numeroTour;
    }
    
    // Méthodes métier
    
    /**
     * Affiche la grille du jeu de dames
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
                        System.out.print("□ "); // Case blanche (non jouable)
                    } else {
                        System.out.print("■ "); // Case noire (jouable)
                    }
                } else {
                    // Affichage de la pièce selon sa couleur
                    if (pionAPosition.getCouleur() == 0) {
                        System.out.print("○ "); // Pion blanc
                    } else {
                        System.out.print("● "); // Pion noir
                    }
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
            Point2D pos = pion.getPosition();
            if (pos.getX() == x && pos.getY() == y) {
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
        System.out.println("│ 2. Abandonner la partie               │");
        System.out.println("│ 3. Sauvegarder et quitter             │");
        System.out.println("└───────────────────────────────────────┘");
    }
    
    /**
     * Lit et valide une position entrée par le joueur
     * Format attendu: lettre + chiffre (ex: A3, B5)
     * @param scanner Le scanner pour lire l'entrée
     * @param message Le message à afficher
     * @return La position saisie ou null si invalide/annulation
     */
    private Point2D lirePosition(Scanner scanner, String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim().toUpperCase();
        
        // Permettre l'annulation
        if (input.equals("A") || input.equals("ANNULER")) {
            return null;
        }
        
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
    }
    
    /**
     * Joue un tour de jeu complet avec interaction utilisateur
     * Cette méthode affiche la grille, propose des choix au joueur,
     * valide les entrées et enregistre le coup
     * 
     * @param pions La liste des pions sur le plateau
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
        System.out.println("👤 Joueur: " + joueurActif.getNom());
        
        // Affichage de la grille
        afficherGrille(pions);
        
        // Menu d'options
        afficherMenuOptions();
        
        boolean tourTermine = false;
        while (!tourTermine) {
            System.out.print("\n➤ Choisissez une option (1-3): ");
            String choix = scanner.nextLine().trim();
            
            switch (choix) {
                case "1":
                    // Déplacer une pièce
                    tourTermine = effectuerDeplacement(pions, scanner);
                    break;
                    
                case "2":
                    // Abandonner
                    System.out.print("\n⚠️  Êtes-vous sûr de vouloir abandonner? (O/N): ");
                    String confirmation = scanner.nextLine().trim().toUpperCase();
                    if (confirmation.equals("O") || confirmation.equals("OUI")) {
                        System.out.println("🏳️  " + joueurActif.getNom() + " abandonne la partie.");
                        return false;
                    }
                    break;
                    
                case "3":
                    // Sauvegarder et quitter
                    System.out.println("💾 Sauvegarde de la partie...");
                    System.out.println("   (Fonctionnalité à implémenter avec Sauvegarde.java)");
                    return false;
                    
                default:
                    System.out.println("❌ Option invalide. Choisissez entre 1 et 3.");
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
        Pion pionADeplacer = null;
        while (depart == null) {
            depart = lirePosition(scanner, "📍 Position de départ (ex: A3) ou 'A' pour annuler: ");
            if (depart == null) {
                System.out.println("⚠️  Annulation du déplacement.");
                return false;
            }
            
            // Vérifier qu'il y a bien une pièce à cette position
            pionADeplacer = trouverPionAPosition(pions, depart.getX(), depart.getY());
            if (pionADeplacer == null) {
                System.out.println("❌ Aucune pièce à cette position.");
                depart = null;
            } else {
                // Vérifier que la pièce appartient au joueur actif
                int couleurJoueur = joueurActif.getCouleur() ? 1 : 0;
                if (pionADeplacer.getCouleur() != couleurJoueur) {
                    System.out.println("❌ Cette pièce ne vous appartient pas.");
                    depart = null;
                    pionADeplacer = null;
                }
            }
        }
        
        // Lecture de la position d'arrivée
        Point2D arrivee = null;
        while (arrivee == null) {
            arrivee = lirePosition(scanner, "📍 Position d'arrivée (ex: B4) ou 'A' pour annuler: ");
            if (arrivee == null) {
                System.out.println("⚠️  Annulation du déplacement.");
                return false;
            }
            
            // Vérifier que la case d'arrivée est vide
            Pion pionArrivee = trouverPionAPosition(pions, arrivee.getX(), arrivee.getY());
            if (pionArrivee != null) {
                System.out.println("❌ La case d'arrivée est occupée.");
                arrivee = null;
            }
            
            // Vérifier que c'est une case noire (jouable)
            if (arrivee != null && (arrivee.getX() + arrivee.getY()) % 2 == 0) {
                System.out.println("❌ Les pions ne peuvent se déplacer que sur les cases noires.");
                arrivee = null;
            }
        }
        
        // Enregistrement du déplacement
        this.positionDepart = depart;
        this.positionArrivee = arrivee;
        
        // Tentative de déplacement du pion
        try {
            double distance = depart.distance(arrivee);
            
            // Si distance ≈ √2, c'est un déplacement simple
            if (Math.abs(distance - Math.sqrt(2)) < 0.1) {
                pionADeplacer.deplacer(arrivee);
                System.out.println("\n✅ Déplacement effectué: " + formatPosition(depart) + " → " + formatPosition(arrivee));
            }
            // Si distance ≈ 2√2, c'est potentiellement une capture
            else if (Math.abs(distance - 2 * Math.sqrt(2)) < 0.1) {
                pionADeplacer.capturer(arrivee);
                System.out.println("\n✅ Capture effectuée: " + formatPosition(depart) + " ✕ " + formatPosition(arrivee));
            }
            else {
                System.out.println("❌ Déplacement invalide: distance incorrecte.");
                return false;
            }
            
            return true;
            
        } catch (Exception e) {
            System.out.println("❌ Erreur lors du déplacement: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Formate une position pour l'affichage (ex: [2,3] → "C3")
     * @param pos La position à formater
     * @return La chaîne formatée
     */
    private String formatPosition(Point2D pos) {
        char colonne = (char) ('A' + pos.getY());
        int ligne = pos.getX() + 1;
        return "" + colonne + ligne;
    }
    
    /**
     * Retourne une représentation textuelle du tour
     * @return Une chaîne décrivant le tour
     */
    @Override
    public String toString() {
        String coup = "pas encore joué";
        if (positionDepart != null && positionArrivee != null) {
            coup = formatPosition(positionDepart) + " → " + formatPosition(positionArrivee);
        }
        return "Tour #" + numeroTour + 
               " - Joueur: " + (joueurActif != null ? joueurActif.getNom() : "inconnu") +
               " | Coup: " + coup;
    }
}
