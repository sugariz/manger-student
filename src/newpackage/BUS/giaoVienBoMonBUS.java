/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.BUS;

import java.util.ArrayList;
import javaapplication3.DAO.giaoVienBoMonDAO;
import javaapplication3.DTO.giaoVienBoMonDTO;
import javaapplication3.DTO.gradeDTO;
import javaapplication3.DTO.classDTO;
import javaapplication3.DTO.subjectDTO;

/**
 *
 * @author azu
 */
public class giaoVienBoMonBUS {

    public static ArrayList<giaoVienBoMonDTO> listGiaoVienBoMon = null;
    private String maGv;

    public giaoVienBoMonBUS(String maGv) {
        this.maGv = maGv;
        if (listGiaoVienBoMon == null) {
            listGiaoVienBoMon = new giaoVienBoMonDAO().getThongTinGiaoVien(this.maGv);
        }
    }
    
    /*
    Lấy danh sách vê Năm Học - Lớp HK Môn mà giáo viên đó dạy
    */

    public ArrayList<classDTO> getLopHoc(String maNamHoc, Object khoi) {
        ArrayList<classDTO> listLophoc = new ArrayList<classDTO>();
        new lopBUS().build();
        for (giaoVienBoMonDTO giaoVienBoMon : listGiaoVienBoMon) {
            boolean condi = listLophoc.stream()
                    .anyMatch(obj -> obj.getMaLop().equals(giaoVienBoMon.getLopHoc()));
            if (condi == false
                    && giaoVienBoMon.getMaNamHoc().equals(maNamHoc)
                    && giaoVienBoMon.getMaKhoiLop().equals(khoi)) {
                classDTO result = lopBUS.listLop
                        .stream()
                        .filter(obj -> obj.getMaLop().equals(giaoVienBoMon.getLopHoc()))
                        .findFirst()
                        .get();
                listLophoc.add(result);
            }
        }

        return listLophoc;
    }

    public ArrayList<subjectDTO> getMonHoc(Object maLop) {
        ArrayList<subjectDTO> listMonHoc = new ArrayList<subjectDTO>();
        new monHocBUS().build();
        for (giaoVienBoMonDTO giaoVienBoMon : listGiaoVienBoMon) {
            boolean condi = listMonHoc.stream()
                    .anyMatch(obj -> obj.getIdSubject().equals(giaoVienBoMon.getMonHoc()));
            if (condi == false && giaoVienBoMon.getLopHoc().equals(maLop)) {
                subjectDTO result = monHocBUS.listMonHoc
                        .stream()
                        .filter(obj -> obj.getIdSubject().equals(giaoVienBoMon.getMonHoc()))
                        .findFirst()
                        .get();
                listMonHoc.add(result);
            }
        }

        return listMonHoc;
    }

    public ArrayList<gradeDTO> getKhoi(String maNamHoc) {
        ArrayList<gradeDTO> listKhoi = new ArrayList<gradeDTO>();
        new khoiBUS().build();
        for (giaoVienBoMonDTO giaoVienBoMon : listGiaoVienBoMon) {
            boolean condi = listKhoi.stream()
                    .anyMatch(obj -> obj.getMaKhoi().equals(giaoVienBoMon.getMaKhoiLop()));
            if(condi == false &&
                giaoVienBoMon.getMaNamHoc().equals(maNamHoc)) {
                gradeDTO result = khoiBUS.listKhoi
                        .stream()
                        .filter(obj -> obj.getMaKhoi().equals(giaoVienBoMon.getMaKhoiLop()))
                        .findFirst()
                        .get();
                listKhoi.add(result);
            }
        }

        return listKhoi;
    }
    

}
