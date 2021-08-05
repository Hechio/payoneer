package com.stevehechio.apps.payoneer.data.local.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stevehechio.apps.payoneer.data.local.converters.LinkConverters;

import java.io.Serializable;

/**
 * Created by stevehechio on 8/3/21
 */


@Entity(indices = {@Index(value = {"code"}, unique = true)})
public class PaymentMethodEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("links")
    @Expose
    @TypeConverters(LinkConverters.class)
    private Links links;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public Links getLinks() {
        return links;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public static class Links {
        @SerializedName("logo")
        @Expose
        private String logo;

        public String getLogo() {
            return logo;
        }
    }
}

