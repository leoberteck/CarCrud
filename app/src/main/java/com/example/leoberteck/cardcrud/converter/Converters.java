package com.example.leoberteck.cardcrud.converter;

import android.content.Intent;
import android.databinding.InverseMethod;
import android.renderscript.Double2;
import android.support.annotation.StringRes;

/**
 * Created by Trovata on 26/07/2017.
 */

public class Converters {

//    @InverseMethod("toInt")
//    public static String toString(Integer intval) {
//        return String.valueOf(intval);
//    }
//
//    public static Integer toInt(String string) {
//        return string.isEmpty() ? 0 : Integer.parseInt(string);
//    }

    @InverseMethod("toDouble")
    public static String toString(double doubleval){
        return String.valueOf(doubleval);
    }

    public static double toDouble(String string) {
        return string.isEmpty() ? 0 : Double.parseDouble(string);
    }
}
