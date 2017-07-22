package com.example.leoberteck.cardcrud.mvp.impl;


import android.databinding.Bindable;
import android.view.WindowManager;

import com.example.leoberteck.cardcrud.entity.Brand;
import com.example.leoberteck.cardcrud.entity.Type;
import com.example.leoberteck.cardcrud.repository.interfaces.IBrandRepository;
import com.example.leoberteck.cardcrud.repository.interfaces.IModelRepository;
import com.example.leoberteck.cardcrud.repository.interfaces.ITypeRepository;
import com.example.leoberteck.cardcrud.utils.DependencyCacheHelper;
import com.example.leoberteck.cardcrud.utils.ExtendedBaseObservable;

import java.lang.ref.WeakReference;
import java.util.List;

import static com.example.leoberteck.cardcrud.mvp.ModelFromMvp.*;

/**
 * Created by Trovata on 22/07/2017.
 */

public class ModelFormPresenter extends ExtendedBaseObservable implements IModelFormPresenter {

    private WeakReference<IModelFormActivity> modelFormActivityWeakReference;

    private List<Brand> brandList;
    private List<Type> typeList;

    private Integer selectedBrandPosition;
    private Integer selectedTypePosition;

    private String name;
    private double price;
    private double weight;
    private Integer idBrand;
    private Integer idType;

    private IBrandRepository brandRepository = DependencyCacheHelper.getInstance(IBrandRepository.class);
    private ITypeRepository typeRepository = DependencyCacheHelper.getInstance(ITypeRepository.class);
    private IModelRepository modelRepository = DependencyCacheHelper.getInstance(IModelRepository.class);

    @Override
    public void setModelFromActivity(IModelFormActivity modelFromActivity) {
        modelFormActivityWeakReference = new WeakReference<IModelFormActivity>(modelFromActivity);
    }

    @Override
    public void setModel(Integer idModel) {

    }

    @Override
    public Object getBindingBean() {
        return null;
    }

    @Bindable
    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
        notifyPropertyChanged();
    }

    @Bindable
    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
        notifyPropertyChanged();
    }

    @Bindable
    public Integer getSelectedBrandPosition() {
        return selectedBrandPosition;
    }

    public void setSelectedBrandPosition(Integer selectedBrandPosition) {
        this.selectedBrandPosition = selectedBrandPosition;
        notifyPropertyChanged();
    }

    @Bindable
    public Integer getSelectedTypePosition() {
        return selectedTypePosition;
    }

    public void setSelectedTypePosition(Integer selectedTypePosition) {
        this.selectedTypePosition = selectedTypePosition;
        notifyPropertyChanged();
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged();
    }

    @Bindable
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyPropertyChanged();
    }

    @Bindable
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        notifyPropertyChanged();
    }
}
