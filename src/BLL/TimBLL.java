/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.TimDAL;
import DTO.TimDTO;
import java.util.ArrayList;

/**
 *
 * @author sam
 */
public class TimBLL {
    TimDAL dal = new TimDAL();

    public ArrayList<TimDTO> getAllTim() {
        return dal.getAllTim();
    }

    public ArrayList<TimDTO> getTim(String tensach, String tentg, String theloai, String nxb) {
        return dal.getTim(tensach, tentg, theloai, nxb);
    }
}
