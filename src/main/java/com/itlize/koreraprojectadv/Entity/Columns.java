package com.itlize.koreraprojectadv.Entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Columns {

    @Id
    @GeneratedValue
    @Column( name = "columnId")
    private Integer columnId;

    private String columnName;

    @Enumerated(EnumType.STRING)
    private ColumnType columnType;

    @CreatedDate
    private Date CreatTime;

    @LastModifiedDate
    private Date LastUpdated;

    @ManyToOne(
            cascade =
                {CascadeType.MERGE})
    @JoinColumn(name = "resource_id")
    private Resource resource;

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    public Date getCreatTime() {
        return CreatTime;
    }

    public void setCreatTime(Date creatTime) {
        CreatTime = creatTime;
    }

    public Date getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        LastUpdated = lastUpdated;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString(){
        return
                "Column id = " + columnId +
                        ", Column Name =" + columnName +
                        " , columnType =" + columnType +
                        ", this column belong to " + resource;
    }
}
