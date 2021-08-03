package com.stevehechio.apps.payoneer.data;

import static com.stevehechio.apps.payoneer.data.Status.ERROR;
import static com.stevehechio.apps.payoneer.data.Status.LOADING;
import static com.stevehechio.apps.payoneer.data.Status.SUCCESS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by stevehechio on 8/3/21
 */
public class Resource<T> {
    @NonNull
    public final T data;

    @NonNull
    public final Status status;

    @Nullable
    public final String message;

    public Resource(@NonNull T data, @NonNull Status status, @Nullable String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }
    public static <T> Resource<T> success(@NonNull T data){
        return new Resource<>(data,SUCCESS,null);
    }
    public static <T> Resource<T> error(String msg, @Nullable T data) {
        assert data != null;
        return new Resource<>( data,ERROR,msg);
    }
    public static <T> Resource<T> loading(@Nullable T data) {
        assert data != null;
        return new Resource<>( data, LOADING,null);
    }

    public boolean isSuccess() {
        return status == Status.SUCCESS;
    }

    public boolean isLoading() {
        return status == LOADING;
    }

    public boolean isLoaded() {
        return status != LOADING;
    }
}
