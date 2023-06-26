package com.astratech.meister.service;


import com.astratech.meister.model.Akun;
import com.astratech.meister.repository.AkunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AkunService {

    @Autowired
    AkunRepository akunRepository;


    public List<Akun> getAllData(){
        List<Akun> akunList = (List<Akun>) akunRepository.findAkunByStatus(1);
        return akunList;
    }

    public void save(Akun akun){
        akun.setStatus(1);
        akunRepository.save(akun);
    }

    public Akun findById(int id) {
        Akun akun = akunRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id : " + id));
        return akun;
    }

    public void delete(int id) {
        Akun tempAkun = akunRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id : " + id));
        tempAkun.setStatus(0);
        akunRepository.save(tempAkun);
    }

    public void update(int id, Akun akun) {
        Akun tempAkun = akunRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id : " + id));
        if (akun.getPassword() != "") {
            tempAkun.setPassword(akun.getPassword());
        }
        tempAkun.setEmail(akun.getEmail());
        tempAkun.setNama(akun.getNama());
        tempAkun.setNo_hp(akun.getNo_hp());
        akunRepository.save(tempAkun);
    }

    public boolean login(Akun akun) {
        if (akunRepository.login(akun.getNim(), akun.getPassword())) {
            return true;
        }
        return false;
    }

    public Akun getAkunByNimAndPassword(String nim, String password) {
        Akun akun = akunRepository.getAkunByNimAndPassword(nim, password);
        return akun;
    }
}

