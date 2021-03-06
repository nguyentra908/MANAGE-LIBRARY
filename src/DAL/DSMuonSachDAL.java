/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import static DAL.Database.getData;
import DTO.DSMuonSachDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sam
 */
public class DSMuonSachDAL {
    public ArrayList<DSMuonSachDTO> getTheoNgay(Date ngaydau,Date ngaycuoi){
        String tungay, denngay;
        java.sql.Date dtungay, ddenngay;
        dtungay = new java.sql.Date(ngaydau.getTime());
        ddenngay = new java.sql.Date(ngaycuoi.getTime());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        tungay = dateFormat.format(dtungay);
        denngay = dateFormat.format(ddenngay);
        System.out.println(tungay + "   " + denngay);
        ArrayList<DSMuonSachDTO> ar=new ArrayList<DSMuonSachDTO>();
        String sql1 = "SELECT DOCGIA.MADOCGIA,THETHUVIEN.MATHE,DOCGIA.TEN FROM DOCGIA JOIN THETHUVIEN ON THETHUVIEN.MADOCGIA=DOCGIA.MADOCGIA JOIN QTMUON ON QTMUON.MADOCGIA=DOCGIA.MADOCGIA where ngaymuon <= TO_DATE('" + denngay + "','dd-MM-YYYY') and ngaymuon >= TO_DATE('" + tungay + "','dd-MM-YYYY') GROUP BY DOCGIA.MADOCGIA,THETHUVIEN.MATHE,DOCGIA.TEN";
        int i = 1;
        ResultSet rs = getData(conectionJDBC(), sql1);
        try {
            while (rs.next()) {
            DSMuonSachDTO ds=new DSMuonSachDTO();
                //temp[0] = i;
                ds.setStt(i);
                i++;
               // temp[1] = rs.getString("MATHE");
               ds.setMathe(rs.getString("MATHE"));
                //temp[2] = rs.getString("MADOCGIA");
                ds.setMadocgia(rs.getString("MADOCGIA"));
                //temp[3] = rs.getString("TEN");
                ds.setTenDG(rs.getString("TEN"));
                String sql2 = "select count(*) from qtmuon where ngaymuon <= TO_DATE('" + denngay + "','dd-MM-YYYY') and ngaymuon >= TO_DATE('" + tungay + "','dd-MM-YYYY') group by madocgia having madocgia='" + ds.getMadocgia() + "'";
                ResultSet rss = getData(conectionJDBC(), sql2);
                while (rss.next()) {
                   // temp[4] = rss.getInt(1);
                    ds.setSoSachMuon(rss.getInt(1));
                }
               // model.addRow(temp);
               ar.add(ds);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ar;
    }
    public ArrayList<DSMuonSachDTO> getTheoThang(int thang,int nam){
         String sql1 = "SELECT DOCGIA.MADOCGIA,THETHUVIEN.MATHE,DOCGIA.TEN FROM DOCGIA JOIN THETHUVIEN ON THETHUVIEN.MADOCGIA=DOCGIA.MADOCGIA JOIN QTMUON ON QTMUON.MADOCGIA=DOCGIA.MADOCGIA where EXTRACT(MONTH FROM ngaymuon) =" + thang + " and EXTRACT(YEAR FROM ngaymuon) = " + nam + " GROUP BY DOCGIA.MADOCGIA,THETHUVIEN.MATHE,DOCGIA.TEN";
        ArrayList<DSMuonSachDTO> ar=new ArrayList<DSMuonSachDTO>();
        int i = 1;
        ResultSet rs = getData(conectionJDBC(), sql1);
        try {
            while (rs.next()) {
               DSMuonSachDTO ds=new DSMuonSachDTO();
                ds.setStt(i);
                i++;
               ds.setMathe(rs.getString("MATHE"));
                ds.setMadocgia(rs.getString("MADOCGIA"));
                ds.setTenDG(rs.getString("TEN"));
                String sql2 = "select count(*) from qtmuon where EXTRACT(MONTH FROM ngaymuon) =" + thang + " and EXTRACT(YEAR FROM ngaymuon) = " + nam + " group by madocgia having madocgia='" + ds.getMadocgia() + "'";
                 ResultSet rss = getData(conectionJDBC(), sql2);
                while (rss.next()) {
                    ds.setSoSachMuon(rss.getInt(1));
                }
               ar.add(ds);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ar;
    }
}
