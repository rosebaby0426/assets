package com.sihsing.assets.storage.mysql.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sihsing.assets.model.po.EmployeePO;
import com.sihsing.assets.model.vo.EmployeeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Christine 2019/12/23
 */
@Mapper
@Repository
public interface EmployeeMapper {

    EmployeePO login(EmployeePO employeePO);

    void updateLogin(EmployeePO employeePO);

    void update(EmployeePO employeePO);

    EmployeeVO getEmpInfo(String account);

    void insert(EmployeePO employeePO);

    void updateAccount(@Param("empId") String empId, @Param("account") String newAccount,
                       @Param("password") String password, @Param("updateTime") LocalDateTime updateTime);

    EmployeePO selectInfoByEmpId(String empId);

    EmployeePO selectInfoByAccount(String account);

    List<EmployeePO> selectAll();

    Page<EmployeePO> selectByCondition(Page<EmployeePO> poPage,@Param("empId") String empId,
                                       @Param("account") String newAccount,@Param("name") String name);

}
