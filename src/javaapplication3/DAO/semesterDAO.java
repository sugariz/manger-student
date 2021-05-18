/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.semesterDTO;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class semesterDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public semesterDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<semesterDTO> getListSemester() {
        ArrayList<semesterDTO> listSemester = new ArrayList<semesterDTO>();
        String query = "SELECT * FROM hocky";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                semesterDTO semester = new semesterDTO(
                    results.getString(1),
                    results.getString(2)
                );
                listSemester.add(semester);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        return listSemester;
    }
    
}
