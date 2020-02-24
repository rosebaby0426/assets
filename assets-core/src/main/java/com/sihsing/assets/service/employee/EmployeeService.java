package com.sihsing.assets.service.employee;


import com.sihsing.assets.model.po.EmployeePO;
import com.sihsing.assets.model.vo.EmployeeVO;

/**
 * Christine 2019/12/11
 */
public interface EmployeeService {

    EmployeePO login(String account, String password);

    EmployeeVO getEmpInfo(String account);

    void addNewEmp(EmployeePO employeePO, String userAccount);

    void updateAccountFirstLogin(String empId, String newAccount, String newPassword);

    void updateEmpInfo(EmployeePO employeePO, String userAccount);

    void updatePassword(String account, String oldPassword, String newPassword);

    void resetPassword(String resetAccount, String userAccount);

}
