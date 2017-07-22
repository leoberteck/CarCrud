package com.example.leoberteck.cardcrud.repository.impl;

import com.example.leoberteck.cardcrud.App;
import com.example.leoberteck.cardcrud.entity.Model;
import com.example.leoberteck.cardcrud.repository.interfaces.IModelRepository;


/**
 * Created by Trovata on 22/07/2017.
 */

public class ModelRepository extends AbstractRepository<Model, Integer> implements IModelRepository {
    public ModelRepository() {
        super(App.getDaoSession().getModelDao());
    }
}
