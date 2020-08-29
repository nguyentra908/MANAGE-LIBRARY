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
public class NhanVienDTO {
    private String MaNV;
    private String TenNV;
    private String NgaySinh;
    private String SDT;
    private String Email;
    private String GioiTinh;
    private String ChucVu;
    private String DiaChi;
    private String tentk;
    private String loaitk;

    public String getLoaitk() {
        return loaitk;
    }

    public void setLoaitk(String loaitk) {
        this.loaitk = loaitk;
    }
    

    public String getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public String getEmail() {
        return Email;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getTentk() {
        return tentk;
    }


    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public NhanVienDTO(String MaNV, String TenNV, String NgaySinh, String SDT, String Email, String GioiTinh, String ChucVu, String DiaChi, String tentk, String loaitk) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.ChucVu = ChucVu;
        this.DiaChi = DiaChi;
        this.tentk = tentk;
        this.loaitk = loaitk;
    }

    
    public NhanVienDTO() {
    }
    
}
