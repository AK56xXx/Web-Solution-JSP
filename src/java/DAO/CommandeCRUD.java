/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Commande;
import Models.Contact;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AK
 */
public class CommandeCRUD implements CommandeInterface {
  DbConnect c = new DbConnect();
    @Override
    public void addCommande(Commande com , int[] tab) {
        Connection con = c.getConn();
        
        int id = 1;
        String max_id ="SELECT max(idc) as maximum from `commande`;";
        PreparedStatement ps_max;
       try{
           ps_max = (PreparedStatement) con.prepareStatement(max_id);
           ResultSet rs_max=ps_max.executeQuery();
           if(rs_max.next())
           {
            id=rs_max.getInt("maximum");
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
       id = id+1;
       String sql = "INSERT INTO `commande`( `idc`, `nom_c`, `details`, `cdc`, `datec`, `user_id` , `prix`) VALUES (?, ? , ? , ? , ? , ? , ?);";
       PreparedStatement ps;
       try{
           ps = (PreparedStatement) con.prepareStatement(sql);
           ps.setInt( 1 , id);
           ps.setString(2, com.getNom_c());
           ps.setString(3, com.getDetails());
           ps.setString(4, com.getCdc());
           ps.setString(5, com.getDate());
           ps.setInt(6, com.getUser_id());
           ps.setDouble(7, com.getPrix());

           
           ps.executeUpdate();
          
           for(int i=0 ; i<tab.length ; i++){
               if(tab[i] != 0){
               String sql2 = "INSERT INTO `option_commande`( `ido`, `idc`) VALUES (?,?);";
                PreparedStatement ps2;
                      try{
                          ps2 = (PreparedStatement) con.prepareStatement(sql2);
                          ps2.setInt(1, tab[i]);
                          ps2.setInt(2, id);
                          ps2.executeUpdate();
                          }catch (SQLException e){
                            e.printStackTrace();
                        }
           }
           } 
               con.close();
          
       }catch (SQLException e){
           e.printStackTrace();
       }
    }

    @Override
    public List<Commande> getAll() {
Connection con = c.getConn();
       String sql = "select * from `commande`";
       PreparedStatement ps;
       List<Commande> list =new ArrayList<Commande>();
       try{
           ps = (PreparedStatement) con.prepareStatement(sql);
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               
                int idc = rs.getInt("idc");
                String nom_c = rs.getString("nom_c");
                String  details = rs.getString("details");
                String cdc = rs.getString("cdc");
                String  datec = rs.getString("datec");
                int  user_id = rs.getInt("user_id");
                double  prix = rs.getDouble("prix");
               
               list.add(new Commande(idc , nom_c, details, cdc, datec, user_id, prix));
            
             
               
           
           
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
       return list;
    }

    @Override
    public void delete(int id) {
       Connection con = c.getConn();
       String sql = "DELETE FROM `commande` WHERE `idc`= ? ;";
       PreparedStatement ps;
       try{
           ps = (PreparedStatement) con.prepareStatement(sql);
           ps.setInt(1, id);
           
           ps.executeUpdate();
          
               con.close();
              
           
           
          
       }catch (SQLException e){
           e.printStackTrace();
       }
    }
    
    
}
