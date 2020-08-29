/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.BangTamDTO;
import DTO.TraDTO;
import static DAL.Database.getData;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
public class TraDAL {
    public ArrayList<TraDTO> getAllTra(){
        ArrayList<TraDTO> ar=new ArrayList<>();
        String sql="SELECT * FROM QTMUON WHERE NGAYTRA IS NULL";
        ResultSet rs=getData(conectionJDBC(), sql);
        try {
            while(rs.next()){
                TraDTO tra=new TraDTO();
                tra.setMaDG(rs.getString("MADOCGIA"));
                tra.setMaSach(rs.getString("MASACH"));
                tra.setNgayMuon(rs.getString("NGAYMUON"));
                tra.setNgayHetHan(rs.getString("NGAYHETHAN"));
                tra.setTrangThai(rs.getString("TRANGTHAI"));
                ar.add(tra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
    public ArrayList<TraDTO> getTra(String ma){
        ArrayList<TraDTO> ar=new ArrayList<>();
        String sql="SELECT * FROM QTMUON WHERE NGAYTRA IS NULL AND MADOCGIA='"+ma+"'";
        ResultSet rs=getData(conectionJDBC(), sql);
        try {
            while(rs.next()){
                TraDTO tra=new TraDTO();
                tra.setMaDG(rs.getString("MADOCGIA"));
                tra.setMaSach(rs.getString("MASACH"));
                tra.setNgayMuon(rs.getString("NGAYMUON"));
                tra.setNgayHetHan(rs.getString("NGAYHETHAN"));
                tra.setTrangThai(rs.getString("TRANGTHAI"));
                ar.add(tra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
    public int TinhTienPhat(String ma){
        String sql = "{?=call TINH_Phat(?,?)}";
        // int index=this.TableTra.getSelectedRow();
        int output = 0;
        try {
            CallableStatement st = conectionJDBC().prepareCall(sql);
            //st.setString(2, (String) this.TableTra.getValueAt(index, 0));
            st.setString(2, ma);
            st.setInt(3, 2000);
            st.registerOutParameter(1, Types.INTEGER);
            st.execute();
            output = st.getInt(1);
            // this.TextTienPhat.setText(String.valueOf(output));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return output;
    }
    public void TraSach(TraDTO tra,int index){
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Không có sách được chọn");
            //return null;
        }
        PreparedStatement st;
        //String tra="UPDATE QTMUON SET NGAYTRA=SYSDATE,TRANGTHAI=null WHERE MASACH='"+table.getValueAt(index, 1)+"' AND MADOCGIA='"+table.getValueAt(index, 0)+"' AND NGAYTRA IS NULL";
        String sqltra = "UPDATE QTMUON SET NGAYTRA=SYSDATE WHERE MASACH='" + tra.getMaSach() + "' AND MADOCGIA='" + tra.getMaDG() + "' AND NGAYTRA IS NULL";
        try {
            st = conectionJDBC().prepareCall(sqltra);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String update = "UPDATE SACH SET TRANGTHAI='Chua muon' WHERE MASACH='" + tra.getMaSach() + "'";
        try {
            st = conectionJDBC().prepareCall(update);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã thanh toán tiền phạt");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         String sql2="UPDATE QTMUON SET TRANGTHAI=null WHERE MADOCGIA='"+tra.getMaDG()+"' AND TRANGTHAI='phat'AND MASACH='"+tra.getMaSach()+"'";
        try {
            st=conectionJDBC().prepareCall(sql2);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Đã trả sách");
        //this.setdefaultTra();
    }
    public int getSoSachMuon(String ma){
         int dangmuon=0;
        String strmuon = "select COUNT(MASACH) FROM QTMUON WHERE NGAYTRA IS NULL AND MADOCGIA='" + ma + "' GROUP BY MADOCGIA";
        ResultSet rs = getData(conectionJDBC(), strmuon);
        try {
            while (rs.next()) {
                dangmuon = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dangmuon;
    }
    public int getSoSachQuaHan(String ma){
        int quahan=0;
         String strhan = "select COUNT(MASACH) FROM QTMUON WHERE NGAYTRA IS NULL AND NGAYHETHAN < SYSDATE AND MADOCGIA='" + ma + "' GROUP BY MADOCGIA";
                ResultSet    rs = getData(conectionJDBC(), strhan);
        try {
            while (rs.next()) {
                quahan = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return quahan;
    }
    public String LayTenDocGia(String ma){
        String ten="";
         String duyet = "select DOCGIA.TEN FROM DOCGIA WHERE MADOCGIA='" + ma + "'";
               ResultSet rs = getData(conectionJDBC(), duyet);
                
        try {
            while (rs.next()) {
                ten = rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ten;
    }
    public boolean CheckMaSach(String masach) {
        String sqlmasach = "select TRANGTHAI FROM SACH WHERE MASACH='" + masach + "'";
        ResultSet rs = getData(conectionJDBC(), sqlmasach);
        boolean temp = false;
        try {
            while (rs.next()) {
//                    this.TextTrangThaiSach.setText(rs.getNString(1));
//                    this.LBTinhTrangSach.setVisible(false);
                temp = true;
            }
            rs.close();
//                if (temp <= 0) {
//                    this.LBTinhTrangSach.setVisible(true);
//                    this.TextTrangThaiSach.setText("");
//                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            return temp;
    }
    public String LayTrangThaiSach(String masach){
        String sqlmasach = "select TRANGTHAI FROM SACH WHERE MASACH='" + masach + "'";
        ResultSet rs = getData(conectionJDBC(), sqlmasach);
        String temp = "";
        try {
            while (rs.next()) {
//                    this.TextTrangThaiSach.setText(rs.getNString(1));
            temp= rs.getNString(1);
//                    this.LBTinhTrangSach.setVisible(false);
               // temp = true;
            }
            rs.close();
//                if (temp <= 0) {
//                    this.LBTinhTrangSach.setVisible(true);
//                    this.TextTrangThaiSach.setText("");
//                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return temp;
    }
    public BangTamDTO LaySachDeChoVaoBangTam(String ma){
        String sql = "SELECT * FROM SACH WHERE MASACH='" + ma + "'";
            ResultSet rs = getData(conectionJDBC(), sql);
            try {
                while (rs.next()) {
                    BangTamDTO bt=new BangTamDTO();
                    bt.setMaSach(rs.getString("MASACH"));
                    bt.setTenSach((rs.getString("TENSACH")));
                    return bt;
                }
                //this.TableMuonTam.setModel(model);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
    }
//     public static void ThemVaoQTMuon(JTable table,int sodongtam,String ma){
//        PreparedStatement st;
//            try {
//                for (int i = 0; i < sodongtam; i++) {
//                    String sqlqt = "insert into QTMUON VALUES('" + (String) table.getValueAt(i, 0) + "',SYSDATE,'" + ma + "',ADD_MONTHS(SYSDATE,3),null,null)";
//                    st = conectionJDBC().prepareCall(sqlqt);
//                    st.executeUpdate();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//    }
//    public static void ThemPhieuMuon(JTable table,int sodongtam, String maphieumuon,String madg){
//        PreparedStatement st;
//        try {
//                for (int i = 0; i < sodongtam; i++) {
//                    String sqlpm = "insert into PHIEUMUON VALUES('" + maphieumuon + "','" + (String) table.getValueAt(i, 0) + "','" + madg + "',SYSDATE, ADD_MONTHS(SYSDATE,3))";
//                    st = conectionJDBC().prepareCall(sqlpm);
//                    st.executeUpdate();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//    }
//    public static void ThayDoiTrangThaiSach(JTable table, int sodongtam){
//        PreparedStatement st;
//         for (int i = 0; i < sodongtam; i++) {
//                String sqlupdate = "UPDATE SACH SET TRANGTHAI='Da muon' WHERE MASACH='" + (String) table.getValueAt(i, 0) + "'";
//                try {
//                    st = conectionJDBC().prepareCall(sqlupdate);
//                    st.executeUpdate();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//    }
    public void choMuon(BangTamDTO bt, String madg, String mapm) {
        PreparedStatement st;
        try {
            String sqlqt = "insert into QTMUON VALUES('" + bt.getMaSach() + "',SYSDATE,'" + madg + "',ADD_MONTHS(SYSDATE,3),null,null)";
            st = conectionJDBC().prepareCall(sqlqt);
            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            String sqlpm = "insert into PHIEUMUON VALUES('" + mapm + "','" + bt.getMaSach() + "','" + madg + "',SYSDATE, ADD_MONTHS(SYSDATE,3))";
            st = conectionJDBC().prepareCall(sqlpm);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String sqlupdate = "UPDATE SACH SET TRANGTHAI='Da muon' WHERE MASACH='" + bt.getMaSach() + "'";
        try {
            st = conectionJDBC().prepareCall(sqlupdate);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
