package com.example.leoberteck.cardcrud.mvp;

import android.databinding.ObservableDouble;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Trovata on 29/07/2017.
 */

public interface MainMvp {
    interface IMainActivity{
        void openModelForm(Long modelId);
    }

    interface IMainPresenter{
        void setMainActivity(IMainActivity mainActivity);
        Object getBindingBean();
    }
}
