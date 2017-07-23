package com.example.leoberteck.cardcrud.mvp;

/**
 * Created by Trovata on 22/07/2017.
 */

public interface ModelFromMvp {

    interface IModelFormActivity {
        void requestNewBrand();
        void requestNewType();
    }

    interface IModelFormPresenter {
        void setModelFromActivity(IModelFormActivity modelFromActivity);
        void setModel(Integer idModel);
        Object getBindingBean();

        void saveNewBrand(String name);
        void saveNewType(String name);
    }
}
