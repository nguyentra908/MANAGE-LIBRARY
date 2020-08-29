/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.TraDAL;
import DTO.TraDTO;
import java.util.ArrayList;

/**
 *
 * @author sam
 */
public class TraBLL {
    TraDAL dal=new TraDAL();
    public ArrayList<TraDTO> getAllTra(){
        return dal.getAllTra();
    }
    public ArrayList<TraDTO> getTra(String ma){
        return dal.getTra(ma);
    }
    public int TinhTienPhat(String ma){
        return dal.TinhTienPhat(ma);
    }
    public void TraSach(TraDTO tra,int index){
        dal.TraSach(tra, index);
    }
}
