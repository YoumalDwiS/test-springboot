package com.astratech.meister.rest;

import com.astratech.meister.model.Bagian;
import com.astratech.meister.service.BagianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/bagian")
public class BagianRest {
    @Autowired
    BagianService bagianService;

    @GetMapping("/alldata")
    public List<Bagian> getAllData(){
        List<Bagian> list = bagianService.getAllData();
        return list;
    }

    @GetMapping("/data")
    public Bagian getData(@RequestParam("id") int id){
        Bagian obj = bagianService.findById(id);
        return obj;
    }

    @GetMapping("/tambah")
    public ResponseEntity<Void> tambah(RedirectAttributes flashmsg
            , @RequestParam(value="tambah_nama") String tambah_nama){
        Bagian obj = new Bagian();
        obj.setNama_section(tambah_nama);
        obj.setStatus(1);

        bagianService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil ditambahkan!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/bagian/daftar")).build();

    }

    @GetMapping("/edit")
    public ResponseEntity<Void> edit(RedirectAttributes flashmsg
            , @RequestParam(value="edit_id") int edit_id
            , @RequestParam(value="edit_nama") String edit_nama){
        Bagian obj = bagianService.findById(edit_id);
        obj.setNama_section(edit_nama);

        bagianService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil diedit!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/bagian/daftar")).build();

    }

    @PostMapping("/hapus")
    public  ResponseEntity<Void> delete(RedirectAttributes flashmsg, @RequestParam(value="id_section") int id){
        Bagian obj = bagianService.findById(id);
        bagianService.delete(obj.getId_section());
        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil dihapus!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/bagian/daftar")).build();
    }
}

