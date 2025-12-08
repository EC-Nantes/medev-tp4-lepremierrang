/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jeudedame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nathan
 */
public class Pion {
    private int couleur;
    private Point2D position;
    /**
     *liste des couleur (correspondance numéro-texte)
     */
    public final static List<String> couleurs =List.of("blanc","noir");
  
    public Pion(String couleur, int x, int y) throws Exception{
        if (null == couleur){
            Exception Erreur = new Erreur("La couleur de création du Pion n'est pas correcte");
            throw Erreur;
        }
        else switch (couleur) {
            case "noir":
                this.couleur=1;
                break;
            case "blanc":
                this.couleur=0;
                break;
            default:
                Exception Erreur = new Erreur("La couleur de création du Pion n'est pas correcte");
                throw Erreur;
        }
        position=new Point2D(x,y);
    }
    public Pion(int couleur, int x, int y) throws Exception{
        this.couleur=couleur;
        position=new Point2D(x,y);
    }
    
    
    public void deplacer(Point2D cible) throws Exception{
        if (estLibre(cible)){
            this.position=cible;
        }
        else {
            Exception probleme=new Erreur("la case est inatteignable");
            throw probleme;
        }
    }
    public boolean estLibre(Point2D test){
        return true;
    }
    
    
    public void capturer(Point2D cible) throws Exception{
        boolean possible=false;
        for (Point2D test : pionMangeable()){
            if (test.equals(cible)){
                int x=this.position.getX()+2*(this.position.getX()-cible.getX());
                int y=this.position.getY()+2*(this.position.getY()-cible.getY());
                Point2D positionArrivee=new Point2D(x,y);
                if (estLibre(positionArrivee)){
                    possible=true;
                    this.position=positionArrivee;
                }
                else{
                    Exception probleme=new Erreur("la case est inatteignable");
                    throw probleme;
                }
            }
        }
        if (!possible){
            Exception probleme2=new Erreur("il n'est pas possible de manger le pion à l'endroit indiqué");
            throw probleme2;
        }
        
    }
    public List<Point2D> pionMangeable(){
        return null;
    }
    
    public void devenirDame(){
        
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
    
    
}
