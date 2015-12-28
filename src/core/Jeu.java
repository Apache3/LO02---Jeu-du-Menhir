/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import affich.console.Console;
import affich.Affichage;
import affich.gui.*;
import MenhirExceptions.WrongNumberException;
import java.util.InputMismatchException;

public class Jeu {
    
    private ChoixFinPartie choixFinPartie;
    private Console console;
    private Partie part;
    private boolean continuer;
    
    public Jeu(){
        console = Console.getInstance();
        continuer = false;
        choixFinPartie = ChoixFinPartie.NOUVELLE_PARTIE;
    }
    
    /**
     *  Gère le démarrage d'une partie en mode console ou en mode graphique.
     */
    public void lancer(){
        while(choixFinPartie!=ChoixFinPartie.QUITTER){
            if(choixFinPartie==ChoixFinPartie.NOUVELLE_PARTIE){
                initJeu();
            }
                
            part.lancerPartie();
            choixFinPartie =console.displayChoixFinPartie();

        }
    }
    
    private void initJeu(){
        int nbJoueurs = 0;
        int nbJH = 1;
        nbJoueurs = console.getNbJoueurs();
        if(console.getTypePartie(nbJH, nbJoueurs))
            part = new PartieAvancee(nbJH,nbJoueurs-nbJH);
        else
            part = new PartieRapide(nbJH,nbJoueurs-nbJH);
    }
}
