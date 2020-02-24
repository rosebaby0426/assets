package com.sihsing.assets.storage.mysql.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sihsing.assets.model.po.AnnouncementPO;
import com.sihsing.assets.model.vo.AnnouncementVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Christine 2020/01/08
 */
@Mapper
@Repository
public interface AnnouncementMapper {

    void insert(AnnouncementPO announcementPO);

    void update(AnnouncementPO announcementPO);

    void deleteById(@Param("id") Integer id);

    AnnouncementPO selectById(@Param("id") Integer id);

    List<AnnouncementVO> selectByTopTenAndAnnounceTime(@Param("announceTime") LocalDateTime announceTime);

    Page<AnnouncementVO> selectAll(Page page);

}
