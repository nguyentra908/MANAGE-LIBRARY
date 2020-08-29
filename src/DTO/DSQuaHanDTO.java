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
public class DSQuaHanDTO {
     private int stt;
    private String mathe;
    private String madocgia;
    private String tenDG;
    private int SoSachQuaHan;

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

    public int getSoSachQuaHan() {
        return SoSachQuaHan;
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

    public void setSoSachQuaHan(int SoSachQuaHan) {
        this.SoSachQuaHan = SoSachQuaHan;
    }

    public DSQuaHanDTO(int stt, String mathe, String madocgia, String tenDG, int SoSachQuaHan) {
        this.stt = stt;
        this.mathe = mathe;
        this.madocgia = madocgia;
        this.tenDG = tenDG;
        this.SoSachQuaHan = SoSachQuaHan;
    }

    public DSQuaHanDTO() {
    }
    
}
