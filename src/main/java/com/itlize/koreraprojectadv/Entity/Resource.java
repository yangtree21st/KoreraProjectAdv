package com.itlize.koreraprojectadv.Entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Resource")
public class Resource {


    @Id
    @GeneratedValue
    //@Column(name = "resource_id")
    private Long resourceId;

   // @Column(name = "resource_name",unique = true,nullable = false)
    private String resourceName;

    //@Column(name = "resource_code",unique = true,nullable = false)
    private Integer resourceCode;

    @CreatedDate
    //@Column(name = "create_time")
    private Date createTime;

    @LastModifiedDate
    //@Column(name = "update_time")
    private Date updateTime;

    @OneToMany(targetEntity = ProjectResource.class, cascade = CascadeType.ALL,mappedBy = "resource")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Collection<ProjectResource> projectResources;

    @OneToMany(targetEntity = Columns.class,cascade = CascadeType.ALL,mappedBy = "resource",
    fetch = FetchType.LAZY)
    private List <Columns> columnsList = new ArrayList<>();

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(Integer resourceCode) {
        this.resourceCode = resourceCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Collection<ProjectResource> getProjectResources() {
        return projectResources;
    }

    public void setProjectResources(Collection<ProjectResource> projectResources) {
        this.projectResources = projectResources;
    }

    public List<Columns> getColumnsList() {
        return columnsList;
    }

    public void setColumnsList(List<Columns> columnsList) {
        this.columnsList = columnsList;
    }
//    @Column(name = "resource_code",unique = true,nullable = false)
//    private Long resourceCode;




}
