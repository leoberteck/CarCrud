package com.example.leoberteck.cardcrud.repository.interfaces;

import android.graphics.PorterDuff;

import com.example.leoberteck.cardcrud.entity.Model;
import com.example.leoberteck.cardcrud.exceptions.EntityValidationException;

/**
 * Created by Trovata on 22/07/2017.
 */

public interface IModelRepository extends IAbstractRepository<Model, Long> {
    void validate(Model model) throws EntityValidationException;
}
