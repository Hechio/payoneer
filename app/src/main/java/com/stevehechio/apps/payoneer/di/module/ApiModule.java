package com.stevehechio.apps.payoneer.di.module;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stevehechio.apps.payoneer.data.remote.api.PaymentMethodApiService;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by stevehechio on 8/3/21
 */

@Module
public class ApiModule {

    /**
     * Here we return the Gson object
     * */
    @Provides
    @Singleton
    Gson provideGson(){
        return new GsonBuilder().create();
    }
    /**
     * Here we return the Cache object
     * */
    @Provides
    @Singleton
    Cache provideCache(Application application){
        long cacheSize = 10 * 1024 * 1024; // 10 MB
        File httpCacheDirectory = new File(application.getCacheDir(), "http-cache");
        return new Cache(httpCacheDirectory, cacheSize);
    }

    /**
     * Here we return the OKhttp object
     * */
    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.cache(cache);
        httpClient.addInterceptor(logging);
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        return httpClient.build();
    }
    /**
     * Here we return the Retrofit object
     * */
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://raw.githubusercontent.com/optile/")
                .client(okHttpClient)
                .build();
    }
    /*
     * We need the PaymentMethodApiService module.
     * For this, We need the Retrofit object, Gson, Cache and OkHttpClient .
     * So we will define the providers for these objects here in this module.
     *
     * */

    @Provides
    @Singleton
    PaymentMethodApiService providePaymentMethodApiService(Retrofit retrofit){
        return retrofit.create(PaymentMethodApiService.class);
    }
}
