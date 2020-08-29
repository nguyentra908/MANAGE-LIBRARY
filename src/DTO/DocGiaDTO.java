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
public class DocGiaDTO {
    private String MaDG;
    private String TenDG;
    private String NgaySinhDG;
    private String SDT;
    private String DiaChi;
    private String Lop;
    private String DoiTuong;
    private String GioiTinh;
    private String MaThe;

    public String getMaDG() {
        return MaDG;
    }

    public String getTenDG() {
        return TenDG;
    }

    public String getNgaySinhDG() {
        return NgaySinhDG;
    }

    public String getSDT() {
        return SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getLop() {
        return Lop;
    }

    public String getDoiTuong() {
        return DoiTuong;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getMaThe() {
        return MaThe;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public void setTenDG(String TenDG) {
        this.TenDG = TenDG;
    }

    public void setNgaySinhDG(String NgaySinhDG) {
        this.NgaySinhDG = NgaySinhDG;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public void setDoiTuong(String DoiTuong) {
        this.DoiTuong = DoiTuong;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setMaThe(String MaThe) {
        this.MaThe = MaThe;
    }

    public DocGiaDTO(String MaDG, String TenDG, String NgaySinhDG, String SDT, String DiaChi, String Lop, String DoiTuong, String GioiTinh, String MaThe) {
        this.MaDG = MaDG;
        this.TenDG = TenDG;
        this.NgaySinhDG = NgaySinhDG;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.Lop = Lop;
        this.DoiTuong = DoiTuong;
        this.GioiTinh = GioiTinh;
        this.MaThe = MaThe;
    }

    public DocGiaDTO() {
    }
    
}
