/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.TimDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
public class TimDAL {
    public ArrayList<TimDTO> getAllTim(){
        ArrayList<TimDTO> ar=new ArrayList<>();
        String sql="SELECT * FROM SACH JOIN NHAXUATBAN ON NHAXUATBAN.MANXB=SACH.MANXB";
        ResultSet rs=DAL.Database.getData(conectionJDBC(), sql);
        try {
            while(rs.next()){
                TimDTO tim=new TimDTO();
                tim.setMaSach(rs.getString("MASACH"));
                tim.setTenSach(rs.getString("TENSACH"));
                tim.setTacGia(rs.getString("TACGIA"));
                tim.setNXB(rs.getString("TENNXB"));
                tim.setTheLoai(rs.getString("THELOAI"));
                tim.setTrangThai(rs.getString("TRANGTHAI"));
                ar.add(tim);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
    public ArrayList<TimDTO> getTim(String tensach,String tentg,String theloai, String nxb){
        ArrayList<TimDTO> ar=new ArrayList<>();
        String sql="select * from sach join nhaxuatban on nhaxuatban.manxb=sach.manxb where TENSACH LIKE '%" + tensach + "%' AND TACGIA LIKE '%" + tentg + "%' AND TENNXB LIKE '%" + nxb + "%' AND THELOAI LIKE '%" + theloai + "%'";
        ResultSet rs=DAL.Database.getData(conectionJDBC(), sql);
        try {
            while(rs.next()){
                TimDTO tim=new TimDTO();
                tim.setMaSach(rs.getString("MASACH"));
                tim.setTenSach(rs.getString("TENSACH"));
                tim.setTacGia(rs.getString("TACGIA"));
                tim.setNXB(rs.getString("TENNXB"));
                tim.setTheLoai(rs.getString("THELOAI"));
                tim.setTrangThai(rs.getString("TRANGTHAI"));
                ar.add(tim);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
    public static JComboBox TaoCBBTheLoai(JComboBox jc){
        //JComboBox CBBoxTheLoai=new JComboBox();
        String sqlTheLoai="select * from theloai";
         ResultSet rs=Database.getData(Database.conectionJDBC (),sqlTheLoai);
         String temp;
            jc.removeAllItems();
            jc.addItem("");
        try {
            while(rs.next()){
                temp=rs.getString("TENTHELOAI");
                jc.addItem(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "loi khi lay du lieu the loai");
        }
        return jc;
    }
    public static JComboBox TaoCBBNXB(JComboBox jc){
        String sqlnxb="select * from nhaxuatban";
        ResultSet rs=Database.getData(Database.conectionJDBC (),sqlnxb);
        //JComboBox CBBoxNXB=new JComboBox();
        try {
            jc.removeAllItems();
            jc.addItem("");
            while(rs.next()){
               String temp=rs.getString("TENNXB");
               jc.addItem(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "loi khi lay du lieu nha xuat ban");
        }
        return jc;
    } 
}
