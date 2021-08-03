package com.stevehechio.apps.payoneer.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.stevehechio.apps.payoneer.data.local.dao.PaymentMethodDao;
import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;

/**
 * Created by stevehechio on 8/3/21
 */

@Database(entities = {PaymentMethodEntity.class},version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
public abstract PaymentMethodDao paymentMethodDao();
}
