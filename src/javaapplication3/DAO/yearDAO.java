/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.yearDTO;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class yearDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public yearDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<yearDTO> getListYear() {
        ArrayList<yearDTO> listYear = new ArrayList<yearDTO>();
        String query = "SELECT * FROM namhoc";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                yearDTO year = new yearDTO(
                    results.getString(1),
                    results.getString(2)
                );
                
                listYear.add(year);
            }
        }
        catch(Exception e) {
            System.err.println(e);
        }
        
        return listYear;
    }
    
}
