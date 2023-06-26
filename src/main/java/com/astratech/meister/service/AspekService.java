package com.astratech.meister.service;


import com.astratech.meister.model.Aspek;
import com.astratech.meister.repository.AspekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AspekService {

    @Autowired
    AspekRepository aspekRepository;

    public List<Aspek> getAllData(){
        List<Aspek> aspekList = (List<Aspek>) aspekRepository.findAspekByStatus("Aktif");
        return aspekList;
    }

    public void save(Aspek aspek){
        aspek.setStatus("Aktif");
        aspekRepository.save(aspek);
    }

    public Aspek findById(int id){
        Aspek aspek = aspekRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        return aspek;
    }

    public void delete(int id){
        Aspek tempAspek = aspekRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempAspek.setStatus("Tidak Aktif");
        aspekRepository.save(tempAspek);
    }

    public void update(int id,Aspek aspek){
        Aspek tempAspek = aspekRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempAspek.setNama_aspek(aspek.getNama_aspek());
        aspekRepository.save(tempAspek);
    }
}