package com.sihsing.assets.mapper;

import com.sihsing.assets.model.po.AnnouncementPO;
import com.sihsing.assets.model.po.RolePO;
import com.sihsing.assets.storage.mysql.mapper.AnnouncementMapper;
import com.sihsing.assets.storage.mysql.mapper.RoleMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * Christine 2020/01/08
 * */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testInsert(){
        RolePO rolePO = RolePO.builder().name("最高管理者").description("最高權限").status("ENABLED").build();
        roleMapper.insert(rolePO);
    }

    @Test
    public void testUpdate(){
        RolePO rolePO = RolePO.builder().id(1).status("ENABLED").build();
        roleMapper.update(rolePO);
    }

    @Test
    public void testDeleteById(){
        roleMapper.deleteById(1);
    }

    @Test
    public void testSelectById(){
        RolePO rolePO = roleMapper.selectById(2);
        Assert.assertNotNull(rolePO);
    }
}
