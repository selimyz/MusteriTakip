package com.selim.musteritakip.controllermodel;

import com.selim.musteritakip.repository.entity.User;
import com.selim.musteritakip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        System.out.println("GET isteğine cevap verildi");
        // Özel bir kontrolcü ile modelview nesnesi oluşturdum.
        ModelAndView model = new ModelAndView();
        // model nesnesinin görünümünün ne olacağını söylüyoruz.
        model.setViewName("login");
        return model;
    }

    // NOT!!!
    // SORUN: kullanıcı bilgileri doğru ise ana sayfaya yönlenecek
    // değil ise tekrar aynı sayfada kalacak
    @PostMapping("/login")
    public Object doLogin(String username, String password) {
        System.out.println("POST isteğine cevap verildi");
        Optional<User> user = userService.findUserAndPassword(username, password);
        if (user.isPresent())
            return "redirect:/";
        else {
            ModelAndView model = new ModelAndView();
            model.addObject("error", "kullanıcı adı ya da şifre hatalıdır. lütfen tekrar deneyiniz.");
            model.setViewName("login");
            return model;
        }
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        return model;
    }

    @PostMapping("/register")
    public String register(String username, String email, String password, String questions, String answer) {
        userService.save(
                User.builder()
                        .username(username)
                        .password(password)
                        .email(email)
                        .question(questions)
                        .answer(answer)
                        .build());
        return "redirect:/login";
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
