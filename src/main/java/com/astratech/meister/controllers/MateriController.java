package com.astratech.meister.controllers;


import com.astratech.meister.model.Materi;
import com.astratech.meister.service.MateriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/materi")
public class MateriController {
    @Autowired
    MateriService materiService;

    @RequestMapping("/daftar")
    public String daftar(HttpSession session, Model model){
        /*if(session.getAttribute("user") == null){
            return "redirect:/logout";
        }
        model.addAttribute("user",session.getAttribute("user"));*/

        List<Materi> list = materiService.getAllData();
        model.addAttribute("list",list);
        return "materi/daftar";
    }
}
