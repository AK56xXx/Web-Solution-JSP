/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author AK
 */
public class Contact {
    
    private int id;
    private String email;
    private String  nom;
    private String sujet;
    private String  message;

    public Contact() {
    }

    public Contact(String email, String nom, String sujet, String message) {
        this.email = email;
        this.nom = nom;
        this.sujet = sujet;
        this.message = message;
    }

    public Contact(int id, String email, String nom, String sujet, String message) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.sujet = sujet;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
