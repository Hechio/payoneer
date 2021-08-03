package com.stevehechio.apps.payoneer.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;

import java.util.List;

/**
 * Created by stevehechio on 8/3/21
 */
@Dao
public interface PaymentMethodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertPaymentMethod(List<PaymentMethodEntity> paymentMethods);

    @Query("SELECT * FROM `PaymentMethodEntity`")
    List<PaymentMethodEntity> getAllPaymentMethods();
}
