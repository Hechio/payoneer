package com.stevehechio.apps.payoneer.di.module;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;


import com.stevehechio.apps.payoneer.data.local.dao.PaymentMethodDao;
import com.stevehechio.apps.payoneer.data.local.db.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by stevehechio on 8/3/21
 */
@Module
public class DbModule {
    /**
     * Here we return the Database object
     * */
    @Provides
    @Singleton
    AppDatabase provideDatabase(@NonNull Application application) {
        return Room.databaseBuilder(application,
                AppDatabase.class, "PaymentMethod.db")
                .allowMainThreadQueries().build();
    }


    /**
     * We need the PaymentMethodDao module.
     * For this, We need the AppDatabase object
     * So we will define the providers for this here in this module.
     * */
    @Provides
    @Singleton
    PaymentMethodDao providePaymentDao(@NonNull AppDatabase appDatabase){
        return appDatabase.paymentMethodDao();
    }
}
