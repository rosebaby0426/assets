package com.sihsing.assets.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sihsing.assets.controller.dto.ApiResult;
import com.sihsing.assets.enums.ApiResultMsgEnum;
import com.sihsing.assets.model.po.AnnouncementPO;
import com.sihsing.assets.model.vo.AnnouncementVO;
import com.sihsing.assets.service.announcement.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Christine 2020/01/15
 */
@Controller
@RequestMapping("/announcement")
public class AnnouncementController {

    private AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @RequestMapping("/index")
    public String index(Model model) {

        Page<AnnouncementVO> announcementVOPage = announcementService.selectAll();

        String title = "布告欄";

        model.addAttribute("announcementList", announcementVOPage.getRecords());
        model.addAttribute("page", announcementVOPage);
        model.addAttribute("headTitle", title);

        return "/announcement/index";
    }

    @RequestMapping("/addAnnouncement")
    public ApiResult<Void> addAnnouncement(AnnouncementPO announcementPO, String userAccount) {
        ApiResult<Void> result = new ApiResult<>();

        announcementService.addNewAnnouncement(announcementPO, userAccount);

        result.setCode(ApiResult.SUCCESS_CODE);
        result.setMsg(ApiResultMsgEnum.ADD_SUCCESS.getDescription());

        return result;
    }

    @RequestMapping("/updateAnnouncement")
    public ApiResult<Void> updateAnnouncement(AnnouncementPO announcementPO, String userAccount) {
        ApiResult<Void> result = new ApiResult<>();

        announcementService.updateAnnouncement(announcementPO, userAccount);

        result.setCode(ApiResult.SUCCESS_CODE);
        result.setMsg(ApiResultMsgEnum.UPDATE_SUCCESS.getDescription());

        return result;
    }

    @RequestMapping("/deleteAnnouncement")
    public ApiResult<Void> deleteAnnouncement(Integer announceId, String userAccount) {
        ApiResult<Void> result = new ApiResult<>();

        announcementService.deleteAnnouncement(announceId, userAccount);

        result.setCode(ApiResult.SUCCESS_CODE);
        result.setMsg(ApiResultMsgEnum.DELETE_SUCCESS.getDescription());

        return result;
    }

}
