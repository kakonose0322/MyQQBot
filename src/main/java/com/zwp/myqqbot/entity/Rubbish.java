package com.zwp.myqqbot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * 垃圾的实体类
 */
public class Rubbish implements Serializable {
//    /**
//     * 自增序号
//     */
//    @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;

    /**
     * 垃圾名称
     */
    private String name;

    /**
     * 垃圾类型
     */
    private String type;

    public Rubbish() {
    }

    public Rubbish(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    @Override
    public String toString() {
        return "Rubbish{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
