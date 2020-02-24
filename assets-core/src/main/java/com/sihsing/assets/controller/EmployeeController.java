package com.sihsing.assets.controller;

import com.sihsing.assets.controller.dto.ApiResult;
import com.sihsing.assets.enums.ApiResultMsgEnum;
import com.sihsing.assets.model.po.EmployeePO;
import com.sihsing.assets.model.vo.EmployeeVO;
import com.sihsing.assets.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/{account}")
    public String index(@PathVariable(value = "account") String account, Model model) {
        EmployeeVO employeeVO = employeeService.getEmpInfo(account);

        String title = "我的資訊";
        model.addAttribute("headTitle", title);
        model.addAttribute("account", employeeVO);

        return "employee/index";
    }

    @ResponseBody
    @RequestMapping("/updateEmployeePassword")
    public ApiResult<Void> changePassword(String account, String oldPassword, String newPassword) {
        ApiResult<Void> result = new ApiResult<>();
        employeeService.updatePassword(account, oldPassword, newPassword);
        result.setCode(ApiResult.SUCCESS_CODE);
        result.setMsg(ApiResultMsgEnum.UPDATE_SUCCESS.getDescription());
        return result;
    }

    @ResponseBody
    @RequestMapping("/addNewEmployee")
    public ApiResult<Void> addNewEmp(EmployeePO employeePO, String userAccount) {
        ApiResult<Void> result = new ApiResult<>();
        employeeService.addNewEmp(employeePO, userAccount);
        result.setCode(ApiResult.SUCCESS_CODE);
        result.setMsg(ApiResultMsgEnum.ADD_SUCCESS.getDescription());
        return result;
    }

    @ResponseBody
    @RequestMapping("/updateEmpInfo")
    public ApiResult<Void> updateEmpInfo(EmployeePO employeePO, String userAccount) {
        ApiResult<Void> result = new ApiResult<>();
        employeeService.updateEmpInfo(employeePO, userAccount);
        result.setCode(ApiResult.SUCCESS_CODE);
        result.setMsg(ApiResultMsgEnum.UPDATE_SUCCESS.getDescription());
        return result;
    }

    @ResponseBody
    @RequestMapping("/resetPassword")
    public ApiResult<Void> resetPassword(String resetAccount, String userAccount) {
        ApiResult<Void> result = new ApiResult<>();
        employeeService.resetPassword(resetAccount, userAccount);
        result.setCode(ApiResult.SUCCESS_CODE);
        result.setMsg(ApiResultMsgEnum.UPDATE_SUCCESS.getDescription());
        return result;
    }

    @RequestMapping("/selectEmpInfo")
    public String selectEmpInfo(String account, Model model) {
        EmployeeVO employeeVO = employeeService.getEmpInfo(account);

        model.addAttribute("employee", employeeVO);
        //todo 加上前端畫面路徑
        return "";
    }

}
