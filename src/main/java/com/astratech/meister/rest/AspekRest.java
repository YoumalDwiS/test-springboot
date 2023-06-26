package com.astratech.meister.rest;


import com.astratech.meister.model.Aspek;
import com.astratech.meister.service.AspekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/aspek")
public class AspekRest {

    @Autowired
    AspekService aspekService;


    @GetMapping("/alldata")
    public List<Aspek> getAllData(){
        List<Aspek> list = aspekService.getAllData();
        return list;
    }

    @GetMapping("/data")
    public Aspek getData(@RequestParam("id") int id){
        Aspek obj = aspekService.findById(id);
        return obj;
    }

    @GetMapping("/tambah")
    public ResponseEntity<Void> tambah(RedirectAttributes flashmsg
            , @RequestParam(value="tambah_nama") String tambah_nama){
        Aspek obj = new Aspek();
        obj.setNama_aspek(tambah_nama);
        obj.setStatus("Aktif");

        aspekService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil ditambahkan!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/aspek/daftar")).build();

    }

    @GetMapping("/edit")
    public ResponseEntity<Void> edit(RedirectAttributes flashmsg
            , @RequestParam(value="edit_id") int edit_id
            , @RequestParam(value="edit_nama") String edit_nama){
        Aspek obj = aspekService.findById(edit_id);
        obj.setNama_aspek(edit_nama);

        aspekService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil diedit!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/aspek/daftar")).build();

    }

    @PostMapping("/hapus")
    public  ResponseEntity<Void> delete(RedirectAttributes flashmsg, @RequestParam(value="id_kategori_sparepart") int id){
        Aspek obj = aspekService.findById(id);
        aspekService.delete(obj.getId_aspek());
        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil dihapus!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/aspek/daftar")).build();
    }
}