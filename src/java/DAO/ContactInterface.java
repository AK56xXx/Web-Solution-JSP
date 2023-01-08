/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Contact;
import java.util.List;

/**
 *
 * @author AK
 */
public interface ContactInterface {
    public void sendMessage(Contact contact);
    public List<Contact> getAll();
    public void delete(int id);
}


