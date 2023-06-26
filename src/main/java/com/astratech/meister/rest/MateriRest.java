package com.astratech.meister.rest;

import com.astratech.meister.model.Materi;
import com.astratech.meister.service.MateriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/materi")
public class MateriRest {
    @Autowired
    MateriService materiService;

    @GetMapping("/alldata")
    public List<Materi> getAllData(){
        List<Materi> list = materiService.getAllData();
        return list;
    }

    @GetMapping("/data")
    public Materi getData(@RequestParam("id") int id){
        Materi obj = materiService.findById(id);
        return obj;
    }

    @GetMapping("/tambah")
    public ResponseEntity<Void> tambah(RedirectAttributes flashmsg
            , @RequestParam(value="tambah_nama") String tambah_nama
            , @RequestParam(value = "tambah_deskripsi") String tambah_deskripsi){
        Materi obj = new Materi();
        obj.setNama_materi(tambah_nama);
        obj.setDeskripsi(tambah_deskripsi);
        obj.setStatus(1);

        materiService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil ditambahkan!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/materi/daftar")).build();

    }

    @GetMapping("/edit")
    public ResponseEntity<Void> edit(RedirectAttributes flashmsg
            , @RequestParam(value="edit_id") int edit_id
            , @RequestParam(value="edit_nama") String edit_nama
            , @RequestParam(value = "edit_deskripsi") String edit_deskripsi){
        Materi obj = materiService.findById(edit_id);
        obj.setNama_materi(edit_nama);
        obj.setDeskripsi(edit_deskripsi);

        materiService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil diedit!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/materi/daftar")).build();

    }

    @PostMapping("/hapus")
    public  ResponseEntity<Void> delete(RedirectAttributes flashmsg, @RequestParam(value="id_materi") int id){
        Materi obj = materiService.findById(id);
        materiService.delete(obj.getId_materi());
        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil dihapus!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/materi/daftar")).build();
    }
}
