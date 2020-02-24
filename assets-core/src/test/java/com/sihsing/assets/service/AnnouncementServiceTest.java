package com.sihsing.assets.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sihsing.assets.model.po.AnnouncementPO;
import com.sihsing.assets.model.vo.AnnouncementVO;
import com.sihsing.assets.service.announcement.AnnouncementService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnnouncementServiceTest {

    @Autowired
    private AnnouncementService announcementService;

    @Test
    public void testSelectLatestAnnouncements() {
        List<AnnouncementVO> announcementVOs = announcementService.selectLatestAnnouncements(LocalDateTime.now());
        System.err.println(announcementVOs);
    }

    @Test
    public void testSelectAll() {
        Page<AnnouncementVO> announcementVOPage = announcementService.selectAll();
        System.err.println("current：" + announcementVOPage.getCurrent());
        System.err.println("size：" + announcementVOPage.getSize());
        System.err.println("total：" + announcementVOPage.getTotal());
        System.err.println("pages：" + announcementVOPage.getPages());
        System.err.println("list：" + announcementVOPage.getRecords());
    }

    @Test
    public void testAddNewAnnouncement() {
        AnnouncementPO announcementPO = AnnouncementPO.builder()
                .type("NORMAL")
                .title("尾牙活動")
                .content("一年一度的尾牙...")
                .build();
        announcementService.addNewAnnouncement(announcementPO, "admin");
    }

    @Test
    public void testUpdateAnnouncement(){
        AnnouncementPO announcementPO = AnnouncementPO.builder()
                .id(16)
                .status("OPEN")
                .build();
        announcementService.updateAnnouncement(announcementPO,"admin");
    }

    @Test
    public void testDeleteAnnouncement(){
        announcementService.deleteAnnouncement(14,"admin");
    }
}
