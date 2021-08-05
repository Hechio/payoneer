package com.stevehechio.apps.payoneer.data.remote.api;

import static org.junit.Assert.*;

import com.stevehechio.apps.payoneer.ApiAbstract;
import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * Created by stevehechio on 8/5/21
 */
@RunWith(JUnit4.class)
public class PaymentMethodApiServiceTest extends ApiAbstract<PaymentMethodApiService> {

    private PaymentMethodApiService apiService;

    @Before
    public void setUp() throws Exception {
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