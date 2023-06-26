package com.astratech.meister.model;


import javax.persistence.*;

@Entity
public class DetailAspek {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detail_aspek;
    @JoinColumn(name = "id_aspek", referencedColumnName = "id_aspek")
    @ManyToOne
    private Aspek id_aspek;
    private String soal;
    private String status;


    public DetailAspek(){}

    public int getId_detail_aspek() {
        return id_detail_aspek;
    }

    public void setId_detail_aspek(int id_detail_aspek) {
        this.id_detail_aspek = id_detail_aspek;
    }

    public Aspek getId_aspek() {
        return id_aspek;
    }

    public void setId_aspek(Aspek id_aspek) {
        this.id_aspek = id_aspek;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
