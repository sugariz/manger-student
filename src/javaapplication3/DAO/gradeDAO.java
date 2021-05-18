/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.gradeDTO;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class gradeDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public gradeDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<gradeDTO> getGrade() {
        ArrayList<gradeDTO> listGrade = new ArrayList<gradeDTO>();
        String query = "SELECT * FROM khoilop";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                gradeDTO grade = new gradeDTO(
                    results.getString(1),
                    results.getString(2)
                );
                listGrade.add(grade);
            }
        }
        catch(Exception e) {
            System.err.println(e);
        }
        
        return listGrade;
    }
    
}
