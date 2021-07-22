package com.itlize.koreraprojectadv.Repository;

import com.itlize.koreraprojectadv.Entity.Project;
import com.itlize.koreraprojectadv.Entity.ProjectResource;
import com.itlize.koreraprojectadv.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectResourceRepository extends JpaRepository<ProjectResource,Integer> {

    public List<ProjectResource> findByProjectAndResource(Project project, Resource resource);

    public List<ProjectResource> findByProject(Project project);

    public List<ProjectResource> findByResource(Resource resource);




}
