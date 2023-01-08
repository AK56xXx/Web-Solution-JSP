/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.TypeService;
import java.util.List;

/**
 *
 * @author AK
 */
//nourhene.coding@gmail.com
public interface ServiceInterface {
    public List<TypeService> getAllServices();
    public TypeService getServiceById(int id);
    public void delete(int id);
    public void addService(TypeService s);
    public void updateService( TypeService s);
}
