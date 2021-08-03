package com.stevehechio.apps.payoneer.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.stevehechio.apps.payoneer.factory.ViewModelFactory;
import com.stevehechio.apps.payoneer.ui.viewmodel.PaymentMethodViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by stevehechio on 8/3/21
 */

@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModel(ViewModelFactory factory);

    /**
     * injects this object into a Map using the @IntoMap annotation,
     * with the  PaymentMethodViewModel.class as key,
     * and a Provider that will build a PaymentMethodViewModel
     * object.
     *
     * */

    @Binds
    @IntoMap
    @ViewModelKey(PaymentMethodViewModel.class)
    protected abstract ViewModel movieListViewModel(PaymentMethodViewModel moviesListViewModel);
}
