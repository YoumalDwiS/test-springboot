package com.astratech.meister.rest;


import com.astratech.meister.model.Akun;
import com.astratech.meister.service.AkunService;
//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/akun")
public class AkunRest {

    @Autowired
    AkunService akunService;


    @GetMapping("/alldata")
    public List<Akun> getAllData(){
        List<Akun> list = akunService.getAllData();
        return list;
    }

    @GetMapping("/data")
    public Akun getData(@RequestParam("id") int id){
        Akun obj = akunService.findById(id);
        return obj;
    }



    @GetMapping("/tambah")
    public ResponseEntity<Void> tambah(RedirectAttributes flashmsg
            , @RequestParam(value="tambah_nim") String tambah_nim
            , @RequestParam(value="tambah_role") String tambah_role
            , @RequestParam(value="tambah_email") String tambah_email
            , @RequestParam(value="tambah_password") String tambah_password
            , @RequestParam(value="tambah_nama") String tambah_nama
            , @RequestParam(value="tambah_no") String tambah_no){
        Akun obj = new Akun();
        obj.setNim(tambah_nim);
        obj.setRole(tambah_role);
        obj.setEmail(tambah_email);
        obj.setPassword(tambah_password);
        obj.setNama(tambah_nama);
        obj.setNo_hp(tambah_no);
        obj.setStatus(1);

        akunService.save(obj);


        Akun objAkses = akunService.getAkunByNimAndPassword(tambah_nim,tambah_password);


        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil ditambahkan!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/akun/daftar")).build();

    }

    @GetMapping("/edit")
    public ResponseEntity<Void> edit(RedirectAttributes flashmsg
            , @RequestParam(value="edit_id") int edit_id
            , @RequestParam(value="edit_role") String edit_role
            , @RequestParam(value="edit_nim") String edit_nim
            , @RequestParam(value="edit_email") String edit_email
            , @RequestParam(value="edit_password") String edit_password
            , @RequestParam(value="edit_nama") String edit_nama
            , @RequestParam(value="edit_no") String edit_no){
        Akun obj = akunService.findById(edit_id);
        obj.setNim(edit_nim);
        obj.setRole(edit_role);
        obj.setEmail(edit_email);
        if(edit_password != ""){obj.setPassword(edit_password);}
        obj.setNama(edit_nama);
        obj.setNo_hp(edit_no);

//        AkunService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil diedit!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/akun/daftar")).build();

    }

    @PostMapping("/hapus")
    public  ResponseEntity<Void> delete(RedirectAttributes flashmsg, @RequestParam(value="id_akun") int id){
        Akun obj = akunService.findById(id);
        akunService.delete(obj.getId_akun());
        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil dihapus!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/akun/daftar")).build();
    }

}
