/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affich.gui;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.io.*;
import java.net.MalformedURLException;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import core.*;
/**
 *
 * @author Apache
 */
public class MBouton extends JButton implements MouseListener{
    private static String location="src/sons/";
    private File file;
    private final TypeAction action;
    private CarteIngredient carte; 
    
    public MBouton(TypeAction action){
        this("",action);
    }
    
    public MBouton(String str, TypeAction action){
        super(str);
        this.action=action;
        //choixJoueur.setAction(action);
        file = new File(location+action.getUrl());
        this.addMouseListener(this);
    }
    
    public synchronized void playSound() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                    clip.open(inputStream);
                    clip.start(); 
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
    public CarteIngredient getCarte(){
        return carte;
    }
    public TypeAction getTypeAction(){
        return action;
    }
    public void setCarte(CarteIngredient carte){
        this.carte = carte;
    }
    
   
    @Override
    public void mouseExited(MouseEvent event){}
    @Override
    public void mouseEntered(MouseEvent event){
    }
    @Override
    public void mouseReleased(MouseEvent event){}
    @Override
    public void mousePressed(MouseEvent event){
        playSound();
        System.out.println("Sound played");
    }
    @Override
    public void mouseClicked(MouseEvent event){
       
    }
}
