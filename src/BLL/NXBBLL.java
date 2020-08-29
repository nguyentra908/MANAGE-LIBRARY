/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NXBDAL;
import DTO.NXBDTO;
import java.util.ArrayList;

/**
 *
 * @author sam
 */
public class NXBBLL {
    NXBDAL dal=new NXBDAL();
    public boolean ThemNXB(NXBDTO nxb) {
        return dal.ThemNXB(nxb);
    }

    public boolean SuaNXB(NXBDTO nxb,String ma) {
        return dal.SuaNXB(nxb, ma);
    }

    public boolean XoaNXB(String ma) {
        return dal.XoaNXB(ma);
    }
    public NXBDTO getNXB(String ma){
        return dal.getNXB(ma);
    }
    public ArrayList<NXBDTO> getAllNXB(){
        return dal.getAllNXB();
    }
}
