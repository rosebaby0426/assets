package com.sihsing.assets.service.announcement;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sihsing.assets.model.po.AnnouncementPO;
import com.sihsing.assets.model.vo.AnnouncementVO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Christine 2020/01/14
 */
public interface AnnouncementService {

    List<AnnouncementVO> selectLatestAnnouncements(LocalDateTime announceTime);

    Page<AnnouncementVO> selectAll();

    void addNewAnnouncement(AnnouncementPO announcementPO, String userAccount);

    void updateAnnouncement(AnnouncementPO announcementPO, String userAccount);

    void deleteAnnouncement(Integer announceId,String userAccount);
}
