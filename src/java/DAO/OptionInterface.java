/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Option;
import java.util.List;

/**
 *
 * @author AK
 */
public interface OptionInterface {
    
    List<Option> getOptionsByService(int id);
    
}
