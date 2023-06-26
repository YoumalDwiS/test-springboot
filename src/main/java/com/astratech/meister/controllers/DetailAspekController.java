package com.astratech.meister.controllers;

import com.astratech.meister.model.Aspek;
import com.astratech.meister.model.DetailAspek;
import com.astratech.meister.service.AspekService;
import com.astratech.meister.service.DetailAspekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/detailaspek")
public class DetailAspekController {

    @Autowired
    AspekService aspekService;

    @Autowired
    DetailAspekService detailAspekService;

    @RequestMapping("/daftar")
    public String daftar(HttpSession session, Model model){
//        if(session.getAttribute("akun") == null){
//            return "redirect:/logout";
//        }
        model.addAttribute("akun",session.getAttribute("akun"));

        List<DetailAspek> list = detailAspekService.getAllData();
        model.addAttribute("list",list);

        List<Aspek> listks = aspekService.getAllData();
        model.addAttribute("listks",listks);

        return "detailaspek/daftar";
    }
}
