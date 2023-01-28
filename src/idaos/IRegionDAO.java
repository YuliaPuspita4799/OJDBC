/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;
import java.util.List;
import models.Region;

/**
 *
 * @author hp
 */
public interface IRegionDAO {
    
    public List<Region> getAll(); 
    //query like
    
    public Region getById(int id);
    
    public List<Region> search(String keyword);
    //return null jika gagal
    
    public Region insert(Region region);
    //return null jika gagal
    
    public Region update(Region region);
    
    public void delete(int id);
    
    
}
