package com.stevehechio.apps.payoneer.data.remote.api;

import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.stevehechio.apps.payoneer.ApiAbstract;
import java.io.IOException;

/**
 * Created by stevehechio on 8/5/21
 */

public class PaymentMethodApiServiceTest extends ApiAbstract<PaymentMethodApiService> {

    private PaymentMethodApiService apiService;

    @Before
    public void setUp() {
        this.apiService = createService(PaymentMethodApiService.class);
    }

    @Test
    public void testToFetchPaymentMethods() throws IOException {
        enqueueResponse("test_payment_methods.json");
        PaymentMethodEntity entity = apiService.fetchPaymentMethods().
                blockingFirst().getResult().getPaymentMethodLists().get(0);
        Assert.assertEquals("AMEX",entity.getCode());
        Assert.assertEquals("American Express",entity.getLabel());
    }

}