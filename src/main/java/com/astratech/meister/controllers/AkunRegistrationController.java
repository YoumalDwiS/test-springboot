package com.astratech.meister.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class AkunRegistrationController {
//
//    @Autowired
//    AkunService akunService;
//
//    @Autowired
//    HakAksesService hakAksesService;
//
//    @Autowired
//    JabatanService jabatanService;
//
//    @RequestMapping("/daftar")
//    public String daftar(HttpSession session, Model model){
//        if(session.getAttribute("user") == null){
//            return "redirect:/logout";
//        }
//        model.addAttribute("user",session.getAttribute("user"));
//
//        List<User> list = userService.getAllData();
//        model.addAttribute("list",list);
//
//        List<Jabatan> listjb = jabatanService.getAllData();
//        model.addAttribute("listjb",listjb);
//        return "user/daftar";
//    }


}