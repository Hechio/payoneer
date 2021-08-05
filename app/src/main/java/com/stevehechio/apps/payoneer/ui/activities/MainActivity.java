package com.stevehechio.apps.payoneer.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.stevehechio.apps.payoneer.R;
import com.stevehechio.apps.payoneer.data.local.entities.PaymentMethodEntity;
import com.stevehechio.apps.payoneer.databinding.ActivityMainBinding;
import com.stevehechio.apps.payoneer.factory.ViewModelFactory;
import com.stevehechio.apps.payoneer.ui.adapter.PaymentMethodsAdapter;
import com.stevehechio.apps.payoneer.ui.viewmodel.PaymentMethodViewModel;
import com.stevehechio.apps.payoneer.utils.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


public class MainActivity extends AppCompatActivity {
    @Inject
    ViewModelFactory viewModelFactory;

    private ActivityMainBinding binding;


    private PaymentMethodViewModel paymentMethodViewModel;
    private PaymentMethodsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpViews();
        setUpViewModel();
    }


    private void setUpViews() {
        adapter = new PaymentMethodsAdapter(getApplicationContext());
        binding.rvPayMethods.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvPayMethods.setAdapter(adapter);
    }

    private void setUpViewModel() {
    paymentMethodViewModel = new ViewModelProvider(this,viewModelFactory)
            .get(PaymentMethodViewModel.class);
    paymentMethodViewModel.getPaymentMethodLiveDate().observe(this, response ->{
        if (response.isLoading()){
            onShowLoading();
        }else if (!response.data.isEmpty()){
            onShowData(response.data);
        }else {
            onErrorOccurred(response.message);
        }
    });
    paymentMethodViewModel.loadPaymentMethods();
    }

    private void onErrorOccurred(String message) {
        binding.pbMain.setVisibility(View.GONE);
        binding.tvInfo.setVisibility(View.VISIBLE);
        binding.rvPayMethods.setVisibility(View.GONE);
        binding.tvInfo.setText(message);
        if (!NetworkUtils.isNetworkAvailable(getApplicationContext())){
            binding.tvInfo.setText(getString(R.string.please_check_your_network));
        }else {
            binding.tvInfo.setText(message);
        }
    }

    private void onShowData(List<PaymentMethodEntity> data) {
        adapter.setPaymentMethodEntities(data);
        binding.pbMain.setVisibility(View.GONE);
        binding.tvInfo.setVisibility(View.GONE);
        binding.rvPayMethods.setVisibility(View.VISIBLE);
    }

    private void onShowLoading() {
        binding.pbMain.setVisibility(View.VISIBLE);
        binding.tvInfo.setVisibility(View.GONE);
        binding.rvPayMethods.setVisibility(View.GONE);
    }

}