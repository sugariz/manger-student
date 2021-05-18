/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;


import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.scoreDTO;
import javaapplication3.mySQLConnect;


/**
 *
 * @author azu
 */
public class inputScoreDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public inputScoreDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<scoreDTO> getListInfoStudent(String maGV) {
        ArrayList<scoreDTO> listDiem = new ArrayList<scoreDTO>();
        String query = "SELECT diem.MA_CHI_TIET_DIEM, diem.MAHS, diem.MANAMHOC, diem.MAHOCKY, diem.MALOP, diem.MALOAI, diem.MAMON, diem.DIEM " +
                        "FROM diem, monhoc, giaovienbomon " +
                        "WHERE diem.MAMON = monhoc.MAMONHOC AND monhoc.MAMONHOC = giaovienbomon.MAMONHOC AND giaovienbomon.MAGV = '" + maGV +"'";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                scoreDTO diem = new scoreDTO(
                    results.getInt(1),
                    results.getString(2),
                    results.getString(3),
                    results.getString(4),
                    results.getString(5),
                    results.getString(6),
                    results.getString(7),
                    results.getFloat(8)
                );
                listDiem.add(diem);
            }
        }
        catch(Exception e) {
            System.err.println(e);
        }
        
        return listDiem;
    }
    
    public void insertScore(String query) {
        try {
            connect.executeUpdate(query);
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
    
    public void updateScore(String query) {
        try {
            connect.executeUpdate(query);
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
    
    public void deleteScore(String query) {
        try {
            connect.executeUpdate(query);
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
    
    public void setDiem() {
        String query = "INSERT INTO HOCSINH VALUES ()";
    }
    
}
