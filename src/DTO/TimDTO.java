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
public class TimDTO {
    private String MaSach;
    private String TenSach;
    private String TheLoai;
    private String NXB;
    private String TacGia;
    private String TrangThai;

    public String getMaSach() {
        return MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public String getNXB() {
        return NXB;
    }

    public String getTacGia() {
        return TacGia;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public TimDTO(String MaSach, String TenSach, String TheLoai, String NXB, String TacGia, String TrangThai) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TheLoai = TheLoai;
        this.NXB = NXB;
        this.TacGia = TacGia;
        this.TrangThai = TrangThai;
    }

    public TimDTO() {
    }
    
}
