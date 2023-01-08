/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Contact;
import Models.TypeService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AK
 */
public class ContactCRUD implements ContactInterface{
DbConnect c = new DbConnect();

    @Override
    public void sendMessage(Contact contact) {
         Connection con = c.getConn();
       String sql = "insert into contact(email,nom , sujet , message) values(?,?,?,?);";
       PreparedStatement ps;
       try{
           ps = (PreparedStatement) con.prepareStatement(sql);
           ps.setString(1, contact.getEmail());
           ps.setString(2, contact.getNom());
           ps.setString(3, contact.getSujet());
           ps.setString(4,contact.getMessage());
           ps.executeUpdate();
          
               con.close();
 
       }catch (SQLException e){
           e.printStackTrace();
       }
    }

    @Override
    public List<Contact> getAll() {
       Connection con = c.getConn();
       String sql = "select * from `contact`";
       PreparedStatement ps;
       List<Contact> list =new ArrayList<Contact>();
       try{
           ps = (PreparedStatement) con.prepareStatement(sql);
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String  nom = rs.getString("nom");
                String sujet = rs.getString("sujet");
                String  message = rs.getString("message");
               
               list.add(new Contact(id,email,nom,sujet,message));
            
             
               
           
           
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
       return list;
    }

    @Override
    public void delete(int id) {
        Connection con = c.getConn();
       String sql = "DELETE FROM `contact` WHERE `id`= ? ;";
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
