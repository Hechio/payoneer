package com.stevehechio.apps.payoneer.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.stevehechio.apps.payoneer.R;
import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;
import com.stevehechio.apps.payoneer.databinding.ItemPaymentMethodsListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stevehechio on 8/3/21
 */
public class PaymentMethodsAdapter extends RecyclerView.Adapter<PaymentMethodsAdapter.PaymentMethodHolder> {
    private List<PaymentMethodEntity> paymentMethodEntities;
    private Context context;

    public PaymentMethodsAdapter(Context context) {
        this.context = context;
    }

    public void setPaymentMethodEntities(List<PaymentMethodEntity> paymentMethodEntities) {
        this.paymentMethodEntities = paymentMethodEntities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PaymentMethodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaymentMethodHolder(ItemPaymentMethodsListBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentMethodHolder holder, int position) {
        holder.bindViews(paymentMethodEntities.get(position),context);
    }

    @Override
    public int getItemCount() {
        return paymentMethodEntities == null ? 0 : paymentMethodEntities.size();
    }

    protected static class PaymentMethodHolder extends RecyclerView.ViewHolder {
        private final ItemPaymentMethodsListBinding paymentMethodsListBinding;
        public PaymentMethodHolder(@NonNull ItemPaymentMethodsListBinding paymentMethodsListBinding) {
            super(paymentMethodsListBinding.getRoot());
            this.paymentMethodsListBinding = paymentMethodsListBinding;
        }

        public void bindViews(PaymentMethodEntity paymentMethodEntity, Context context){
            if (paymentMethodEntity == null)return;
            paymentMethodsListBinding.tvPayment.setText(paymentMethodEntity.getLabel());
            String url = paymentMethodEntity.getLinks().getLogo();
            if (url == null)return;
            Glide.with(context).load(url).error(R.mipmap.ic_launcher)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                    Target<Drawable> target, boolean isFirstResource) {
                            paymentMethodsListBinding.pb.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model,
                                                       Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            paymentMethodsListBinding.pb.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(paymentMethodsListBinding.ivPayment);

        }
    }
}
