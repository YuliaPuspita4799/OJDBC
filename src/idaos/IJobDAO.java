/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Job;

/**
 *
 * @author hp
 */
public interface IJobDAO {
    
    public List<Job> getAll(); 
    //query like
    
    public Job getById(String id);
    
    public List<Job> search(String keyword);
    //return null jika gagal
    
    public Job insert(Job j);
    //return null jika gagal
    
    public Job update(Job j);
    
    public void delete(String id);
    
    
}
