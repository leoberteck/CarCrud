package com.example.leoberteck.cardcrud.mvp;

import android.support.annotation.StringRes;

/**
 * Created by Trovata on 22/07/2017.
 */

public interface ModelFormMvp {

    interface IModelFormActivity {
        void requestNewBrand();
        void requestNewType();
        void goBack();

        void showError(@StringRes int message);
    }

    interface IModelFormPresenter {
        void setModelFromActivity(IModelFormActivity modelFromActivity);
        void setModel(Long idModel);
        Object getBindingBean();

        void saveNewBrand(String name);
        void saveNewType(String name);
    }
}
