package com.itlize.koreraprojectadv.Service.ServiceImpl;

import com.itlize.koreraprojectadv.Entity.Columns;
import com.itlize.koreraprojectadv.Entity.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResouceServiceImplTest {

   @Autowired
   private ResouceServiceImpl resouceServiceImpl;

    @Test
    void saveResource() {
        Resource resource = new Resource();
        resource.setResourceCode(12345678);
        resource.setResourceName("Project titles");
        resouceServiceImpl.saveResource(resource);
    }




    @Test
    void findOneResourceById() {
        Resource resource = resouceServiceImpl.findOneResourceById((long) 3);
        System.out.println(resource);
    }

    @Test
    void findAll() {
        resouceServiceImpl.findAll();
    }

    @Test
    void updateResourceName() {
        Resource resource = resouceServiceImpl.findOneResourceById((long)3);
        resource.setResourceName("TestUpdateName");
        resouceServiceImpl.saveResource(resource);


    }

    @Test
    void updateResourceCode() {
    }

    @Test
    void deleteResource() {
    }

    @Test
    void setResourceRepository() {
    }
}