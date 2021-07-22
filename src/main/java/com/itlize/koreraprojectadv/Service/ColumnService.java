package com.itlize.koreraprojectadv.Service;

import com.itlize.koreraprojectadv.Entity.ColumnType;
import com.itlize.koreraprojectadv.Entity.Columns;
import com.itlize.koreraprojectadv.Entity.Resource;

import java.util.List;

public interface ColumnService {

    Columns save(Columns columns);

    Columns getColumnById(Integer columnId);

    List<Columns> getColumnListByResource (Resource resouce);

    Columns changeColumnsName(Columns columns,String columnName);

    Columns changeColumnType (Columns columns, ColumnType type);

    void deleteResource(Columns columns);
}
