package com.sihsing.assets.controller;

import com.sihsing.assets.model.vo.AnnouncementVO;
import com.sihsing.assets.service.announcement.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    private AnnouncementService announcementService;

    @Autowired
    public HomeController(AnnouncementService announcementService){
        this.announcementService = announcementService;
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg","test1235644565");
        return "login";
    }

    @RequestMapping("/index")
    public String indexHome(Model model) {
        System.err.println("已經登入囉");
        List<AnnouncementVO> announcementVOs = announcementService.selectLatestAnnouncements(LocalDateTime.now());
        model.addAttribute("announcements",announcementVOs);
        return "index";
    }
}
