package com.sihsing.assets.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sihsing.assets.enums.EmployeeStatusEnum;
import com.sihsing.assets.model.po.EmployeePO;
import com.sihsing.assets.model.vo.EmployeeVO;
import com.sihsing.assets.storage.mysql.mapper.EmployeeMapper;
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
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testLogin() {
        EmployeePO epm = EmployeePO.builder().account("admin").password("123456").build();
        EmployeePO account = employeeMapper.login(epm);
        System.err.println(account.getId());
        System.err.println(account.getAccount());
        System.err.println(account.getName());
    }

    @Test
    public void testUpdateLogin() {
        EmployeePO epm = EmployeePO.builder().account("admin").password("123456").lastLoginTime(LocalDateTime.now()).build();
        employeeMapper.updateLogin(epm);
    }

    @Test(timeout = 400)
    public void testGetEmpInfo() {
        EmployeeVO employeeVO = employeeMapper.getEmpInfo("admin");
        System.err.println(employeeVO.getDepartmentId());
        System.err.println(employeeVO.getDepartmentName());
    }

    @Test
    public void testInsert() {
        EmployeePO employeePO = EmployeePO.builder()
                .account("2020010303")
                .password("123456")
                .name("張三豐")
                .phone("09123456789")
                .address("台北市中正區")
                .createTime(LocalDateTime.now())
                .departmentId(1)
                .status(EmployeeStatusEnum.NORMAL.name())
                .empId("2020010303")
                .englishName("Sam")
                .build();
        employeeMapper.insert(employeePO);
    }

    @Test
    public void testUpdateAccount() {
        employeeMapper.updateAccount("2020010303", "sam", "", LocalDateTime.now());
    }

    @Test
    public void testUpdate() {
        EmployeePO employeePO = EmployeePO.builder()
                .account("david")
                .name("王大衛")
                .phone("091234567899")
                .address("台北市大安區")
                .englishName("David")
                .updateTime(LocalDateTime.now())
                .build();
        employeeMapper.update(employeePO);
    }

    @Test(timeout = 400)
    public void testSelectInfoFirstLogin() {
        EmployeePO employeePO = employeeMapper.selectInfoByEmpId("2020010303");
        Assert.assertNull(employeePO.getLastLoginTime());
    }

    @Test
    public void testSelectInfoByAccount() {
        EmployeePO employeePO = employeeMapper.selectInfoByAccount("admin");
        Assert.assertNotNull(employeePO);
    }

    @Test
    public void testSelectAll() {
        List<EmployeePO> employeePOs = employeeMapper.selectAll();
        System.err.println(employeePOs);
        Assert.assertNotNull(employeePOs);
    }

    @Test
    public void testSelectByCondition(){
        Page<EmployeePO> page = new Page<>();
        Page<EmployeePO> employeePOs = employeeMapper.selectByCondition(page,null,null,null);
        System.err.println(employeePOs.getRecords());
    }

    @Test
    public void testSelectInfoByEmpId(){
        EmployeePO employeePO = employeeMapper.selectInfoByEmpId("2020010101");
        Assert.assertNotNull(employeePO);
        System.err.println(employeePO.getName());
    }
}
