package com.sihsing.assets.mapper;

import com.sihsing.assets.model.po.DepartmentPO;
import com.sihsing.assets.storage.mysql.mapper.DepartmentMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Christine 2020/01/07
 * */

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentMapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void testSelectById(){
        DepartmentPO departmentPO = departmentMapper.selectById(2);
        Assert.assertNotNull(departmentPO);
        System.err.println(departmentPO.getName());
    }

    @Test
    public void testInsert(){
        departmentMapper.insert("技術二部");
    }
}
