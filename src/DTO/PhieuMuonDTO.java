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
public class PhieuMuonDTO {
    private String MaPhieu;
    private String MaSach;
    private String MADG;
    private String NgayMuon;
    private String NgayHetHan;

    public String getMaPhieu() {
        return MaPhieu;
    }

    public String getMaSach() {
        return MaSach;
    }

    public String getMADG() {
        return MADG;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public String getNgayHetHan() {
        return NgayHetHan;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setMADG(String MADG) {
        this.MADG = MADG;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public void setNgayHetHan(String NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }

    public PhieuMuonDTO(String MaPhieu, String MaSach, String MADG, String NgayMuon, String NgayHetHan) {
        this.MaPhieu = MaPhieu;
        this.MaSach = MaSach;
        this.MADG = MADG;
        this.NgayMuon = NgayMuon;
        this.NgayHetHan = NgayHetHan;
    }

    public PhieuMuonDTO() {
    }
    
}
