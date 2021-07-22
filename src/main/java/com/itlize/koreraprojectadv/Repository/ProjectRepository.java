package com.itlize.koreraprojectadv.Repository;

import com.itlize.koreraprojectadv.Entity.Project;
import com.itlize.koreraprojectadv.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project,Integer> {

     List<Project> findByUser(User user);
}
