package com.sihsing.assets.service;

import com.sihsing.assets.enums.EmployeeStatusEnum;
import com.sihsing.assets.model.po.EmployeePO;
import com.sihsing.assets.model.vo.EmployeeVO;
import com.sihsing.assets.service.employee.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testLogin() {
        EmployeePO account = employeeService.login("admin", "123456");
        System.err.println(account.getId());
        System.err.println(account.getName());
    }

    @Test
    public void testGetEmpInfo() {
        EmployeeVO employeeVO = employeeService.getEmpInfo("admin");
        System.err.println(employeeVO.getDepartmentName());
    }

    @Test
    public void testAddNewEmp() {
        EmployeePO employeePO = EmployeePO.builder()
                .empId("2020010302")
                .name("王曉強")
                .englishName("good")
                .phone("0912321456987")
                .address("台北市信義區")
                .account("good")
                .password("123456")
                .departmentId(1)
                .status(EmployeeStatusEnum.NORMAL.name())
                .build();
        employeeService.addNewEmp(employeePO, "admin");
    }

    @Test
    public void testUpdateAccountFirstLogin() {
        employeeService.updateAccountFirstLogin("2020010302", "good123", "123456");
    }

    @Test
    public void testUpdateEmpInfo() {
        EmployeePO employeePO = EmployeePO.builder()
                .address("台北市大安區")
                .account("good123")
                .build();
        employeeService.updateEmpInfo(employeePO, "admin");
    }

    @Test
    public void testUpdatePassword() {
        employeeService.updatePassword("sam", "123456", "123123");
    }

    @Test
    public void testResetPassword() {
        employeeService.resetPassword("sam", "admin");
    }


}
