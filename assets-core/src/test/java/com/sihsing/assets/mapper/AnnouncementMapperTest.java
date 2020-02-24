package com.sihsing.assets.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sihsing.assets.model.po.AnnouncementPO;
import com.sihsing.assets.model.vo.AnnouncementVO;
import com.sihsing.assets.storage.mysql.mapper.AnnouncementMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Christine 2020/01/08
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnnouncementMapperTest {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Test
    public void testInsert() {
        AnnouncementPO announcementPO = AnnouncementPO.builder()
                .userId(1)
                .title("緊急通知")
                .content("緊急.............")
                .status("CLOSE")
                .createTime(LocalDateTime.now())
                .type("URGENT")
                .build();
        announcementMapper.insert(announcementPO);
        AnnouncementPO announcementPO2 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("OPEN")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO2);
        AnnouncementPO announcementPO3 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("OPEN")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO3);
        AnnouncementPO announcementPO4 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("OPEN")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO4);
        AnnouncementPO announcementPO5 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("OPEN")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO5);
        AnnouncementPO announcementPO6 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("OPEN")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO6);
        AnnouncementPO announcementPO7 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("OPEN")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO7);
        AnnouncementPO announcementPO8 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("OPEN")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO8);
        AnnouncementPO announcementPO9 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("OPEN")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO9);
        AnnouncementPO announcementPO10 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("OPEN")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO10);
        AnnouncementPO announcementPO11 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("OPEN")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO11);
        AnnouncementPO announcementPO12 = AnnouncementPO.builder()
                .userId(1)
                .title("放假")
                .content("放假囉..........")
                .status("CLOSE")
                .createTime(LocalDateTime.now())
                .type("NORMAL")
                .build();
        announcementMapper.insert(announcementPO12);
    }

    @Test
    public void testUpdate() {
        AnnouncementPO announcementPO = AnnouncementPO.builder()
                .id(1)
                .title("緊急通知")
                .content("緊急.............++++++++++")
                .status("OPEN")
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO);
        AnnouncementPO announcementPO2 = AnnouncementPO.builder()
                .id(2)
                .status("OPEN")
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO2);
        AnnouncementPO announcementPO3 = AnnouncementPO.builder()
                .id(3)
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO3);
        AnnouncementPO announcementPO4 = AnnouncementPO.builder()
                .id(4)
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO4);
        AnnouncementPO announcementPO5 = AnnouncementPO.builder()
                .id(5)
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO5);
        AnnouncementPO announcementPO6 = AnnouncementPO.builder()
                .id(6)
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO6);
        AnnouncementPO announcementPO7 = AnnouncementPO.builder()
                .id(7)
                .status("OPEN")
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO7);
        AnnouncementPO announcementPO8 = AnnouncementPO.builder()
                .id(8)
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO8);
        AnnouncementPO announcementPO9 = AnnouncementPO.builder()
                .id(9)
                .status("OPEN")
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO9);
        AnnouncementPO announcementPO10 = AnnouncementPO.builder()
                .id(10)
                .status("OPEN")
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO10);
        AnnouncementPO announcementPO12 = AnnouncementPO.builder()
                .id(12)
                .status("OPEN")
                .announceTime(LocalDateTime.now())
                .build();
        announcementMapper.update(announcementPO12);

    }

    @Test
    public void testDeleteById() {
        announcementMapper.deleteById(2);
    }

    @Test
    public void testSelectById() {
        AnnouncementPO announcementPO = announcementMapper.selectById(3);
        Assert.assertNotNull(announcementPO);
    }

    @Test
    public void testSelectByTopTenAndAnnounceTime() {
        List<AnnouncementVO> announcementVOS = announcementMapper.selectByTopTenAndAnnounceTime(LocalDateTime.now());
        System.err.println(announcementVOS);
        Assert.assertNotNull(announcementVOS);
    }

    @Test
    public void testSelectAll() {
        Page<AnnouncementVO> page = new Page<>();
        Page<AnnouncementVO> announcementVOPage = announcementMapper.selectAll(page);
        Assert.assertNotNull(announcementVOPage);
        System.err.println("total：" + announcementVOPage.getTotal());
        System.err.println("current：" + announcementVOPage.getCurrent());
        System.err.println("size：" + announcementVOPage.getSize());
        System.err.println("pages：" + announcementVOPage.getPages());
        System.err.println("list：" + announcementVOPage.getRecords());
    }
}
