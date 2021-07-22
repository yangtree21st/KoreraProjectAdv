package com.itlize.koreraprojectadv.Controller;


import com.itlize.koreraprojectadv.Entity.Project;
import com.itlize.koreraprojectadv.Entity.ProjectResource;
import com.itlize.koreraprojectadv.Entity.Resource;
import com.itlize.koreraprojectadv.Repository.ProjectRepository;
import com.itlize.koreraprojectadv.Service.ProjectResourceService;
import com.itlize.koreraprojectadv.Service.ProjectService;
import com.itlize.koreraprojectadv.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectResourceService projectResourceService;

    @Autowired
    ResourceService resourceService;


    @PostMapping("/createProject")
    private ResponseEntity<?> createProject(@RequestBody Project project)
    {


        projectService.save(project);

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @GetMapping("/getProject")
    private ResponseEntity<?> getProject(
                                         @RequestParam String projectName)
    {
        Project project =projectService.findProjectByName(projectName);
        if(project == null)
        {
            return new ResponseEntity<>("{error: project not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(project,HttpStatus.OK);
    }


    @PostMapping("/deleteProject")
    private ResponseEntity<?> deleteProject(Principal principal,
                                            @RequestBody Project project){
        Boolean projectExist = projectService.projectExist(project);
        if(!projectExist){
            return new ResponseEntity<>("{Did not find the project",HttpStatus.BAD_REQUEST);
        }
        projectService.deleteProject(project);
        return new ResponseEntity<>(project,HttpStatus.OK);

    }

    @PostMapping("/addResourceToProject")
    private ResponseEntity<?> addResourceToproject(@RequestParam Long resourceId,
                                                   @RequestParam Integer projectId)

    {
        Project project = projectService.getAProjectById(projectId);
        Resource resource = resourceService.findOneResourceById(resourceId);
        Boolean projectExist = projectService.projectExist(  project);
        Boolean resourceExist = resourceService.resourceExist(resource);

        if(!projectExist){
            return new ResponseEntity<>("{Did not find the project",HttpStatus.BAD_REQUEST);
        }
        if(!resourceExist){
            return new ResponseEntity<>("Did not find the resource",HttpStatus.BAD_REQUEST);
        }

        ProjectResource projectResource = projectResourceService.addResourceToproject(project,resource);

        return new ResponseEntity<>(projectResource,HttpStatus.CREATED);

    }

    @PostMapping("/deleteResourceFromProject")
       public ResponseEntity<?> deleteResourceFromProject(@RequestParam Long resourceId,
                                                          @RequestParam Integer projectId)
    {
        Project project = projectService.getAProjectById(projectId);
        Resource resource = resourceService.findOneResourceById(resourceId);

        Boolean projectExist = projectService.projectExist(project);
        Boolean resourceExist = resourceService.resourceExist(resource);

        if(!projectExist){
            return new ResponseEntity<>("{Did not find the project",HttpStatus.BAD_REQUEST);
        }
        if(!resourceExist){
            return new ResponseEntity<>("Did not find the resource",HttpStatus.BAD_REQUEST);
        }

        List<ProjectResource> projectResourceList =projectResourceService.getProjectResourcesByPR(project,resource);

        ProjectResource projectResource= projectResourceList.get(0);
        System.out.println(projectResource);

        projectResourceService.delete(projectResource);
        return new ResponseEntity<>("Delete Resource from project", HttpStatus.OK);
    }








}
