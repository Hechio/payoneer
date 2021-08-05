package com.stevehechio.apps.payoneer.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.stevehechio.apps.payoneer.data.Resource;
import com.stevehechio.apps.payoneer.data.local.dao.PaymentMethodDao;
import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;
import com.stevehechio.apps.payoneer.data.remote.api.PaymentMethodApiService;
import com.stevehechio.apps.payoneer.data.repository.PaymentMethodRepository;
import com.stevehechio.apps.payoneer.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by stevehechio on 8/3/21
 */
public class PaymentMethodViewModel extends BaseViewModel {
    private final PaymentMethodRepository paymentMethodRepository;
    private final MutableLiveData<Resource<List<PaymentMethodEntity>>> paymentMethodLiveDate = new MutableLiveData<>();

    //inject PaymentMethodDao and PaymentApiService classes to this viewModel

    @Inject
    public PaymentMethodViewModel(PaymentMethodDao paymentMethodDao,
                                  PaymentMethodApiService paymentMethodApiService) {
        paymentMethodRepository = new PaymentMethodRepository(paymentMethodDao,paymentMethodApiService);
    }

    public void loadPaymentMethods(){
        addToDisposable( paymentMethodRepository.loadPaymentMethods()
                .subscribe(resource -> getPaymentMethodLiveDate().postValue(resource)));

    }

    public MutableLiveData<Resource<List<PaymentMethodEntity>>> getPaymentMethodLiveDate() {
        return paymentMethodLiveDate;
    }
}
