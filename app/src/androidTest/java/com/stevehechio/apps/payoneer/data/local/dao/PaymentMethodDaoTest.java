package com.stevehechio.apps.payoneer.data.local.dao;

import static org.junit.Assert.*;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.stevehechio.apps.payoneer.data.local.db.AppDatabaseTest;
import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stevehechio on 8/5/21
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class PaymentMethodDaoTest extends AppDatabaseTest {

    @Test
    public void insertAndGetPaymentMethod() {
        List<PaymentMethodEntity> entities = new ArrayList<>();
        PaymentMethodEntity entity = new PaymentMethodEntity();
        entity.setCode("AMEX");
        entity.setLabel("American Express");
        entities.add(entity);

        PaymentMethodEntity entity1 = new PaymentMethodEntity();
        entity1.setCode("AMEX");
        entity1.setLabel("American Express");
        entities.add(entity1);
        database.paymentMethodDao().insertPaymentMethod(entities);
        List<PaymentMethodEntity> entities1 = database.paymentMethodDao().getAllPaymentMethods().blockingFirst();
        Assert.assertEquals(entity1.getCode(),entities1.get(0).getCode());
        Assert.assertEquals(entity1.getLabel(),entities1.get(0).getLabel());
    }
}