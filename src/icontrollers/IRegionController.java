/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author hp
 */
public interface IRegionController {
     public List<Region> getAll(); 
    //query like
    
    public Region getById(String id);
    
    public List<Region> search(String keyword);
    //return null jika gagal
    
    public Region insert(String id, String name);
    //return null jika gagal
    
    public Region update(String id, String name);
    
    public void delete(String id);
}
