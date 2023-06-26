package com.astratech.meister.service;


import com.astratech.meister.model.DetailAspek;
import com.astratech.meister.repository.DetailAspekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailAspekService {

    @Autowired
    DetailAspekRepository detailAspekRepository;

    public List<DetailAspek> getAllData(){
        List<DetailAspek> detailAspekList = (List<DetailAspek>) detailAspekRepository.findDetailAspekByStatus("Aktif");
        return detailAspekList;
    }

    public List<DetailAspek> getAllDataByAspek(Integer id){
        List<DetailAspek> detailAspekList = (List<DetailAspek>) detailAspekRepository.findDetailAspekById_aspek(id);
        return detailAspekList;
    }

    public void save(DetailAspek detailAspek){
        detailAspek.setStatus("Aktif");
        detailAspekRepository.save(detailAspek);
    }

    public DetailAspek findById(int id){
        DetailAspek detailAspek = detailAspekRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        return detailAspek;
    }

    public void delete(int id){
        DetailAspek tempDetailAspek = detailAspekRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempDetailAspek.setStatus("Tidak Aktif");
        detailAspekRepository.save(tempDetailAspek);
    }

    public void update(int id,DetailAspek detailAspek){
        DetailAspek tempDetailAspek = detailAspekRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempDetailAspek.setId_aspek(tempDetailAspek.getId_aspek());
        tempDetailAspek.setSoal(tempDetailAspek.getSoal());
        detailAspekRepository.save(tempDetailAspek);
    }
}