package com.imooc.canvas.entity;

import java.util.Date;

public class Canvas {
    /**
     * `id` bigint(20) NOT NULL AUTO_INCREMENT,
     *   `categoryId` bigint(20) NOT NULL,
     *   `name` varchar(45) NOT NULL,
     *   `creator` varchar(50) NOT NULL,
     *   `price` int(9) NOT NULL,
     *   `smallImg` mediumblob,
     *   `createTime` timestamp NULL DEFAULT NULL,
     *   `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     *   `description` varchar(255) DEFAULT NULL,
     *   `details` varchar(20000) DEFAULT NULL,
     */
    private Integer id;
    private Integer categoryId;
    private String name;
    private String creator;
    private Integer price;
    //图片用字节储存
    private byte[] smallImg;
    private Date createTime;
    private Date updateTime;
    private String description;
    private String details;

    public Canvas() {
    }

    public Canvas(Integer id, byte[] smallImg) {
        this.id = id;
        this.smallImg = smallImg;
    }

    public Canvas(Integer id, Integer categoryId, String name, String creator, Integer price, byte[] smallImg, Date updateTime, String description, String details) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.creator = creator;
        this.price = price;
        this.smallImg = smallImg;
        this.updateTime = updateTime;
        this.description = description;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public byte[] getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(byte[] smallImg) {
        this.smallImg = smallImg;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Canvas{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                ", price=" + price +
                ", smallImg=" + smallImg +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
