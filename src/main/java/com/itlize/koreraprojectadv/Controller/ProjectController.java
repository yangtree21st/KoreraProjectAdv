package com.itlize.koreraprojectadv.Controller;


import com.itlize.koreraprojectadv.Entity.Project;
import com.itlize.koreraprojectadv.Entity.ProjectResource;
import com.itlize.koreraprojectadv.Entity.Resource;
import com.itlize.koreraprojectadv.Service.ProjectResourceService;
import com.itlize.koreraprojectadv.Service.ProjectService;
import com.itlize.koreraprojectadv.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.Principal;

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
    private ResponseEntity<?> createProject(Principal principal,
                                         @RequestParam(name="projectName") String projectName)
    {
        Project projectToAdd = new Project();
        projectToAdd.setProjectName(projectName);
        projectService.save(projectToAdd);

        return new ResponseEntity<>(projectToAdd, HttpStatus.CREATED);
    }

    @GetMapping("/getProject")
    private ResponseEntity<?> getProject(Principal principal,
                                         @RequestParam(name = "projectName") String projectName)
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
    private ResponseEntity<?> addResourceToproject(@RequestBody Resource resource,
                                                   @RequestBody Project project)
    {
        Boolean projectExist = projectService.projectExist(project);
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
       public ResponseEntity<?> deleteResourceFromProject(@RequestBody Resource resource,
                                                          @RequestBody Project project)
    {
        Boolean projectExist = projectService.projectExist(project);
        Boolean resourceExist = resourceService.resourceExist(resource);

        if(!projectExist){
            return new ResponseEntity<>("{Did not find the project",HttpStatus.BAD_REQUEST);
        }
        if(!resourceExist){
            return new ResponseEntity<>("Did not find the resource",HttpStatus.BAD_REQUEST);
        }

        projectResourceService.deleteResourceFromProject(resource,project);

        return new ResponseEntity<>("Delete Resource from project", HttpStatus.OK);
    }








}
