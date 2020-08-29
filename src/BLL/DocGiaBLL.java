/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DocGiaDAL;
import DTO.DocGiaDTO;
import DTO.TaiKhoanDTO;
import DTO.TheThuVienDTO;

/**
 *
 * @author sam
 */
public class DocGiaBLL {
    DocGiaDAL dal=new DocGiaDAL();
    public boolean ThemDocGia(DocGiaDTO dg, TaiKhoanDTO tk, TheThuVienDTO the){
        return dal.ThemDocGia(dg, tk, the);
    }
    public boolean XoaDocGia(String ma){
        return dal.XoaDocGia(ma);
    }
    public boolean SuaDocGia(DocGiaDTO dg, String ma){
        return dal.SuaDocGia(dg, ma);
    }
}
