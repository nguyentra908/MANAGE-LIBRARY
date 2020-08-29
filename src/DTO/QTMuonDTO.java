/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author sam
 */
public class QTMuonDTO {
    private String MaSach;
    private String NgayMuon;
    private String MaDocGia;
    private String NgayHetHan;
    private String NgayTra;
    private String TrangThai;

    public String getMaSach() {
        return MaSach;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public String getMaDocGia() {
        return MaDocGia;
    }

    public String getNgayHetHan() {
        return NgayHetHan;
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public void setMaDocGia(String MaDocGia) {
        this.MaDocGia = MaDocGia;
    }

    public void setNgayHetHan(String NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }

    public void setNgayTra(String NgayTra) {
        this.NgayTra = NgayTra;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public QTMuonDTO(String MaSach, String NgayMuon, String MaDocGia, String NgayHetHan, String NgayTra, String TrangThai) {
        this.MaSach = MaSach;
        this.NgayMuon = NgayMuon;
        this.MaDocGia = MaDocGia;
        this.NgayHetHan = NgayHetHan;
        this.NgayTra = NgayTra;
        this.TrangThai = TrangThai;
    }

    public QTMuonDTO() {
    }
    
}
