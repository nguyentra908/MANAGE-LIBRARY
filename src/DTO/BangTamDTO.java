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
public class BangTamDTO {
    private String MaSach;
    private String TenSach;

    public String getMaSach() {
        return MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public BangTamDTO(String MaSach, String TenSach) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
    }

    public BangTamDTO() {
    }
    
}
