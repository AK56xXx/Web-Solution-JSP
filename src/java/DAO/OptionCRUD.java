/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Option;
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
public class OptionCRUD implements OptionInterface {

    @Override
    public List<Option> getOptionsByService(int id) {
        DbConnect c = new DbConnect();
        Connection con = c.getConn();
       String sql = "select * from `options` where id_serv="+id;
       PreparedStatement ps;
       List<Option> list =new ArrayList<Option>();
       try{
           ps = (PreparedStatement) con.prepareStatement(sql);
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               int id_op =rs.getInt("id_op");
               int id_serv =rs.getInt("id_serv");
               String nom = rs.getString("nom");
               double prix =rs.getDouble("prix");
               int obligation =rs.getInt("obligation");
               list.add(new Option(id_op ,id_serv,nom,prix,obligation ));
            
             
               
           
           
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
       return list;
    }
    
}
