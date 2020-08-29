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
public class PhieuNhapSachDTO {
    private String MaPhieu;
    private String TenSach;
    private int SL;
    private int DongGia;
    private String NgayGiao;
    private String MaNV;
    private String MaNXB;

    public String getMaPhieu() {
        return MaPhieu;
    }

    public String getTenSach() {
        return TenSach;
    }

    public int getSL() {
        return SL;
    }

    public int getDongGia() {
        return DongGia;
    }

    public String getNgayGiao() {
        return NgayGiao;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public void setDongGia(int DongGia) {
        this.DongGia = DongGia;
    }

    public void setNgayGiao(String NgayGiao) {
        this.NgayGiao = NgayGiao;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public PhieuNhapSachDTO(String MaPhieu, String TenSach, int SL, int DongGia, String NgayGiao, String MaNV, String MaNXB) {
        this.MaPhieu = MaPhieu;
        this.TenSach = TenSach;
        this.SL = SL;
        this.DongGia = DongGia;
        this.NgayGiao = NgayGiao;
        this.MaNV = MaNV;
        this.MaNXB = MaNXB;
    }

    public PhieuNhapSachDTO() {
    }
    
}
