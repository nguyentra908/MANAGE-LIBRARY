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
public class DSMuonSachDTO {
    private int stt;
    private String mathe;
    private String madocgia;
    private String tenDG;
    private int SoSachMuon;

    public int getStt() {
        return stt;
    }

    public String getMathe() {
        return mathe;
    }

    public String getMadocgia() {
        return madocgia;
    }

    public String getTenDG() {
        return tenDG;
    }

    public int getSoSachMuon() {
        return SoSachMuon;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public void setMathe(String mathe) {
        this.mathe = mathe;
    }

    public void setMadocgia(String madocgia) {
        this.madocgia = madocgia;
    }

    public void setTenDG(String tenDG) {
        this.tenDG = tenDG;
    }

    public void setSoSachMuon(int SoSachMuon) {
        this.SoSachMuon = SoSachMuon;
    }

    public DSMuonSachDTO(int stt, String mathe, String madocgia, String tenDG, int SoSachMuon) {
        this.stt = stt;
        this.mathe = mathe;
        this.madocgia = madocgia;
        this.tenDG = tenDG;
        this.SoSachMuon = SoSachMuon;
    }

    public DSMuonSachDTO() {
    }
    
}
