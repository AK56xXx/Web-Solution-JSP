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
public class TypeService {
    private int id;
    private String nomServ;
    private String image;
    private String description;

    public TypeService() {
    }

    public TypeService(int id, String nomServ) {
        this.id = id;
        this.nomServ = nomServ;
    }

    public TypeService(int id, String nomServ, String image, String description) {
        this.id = id;
        this.nomServ = nomServ;
        this.image = image;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomServ() {
        return nomServ;
    }

    public void setNomServ(String nomServ) {
        this.nomServ = nomServ;
    }
    
    
    
    
    
    
    
}
