/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IJobDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Job;

/**
 *
 * @author hp
 */
public class JobDAO implements IJobDAO{
    private Connection connection;
    // DAO = Data Access Object
    public JobDAO (Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Job> getAll() {
        List<Job> listRegion = new ArrayList<Job>();
        String query = "SELECT  * FROM HR.JOBS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement (query);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            while (resultSet.next()) {
                Job j = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                j.setId(resultSet.getString(1));
                j.setName(resultSet.getString(2));
                j.setMin(resultSet.getInt(3));
                j.setMax(resultSet.getInt(4));
                listRegion.add(j);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listRegion;
    }

    @Override
    public Job getById(String id) {
        Job j = new Job();
        String query = "SELECT * FROM HR.JOBS WHERE JOB_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                
                j.setId(resultSet.getString(1));
                j.setName(resultSet.getString(2));
                j.setMin(resultSet.getInt(3));
                j.setMax(resultSet.getInt(4));
                
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
       return j;
    }

    @Override
    public List<Job> search(String keyword) {
        List<Job> listJob = new ArrayList<Job>();
        String query = "SELECT * FROM HR.JOBS WHERE JOB_TITLE LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+keyword+"%"); 
            
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                Job j = new Job();
                j.setId(resultSet.getString(1));
                j.setName(resultSet.getString(2));
                j.setMin(resultSet.getInt(3));
                j.setMax(resultSet.getInt(4));
                listJob.add(j);
            }
        } catch (Exception e) {
            //System.out.println("Data Not Found");
            e.getStackTrace();
        }
        return listJob;
    }

    @Override
    public Job insert(Job j) {
        String query = "INSERT INTO HR.JOBS(job_id, job_title, min_salary, max_salary) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getId());
            preparedStatement.setString(2, j.getName());
            preparedStatement.setInt(3, j.getMin());
            preparedStatement.setInt(4, j.getMax());
//            System.out.println(preparedStatement);
            preparedStatement.executeQuery();
//            System.out.println("t");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("f");
            return null;
        }
        return j;
    }

    @Override
    public Job update(Job j) {
        String query = "UPDATE HR.JOBS SET JOB = ? WHERE COUNTRY_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, j.getName());
            ps.setInt(2, j.getMin());
            ps.setInt(3, j.getMax());
            ps.setString(4, j.getId());
            ps.executeQuery();
//           return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            //return null;
        }
        return j;
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM HR.JOBS WHERE JOB_ID = ?  ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeQuery();
//            System.out.println("The procedure succesfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Error");
//            System.out.println("See the details below");
            
        }
    }
    
}
