package com.example.leoberteck.cardcrud.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Trovata on 22/07/2017.
 */

@Entity
public class Type {
    @Id
    private Long id;
    private String name;

    @Generated(hash = 1884504993)
    public Type(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1782799822)
    public Type() {
    }
    
    @Override
    public String toString() {
        return name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
