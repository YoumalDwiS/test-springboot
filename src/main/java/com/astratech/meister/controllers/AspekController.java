package com.astratech.meister.controllers;


import com.astratech.meister.model.Aspek;
import com.astratech.meister.service.AspekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("aspek")
public class AspekController {

    @Autowired
    AspekService aspekService;

    @RequestMapping("/daftar")
    public String daftar(HttpSession session, Model model){
//        if(session.getAttribute("user") == null){
//            return "redirect:/logout";
//        }
        model.addAttribute("akun",session.getAttribute("akun"));

        List<Aspek> list = aspekService.getAllData();
        model.addAttribute("list",list);
        return "aspek/daftar";
    }




}
