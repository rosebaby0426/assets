package com.sihsing.assets.service.announcement;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sihsing.assets.enums.AnnpuncementStatusEnum;
import com.sihsing.assets.exception.ServiceException;
import com.sihsing.assets.model.po.AnnouncementPO;
import com.sihsing.assets.model.po.EmployeePO;
import com.sihsing.assets.model.vo.AnnouncementVO;
import com.sihsing.assets.storage.mysql.mapper.AnnouncementMapper;
import com.sihsing.assets.storage.mysql.mapper.EmployeeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Christine 2020/01/14
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private AnnouncementMapper announcementMapper;

    private EmployeeMapper employeeMapper;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementMapper announcementMapper, EmployeeMapper employeeMapper) {
        this.announcementMapper = announcementMapper;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<AnnouncementVO> selectLatestAnnouncements(LocalDateTime announceTime) {
        //todo 驗證時間
        return announcementMapper.selectByTopTenAndAnnounceTime(announceTime);
    }

    @Override
    public Page<AnnouncementVO> selectAll() {
        Page page = new Page();
        page.setSize(20);
        return announcementMapper.selectAll(page);
    }

    @Override
    public void addNewAnnouncement(AnnouncementPO announcementPO, String userAccount) {

        EmployeePO employeePO = getEmployee(userAccount);
        //todo 驗證 announcementPO欄位

        announcementPO.setUserId(employeePO.getId());
        announcementPO.setCreateTime(LocalDateTime.now());
        announcementPO.setStatus("CLOSE");
        announcementMapper.insert(announcementPO);

    }

    @Override
    public void updateAnnouncement(AnnouncementPO announcementPO, String userAccount) {

        getEmployee(userAccount);
        //todo 驗證 announcementPO欄位

        AnnouncementPO exsitAnnouncement = getExitAnnouncement(announcementPO.getId());

        if(!exsitAnnouncement.getStatus().equals(announcementPO.getStatus()) && AnnpuncementStatusEnum.CLOSE.name().equals(announcementPO.getStatus())){
            exsitAnnouncement.setStatus(AnnpuncementStatusEnum.CLOSE.name());
        }

        if(Objects.isNull(exsitAnnouncement.getAnnounceTime()) && AnnpuncementStatusEnum.OPEN.name().equals(announcementPO.getStatus())){
            exsitAnnouncement.setStatus(AnnpuncementStatusEnum.OPEN.name());
            exsitAnnouncement.setAnnounceTime(LocalDateTime.now());
        }

        if(Objects.nonNull(exsitAnnouncement.getAnnounceTime())){
            //todo 紀錄至日誌
            //log 新增
        }
        announcementMapper.update(exsitAnnouncement);
    }

    @Override
    public void deleteAnnouncement(Integer announcementId, String userAccount) {

        getEmployee(userAccount);
        getExitAnnouncement(announcementId);
        announcementMapper.deleteById(announcementId);
        //todo 紀錄至日誌
    }

    private EmployeePO getEmployee(String account){

        if(StringUtils.isBlank(account)){
            throw new ServiceException("帳號不可為空");
        }

        EmployeePO employeePO = employeeMapper.selectInfoByAccount(account);

        if(Objects.isNull(employeePO)){
            throw new ServiceException("無此帳號");
        }

        return employeePO;
    }

    private AnnouncementPO getExitAnnouncement(Integer announcementId){

        AnnouncementPO announcementPO = announcementMapper.selectById(announcementId);
        if(Objects.isNull(announcementPO)){
            throw new ServiceException("無此公告");
        }
        return announcementPO;
    }
}
