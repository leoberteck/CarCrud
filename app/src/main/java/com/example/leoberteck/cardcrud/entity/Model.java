package com.example.leoberteck.cardcrud.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Trovata on 22/07/2017.
 */

@Entity
public class Model {
    @Id
    @Generated
    private Integer id;
    private String name;
    private double weight;
    private double price;

    private Integer idBrand;
    private Integer idType;

    @ToOne(joinProperty = "idBrand")
    private Brand brand;
    @ToOne(joinProperty = "idType")
    private Type type;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1902358955)
    private transient ModelDao myDao;
    @Generated(hash = 778075598)
    public Model(Integer id, String name, double weight, double price,
            Integer idBrand, Integer idType) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.idBrand = idBrand;
        this.idType = idType;
    }
    @Generated(hash = 2118404446)
    public Model() {
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
    public double getWeight() {
        return this.weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Integer getIdBrand() {
        return this.idBrand;
    }
    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }
    public Integer getIdType() {
        return this.idType;
    }
    public void setIdType(Integer idType) {
        this.idType = idType;
    }
    @Generated(hash = 671615819)
    private transient Integer brand__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1878864586)
    public Brand getBrand() {
        Integer __key = this.idBrand;
        if (brand__resolvedKey == null || !brand__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BrandDao targetDao = daoSession.getBrandDao();
            Brand brandNew = targetDao.load(__key);
            synchronized (this) {
                brand = brandNew;
                brand__resolvedKey = __key;
            }
        }
        return brand;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1232793700)
    public void setBrand(Brand brand) {
        synchronized (this) {
            this.brand = brand;
            idBrand = brand == null ? null : brand.getId();
            brand__resolvedKey = idBrand;
        }
    }
    @Generated(hash = 1960251954)
    private transient Integer type__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1185465862)
    public Type getType() {
        Integer __key = this.idType;
        if (type__resolvedKey == null || !type__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypeDao targetDao = daoSession.getTypeDao();
            Type typeNew = targetDao.load(__key);
            synchronized (this) {
                type = typeNew;
                type__resolvedKey = __key;
            }
        }
        return type;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 160725909)
    public void setType(Type type) {
        synchronized (this) {
            this.type = type;
            idType = type == null ? null : type.getId();
            type__resolvedKey = idType;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 454860095)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getModelDao() : null;
    }
}
