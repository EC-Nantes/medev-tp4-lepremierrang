/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JeuDeDame;

/**
 *
 * @author nathan
 */
public class Erreur extends Exception{
    private final String texte;
    public Erreur(String texte){
        this.texte=texte;
    }
}
