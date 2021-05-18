/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.coefficientDTO;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class coefficientDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public coefficientDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<coefficientDTO> getCoefficient() {
        ArrayList<coefficientDTO> coefficientList = new ArrayList<coefficientDTO>();
        String query = "SELECT * FROM loaidiem";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                
            }
        }
        catch(Exception e) {
            System.err.println("ERROR");
        }
        
        return coefficientList;
    }
    
}
