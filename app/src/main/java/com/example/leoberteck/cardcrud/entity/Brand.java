package com.example.leoberteck.cardcrud.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Trovata on 22/07/2017.
 */

@Entity
public class Brand {
    @Id
    @Generated
    private Integer id;
    private String name;
    @Generated(hash = 766751527)
    public Brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 128156227)
    public Brand() {
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
