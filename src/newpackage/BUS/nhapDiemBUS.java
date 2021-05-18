/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.BUS;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javaapplication3.DAO.infoClassDAO;
import javaapplication3.DAO.inputScoreDAO;
import javaapplication3.DTO.infoClassDTO;
import javaapplication3.DTO.diemDTO;
import javaapplication3.DTO.scoreDTO;

/**
 *
 * @author azu
 */
public class nhapDiemBUS {
    
    public static ArrayList<scoreDTO> listScore = null;
    private String maGv;
    
    public nhapDiemBUS(String maGv) {
        this.maGv = maGv;
    }
    
    public ArrayList<infoClassDTO> getScore(String idSubject, String idSemester, String idClass, String idYear) {
        this.build(maGv);
        ArrayList<infoClassDTO> listThongTinDiem = new infoClassDAO().getClassList();
        List<infoClassDTO> tmpClassList = listThongTinDiem.stream()
                .filter(obj -> obj.getClassId().equals(idClass))
                .collect(Collectors.toList());
        ArrayList<infoClassDTO> classList = new ArrayList<infoClassDTO>(tmpClassList);
        listScore.forEach(cnsmr -> {
            if(cnsmr.getIdSubject().equals(idSubject)
                && cnsmr.getIdSemester().equals(idSemester)
                && cnsmr.getIdClass().equals(idClass)
                && cnsmr.getIdYears().equals(idYear)) {
                
                infoClassDTO infoDiem = classList.stream()
                        .filter(obj -> obj.getIdStudent().equals(cnsmr.getIdStudent()))
                        .findFirst().get();

                switch (cnsmr.getIdScoreType()) {
                    case "MIENG":
                        infoDiem.addDiemMieng(cnsmr);
                        break;
                    case "15PHUT":
                        infoDiem.addDiem15Phut(cnsmr);
                        break;
                    case "1TIET":
                        infoDiem.addDiem1Tiet(cnsmr);
                        break;
                    case "HOCKY":
                        infoDiem.setScoreHocKy(cnsmr);
                }
            }
        });
        
        return classList;
    }
    
    public void updateScore(diemDTO diem) {
        
    }
    
    public void insertScore(scoreDTO score) {
        String query = "INSERT INTO diem (`MAHS`, `MAMON`, `MAHOCKY`, `MALOAI`, `MALOP`, `MANAMHOC`, `DIEM`) " +
        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %f); ";
        
        query = String.format(query, score.getIdStudent(), score.getIdSubject(), score.getIdSemester(), score.getIdScoreType(), score.getIdClass(), score.getIdYears(), score.getScore());
        System.err.println(query);
        new inputScoreDAO().insertScore(query);
        listScore = new inputScoreDAO().getListInfoStudent(this.maGv);
    }
    
    public void updateScore(scoreDTO score) {
        String query = "UPDATE diem " +
        "SET DIEM = %f " +
        "WHERE MA_CHI_TIET_DIEM = %d ";
        query = String.format(query, score.getScore(), score.getIdScore());
        new inputScoreDAO().updateScore(query);
        listScore = new inputScoreDAO().getListInfoStudent(this.maGv);
    }
    
    public void deleteScore(scoreDTO score) {
        String query = "DELETE FROM diem " +
        "WHERE MA_CHI_TIET_DIEM = %d ";
        
        query = String.format(query, score.getIdScore());
        new inputScoreDAO().deleteScore(query);
        listScore = new inputScoreDAO().getListInfoStudent(this.maGv);
    }

    public void build(String maGV) {
        if(listScore == null)
            listScore = new inputScoreDAO().getListInfoStudent(maGV);
    }

    public static void main(String[] args) {
        System.err.println(new nhapDiemBUS("GV0001").getScore("MH0001", "HK1", "LOP1011920", "NH1920").size());
    }
    
}
