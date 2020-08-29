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
public class TaiKhoanDTO {
    private String TenTK;
    private String MatKhau;
    private String LoaiTK;

    public String getTenTK() {
        return TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getLoaiTK() {
        return LoaiTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setLoaiTK(String LoaiTK) {
        this.LoaiTK = LoaiTK;
    }

    public TaiKhoanDTO(String TenTK, String MatKhau, String LoaiTK) {
        this.TenTK = TenTK;
        this.MatKhau = MatKhau;
        this.LoaiTK = LoaiTK;
    }

    public TaiKhoanDTO() {
    }
    
}
