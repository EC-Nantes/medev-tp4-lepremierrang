/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jeudedame;

import java.util.Objects;

/**
 * Classe représentant un joueur de la partie de jeu de dame
 * @author jujus
 */
public class Joueur {
    
    // Attributs
    private String nom;
    private Boolean couleur; // Noir = true/1 et Blanc = false/0
    
    /**
     * Constructeur par défaut
     */
    public Joueur() {
        this.nom = "";
        this.couleur = true; //Noir
    }
    
    /**
     * Constructeur avec paramètres
     * @param nom Le nom du joueur
     * @param couleur La couleur des pièces du joueur (True = Noir)
     * @throws IllegalArgumentException si la couleur n'est pas "BLANC" ou "NOIR"
     */
    public Joueur(String nom, Boolean couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }
    
    /**
     * Constructeur de copie
     * @param autre Le joueur à copier
     */
    public Joueur(Joueur autre) {
        this.nom = autre.nom;
        this.couleur = autre.couleur;
    }
    
    // Getters
    /**
     * Obtient le nom du joueur
     * @return Le nom du joueur
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Obtient la couleur du joueur
     * @return La couleur du joueur
     */
    public Boolean getCouleur() {
        return couleur;
    }
    
    // Setters
    /**
     * Définit le nom du joueur
     * @param nom Le nouveau nom
     */
    /**
     * Définit la couleur du joueur
     * @param couleur La nouvelle couleur
     */
    public void setCouleur(Boolean couleur) {
        this.couleur = couleur;
    }
    
    
    // Méthodes métier
    
    /**
     * Retourne une représentation textuelle du joueur
     * @return Une chaîne décrivant le joueur
     */
    @Override
    public String toString() {
        String couleurString = "Blanc";
        if (couleur) couleurString = "Noir";
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", couleur = '" + couleurString + '\'' +
                '}';
    }
    
    /**
     * Vérifie l'égalité entre deux joueurs
     * @param obj L'objet à comparer
     * @return true si les joueurs sont égaux, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Joueur joueur = (Joueur) obj;
        return nom.equals(joueur.nom) && couleur.equals(joueur.couleur);
    }

    /**
     * HashCode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nom);
        hash = 47 * hash + Objects.hashCode(this.couleur);
        return hash;
    }
}
