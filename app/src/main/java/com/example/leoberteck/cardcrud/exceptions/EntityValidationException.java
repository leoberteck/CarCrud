package com.example.leoberteck.cardcrud.exceptions;

import android.support.annotation.StringRes;

/**
 * Created by Trovata on 29/07/2017.
 */

public class EntityValidationException extends Exception {
    private int messageRes;

    public EntityValidationException(@StringRes int messageRes) {
        this.messageRes = messageRes;
    }

    public int getMessageRes() {
        return messageRes;
    }
}
