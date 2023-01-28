/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import models.Region;

/**
 *
 * @author hp
 */
public class RegionDAO implements IRegionDAO {
    
    private Connection connection;
    // DAO = Data Access Object
    public RegionDAO (Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Region> getAll() {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT  * FROM HR.REGIONS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement (query);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            while (resultSet.next()) {
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listRegion;
    }
    
    @Override
    public Region insert(Region region) {
        Region r = region;
        String query = "INSERT INTO HR.REGIONS(region_id, region_name) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getId());
            preparedStatement.setString(2, r.getName());
//            System.out.println(preparedStatement);
            preparedStatement.executeQuery();
//            System.out.println("t");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("f");
            return null;
        }
        return r;
    }
   
//    public Region insert(Region region) {
//        //boolean result = false;
//        String query = "INSERT INTO HR.REGIONS(REGION_ID, REGION_NAME) VALUES (?,?)";
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, region.getId());
//            ps.setString(2, region.getName());
//            ps.executeQuery();
//
//            //result = true ;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return region;
//    }
    
   
    @Override
    public Region getById(int id) {
        Region r = new Region();
        String query = "SELECT * FROM HR.REGIONS WHERE REGION_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
       return r;

    }

    @Override
    public List<Region> search(String keyword) {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS WHERE REGION_NAME LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+keyword+"%"); 
            
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                Region r = new Region();
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e) {
            //System.out.println("Data Not Found");
            e.getStackTrace();
        }
        return listRegion;
    
        
//         List<Region> listRegion = new ArrayList<Region>();
//        String query = "SELECT * FROM HR.REGIONS WHERE REGION_NAME = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, key);
//
//            ResultSet resultSet = ps.executeQuery();
//            if (resultSet.next()) {
//                Region r = new Region();
//                r.setId(resultSet.getInt(1));
//                r.setName(resultSet.getString(2));
//                listRegion.add(r);
//            }
//        } catch (Exception e) {
////            System.out.println("Error");
//            e.getStackTrace();
//        }
//        return listRegion;
    }

    @Override
   public Region update(Region region) {
        String query = "UPDATE HR.REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, region.getName());
            ps.setInt(2, region.getId());
            ps.executeQuery();
//           return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            //return null;
        }
        return region;
    }
    

    @Override
    public void delete(int id) {
        String query = "DELETE FROM HR.REGIONS WHERE REGION_ID = ?  ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
//            System.out.println("The procedure succesfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Error");
//            System.out.println("See the details below");
            
        }
        
    }
}