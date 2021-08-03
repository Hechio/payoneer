package com.stevehechio.apps.payoneer.data.repository;


import androidx.annotation.NonNull;

import com.stevehechio.apps.payoneer.data.NetworkBoundResource;
import com.stevehechio.apps.payoneer.data.Resource;
import com.stevehechio.apps.payoneer.data.local.dao.PaymentMethodDao;
import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;
import com.stevehechio.apps.payoneer.data.remote.api.PaymentMethodApiService;
import com.stevehechio.apps.payoneer.data.remote.model.PaymentMethodApiResponse;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by stevehechio on 8/3/21
 */

@Singleton
public class PaymentMethodRepository {

    private PaymentMethodDao paymentMethodDao;
    private PaymentMethodApiService paymentMethodApiService;

    public PaymentMethodRepository(PaymentMethodDao paymentMethodDao, PaymentMethodApiService paymentMethodApiService) {
        this.paymentMethodDao = paymentMethodDao;
        this.paymentMethodApiService = paymentMethodApiService;
    }

    public Observable<Resource<List<PaymentMethodEntity>>> loadPaymentMethods(){
        return new NetworkBoundResource<List<PaymentMethodEntity>, PaymentMethodApiResponse>() {
            @Override
            protected boolean shouldFetch() {
                return true;
            }

            @NonNull
            @Override
            protected Flowable<List<PaymentMethodEntity>> loadFromDb() {
                List<PaymentMethodEntity> paymentMethodEntities = paymentMethodDao.getAllPaymentMethods();
                if (paymentMethodEntities == null || paymentMethodEntities.isEmpty()){
                    return Flowable.empty();
                }
                return Flowable.just(paymentMethodEntities);
            }

            @Override
            protected void saveCallResult(@NonNull PaymentMethodApiResponse item) {
                paymentMethodDao.insertPaymentMethod(item.getResult().getPaymentMethodLists());
            }

            @NonNull
            @Override
            protected Observable<Resource<PaymentMethodApiResponse>> createCall() {
                return paymentMethodApiService.fetchPaymentMethods()
                        .flatMap(response ->
                                Observable.just(response == null ? Resource.error("Something went wrong",
                                        new PaymentMethodApiResponse()) : Resource.success(response)));
            }
        }.getAsObservable();
    }
}
