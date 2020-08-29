/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.TaiKhoanDTO;
import static DAL.Database.conectionJDBC;
import static DAL.Database.getData;
import DTO.DocGiaDTO;
import DTO.TheThuVienDTO;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
public class DocGiaDAL {

    public ArrayList<DocGiaDTO> getAllDocGia() {
        ArrayList<DocGiaDTO> ar = new ArrayList<DocGiaDTO>();
        String sql = "SELECT * FROM DOCGIA";
        ResultSet rs = getData(conectionJDBC(), sql);
        try {
            while (rs.next()) {
                DocGiaDTO dg = new DocGiaDTO();
                dg.setMaDG(rs.getString("MADOCGIA"));
                dg.setTenDG(rs.getString("TEN"));
                dg.setNgaySinhDG(rs.getString("NGAYSINH"));
                dg.setSDT(rs.getString("SDT"));
                dg.setDiaChi(rs.getString("DIACHI"));
                dg.setLop(rs.getString("LOP"));
                dg.setDoiTuong(rs.getString("DOITUONG"));
                dg.setGioiTinh(rs.getString("GIOITINH"));
                dg.setMaThe(rs.getString("MATHE"));
                ar.add(dg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }

    public DocGiaDTO getDocGia(String ma) {
        String sql = "SELECT * FROM NHANVIEN WHERE MANHANVIEN='" + ma + "'";
        ResultSet rs = getData(conectionJDBC(), sql);
        DocGiaDTO dg=new DocGiaDTO();
        try {
            while(rs.next()){
                dg.setMaDG(rs.getString("MADOCGIA"));
                dg.setTenDG(rs.getString("TEN"));
                dg.setNgaySinhDG(rs.getString("NGAYSINH"));
                dg.setSDT(rs.getString("SDT"));
                dg.setDiaChi(rs.getString("DIACHI"));
                dg.setLop(rs.getString("LOP"));
                dg.setDoiTuong(rs.getString("DOITUONG"));
                dg.setGioiTinh(rs.getString("GIOITINH"));
                dg.setMaThe(rs.getString("MATHE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dg;
    }
    public boolean ThemDocGia(DocGiaDTO dg, TaiKhoanDTO tk, TheThuVienDTO the){
        String sql="{call ADD_DOCGIA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        int n=0;
        try {
            CallableStatement pr=conectionJDBC().prepareCall(sql);
            pr.setString(1, tk.getTenTK());
                pr.setString(2, tk.getMatKhau());
                pr.setString(3, "doc gia");
                pr.setString(4, dg.getMaDG());
                pr.setString(5, dg.getTenDG());
                pr.setString(6, dg.getNgaySinhDG());
                pr.setString(7, dg.getSDT());
                pr.setString(8, dg.getDiaChi());
                if (dg.getDoiTuong().equals("Giao vien")) {
                    pr.setString(9, null);
                }else{
                    pr.setInt(9, Integer.parseInt(dg.getLop()));
                }
                pr.setString(10, dg.getDoiTuong());
                pr.setString(11, dg.getGioiTinh());
                pr.setString(12, dg.getMaThe());
                pr.setString(13, the.getMaThe());
                pr.setString(14, the.getMaDocGia());
                pr.setString(15, null);
                n=pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean XoaDocGia(String ma){
        String sql="{call XOA_DOCGIA(?)}";
        CallableStatement pr;
        int n=0;
        try {
            pr = conectionJDBC().prepareCall(sql);
            pr.setString(1, ma);
            n=pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean SuaDocGia(DocGiaDTO dg, String ma){
        int n=0;
         String sqlupdate = "UPDATE DOCGIA SET TEN=?, GIOITINH=?, DIACHI=?, SDT=?, NGAYSINH=TO_DATE(?,'dd-MM-yyyy'), DOITUONG=?, LOP=? WHERE MADOCGIA='" + ma + "'";
        try {
            PreparedStatement update = conectionJDBC().prepareStatement(sqlupdate);
            update.setString(1, dg.getTenDG());
            update.setString(2, dg.getGioiTinh());
            update.setString(3, dg.getDiaChi());
            update.setString(4, dg.getSDT());
            //String strDate = new SimpleDateFormat("dd-MM-yyyy").format(new java.sql.Date(ngaysinh.getTime()));
            update.setString(5, dg.getNgaySinhDG());
            update.setString(6, dg.getDoiTuong());
            update.setString(7, dg.getLop());
            if (dg.getDoiTuong().equals("Giao vien")) {
                update.setString(7, null);
            }
            n=update.executeUpdate();
            JOptionPane.showMessageDialog(null, "cập nhật độc giả thành công");
            //this.setDefaultDocgia();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "dữ liệu để cập nhật độc giả có lỗi");
            ex.printStackTrace();
        }
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
}
