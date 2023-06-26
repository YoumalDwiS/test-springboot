package com.astratech.meister.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aspek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_aspek;
    private String nama_aspek;
    private String status;

    public Aspek(){}

    public int getId_aspek() {
        return id_aspek;
    }

    public void setId_aspek(int id_aspek) {
        this.id_aspek = id_aspek;
    }

    public String getNama_aspek() {
        return nama_aspek;
    }

    public void setNama_aspek(String nama_aspek) {
        this.nama_aspek = nama_aspek;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
