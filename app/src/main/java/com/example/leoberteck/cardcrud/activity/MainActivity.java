package com.example.leoberteck.cardcrud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.leoberteck.cardcrud.BR;
import com.example.leoberteck.cardcrud.R;
import com.example.leoberteck.cardcrud.databinding.ActivityMainBinding;
import com.example.leoberteck.cardcrud.utils.DependencyCacheHelper;

import static com.example.leoberteck.cardcrud.mvp.MainMvp.*;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private IMainPresenter presenter = DependencyCacheHelper.getInstance(IMainPresenter.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.setMainActivity(this);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setVariable(BR.viewModel, presenter.getBindingBean());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.activity_model_form_save);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            openModelForm(null);
            }
        });
    }

    @Override
    public void openModelForm(Long modelId) {
        Intent intent = new Intent(MainActivity.this, ModelFormActivity.class);
        intent.putExtra("modelId", modelId);
        startActivity(intent);
        DependencyCacheHelper.disposeInstance(IMainPresenter.class);
    }
}
