/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.User;
import java.util.List;

/**
 *
 * @author AK
 */
public interface UserInterface {
    public void addUser(User u);
    public boolean checkUser(String email);
    public User isLoginValid(String email,String password);
    public List<User> getAll();
    public void delete(int id);
    
    
}
