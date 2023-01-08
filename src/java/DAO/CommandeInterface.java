/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Commande;
import java.util.List;

/**
 *
 * @author AK
 */
public interface CommandeInterface {
    
    public void addCommande(Commande com , int[] tab);
    public List<Commande> getAll();
    public void delete(int id);
    
}
