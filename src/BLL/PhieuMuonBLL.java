/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.PhieuMuonDAL;
import DTO.PhieuMuonDTO;
import java.util.ArrayList;

/**
 *
 * @author sam
 */
public class PhieuMuonBLL {
    PhieuMuonDAL dal=new PhieuMuonDAL();
    public ArrayList<PhieuMuonDTO> getAllPhieuMuon(){
        return dal.getAllPhieuMuon();
    }
}
