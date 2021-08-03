package com.stevehechio.apps.payoneer.data.local.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;

import java.lang.reflect.Type;

/**
 * Created by stevehechio on 8/3/21
 */
public class LinkConverters {
    @TypeConverter
    public static PaymentMethodEntity.Links fromString(String value) {
        Type listType = new TypeToken<PaymentMethodEntity.Links>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromObject(PaymentMethodEntity.Links list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
