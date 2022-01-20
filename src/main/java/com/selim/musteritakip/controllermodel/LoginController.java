package com.selim.musteritakip.controllermodel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login() {
        // Özel bir kontrolcü ile modelview nesnesi oluşturdum.
        ModelAndView model = new ModelAndView();
        // model nesnesinin görünümünün ne olacağını söylüyoruz.
        model.setViewName("login");
        return model;
    }
    @GetMapping("/logina")
    public ModelAndView loginA() {
        // Özel bir kontrolcü ile modelview nesnesi oluşturdum.
        ModelAndView model = new ModelAndView();
        // model nesnesinin görünümünün ne olacağını söylüyoruz.
        model.addObject("baslik", "A OLAN GİRİŞ SAYFASI");
        model.setViewName("login");
        return model;
    }
}
