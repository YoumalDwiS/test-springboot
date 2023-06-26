package com.astratech.meister.service;

import com.astratech.meister.model.Bagian;
import com.astratech.meister.repository.BagianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BagianService {
    @Autowired
    BagianRepository bagianRepository;

    public List<Bagian> getAllData(){
        List<Bagian> bagianList = (List<Bagian>) bagianRepository.findBagianByStatus(1);
        return bagianList;
    }

    public void save(Bagian bagian){
        bagian.setStatus(1);
        bagianRepository.save(bagian);
    }

    public Bagian findById(int id){
        Bagian bagian = bagianRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        return bagian;
    }

    public void delete(int id){
        Bagian tempbg = bagianRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempbg.setStatus(0);
        bagianRepository.save(tempbg);
    }

    public void update(int id,Bagian bagian){
        Bagian tempBagian = bagianRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempBagian.setNama_section(bagian.getNama_section());
        bagianRepository.save(tempBagian);
    }
}