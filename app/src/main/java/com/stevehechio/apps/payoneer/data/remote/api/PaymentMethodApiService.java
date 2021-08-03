package com.stevehechio.apps.payoneer.data.remote.api;

import com.stevehechio.apps.payoneer.data.remote.model.PaymentMethodApiResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by stevehechio on 8/3/21
 */

public interface PaymentMethodApiService  {
    @GET("checkout-android/develop/shared-test/lists/listresult.json")
    Observable<PaymentMethodApiResponse> fetchPaymentMethods();
}
