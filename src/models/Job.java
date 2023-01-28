/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hp
 */
public class Job {
    private String id;
    private String name;
    private int min;
    private int max;
    
    public Job(){
    }
    
    public Job(String id, String name, int min, int max){
        this.id = id;
        this.name = name;
        this.min = min;
        this.max = max;
        
    }

    
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    public int getMin(){
        return min;
    }
    
    public int getMax(){
        return max;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setMin(int min){
        this.min = min;
    }
    
    public void setMax(int max){
        this.max = max;
    }
    
    public void display(){
       System.out.println("Id: "+ id +" Name: "+name+" Minimal: "+min+" Maximal: "+min);
   }
    
}
