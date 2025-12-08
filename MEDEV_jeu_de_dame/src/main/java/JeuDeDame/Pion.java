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

    /**
     *liste des couleur (correspondance numéro-texte)
     */
    public final static List<String> couleurs =List.of("blanc","noir");
  
    public Pion(String couleur){
        
        if (couleur=="noir"){
            this.couleur=1;
        }
        else if(couleur=="blanc"){
            this.couleur=0;
        }
    }
}
