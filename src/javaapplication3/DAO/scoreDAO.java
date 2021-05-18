/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;
import javaapplication3.mySQLConnect;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import javaapplication3.DTO.scoreDTO;

/**
 *
 * @author azu
 */
public class scoreDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public scoreDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<scoreDTO> getScoreListOfStudent(String maHS) {
//        String query = 
//            "SELECT RS.MAHS, RS.TENMONHOC, " +
//                "(CASE WHEN RS.MALOAI ='MIENG' THEN RS.DIEM ELSE NULL END) AS 'MIENG', " +
//                "(CASE WHEN RS.MALOAI ='15PHUT'THEN RS.DIEM ELSE NULL END) AS '15 PHUT', " +
//                "(CASE WHEN RS.MALOAI ='1TIET'THEN RS.DIEM ELSE NULL END) AS '1 TIET', " +
//                "(CASE WHEN RS.MALOAI ='HOCKY'THEN RS.DIEM ELSE NULL END) AS 'HOCKY' " +
//            "FROM (SELECT DIEM.MAHS, DIEM.MALOAI, DIEM.DIEM, MONHOC.TENMONHOC " +
//                "FROM `DIEM`, `LOAIDIEM`, `MONHOC` " +
//                "WHERE DIEM.MALOAI = LOAIDIEM.MALOAI AND DIEM.MAMON = MONHOC.MAMONHOC) AS RS ";
        
//        String query1 = "SELECT MONHOC.TENMONHOC, DIEM.DIEM, DIEM.MALOAI, LOAIDIEM.HESO, DIEM.MAHOCKY, DIEM.MANAMHOC, DIEM.MALOP " +
//                        "FROM DIEM, MONHOC, LOAIDIEM " +
//                        "WHERE DIEM.MAHS='" + maHS + "' AND DIEM.MAMON = MONHOC.MAMONHOC AND DIEM.MALOAI = LOAIDIEM.MALOAI";
        String query2 = "SELECT diem.MA_CHI_TIET_DIEM, diem.MAHS, diem.MANAMHOC, diem.MAHOCKY, diem.MALOP, diem.MALOAI, diem.MAMON, diem.DIEM FROM diem WHERE MAHS='" + maHS + "'";
        ArrayList<scoreDTO> scoreList = new ArrayList<scoreDTO>();
        
        try {
//            int idScore, String idStudent, String idYears, String idSemester, String idClass, String idScoreType, String idSubject, float score
            results = connect.executeQuery(query2);
            while(results.next()) {
                scoreDTO score = new scoreDTO(
                    results.getInt(1),
                    results.getString(2),
                    results.getString(3),
                    results.getString(4),
                    results.getString(5),
                    results.getString(6),
                    results.getString(7),
                    results.getFloat(8)
                );
                scoreList.add(score);
            }
            
        }
        catch(Exception e) {
            System.err.println(e);
        }
    
        return scoreList;
    }
    
    public static void main(String[] args) {
        new scoreDAO();
    }
}
