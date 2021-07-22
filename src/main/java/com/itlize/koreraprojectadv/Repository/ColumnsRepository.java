package com.itlize.koreraprojectadv.Repository;

import com.itlize.koreraprojectadv.Entity.Columns;
import com.itlize.koreraprojectadv.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnsRepository extends JpaRepository<Columns,Integer> {

   public List<Columns> findByResource(Resource resource);



}
