package com.astratech.meister.controllers;


import com.astratech.meister.model.Akun;
import com.astratech.meister.service.AkunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/akun")
public class AkunController {

    @Autowired
    AkunService akunService;

    @RequestMapping("/daftar")
    public String daftar(HttpSession session, Model model){
//        if(session.getAttribute("akun") == null){
//            return "redirect:/logout";
//        }
        model.addAttribute("akun",session.getAttribute("akun"));

        List<Akun> list = akunService.getAllData();
        model.addAttribute("list",list);

        return "akun/daftar";
    }



}