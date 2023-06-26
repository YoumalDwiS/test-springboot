package com.astratech.meister.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bagian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_section;
    private String nama_section;
    private int status;

    public Bagian(){
    }

    public int getId_section() {
        return id_section;
    }

    public void setId_section(int id_section) {
        this.id_section = id_section;
    }

    public String getNama_section() {
        return nama_section;
    }

    public void setNama_section(String nama_section) {
        this.nama_section = nama_section;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
