/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jeudedame;

import java.util.List;

/**
 *
 * @author Catherine
 */
public class Partie {
	private Joueur joueurBlanc;
	private Joueur joueurNoir;
	private List<Pion> plateau;
	private boolean tourJoueur;

	/**
	 * Constructeur d'une partie
	 * @param joueurBlanc Le joueur des pions blancs
	 * @param joueurNoir Le joueur des pions noirs
	 * @param plateau Une liste dse pions du jeu
	 * @param tourJoueur Sélection du prochain joueur à jouer (false pour blanc et true pour noir)
	 */
	public Partie(Joueur joueurBlanc, Joueur joueurNoir, List<Pion> plateau, boolean tourJoueur) {
		this.joueurBlanc = new Joueur(joueurBlanc);
		this.joueurNoir = new Joueur(joueurNoir);
		this.plateau = new List<Pion>(plateau);
		this.tourJoueur = tourJoueur;
	}

	/**
	 * Constructeur d'une partie
	 * @param joueurBlanc Le joueur des pions blancs
	 * @param joueurNoir Le joueur des pions noirs
	 * @param plateau Une liste dse pions du jeu
	 */
	public Partie(Joueur joueurBlanc, Joueur joueurNoir, List<Pion> plateau) {
		this.joueurBlanc = new Joueur(joueurBlanc);
		this.joueurNoir = new Joueur(joueurNoir);
		this.plateau = new List<Pion>(plateau);
		this.tourJoueur = false;
	}
	
	/**
	 * Constructeur de création d'une partie
	 * @param joueurBlanc Le joueur des pions blancs
	 * @param joueurNoir Le joueur des pions noirs
	 */
	public Partie(Joueur joueurBlanc, Joueur joueurNoir) {
		this.joueurBlanc = new Joueur(joueurBlanc);
		this.joueurNoir = new Joueur(joueurNoir);
		this.tourJoueur = false;
		
		this.plateau = new List<Pion>();
		
		// Placement des pions blancs
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				plateau.add(new Pion(0, i*2+((j+1)%2), j));
			}
		}
		
		// Placement des pions noirs
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				plateau.add(new Pion(0, i*2+((j+1)%2), j+6));
			}
		}
	}
	
	/**
	 * Constructeur de copie
	 * @param partie Une partie à copier
	 */
	public Partie(Partie partie) {
		this.joueurBlanc = new Joueur(partie.getJoueurA());
		this.joueurNoir = new Joueur(partie.getJoueurB());
		this.plateau = new List<Pion>(partie.getPlateau());
		this.tourJoueur = partie.isTourJoueur();
	}
	
	/**
	 *
	 * @return
	 */
	public Joueur getJoueurBlanc() {
		return joueurBlanc;
	}

	/**
	 *
	 * @param joueurBlanc
	 */
	public void setJoueurBlanc(Joueur joueurBlanc) {
		this.joueurBlanc = joueurBlanc;
	}

	/**
	 *
	 * @return
	 */
	public Joueur getJoueurNoir() {
		return joueurNoir;
	}

	/**
	 *
	 * @param joueurNoir
	 */
	public void setJoueurNoir(Joueur joueurNoir) {
		this.joueurNoir = joueurNoir;
	}

	/**
	 *
	 * @return
	 */
	public List<Pion> getPlateau() {
		return plateau;
	}

	/**
	 *
	 * @param plateau
	 */
	public void setPlateau(List<Pion> plateau) {
		this.plateau = plateau;
	}

	/**
	 *
	 * @return
	 */
	public boolean isTourJoueur() {
		return tourJoueur;
	}

	/**
	 *
	 * @param tourJoueur
	 */
	public void setTourJoueur(boolean tourJoueur) {
		this.tourJoueur = tourJoueur;
	}
	
	
	
	

	
	
	
	
	
}
