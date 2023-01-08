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
public class Option {
    
    private int id_op;
    private int id_serv;
    private String nom;
    private double prix;
    private int obligation;

    public Option() {
    }

    public Option(int id_op, int id_serv, String nom, double prix, int obligation) {
        this.id_op = id_op;
        this.id_serv = id_serv;
        this.nom = nom;
        this.prix = prix;
        this.obligation = obligation;
    }

    public int getId_op() {
        return id_op;
    }

    public void setId_op(int id_op) {
        this.id_op = id_op;
    }

    public int getId_serv() {
        return id_serv;
    }

    public void setId_serv(int id_serv) {
        this.id_serv = id_serv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getObligation() {
        return obligation;
    }

    public void setObligation(int obligation) {
        this.obligation = obligation;
    }
    
    
    
    
    
    
    
}
