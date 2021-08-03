package com.stevehechio.apps.payoneer.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stevehechio on 8/3/21
 */
public class PaymentMethodApiResponse {
    @SerializedName("networks")
    @Expose
    private Result result;


    public PaymentMethodApiResponse() {
    this.result = new Result();
    }

    public Result getResult() {
        return result;
    }

    public static class Result {
        @SerializedName("applicable")
        @Expose
        private List<PaymentMethodEntity> paymentMethods;

        public List<PaymentMethodEntity> getPaymentMethodLists() {
            return paymentMethods;
        }
    }
}
