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
public class TraDTO {
    private String MaDG;
    private String MaSach;
    private String NgayMuon;
    private String NgayHetHan;
    private String TrangThai;

    public String getMaDG() {
        return MaDG;
    }

    public String getMaSach() {
        return MaSach;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public String getNgayHetHan() {
        return NgayHetHan;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public void setMaSach(String MaScah) {
        this.MaSach = MaScah;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public void setNgayHetHan(String NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public TraDTO(String MaDG, String MaScah, String NgayMuon, String NgayHetHan, String TrangThai) {
        this.MaDG = MaDG;
        this.MaSach = MaScah;
        this.NgayMuon = NgayMuon;
        this.NgayHetHan = NgayHetHan;
        this.TrangThai = TrangThai;
    }

    public TraDTO() {
    }
    
}
