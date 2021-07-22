package com.itlize.koreraprojectadv.Service.ServiceImpl;

import com.itlize.koreraprojectadv.Entity.ColumnType;
import com.itlize.koreraprojectadv.Entity.Columns;
import com.itlize.koreraprojectadv.Entity.Resource;
import com.itlize.koreraprojectadv.Service.ColumnService;
import com.itlize.koreraprojectadv.Service.ResourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ColumnServiceImplTest {

    @Autowired
    ResourceService resourceService;

    @Autowired
    ColumnService columnService;

    @Test
    void save() {
        Columns columns = new Columns();
        columns.setColumnType(ColumnType.TEXT);
        columns.setColumnName("testColumn5");

      Resource resource = resourceService.findOneResourceById((long)3);
        System.out.println(resource.getResourceName());
        columns.setResource(resource);
        System.out.println(columns);
        columnService.save(columns);
    }

    @Test
    void getColumnById() {
    }

    @Test
    void getColumnListByResource() {

        Resource resource1 = resourceService.findOneResourceById((long)3);

        List<Columns> columnsList = columnService.getColumnListByResource(resource1);
        System.out.println(columnsList);
    }

    @Test
    void changeColumnsName() {
    }

    @Test
    void changeColumnType() {
    }

    @Test
    void deleteResource() {
    }
}