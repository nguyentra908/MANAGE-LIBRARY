/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DSQuaHanDAL;
import DTO.DSMuonSachDTO;
import DTO.DSQuaHanDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sam
 */
public class DSQuaHanBLL {
    DSQuaHanDAL dal=new DSQuaHanDAL();
    public ArrayList<DSQuaHanDTO> getTheoNgayHan(Date ngaydau,Date ngaycuoi){
        return dal.getTheoNgayHan(ngaydau, ngaycuoi);
    }
    public ArrayList<DSQuaHanDTO> getTheoThangHan(int thang,int nam){
        return dal.getTheoThangHan(thang, nam);
    }
}
