package com.example.leoberteck.cardcrud.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.leoberteck.cardcrud.BR;
import com.example.leoberteck.cardcrud.R;
import com.example.leoberteck.cardcrud.databinding.ActivityModelFormBinding;
import com.example.leoberteck.cardcrud.dialogs.CreateNewDialog;
import com.example.leoberteck.cardcrud.utils.DependencyCacheHelper;

import static com.example.leoberteck.cardcrud.mvp.ModelFormMvp.IModelFormActivity;
import static com.example.leoberteck.cardcrud.mvp.ModelFormMvp.IModelFormPresenter;

public class ModelFormActivity extends AppCompatActivity implements IModelFormActivity {

    private IModelFormPresenter presenter = DependencyCacheHelper.getInstance(IModelFormPresenter.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.setModelFromActivity(this);
        ActivityModelFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_model_form);
        binding.setVariable(BR.viewModel, presenter.getBindingBean());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Long modelId = null;
        Intent intent = getIntent();
        if(intent != null && intent.getExtras() != null && intent.getExtras().containsKey("modelId")){
            modelId = intent.getExtras().getLong("modelId");
        }
        presenter.setModel(modelId);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing()){
            DependencyCacheHelper.disposeInstance(IModelFormPresenter.class);
        }
    }

    @Override
    public void requestNewBrand() {
        CreateNewDialog newBrandDialog = new CreateNewDialog();
        newBrandDialog.setListener(new CreateNewDialog.OnCreateDialogConfirmListener() {
            @Override
            public void onCreateDialogConfirm(String newName) {
                presenter.saveNewBrand(newName);
            }
        });
        newBrandDialog.show(getSupportFragmentManager(), null);
    }

    @Override
    public void requestNewType() {
        CreateNewDialog newTypeDialog = new CreateNewDialog();
        newTypeDialog.setListener(new CreateNewDialog.OnCreateDialogConfirmListener() {
            @Override
            public void onCreateDialogConfirm(String newName) {
                presenter.saveNewType(newName);
            }
        });
        newTypeDialog.show(getSupportFragmentManager(), null);
    }

    @Override
    public void goBack() {
        finish();
    }

    @Override
    public void showError(@StringRes int message) {
        new AlertDialog.Builder(this)
        .setTitle(R.string.altert_dialog_title)
        .setMessage(message)
        .setCancelable(false)
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        })
        .show();
    }
}
