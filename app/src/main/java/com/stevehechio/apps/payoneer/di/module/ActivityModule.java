package com.stevehechio.apps.payoneer.di.module;

import com.stevehechio.apps.payoneer.ui.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by stevehechio on 8/3/21
 */
@Module
public abstract class ActivityModule {

    /**
     * This allows us to inject things into Activities using AndroidInjection.inject(this)
     * in the onCreate() method.
     * **/
   @ContributesAndroidInjector()
   abstract MainActivity contributeMainActivity();
}
