package com.example.leoberteck.cardcrud.repository.impl;

import com.example.leoberteck.cardcrud.App;
import com.example.leoberteck.cardcrud.R;
import com.example.leoberteck.cardcrud.entity.Model;
import com.example.leoberteck.cardcrud.exceptions.EntityValidationException;
import com.example.leoberteck.cardcrud.repository.interfaces.IModelRepository;


/**
 * Created by Trovata on 22/07/2017.
 */

public class ModelRepository extends AbstractRepository<Model, Long> implements IModelRepository {
    public ModelRepository() {
        super(App.getDaoSession().getModelDao());
    }

    @Override
    public void validate(Model model) throws EntityValidationException {
        if(model == null){
            throw new EntityValidationException(R.string.model_repository_validade_model_null);
        }else if(model.getName() == null){
            throw new EntityValidationException(R.string.model_repository_validade_model_name_null);
        }else if(model.getIdBrand() == null){
            throw new EntityValidationException(R.string.model_repository_validade_model_brand_null);
        }else if(model.getIdType() == null){
            throw new EntityValidationException(R.string.model_repository_validade_model_type_null);
        }else if(model.getPrice() == 0){
            throw new EntityValidationException(R.string.model_repository_validade_model_price_zero);
        }else if(model.getWeight() == 0){
            throw new EntityValidationException(R.string.model_repository_validade_model_weight_zero);
        }
    }
}
