/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DocGiaDAL;
import DTO.DocGiaDTO;
import java.util.ArrayList;

/**
 *
 * @author sam
 */
public class QuanLiDocGiaBLL {
    DocGiaDAL dgDAL=new DocGiaDAL();
   // DocGiaDAL dgDAL;
    public ArrayList<DocGiaDTO> getAllDocGia(){
        return dgDAL.getAllDocGia();
    }

    public QuanLiDocGiaBLL() {
    }
}
