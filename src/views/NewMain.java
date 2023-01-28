/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CountryController;
import controllers.RegionController;
import java.util.List;
import java.util.Scanner;
import models.Country;
import models.Region;
import tools.DBConnection;

/**
 *
 * @author hp
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnection connection = new DBConnection();
        RegionController rcon = new RegionController(connection.getConnection());
        CountryController ccon = new CountryController(connection.getConnection());
        
        int pilihan = 0;
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        
        
        
        do{ System.out.println("====== Menu ======");
            System.out.println("1. GetAll Region");
            System.out.println("2. Insert Region");
            System.out.println("3. Update Region");
            System.out.println("4. Search Region");
            System.out.println("5. GetById Region");
            System.out.println("6. Delete Region");
            System.out.println("7. GetAll Country");
            System.out.println("8. Insert Country");
            System.out.println("9. Update Country");
            System.out.println("10. Search Country");
            System.out.println("11. GetById Cuntry");
            System.out.println("12. Delete Country");
            System.out.println("13. Exit");
            System.out.println("====================");
            System.out.print("Enter Your Choice : ");
            pilihan = input.nextInt(); 
            
    switch(pilihan){
        case 1: 
            List<Region> reg = rcon.getAll();
            for (Region regs :reg) {
              regs.display();
      }
            System.out.println("====================");
            break;
        
             
        case 2:
            System.out.print("Input Id Region : ");
            String id = input1.nextLine();
            System.out.print("Input Nama Region : ");
            String name = input1.nextLine();
            
            rcon.insert(id, name);
            System.out.println("====================");
            break;
            
            
        case 3:
            System.out.print("Input id Region: ");
            String idu = input1.nextLine();
            System.out.print("Input Name Region: ");
            String nmu = input1.nextLine();
            
            rcon.update(idu, nmu);
            System.out.println("====================");
            break;
            
        case 4:
            System.out.print("Input Name Region : ");
            String nms = input1.nextLine();
            List<Region> regs = rcon.search(nms);
            for (Region re : regs){
                re.display();
            }
            
            rcon.search(nms);
            System.out.println("====================");
            break;
        
        case 5:
            System.out.print("Input Id Region : ");
            String idi = input1.nextLine();
            Region coba = rcon.getById(idi);
            coba.display();
            System.out.println("====================");
            break;
           
        case 6: 
            System.out.print("Input Id Region : ");
            String idd = input1.nextLine();
            
            rcon.delete(idd);
            System.out.println("====================");
            break;
            
        case 7: 
            List<Country> coun = ccon.getAll();
            for (Country  couns : coun){
                couns.display();
            }
            System.out.println("====================");
            break;    
            
        case 8:
            System.out.print("Input Id Country : ");
            String idc = input1.nextLine();
            System.out.print("Input Nama Country : ");
            String nmc = input1.nextLine();
            System.out.print("Input Id Region : ");
            int idrc = input.nextInt();
            
            ccon.insert(idc, nmc, idrc);
            System.out.println("====================");
            break;
            
            
        case 9:
            System.out.print("Input Id Country : ");
            String idcu = input1.nextLine();
            System.out.print("Input Nama Country : ");
            String nmcu = input1.nextLine();
            System.out.print("Input Id Region : ");
            int idrcu = input.nextInt();
            
            ccon.update(idcu, nmcu, idrcu);
            System.out.println("====================");
            break;
            
        case 10:
            System.out.print("Input Name Country : ");
            String nmsu = input1.nextLine();
            List<Country> coun10 = ccon.search(nmsu); 
            for (Country cou : coun10){
                cou.display();
            }
            System.out.println("====================");
            break;
        
        case 11:
            System.out.print("Input Id Country : ");
            String idic = input1.nextLine();
            
            Country dis = ccon.getById(idic);
            dis.display();
            System.out.println("====================");
            break;
            
        case 12:
            System.out.print("Input Id Country : ");
            String iddc = input1.nextLine();
            
            ccon.delete(iddc);
            System.out.println("====================");
            break;    
    
        case 13:
            System.exit(0);
            break;
    }
    }while(pilihan!=0);
      
    }
   
    
}

    
    

