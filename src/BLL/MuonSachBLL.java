/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DSMuonSachDAL;
import DTO.DSMuonSachDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sam
 */
public class MuonSachBLL {
    DSMuonSachDAL dal=new DSMuonSachDAL();
    public ArrayList<DSMuonSachDTO> getTheoNgay(Date ngaydau,Date Ngaycuoi){
        return dal.getTheoNgay(ngaydau, Ngaycuoi);
    }
    public ArrayList<DSMuonSachDTO> getTheoThang(int thang,int nam){
        return dal.getTheoThang(thang, nam);
    }
}
