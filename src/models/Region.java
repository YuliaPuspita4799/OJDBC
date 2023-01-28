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
public class Region {
    private int id;
    private String name;
    
    public Region(){
    }
    
    public Region(int id, String name){
        this.id = id;
        this.name = name;
    }

    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    
    
    //menggunakan method to string untuk menampilkan object berbentuk string 
    //jika tidak menggunakan string maka akan muncul hashcode value nya
    //spt models.Region@123453bf
    
    
    
    public void display(){
       System.out.println("Id: "+ id +" Name: "+name);
   }
    
    
//    public String toString() {
//        return "id =" + id + "\t " + ", name =" + name; 
//    }
//    
}
