package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.*;
import com.codeup.springbootblog.repositories.AdRepository;
import com.codeup.springbootblog.repositories.UserRepository;
//import org.apache.catalina.User;
import com.codeup.springbootblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdController {
    private UserRepository userDao;
    private AdRepository adDao;
    private EmailService emailService;

    public AdController(UserRepository userDao, AdRepository adDao, EmailService emailService) {
        this.userDao = userDao;
        this.adDao = adDao;
        this.emailService = emailService;
    }

    @GetMapping("/ads")
    public String showAds(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String showAd(@PathVariable long id, Model model) {
        Ad ad = adDao.getOne(id);
        model.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("/ads/create")
    public String showCreateForm(Model model) {
        User user = userDao.getOne(1L);
        Ad ad = new Ad();
        ad.setUser(user);
        model.addAttribute("ad", ad);
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public RedirectView createAd(@ModelAttribute Ad ad) {
        User user = userDao.getOne(1L);
        ad.setUser(user);
        adDao.save(ad);
        emailService.prepareAndSend(ad, "Ad has been created", "Title:" + ad.getTitle() + "\nDescription:" + ad.getDescription());
        return new RedirectView("/ads/" + ad.getId());
    }

}

