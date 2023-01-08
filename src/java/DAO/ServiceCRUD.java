/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class ServiceCRUD implements ServiceInterface{
 DbConnect c = new DbConnect();
    @Override
    public List<TypeService> getAllServices() {
 Connection con = c.getConn();
       String sql = "select * from `type_services`";
       PreparedStatement ps;
       List<TypeService> list =new ArrayList<TypeService>();
       try{
           ps = (PreparedStatement) con.prepareStatement(sql);
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               int id =rs.getInt("id");
               String nom = rs.getString("nom_service");
               list.add(new TypeService(id ,nom ));
            
             
               
           
           
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
       return list;
    }

    @Override
    public TypeService getServiceById(int id) {
       Connection con = c.getConn();
       String sql = "select * from `type_services` where id="+id;
       PreparedStatement ps;
       try{
           ps = (PreparedStatement) con.prepareStatement(sql);
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               int id_s =rs.getInt("id");
               String nom = rs.getString("nom_service");
               String image = rs.getString("image");
               String description = rs.getString("description");
               
               return new TypeService(id,nom,image,description );
            
             
               
           
           
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
       return null;
    }

    @Override
    public void delete(int id) {
        Connection con = c.getConn();
       String sql = "DELETE FROM `type_services` WHERE `id`= ? ;";
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

    @Override
    public void addService(TypeService s) {
          Connection con = c.getConn();
       String sql = "INSERT INTO `type_services`(`nom_service`, `image`, `description`)  values(?,?,?);";
       PreparedStatement ps;
       try{
           ps = (PreparedStatement) con.prepareStatement(sql);
           ps.setString(1, s.getNomServ());
           ps.setString(2, s.getDescription());
           ps.setString(3, s.getImage());
           ps.executeUpdate();
          
               con.close();
 
       }catch (SQLException e){
           e.printStackTrace();
       }
       System.out.println("serv");
    }

    @Override
    public void updateService(TypeService s) {

    Connection con = c.getConn();
       String sql = "UPDATE `type_services` SET `nom_service`= ? ,`image`= ? ,`description`= ? WHERE `id` = ?;";
       PreparedStatement ps;
       try{
           ps = (PreparedStatement) con.prepareStatement(sql);
           ps.setString(1, s.getNomServ());
           ps.setString(2, s.getImage());
           ps.setString(3, s.getDescription());
           ps.setInt(4, s.getId());

           ps.executeUpdate();
          
               con.close();
 
       }catch (SQLException e){
           e.printStackTrace();
       }
    }
    
}
