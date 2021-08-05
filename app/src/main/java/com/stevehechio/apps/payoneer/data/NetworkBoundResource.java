package com.stevehechio.apps.payoneer.data;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by stevehechio on 8/3/21
 */
public abstract class NetworkBoundResource<ResultType, RequestType> {
    private Observable<Resource<ResultType>> result;

    @MainThread
    protected NetworkBoundResource(){
        Observable<Resource<ResultType>> source;
        if (shouldFetch()){
        source = createCall().subscribeOn(Schedulers.io())
                .doOnNext(apiResponse -> saveCallResult(processResponse(apiResponse)))
                .flatMap(apiResponse -> loadFromDb().toObservable().map(Resource::success))
                .doOnError(throwable -> onFetchFailed())
                .onErrorResumeNext(throwable -> {
                    return loadFromDb().toObservable().map(data -> Resource.error(throwable.getLocalizedMessage(),data));
                }).observeOn(AndroidSchedulers.mainThread());
        }else {
            source = loadFromDb().toObservable().map(Resource::success);
        }

        result = Observable.concat(loadFromDb().toObservable().map(Resource::loading).take(1),source);
    }


    @MainThread
    protected abstract boolean shouldFetch();

    @NonNull
    @MainThread
    protected abstract Flowable<ResultType> loadFromDb();

    @WorkerThread
    protected abstract void  saveCallResult(@NonNull RequestType item);

    @WorkerThread
    protected  RequestType processResponse(Resource<RequestType> response){ return  response.data;}

    protected void onFetchFailed(){}

    public Observable<Resource<ResultType>> getAsObservable() {
        return result;
    }

    @NonNull
    @MainThread
    protected abstract Observable<Resource<RequestType>> createCall();
}
