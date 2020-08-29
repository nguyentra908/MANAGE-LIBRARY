/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.PhieuNhapSachDAL;
import DTO.PhieuNhapSachDTO;
import java.util.ArrayList;

/**
 *
 * @author sam
 */
public class PhieuNhapSachBLL {
    PhieuNhapSachDAL dal=new PhieuNhapSachDAL();
    public ArrayList<PhieuNhapSachDTO> getAllPhieu(){
        return dal.getAllPhieu();
    }
    public boolean ThemPhieuNhap(PhieuNhapSachDTO pn){
        return dal.ThemPhieuNhap(pn);
    }
    public boolean XoaPhieuNhap(String ma){
        return dal.XoaPhieuNhap(ma);
    }
    public boolean SuaPhieuNhap(String ma, PhieuNhapSachDTO pn,String tensach){
        return dal.SuaPhieuNhap(ma, pn, tensach);
    }
}
