/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author hp
 */
public class RegionController implements IRegionController {

    private IRegionDAO irdao;

    public RegionController(Connection connection) {
        irdao = new RegionDAO(connection);
    }

    @Override
    public List<Region> getAll() {
        return irdao.getAll();
    }

    @Override
    public Region getById(String id) {
        Region reg = new Region(0, "0");
        try{
            if(id.isEmpty()){
                System.out.println("No Input");
            } else {
                reg = irdao.getById(Integer.parseInt(id));
                System.out.println("id: " + reg.getId() + "," +
                                   "name: " + reg.getName());
            } 
        } catch (NumberFormatException nfe){
            System.out.println("Failed");
        } return reg;
    }
    

    @Override
    public List<Region> search(String keyword) {
        List<Region> region = new ArrayList<Region>();
        try {
        //data kosong
        if (keyword.isEmpty()) {
            System.out.println("Infailed entry");
        } else {
            region = irdao.search(keyword);
        }
        } catch (NullPointerException npe) {
            System.out.println("There is an error!!");
            npe.printStackTrace();
        }
        return region;
    }

    @Override
    public Region insert(String id, String name) {
        Region region = new Region(Integer.parseInt(id), name);
        try {
            if (name.isEmpty()) {
                System.out.println("There is an error!!");
            }  
            else if (name.length() < 3) {
                System.out.println("There is an error!!");
            } else {
                region = irdao.insert(region);
                System.out.println("Data Successfully entered");
            }
        } catch (NullPointerException npe) {
            System.out.println("There is an error!!");
            npe.printStackTrace();
        }
        return region;
    }

    @Override
    public Region update(String id, String name) {
        Region region = new Region(Integer.parseInt(id), name);
        try {
            if (name.isEmpty()) {
                System.out.println("Data cannot be empty!!");
            } 
            else if (name.length() < 3) {
                System.out.println("less name lenght");
            } else {
                region = irdao.update(region);
                System.out.println("Data successfully updated");
            }
        } catch (NullPointerException npe) {
            System.out.println("There is an error!!");
            npe.printStackTrace();
        }
        return region;
    }

    @Override
    public void delete(String id) {
        String result = "";
        try {
            if (id.isEmpty()){
                System.out.println("Data cannot be empty!!");
            } 
            else if (Integer.parseInt(id) != irdao.getById(Integer.parseInt(id)).getId()) {
                System.out.println("ID doesn't exist");
            }else {
                irdao.delete(Integer.parseInt(id));
                System.out.println("Data successfully deleted");
            }
        } catch (Exception e){
            e.getStackTrace();
            result = "Failed!!";
        }
    }
}