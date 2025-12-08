/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JeuDeDame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nathan
 */
public class Pion {
    private int couleur;
    private int x;
    private int y;
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
        
        
    }
}
