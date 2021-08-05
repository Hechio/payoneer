package com.stevehechio.apps.payoneer.ui.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by stevehechio on 8/3/21
 */
public class BaseViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void addToDisposable(Disposable disposable){
        compositeDisposable.remove(disposable);
        compositeDisposable.add(disposable);

    }

    public void onStop(){
        compositeDisposable.clear();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        onStop();
    }
}
