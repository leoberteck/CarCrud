package com.example.leoberteck.cardcrud.mvp.impl;


import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.example.leoberteck.cardcrud.entity.Brand;
import com.example.leoberteck.cardcrud.entity.Model;
import com.example.leoberteck.cardcrud.entity.Type;
import com.example.leoberteck.cardcrud.repository.interfaces.IBrandRepository;
import com.example.leoberteck.cardcrud.repository.interfaces.IModelRepository;
import com.example.leoberteck.cardcrud.repository.interfaces.ITypeRepository;
import com.example.leoberteck.cardcrud.utils.DependencyCacheHelper;
import com.example.leoberteck.cardcrud.utils.ExtendedBaseObservable;

import java.lang.ref.WeakReference;
import java.util.List;

import static com.example.leoberteck.cardcrud.mvp.ModelFormMvp.*;

/**
 * Created by Trovata on 22/07/2017.
 */

public class ModelFormPresenter extends ExtendedBaseObservable implements IModelFormPresenter {

    private WeakReference<IModelFormActivity> modelFormActivityWeakReference;

    private List<Brand> brandList;
    private List<Type> typeList;

    private Integer selectedBrandPosition;
    private Integer selectedTypePosition;

    private Integer idModel;
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
        modelFormActivityWeakReference = new WeakReference<>(modelFromActivity);
    }

    @Override
    public void setModel(Integer idModel) {
        this.idModel = idModel;
        if(idModel != null && idModel > 0){
            Model model = modelRepository.load(idModel);
            if(model != null){
                setName(model.getName());
                setWeight(model.getWeight());
                setPrice(model.getPrice());
                idBrand = model.getIdBrand();
                idType = model.getIdType();
            }
        } else {
            setName(null);
            setWeight(0);
            setPrice(0);
            idBrand = null;
            idType = null;
        }
        refreshBrandList();
        refreshTypeList();
    }

    private void refreshBrandList(){
        refreshBrandList(idBrand);
    }

    private void refreshBrandList(Integer desiredId){
        setBrandList(brandRepository.loadAll());
        int index = 0;
        if(desiredId != null && desiredId > 0){
            for (Brand brand : brandList) {
                if(brand.getId().equals(desiredId)){
                    index = brandList.indexOf(brand);
                    break;
                }
            }
        }
        setSelectedBrandPosition(index);
    }

    private void refreshTypeList(){
        refreshTypeList(idType);
    }

    private void refreshTypeList(Integer desiredId){
        setTypeList(typeRepository.loadAll());
        int index = 0;
        if(desiredId != null && desiredId > 0){
            for (Type type : typeList) {
                if(type.getId().equals(desiredId)){
                    index = typeList.indexOf(type);
                    break;
                }
            }
        }
        setSelectedTypePosition(index);
    }

    @Override
    public Object getBindingBean() {
        return this;
    }

    @Override
    public void saveNewBrand(String name) {
        Brand newBrand = new Brand(null, name);
        int newId = (int)brandRepository.insert(newBrand);
        refreshBrandList(newId);
    }

    @Override
    public void saveNewType(String name) {
        Type newType = new Type(null, name);
        int newId = (int)typeRepository.insert(newType);
        refreshTypeList(newId);
    }

    public void saveNewModel(){
        Model newModel = new Model(idModel, name, weight, price, idBrand, idType);
        modelRepository.save(newModel);
        if(modelFormActivityWeakReference.get() != null)
            modelFormActivityWeakReference.get().goBack();
    }

    public void requestNewBrand(){
        if(modelFormActivityWeakReference.get() != null)
            modelFormActivityWeakReference.get().requestNewBrand();
    }

    public void requestNewType(){
        if(modelFormActivityWeakReference.get() != null)
            modelFormActivityWeakReference.get().requestNewType();
    }

    @Bindable
    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
        notifyPropertyChanged(BR.brandList);
    }

    @Bindable
    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
        notifyPropertyChanged(BR.typeList);
    }

    @Bindable
    public Integer getSelectedBrandPosition() {
        return selectedBrandPosition;
    }

    public void setSelectedBrandPosition(Integer selectedBrandPosition) {
        this.selectedBrandPosition = selectedBrandPosition;
        if(selectedBrandPosition != null){
            idBrand = brandList.get(selectedBrandPosition).getId();
        }
        notifyPropertyChanged(BR.selectedBrandPosition);
    }

    @Bindable
    public Integer getSelectedTypePosition() {
        return selectedTypePosition;
    }

    public void setSelectedTypePosition(Integer selectedTypePosition) {
        this.selectedTypePosition = selectedTypePosition;
        if(selectedTypePosition != null){
            idType = typeList.get(selectedTypePosition).getId();
        }
        notifyPropertyChanged(BR.selectedTypePosition);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @Bindable
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
    }
}
