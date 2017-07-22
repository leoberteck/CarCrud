package com.example.leoberteck.cardcrud.utils;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Trovata on 22/07/2017.
 */

@InverseBindingMethods({
        @InverseBindingMethod(type = AppCompatSpinner.class, attribute = "android:selectedItemPosition"),
})
public abstract class ExtendedBaseObservable extends BaseObservable {

    @BindingAdapter("selectedItemPositionAttrChanged")
    public void setSelectedItemPositionListener(AppCompatSpinner view, final InverseBindingListener selectedItemPositionChange) {
        if (selectedItemPositionChange == null) {
            view.setOnItemSelectedListener(null);
        } else {
            view.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    selectedItemPositionChange.onChange();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    @InverseBindingAdapter(attribute = "selectedItemPosition")
    public Integer getSelectedItemPosition(AppCompatSpinner spinner) {
        return spinner.getSelectedItemPosition();
    }

}
