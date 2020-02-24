package com.sihsing.assets.service.employee;

import com.sihsing.assets.enums.OperationEnum;
import com.sihsing.assets.exception.ServiceException;
import com.sihsing.assets.model.po.EmployeePO;
import com.sihsing.assets.model.vo.EmployeeVO;
import com.sihsing.assets.storage.mysql.mapper.EmployeeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeMapper employeeMapper;

    public final String psw = "123456";

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeePO login(String account, String password) {
        EmployeePO employeePO = employeeMapper.selectInfoByAccount(account);
        checkLoginAccount(employeePO, account, password);
        //todo 登入失敗處理

        employeePO = employeeMapper.login(employeePO);
        employeePO.setLastLoginTime(LocalDateTime.now());
        employeeMapper.updateLogin(employeePO);

        return employeePO;
    }

    @Override
    public EmployeeVO getEmpInfo(String account) {

        //todo 驗證account
        checkAccount(account);
        return employeeMapper.getEmpInfo(account);
    }

    @Override
    public void addNewEmp(EmployeePO employeePO, String userAccount) {
        //todo 驗證emp欄位
//        checkInsertOrUpdateData
        employeePO.setCreateTime(LocalDateTime.now());
        employeeMapper.insert(employeePO);
        //todo 紀錄至日誌
    }

    @Override
    public void updateAccountFirstLogin(String empId, String newAccount, String newPassword) {

        checkEmpAccountForFirstLogin(empId, newAccount, newPassword);
        employeeMapper.updateAccount(empId, newAccount, newPassword, LocalDateTime.now());
        //todo 紀錄至日誌
    }

    @Override
    public void updateEmpInfo(EmployeePO employeePO, String userAccount) {

        //todo 驗證欄位
//        checkInsertOrUpdateData
        employeePO.setUpdateTime(LocalDateTime.now());
        employeeMapper.update(employeePO);
        //todo 記錄至日誌
    }

    @Override
    public void updatePassword(String account, String oldPassword, String newPassword) {

        EmployeePO employeePO = employeeMapper.selectInfoByAccount(account);
        checkAccountAndPassword(employeePO, oldPassword, newPassword);
        employeeMapper.updateAccount(employeePO.getEmpId(), employeePO.getAccount(), newPassword, LocalDateTime.now());
        //todo 記錄至日誌
    }

    @Override
    public void resetPassword(String resetAccount, String userAccount) {
        checkAccount(resetAccount);
        EmployeePO employeePO = employeeMapper.selectInfoByAccount(resetAccount);
        employeeMapper.updateAccount(employeePO.getEmpId(), "", psw, LocalDateTime.now());
        //todo 記錄至日誌
    }

    private void checkAccount(String account) {

        if (StringUtils.isBlank(account)) {
            throw new ServiceException("帳號不可為空");
        }

        EmployeePO employeePO = employeeMapper.selectInfoByAccount(account);
        if (Objects.isNull(employeePO)) {
            throw new ServiceException("無此帳號");
        }
    }

    //todo
    private void checkInsertOrUpdateData(String operationEnum, EmployeePO employeePO) {

        if (OperationEnum.INSERT.name().equals(operationEnum)) {

        } else {

        }
    }


    private void checkLoginAccount(EmployeePO employeePO, String account, String password) {

        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            throw new ServiceException("帳號密碼不可為空");
        }

        if (Objects.isNull(employeePO)) {
            throw new ServiceException("無此帳號");
        }
    }

    private void checkAccountAndPassword(EmployeePO employeePO, String oldPassword, String newPassword) {

        //帳號檢查
        if (Objects.isNull(employeePO)) {
            throw new ServiceException("無此帳號");
        }
        //舊密碼檢查
        if (!oldPassword.equals(employeePO.getPassword()) || StringUtils.isBlank(oldPassword)) {
            throw new ServiceException("舊密碼輸入錯誤");
        }
        //新密碼檢查
        if (StringUtils.isBlank(newPassword)) {
            throw new ServiceException("新密碼不能為空");
        }
    }

    private void checkEmpAccountForFirstLogin(String empId, String newAccount, String newPassword) {

        //檢查員工
        if (StringUtils.isBlank(empId)) {
            throw new ServiceException("員工編號不可為空");
        }

        EmployeePO employeePO = employeeMapper.selectInfoByEmpId(empId);
        if (Objects.isNull(employeePO)) {
            throw new ServiceException("無此員工");
        }

        //檢查新帳號
        if (StringUtils.isBlank(newAccount)) {
            throw new ServiceException("新帳號不可為空");
        }

        //檢查新密碼
        if (StringUtils.isBlank(newPassword)) {
            throw new ServiceException("新密碼不可為空");
        }
    }

}
