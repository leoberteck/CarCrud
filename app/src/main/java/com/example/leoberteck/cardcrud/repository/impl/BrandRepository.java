package com.example.leoberteck.cardcrud.repository.impl;

import com.example.leoberteck.cardcrud.App;
import com.example.leoberteck.cardcrud.entity.Brand;
import com.example.leoberteck.cardcrud.repository.interfaces.IBrandRepository;

import org.greenrobot.greendao.AbstractDao;

/**
 * Created by Trovata on 22/07/2017.
 */

public class BrandRepository extends AbstractRepository<Brand, Long> implements IBrandRepository {
    public BrandRepository() {
        super(App.getDaoSession().getBrandDao());
    }
}
