package com.example.leoberteck.cardcrud.utils;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;

import java.text.DecimalFormat;

/**
 * Created by Trovata on 22/07/2017.
 */

@InverseBindingMethods({
    @InverseBindingMethod(type = AppCompatSpinner.class, attribute = "android:selectedItemPosition"),
    @InverseBindingMethod(type = AppCompatEditText.class, attribute = "android:textDouble")
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


    final DecimalFormat twoPlaceDecimalFormat = new DecimalFormat("#.00");
    @BindingAdapter(value = { "android:textDouble", "android:textDoubleAttrChanged" }, requireAll = false)
    public static void setTextDouble(AppCompatEditText AppCompatEditText, double newValue, final InverseBindingListener inverseBindingListener){
        AppCompatEditText.setText(String.valueOf(newValue));
        AppCompatEditText.setSelection(AppCompatEditText.getText().length());

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                inverseBindingListener.onChange();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        AppCompatEditText.addTextChangedListener(textWatcher);
    }

    @InverseBindingAdapter(attribute = "android:textDouble", event = "android:textDoubleAttrChanged")
    public static double getTextDouble(AppCompatEditText AppCompatEditText){
        Double value = 0D;
        try {
            value = Double.parseDouble(AppCompatEditText.getText().toString());
        } catch (Exception ex){}
        return value;
    }
}
