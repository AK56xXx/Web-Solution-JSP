/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;


/**
 *
 * @author AK
 */
public class Commande {
    private int idc;
    private String nom_c;
    private String details;
    private String cdc;
    private String date;
    private int user_id;
    private double prix;

    public Commande(int idc, String nom_c, String details, String cdc, String date, int user_id, double prix) {
        this.idc = idc;
        this.nom_c = nom_c;
        this.details = details;
        this.cdc = cdc;
        this.date = date;
        this.user_id = user_id;
        this.prix = prix;
    }
    
    
    
    
    
    
    
    public Commande(String nom_c, String details, String cdc, String date, int user_id, double prix) {
        this.nom_c = nom_c;
        this.details = details;
        this.cdc = cdc;
        this.date = date;
        this.user_id = user_id;
        this.prix=prix;
    }

    public Commande() {
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getNom_c() {
        return nom_c;
    }

    public void setNom_c(String nom_c) {
        this.nom_c = nom_c;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCdc() {
        return cdc;
    }

    public void setCdc(String cdc) {
        this.cdc = cdc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
    
    
    
}
