package com.itlize.koreraprojectadv.Service.ServiceImpl;


import com.itlize.koreraprojectadv.Entity.ColumnType;
import com.itlize.koreraprojectadv.Entity.Columns;
import com.itlize.koreraprojectadv.Entity.Resource;
import com.itlize.koreraprojectadv.Repository.ColumnsRepository;
import com.itlize.koreraprojectadv.Service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    ColumnsRepository columnsRepository;

    @Override
    public Columns save(Columns columns) {
        return columnsRepository.save(columns);

    }

    @Override
    public Columns getColumnById(Integer columnId) {
        return columnsRepository.getById(columnId);
    }

    @Override
    public List<Columns> getColumnListByResource(Resource resouce) {
        return columnsRepository.findByResource(resouce);
    }

    @Override
    public Columns changeColumnsName(Columns columns, String columnName) {
        columns.setColumnName(columnName);
        return columnsRepository.save(columns);
    }

    @Override
    public Columns changeColumnType(Columns columns, ColumnType type) {
        columns.setColumnType(ColumnType.fORMULA);
         return columns;
    }

    @Override
    public void deleteResource(Columns columns) {
        columnsRepository.delete(columns);
    }
}
