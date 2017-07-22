package com.example.leoberteck.cardcrud.repository.impl;

import com.example.leoberteck.cardcrud.App;
import com.example.leoberteck.cardcrud.entity.Type;
import com.example.leoberteck.cardcrud.repository.interfaces.ITypeRepository;

import org.greenrobot.greendao.AbstractDao;

/**
 * Created by Trovata on 22/07/2017.
 */

public class TypeRepository extends AbstractRepository<Type, Integer> implements ITypeRepository {
    public TypeRepository() {
        super(App.getDaoSession().getTypeDao());
    }
}
