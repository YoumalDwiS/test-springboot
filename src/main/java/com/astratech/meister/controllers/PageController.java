package com.astratech.meister.controllers;

import com.astratech.meister.model.Akun;
import com.astratech.meister.service.AkunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    AkunService akunService;


    @RequestMapping("/")
    public String login(HttpSession session, Model model){
      if(session.getAttribute("akun") != null){
           return "redirect:/home";
       }
        model.addAttribute("akun",new Akun());
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }


    @PostMapping("/aksilogin")
    public String aksilogin(RedirectAttributes flashmsg, HttpServletRequest request, Akun akun){
        request.getSession().invalidate();
        if(akunService.login(akun)){
            akun = akunService.getAkunByNimAndPassword(akun.getNim(),akun.getPassword());
            request.getSession().setAttribute("akun",akun);
            return "redirect:/home";
        }
        flashmsg.addFlashAttribute("type","gagal");
        flashmsg.addFlashAttribute("msg","Gagal login ! , User tidak ditemukan.");
        return "redirect:/";
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model){
//     if(session.getAttribute("user") == null){
//            return "redirect:/logout";
//        }

        model.addAttribute("akun",session.getAttribute("akun"));

        return "index";
    }

}
