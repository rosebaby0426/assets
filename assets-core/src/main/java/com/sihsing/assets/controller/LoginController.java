package com.sihsing.assets.controller;

import com.sihsing.assets.model.po.EmployeePO;
import com.sihsing.assets.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    public static final String SESSION_LOGIN_ATTR = "account";

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/loginAcc", method = RequestMethod.POST)
    public String login(String account, String password, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            model.addAttribute("errorMsg", "");
            EmployeePO emp = employeeService.login(account, password);
            session.setAttribute(SESSION_LOGIN_ATTR, emp);
        } catch (RuntimeException e) {
            model.addAttribute("errorMsg", "帳號密碼錯誤");
            return "login";
        } catch (Exception e) {
            model.addAttribute("errorMsg", "错误");
            return "login";
        }

        return "redirect:/index";
    }

    @RequestMapping("logOut")
    public String logOut(HttpSession session) {
        session.removeAttribute(session.getId());
        return "redirect:/";
    }

}
