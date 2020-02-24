package com.sihsing.assets.storage.mysql.mapper;

import com.sihsing.assets.model.po.RolePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Christine 2020/01/08
 */
@Mapper
@Repository
public interface RoleMapper {

    void insert(RolePO rolePO);

    void update(RolePO rolePO);

    void deleteById(@Param("id") Integer id);

    RolePO selectById(@Param("id") Integer id);

}
