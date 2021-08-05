package com.stevehechio.apps.payoneer.data.repository;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.stevehechio.apps.payoneer.data.local.dao.PaymentMethodDao;
import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;
import com.stevehechio.apps.payoneer.data.remote.api.PaymentMethodApiService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Flowable;

import static org.mockito.Mockito.when;
/**
 * Created by stevehechio on 8/5/21
 */
@RunWith(MockitoJUnitRunner.class)
public class PaymentMethodRepositoryTest {

    @Mock
    PaymentMethodDao paymentMethodDao;

    @Mock
    PaymentMethodApiService paymentMethodApiService;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private PaymentMethodRepository repository;

    @Before
    public void setUp() {
        repository = new PaymentMethodRepository(paymentMethodDao,paymentMethodApiService);
    }

    @Test
    public void loadPaymentMethods() {
        Flowable<List<PaymentMethodEntity>> listFlowable = Flowable.empty();
        when(paymentMethodDao.getAllPaymentMethods()).thenReturn(listFlowable);

    }
}