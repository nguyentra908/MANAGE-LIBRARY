/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.PhieuMuonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sam
 */
public class PhieuMuonDAL {
    public ArrayList<PhieuMuonDTO> getAllPhieuMuon(){
        String sql="SELECT * FROM PHIEUMUON";
        ResultSet rs=DAL.Database.getData(conectionJDBC(), sql);
        ArrayList<PhieuMuonDTO> ar=new ArrayList<>();
        try {
            while(rs.next()){
                PhieuMuonDTO pm=new PhieuMuonDTO();
                pm.setMaPhieu(rs.getString("MAPHIEUMUON"));
                pm.setMADG(rs.getString("MADOCGIA"));
                pm.setMaSach(rs.getString("MASACH"));
                pm.setNgayMuon(rs.getString("NGAYMUON"));
                pm.setNgayHetHan(rs.getString("NGAYHETHAN"));
                ar.add(pm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
}
