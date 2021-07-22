package com.itlize.koreraprojectadv.Service.ServiceImpl;

import com.itlize.koreraprojectadv.Entity.Project;
import com.itlize.koreraprojectadv.Entity.ProjectResource;
import com.itlize.koreraprojectadv.Entity.Resource;
import com.itlize.koreraprojectadv.Repository.ProjectResourceRepository;
import com.itlize.koreraprojectadv.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    ProjectResourceRepository projectResourceRepository;

    @Override
    public ProjectResource save(ProjectResource projectResource) {
        return projectResourceRepository.save(projectResource);
    }

    @Override
    public ProjectResource getProjectResourceById(Integer PRId) {
        return projectResourceRepository.findById(PRId).orElse(null);
    }

    @Override
    public ProjectResource getProjectResourceByPR(Project project, Resource resource) {
        return projectResourceRepository.findByProjectAndResource(project, resource);
    }

    @Override
    public List<ProjectResource> getProjectResourceByProject(Project project) {
        return projectResourceRepository.findByProject(project);


    }

    @Override
    public List<ProjectResource> getProjectResourceByResource(Resource resource) {
        return projectResourceRepository.findByResource(resource);
    }

    @Override
    public void delete(ProjectResource projectResource) {
        projectResourceRepository.delete(projectResource);
        
    }


}
