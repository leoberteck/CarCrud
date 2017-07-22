package com.example.leoberteck.cardcrud.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.leoberteck.cardcrud.R;
import com.example.leoberteck.cardcrud.utils.DependencyCacheHelper;

import static com.example.leoberteck.cardcrud.mvp.ModelFromMvp.*;

public class ModelFormActivity extends AppCompatActivity implements IModelFormActivity {

    private IModelFormPresenter presenter = DependencyCacheHelper.getInstance(IModelFormPresenter.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
}
