/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.giaoVienBoMonDTO;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class giaoVienBoMonDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public giaoVienBoMonDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<giaoVienBoMonDTO> getThongTinGiaoVien(String maGv) {
        ArrayList<giaoVienBoMonDTO> listGiaoVienBoMon = new ArrayList<giaoVienBoMonDTO>();
        String query = "SELECT GVBM.MAGV, LOP.MALOP, GVBM.MAMONHOC, LOP.MANAMHOC, LOP.MAKHOILOP " +
        "FROM thoikhoabieu AS TKB, giaovienbomon AS GVBM, lop as LOP, monhoc AS MH " +
        "WHERE TKB.MAGIAOVIENBOMON = GVBM.MAGIAOVIENBOMON AND TKB.MALOP = LOP.MALOP AND MH.MAMONHOC = GVBM.MAMONHOC AND GVBM.MAGV = '" + maGv + "'";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                giaoVienBoMonDTO giaovienbomon = new giaoVienBoMonDTO(
                    results.getString(1),
                    results.getString(3),
                    results.getString(2),
                    results.getString(4),
                    results.getString(5)
                );
                listGiaoVienBoMon.add(giaovienbomon);
            }
        }
        catch(Exception e) {
            System.err.println(e);
        }
        
        return listGiaoVienBoMon;
    }
    
}
