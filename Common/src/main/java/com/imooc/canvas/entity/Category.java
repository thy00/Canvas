package com.imooc.canvas.entity;

import java.util.Date;

public class Category {
    /**
     * `id` bigint(11) NOT NULL AUTO_INCREMENT,
     *   `name` varchar(100) NOT NULL,
     *   `createName` varchar(45) NOT NULL,
     *   `createTime` timestamp NULL DEFAULT NULL,
     *   `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     *   `description` varchar(220) DEFAULT NULL,
     */
    private Integer id;
    private String name;
    private String createName;
    private Date createTime;
    private Date updateTime;
    private String description;


    public Category() {
    }

    public Category(Integer id, String name, String createName, Date updateTime, String description) {
        this.id = id;
        this.name = name;
        this.createName = createName;
        this.updateTime = updateTime;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createName='" + createName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
