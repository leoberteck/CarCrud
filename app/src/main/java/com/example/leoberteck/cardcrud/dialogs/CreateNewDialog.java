package com.example.leoberteck.cardcrud.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import com.example.leoberteck.cardcrud.R;

/**
 * Created by leo on 23/07/17.
 */

public class CreateNewDialog extends DialogFragment {

    private OnCreateDialogConfirmListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
            .setTitle(R.string.dialog_create_new_title)
            .setView(R.layout.dialog_create_new)
            .setCancelable(true)
            .setPositiveButton(R.string.dialog_create_confirm, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    EditText editText = CreateNewDialog.this.getDialog().findViewById(R.id.dialog_create_new_name);
                    String name = editText != null && editText.getText() != null ? editText.getText().toString() : null;
                    if(listener != null)
                        listener.onCreateDialogConfirm(name);
                }
            }).create();
        return alertDialog;
    }

    public interface OnCreateDialogConfirmListener{
        void onCreateDialogConfirm(String newName);
    }

    public void setListener(OnCreateDialogConfirmListener listener) {
        this.listener = listener;
    }
}
