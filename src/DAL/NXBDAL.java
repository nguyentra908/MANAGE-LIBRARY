/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.NXBDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sam
 */
public class NXBDAL {

    public ArrayList<NXBDTO> getAllNXB() {
        String sql = "SELECT * FROM NHAXUATBAN";
        ArrayList<NXBDTO> ar = new ArrayList<>();
        ResultSet rs = DAL.Database.getData(conectionJDBC(), sql);
        int i = 1;
        try {
            while (rs.next()) {
                NXBDTO nxb = new NXBDTO();
                nxb.setMaNXB(rs.getString("MANXB"));
                nxb.setTenNXB(rs.getString("TENNXB"));
                nxb.setDiaChi(rs.getString("DIACHI"));
                nxb.setSDT(rs.getString("SDT"));
                ar.add(nxb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NXBDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }

    public NXBDTO getNXB(String ma) {
        String sql = "SELECT * FROM NHAXUATBAN WHERE MANXB='" + ma + "'";
        //ArrayList<NXBDTO> ar=new ArrayList<>();
        ResultSet rs = DAL.Database.getData(conectionJDBC(), sql);
        int i = 1;
        NXBDTO nxb = new NXBDTO();
        try {
            while (rs.next()) {
                nxb.setMaNXB(rs.getString("MANXB"));
                nxb.setTenNXB(rs.getString("TENNXB"));
                nxb.setDiaChi(rs.getString("DIACHI"));
                nxb.setSDT(rs.getString("SDT"));
                //ar.add(nxb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NXBDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nxb;
    }

    public boolean ThemNXB(NXBDTO nxb) {
        String sql = "INSERT INTO NHAXUATBAN VALUES(?,?,?,?)";
        int n = 0;
        try {
            PreparedStatement st = conectionJDBC().prepareStatement(sql);
            st.setString(1, nxb.getMaNXB());
            st.setString(2, nxb.getTenNXB());
            st.setString(3, nxb.getDiaChi());
            st.setString(4, nxb.getSDT());
            n = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NXBDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean SuaNXB(NXBDTO nxb,String ma) {
        String sql = "UPDATE NHAXUATBAN SET TENNXB=?, DIACHI=?, SDT=? WHERE MANXB=? ";
        int n = 0;
        try {
            PreparedStatement st = conectionJDBC().prepareStatement(sql);
            st.setString(4, nxb.getMaNXB());
            st.setString(1, nxb.getTenNXB());
            st.setString(2, nxb.getDiaChi());
            st.setString(3, nxb.getSDT());
            n = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NXBDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean XoaNXB(String ma) {
        int n = 0;
        String sql = "DELETE FROM NHAXUATBAN WHERE MANXB='" + ma + "'";
        try {
            PreparedStatement st = conectionJDBC().prepareStatement(sql);
            n = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NXBDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }
}
