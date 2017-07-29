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
    private Long id;
    private String name;

    @Generated(hash = 389708422)
    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 128156227)
    public Brand() {
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
