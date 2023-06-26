package com.astratech.meister.controllers;

import com.astratech.meister.model.Bagian;
import com.astratech.meister.service.BagianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/bagian")
public class BagianController {
    @Autowired
    BagianService bagianService;

    @RequestMapping("/daftar")
    public String daftar(HttpSession session, Model model){
//        if(session.getAttribute("user") == null){
//            return "redirect:/logout";
//        }
//        model.addAttribute("user",session.getAttribute("user"));

        List<Bagian> list = bagianService.getAllData();
        model.addAttribute("list",list);
        return "bagian/daftar";
    }

}