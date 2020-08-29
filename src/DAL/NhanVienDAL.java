/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import static DAL.Database.getData;
import DTO.NhanVienDTO;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sam
 */
public class NhanVienDAL {
    public ArrayList<NhanVienDTO> getAllNhanVien(){
        ArrayList<NhanVienDTO> ar=new ArrayList<NhanVienDTO>();
        String sql="SELECT * FROM NHANVIEN JOIN TAIKHOAN ON MANHANVIEN=TENTK";
        ResultSet rs=getData(conectionJDBC (),sql);
        try {
            while(rs.next()){
                NhanVienDTO nv=new NhanVienDTO();
                nv.setMaNV(rs.getString("MANHANVIEN"));
                nv.setTenNV(rs.getString("HOTEN"));
                nv.setNgaySinh(rs.getString("NGAYSINH"));
                nv.setSDT(rs.getString("SDT"));
                nv.setGioiTinh(rs.getString("GIOITINH"));
                nv.setEmail(rs.getString("EMAIL"));
                nv.setChucVu(rs.getString("CHUCVU"));
                nv.setDiaChi(rs.getString("DIACHI"));
                nv.setTentk(rs.getString("TENTK"));
                nv.setChucVu(rs.getString("CHUCVU"));
                ar.add(nv);
            }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
    public ArrayList<NhanVienDTO> getNhanVien(String ma){
        ArrayList<NhanVienDTO> ar=new ArrayList<NhanVienDTO>();
        String sql="SELECT * FROM NHANVIEN JOIN TAIKHOAN ON MANHANVIEN=TENTK WHERE MANHANVIEN LIKE '%"+ma+"%' OR HOTEN LIKE '%"+ma+"%'";
        ResultSet rs=getData(conectionJDBC (),sql);
        try {
            while(rs.next()){
                NhanVienDTO nv=new NhanVienDTO();
                nv.setMaNV(rs.getString("MANHANVIEN"));
                nv.setTenNV(rs.getString("HOTEN"));
                nv.setNgaySinh(rs.getString("NGAYSINH"));
                nv.setSDT(rs.getString("SDT"));
                nv.setGioiTinh(rs.getString("GIOITINH"));
                nv.setEmail(rs.getString("EMAIL"));
                nv.setChucVu(rs.getString("CHUCVU"));
                nv.setDiaChi(rs.getString("DIACHI"));
                nv.setTentk(rs.getString("TENTK"));
                nv.setChucVu(rs.getString("CHUCVU"));
                ar.add(nv);
            }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
    public boolean ThemNV(NhanVienDTO nv){
        String sql="{call ADD_NHANVIEN(?,?,?,?,?,?,?,?,?,?,?)}";
        int n=0;
        CallableStatement pr;
       // String strDate = new SimpleDateFormat("dd-MM-yyyy").format(NgaySinh.getTime());
        try {
            pr = conectionJDBC().prepareCall(sql);
            pr.setString(1, nv.getTentk());
            pr.setString(2, nv.getTentk());
            pr.setString(3, "thu thu");
            pr.setString(4, nv.getMaNV());
            pr.setString(5, nv.getTenNV());
            pr.setString(6, nv.getNgaySinh());
            pr.setString(7, nv.getSDT());
            pr.setString(8, nv.getEmail());
            pr.setString(9, nv.getGioiTinh());
            pr.setString(10, "thu thu");
            pr.setString(11, nv.getDiaChi());
            n=pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
//    public boolean ThemNV(NhanVienDTO nv){
//        String sql="INSERT INTO TAIKHOAN VALUES(?,?,?)";
//        String ma=DAL.Database.TaoMa("nhanvien");
//        int n=0,m=0;
//        try {
//            PreparedStatement pr=conectionJDBC().prepareStatement(sql);
//            pr.setString(1, ma);
//            pr.setString(2, ma);
//            pr.setString(3, "thu thu");
//            n=pr.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String sql1="INSERT INTO NHANVIEN VALUES(?,?,TO_DATE(?,dd-MM-yyyy),?,?,?,?,?)";
//        PreparedStatement pr;
//        try {
//            pr = conectionJDBC().prepareStatement(sql1);
//            pr.setString(1, ma);
//            pr.setString(2, nv.getTenNV());
//            pr.setString(3, nv.getNgaySinh());
//            pr.setString(4, nv.getSDT());
//            pr.setString(5, nv.getEmail());
//            pr.setString(6, nv.getGioiTinh());
//            pr.setString(7, "thu thu");
//            pr.setString(8, nv.getDiaChi());
//            m=pr.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if(n+m>1){
//            return true;
//        }else{
//            return false;
//        }
//    }
    public boolean CapNhatNV(NhanVienDTO nv, String ma){
        String sql="UPDATE NHANVIEN SET HOTEN=?, NGAYSINH=TO_DATE(?,'dd-MM-yyyy'),SDT=?,EMAIL=?,GIOITINH=?,CHUCVU=?,DIACHI=? WHERE MANHANVIEN='"+ma+"'";
        PreparedStatement pr;
        int n=0;
       // String strDate = new SimpleDateFormat("dd-MM-yyyy").format(NgaySinh.getTime());
        try {
            pr = conectionJDBC ().prepareStatement(sql);
           // pr.setString(1, nv.getMaNV());
            pr.setString(1, nv.getTenNV());
            pr.setString(2, nv.getNgaySinh());
            pr.setString(3, nv.getSDT());
            pr.setString(4, nv.getEmail());
            pr.setString(5, nv.getGioiTinh());
            pr.setString(6, nv.getChucVu());
            pr.setString(7, nv.getDiaChi());
            n=pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean XoaNV(String ma){
        String sql="{call XOA_NHANVIEN(?)}";
        int n=0;
        try {
            CallableStatement pr=conectionJDBC ().prepareCall(sql);
            pr.setString(1, ma);
            n=pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
}
