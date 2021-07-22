package com.itlize.koreraprojectadv.Entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "project_name",nullable = false,unique = true)
    private String projectName;

    @CreatedDate
    @Column(name = "time_create")
    private Date timeCreate;

    @LastModifiedDate
    @Column(name = "last_updated")
    private Date lastUpdated;

    @ManyToOne(targetEntity = User.class,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(targetEntity = ProjectResource.class,cascade = CascadeType.ALL, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ProjectResource> resources;


    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ProjectResource> getResources() {
        return resources;
    }

    public void setResources(Set<ProjectResource> resources) {
        this.resources = resources;
    }
}
