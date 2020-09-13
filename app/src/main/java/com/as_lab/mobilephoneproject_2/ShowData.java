package com.as_lab.mobilephoneproject_2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.as_lab.mobilephoneproject_2.databinding.ActivityShowDataBinding;

public class ShowData extends AppCompatActivity {

    private ActivityShowDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_data);

        binding.tvBuyerNameId.setText("AAAAAAAAAAAAAAAAAAAA");

        SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);

        binding.tvBuyerNameId.setText(preferences.getString("first_name ","")+preferences.getString("last_name",""));
        binding.tvBuyForId.setText(preferences.getString("mobile_for",""));
        binding.tvModelId.setText(preferences.getString("model",""));
        binding.tvBirthId.setText(preferences.getString("day","")+preferences.getString("month","")+preferences.getString("year",""));
        binding.tvGenderId.setText(preferences.getString("gender",""));
        binding.tvImeiId.setText(preferences.getString("imei",""));

    }
}