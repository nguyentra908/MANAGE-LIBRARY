/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import static DAL.Database.getData;
import DTO.NXBDTO;
import DTO.PhieuNhapSachDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author sam
 */
public class PhieuNhapSachDAL {
    public ArrayList<PhieuNhapSachDTO> getAllPhieu(){
        ArrayList<PhieuNhapSachDTO> ar=new ArrayList<PhieuNhapSachDTO>();
        String sql="SELECT * FROM PHIEUNHAPSACH";
        ResultSet rs=DAL.Database.getData(conectionJDBC(), sql);
        try {
            while(rs.next()){
                PhieuNhapSachDTO pn=new PhieuNhapSachDTO();
                pn.setMaPhieu(rs.getString("MANHAP"));
                pn.setTenSach(rs.getString("TENSACH"));
                pn.setMaNXB(rs.getString("MANXB"));
                pn.setMaNV(rs.getString("MANHANVIEN"));
                pn.setNgayGiao(rs.getString("NGAYGIAO"));
                pn.setSL(rs.getInt("SL"));
                pn.setDongGia(rs.getInt("DONGGIA"));
                ar.add(pn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapSachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
    public boolean ThemPhieuNhap(PhieuNhapSachDTO pn){
        int n=0;
        String sql="INSERT INTO PHIEUNHAPSACH VALUES(?,?,?,?,TO_DATE(?,'dd-MM-yyyy'),?,?)";
        try {
            PreparedStatement st=conectionJDBC().prepareStatement(sql);
            st.setString(1, pn.getMaPhieu());
            st.setString(2, pn.getTenSach());
            st.setInt(3, pn.getSL());
            st.setInt(4, pn.getDongGia());
            st.setString(5, pn.getNgayGiao());
            st.setString(6, pn.getMaNV());
            st.setString(7, pn.getMaNXB());
            n=st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapSachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean XoaPhieuNhap(String ma){
        int n=0;
        String sql="DELETE FROM PHIEUNHAPSACH WHERE MANHAP='"+ma+"'";
        try {
            PreparedStatement st=conectionJDBC().prepareStatement(sql);
            n=st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapSachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean SuaPhieuNhap(String ma, PhieuNhapSachDTO pn,String tensach){
         int n=0;
        String sql="UPDATE PHIEUNHAPSACH SET TENSACH=?, SL=?, DONGGIA=?, NGAYGIAO=TO_DATE(?,'dd-MM-yyyy'), MANHANVIEN=?, MANXB=? WHERE MANHAP=? AND TENSACH=?";
        try {
            PreparedStatement st=conectionJDBC().prepareStatement(sql);
            st.setString(7, ma);
            st.setString(1, pn.getTenSach());
            st.setInt(2, pn.getSL());
            st.setInt(3, pn.getDongGia());
            st.setString(4, pn.getNgayGiao());
            st.setString(5, pn.getMaNV());
            st.setString(6, pn.getMaNXB());
            st.setString(8, tensach);
            n=st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapSachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
    public String LayNXB(String ma){
        String nxb="";
        String sql="SELECT * FROM PHIEUNHAPSACH JOIN NHAXUATBAN ON PHIEUNHAPSACH.MANXB=NHAXUATBAN.MANXB WHERE MANHAP='"+ma+"'";
        ResultSet rs=getData(conectionJDBC(),sql);
        try {
            while(rs.next()){
                nxb=rs.getString("TENNXB");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapSachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nxb;
    }
    public void DoDuLieuVaoCBBNXB(JComboBox j){
        String sql="SELECT * FROM NHAXUATBAN";
        ResultSet rs=getData(conectionJDBC(), sql);
        Vector<NXBDTO> v=new Vector<>();
        ArrayList ar=new ArrayList();
        int i=0;
        try {
            while(rs.next()){
                NXBDTO nxb=new NXBDTO(rs.getString("MANXB"), rs.getString("TENNXB"), null, null);
                 v.add(nxb);
                 ar.add(rs.getString("MANXB"));
                 i++;
            }
            ComboBoxModel cb=new DefaultComboBoxModel(v);
            j.setModel(cb);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapSachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
