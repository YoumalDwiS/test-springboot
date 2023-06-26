package com.astratech.meister.rest;


import com.astratech.meister.model.Aspek;
import com.astratech.meister.model.DetailAspek;
import com.astratech.meister.service.DetailAspekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/detailaspek")
public class DetailAspekRest {

    @Autowired
    DetailAspekService detailAspekService;

    @GetMapping("/alldata")
    public List<DetailAspek> getAllData(){
        List<DetailAspek> list = detailAspekService.getAllData();
        return list;
    }

    @GetMapping("/alldataaspek")
    public List<DetailAspek> getAllDataByaspek(@RequestParam("id") int id){
        List<DetailAspek> list = detailAspekService.getAllDataByAspek(id);
        return list;
    }

    @GetMapping("/data")
    public DetailAspek getData(@RequestParam("id") int id){
        DetailAspek obj = detailAspekService.findById(id);
        return obj;
    }

    @GetMapping("/tambah")
    public ResponseEntity<Void> tambah(RedirectAttributes flashmsg
            , @RequestParam(value="tambah_aspek") Aspek tambah_aspek
            , @RequestParam(value="tambah_soal") String tambah_soal){
        DetailAspek obj = new DetailAspek();
        obj.setId_aspek(tambah_aspek);
        obj.setSoal(tambah_soal);
        obj.setStatus("Aktif");

        detailAspekService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil ditambahkan!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/detailaspek/daftar")).build();
    }

    @GetMapping("/edit")
    public ResponseEntity<Void> edit(RedirectAttributes flashmsg
            , @RequestParam(value="edit_id") int edit_id
            , @RequestParam(value="edit_aspek") Aspek edit_aspek
            , @RequestParam(value="edit_soal") String edit_soal){
        DetailAspek obj = detailAspekService.findById(edit_id);
        obj.setId_aspek(edit_aspek);
        obj.setSoal(edit_soal);
        detailAspekService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil diedit!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/detailaspek/daftar")).build();
    }

    @PostMapping("/hapus")
    public  ResponseEntity<Void> delete(RedirectAttributes flashmsg, @RequestParam(value="id_detail_aspek") int id){
        DetailAspek obj = detailAspekService.findById(id);
        detailAspekService.delete(obj.getId_detail_aspek());
        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil dihapus!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/detailaspek/daftar")).build();
    }
}
