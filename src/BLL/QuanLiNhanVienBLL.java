/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author sam
 */
public class QuanLiNhanVienBLL {
    NhanVienDAL dal=new NhanVienDAL();
    public ArrayList<NhanVienDTO> getAllNhanVien(){
        return dal.getAllNhanVien();
    }
    public ArrayList<NhanVienDTO> getNhanVien(String ma){
        return dal.getNhanVien(ma);
    }
    public boolean ThemNV(NhanVienDTO nv){
        return dal.ThemNV(nv);
    }
    public boolean CapNhatNV(NhanVienDTO nv, String ma){
        return dal.CapNhatNV(nv, ma);
    }
    public boolean XoaNV(String ma){
        return dal.XoaNV(ma);
    }
}
