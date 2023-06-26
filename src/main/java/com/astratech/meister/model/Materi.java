package com.astratech.meister.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Materi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_materi;
    private int id_section;
    private String nama_materi;
    private String deskripsi;
    private int status;

    public Materi() {
    }

    public int getId_materi() {
        return id_materi;
    }

    public void setId_materi(int id_materi) {
        this.id_materi = id_materi;
    }

    public int getId_section() {
        return id_section;
    }

    public void setId_section(int id_section) {
        this.id_section = id_section;
    }

    public String getNama_materi() {
        return nama_materi;
    }

    public void setNama_materi(String nama_materi) {
        this.nama_materi = nama_materi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
