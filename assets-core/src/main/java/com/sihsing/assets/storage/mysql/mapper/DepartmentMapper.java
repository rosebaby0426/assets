package com.sihsing.assets.storage.mysql.mapper;

import com.sihsing.assets.model.po.DepartmentPO;
import com.sihsing.assets.model.po.EmployeePO;
import com.sihsing.assets.model.vo.EmployeeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * Christine 2020/01/07
 */
@Mapper
@Repository
public interface DepartmentMapper {

    DepartmentPO selectById(Integer id);

    void insert(String name);
}
