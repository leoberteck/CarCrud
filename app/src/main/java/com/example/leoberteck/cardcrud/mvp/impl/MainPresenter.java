package com.example.leoberteck.cardcrud.mvp.impl;

import android.databinding.Bindable;

import com.example.leoberteck.cardcrud.adapter.ModelAdapter;
import com.example.leoberteck.cardcrud.entity.Model;
import com.example.leoberteck.cardcrud.repository.interfaces.IModelRepository;
import com.example.leoberteck.cardcrud.utils.DependencyCacheHelper;
import com.example.leoberteck.cardcrud.utils.ExtendedBaseObservable;

import java.lang.ref.WeakReference;

import static com.example.leoberteck.cardcrud.mvp.MainMvp.*;

/**
 * Created by Trovata on 29/07/2017.
 */

public class MainPresenter extends ExtendedBaseObservable implements IMainPresenter, ModelAdapter.IModelAdapterEventListener {

    private WeakReference<IMainActivity> mainActivityWeakReference;
    private ModelAdapter adapter;

    private IModelRepository modelRepository = DependencyCacheHelper.getInstance(IModelRepository.class);

    @Override
    public void setMainActivity(IMainActivity mainActivity) {
        mainActivityWeakReference = new WeakReference<>(mainActivity);
    }

    @Override
    public Object getBindingBean() {
        return this;
    }

    @Override
    public void onItemEditRequest(Model model) {
        if(mainActivityWeakReference.get() != null)
            mainActivityWeakReference.get().openModelForm(model.getId());
    }

    @Override
    public void onItemRemoveRequest(Model model) {

    }

    @Bindable
    public ModelAdapter getAdapter() {
        if(adapter == null){
            adapter = new ModelAdapter(modelRepository.loadAll());
            adapter.setEventListener(this);
        }
        return adapter;
    }
}
