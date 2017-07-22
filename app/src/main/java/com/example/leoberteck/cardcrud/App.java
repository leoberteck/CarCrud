package com.example.leoberteck.cardcrud;

import android.app.Application;

import com.example.leoberteck.cardcrud.entity.DaoMaster;
import com.example.leoberteck.cardcrud.entity.DaoSession;

/**
 * Created by Trovata on 22/07/2017.
 */

public final class App extends Application {

    private static App instace;
    private static DaoSession daoSession;
    private static final String DATABASE_NAME = "car_db";

    public static App getInstace() {
        return instace;
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instace = this;
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, DATABASE_NAME);
        daoSession = new DaoMaster(openHelper.getWritableDb()).newSession();
    }
}
