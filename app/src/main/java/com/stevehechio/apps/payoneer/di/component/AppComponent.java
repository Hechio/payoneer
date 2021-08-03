package com.stevehechio.apps.payoneer.di.component;

import android.app.Application;

import com.stevehechio.apps.payoneer.Payoneer;
import com.stevehechio.apps.payoneer.di.module.ActivityModule;
import com.stevehechio.apps.payoneer.di.module.ApiModule;
import com.stevehechio.apps.payoneer.di.module.DbModule;
import com.stevehechio.apps.payoneer.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by stevehechio on 8/3/21
 */

/** @Component defines the connection between the modules and
 * the classes which need the dependency.
 * AndroidSupportInjectionModule.class
 * is an internal class in Dagger 2.10.
 * * Provides our activities and fragments with given module.**/

@Component(modules = {ActivityModule.class, ApiModule.class, DbModule.class, ViewModelModule.class,
        AndroidSupportInjectionModule.class})

@Singleton
public interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    void inject(Payoneer payoneer);
}
