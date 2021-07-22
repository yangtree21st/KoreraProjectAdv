package com.itlize.koreraprojectadv.Entity;

import lombok.Data;

import javax.persistence.*;
import java.lang.annotation.Target;

@Data
@Entity
@Table(name = "ProjectResource")
public class ProjectResource {

    @Id
    @GeneratedValue
    private Integer prId;

    @ManyToOne(cascade =
            {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="project_id")
    private Project project;

    @ManyToOne(targetEntity = Resource.class,
            cascade =
                    {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "resource_id")
    private Resource resource;

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
