package com.as_lab.mobilephoneproject_2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.as_lab.mobilephoneproject_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String mobileFor, f_name, l_name, date, month, year, gender, mobile_name, model, imei, price, address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.reqSubmitBtn.setOnClickListener((View view)->{
            CheckData();
        });
        binding.showUserBtn.setOnClickListener((View view)->{
            startActivity(new Intent(getApplicationContext(),ShowData.class));
        });
    }
    private void CheckData() {
        mobileFor = binding.radioSelf.getText().toString();
        mobileFor = binding.radioOther.getText().toString();
        gender = binding.radioMale.getText().toString();
        gender = binding.radioFemale.getText().toString();
        f_name = binding.regiFirstName.getText().toString();
        l_name = binding.regiLastName.getText().toString();
        date = binding.regiDay.getText().toString();
        month = binding.regiMonth.getText().toString();
        year = binding.regiYear.getText().toString();
        mobile_name = binding.regiMobileNameId.getText().toString();
        model = binding.regiMobileModel.getText().toString();
        imei = binding.regiImei.getText().toString();
        price = binding.regiPrice.getText().toString();
        address = binding.regiAddress.getText().toString();

        if (mobileFor.equals("")){
            Toast.makeText(this, "Please Select Mobile for", Toast.LENGTH_SHORT).show();
        }else if (f_name.equals("")){
            Toast.makeText(this, "Please Enter First Name", Toast.LENGTH_SHORT).show();
        }else if (l_name.equals("")){
            Toast.makeText(this, "Please Enter last name", Toast.LENGTH_SHORT).show();
        }else if (date.equals("")){
            Toast.makeText(this, "Please Enter date", Toast.LENGTH_SHORT).show();
        }else if (month.equals("")){
            Toast.makeText(this, "Please Enter month", Toast.LENGTH_SHORT).show();
        }else if (year.equals("")){
            Toast.makeText(this, "Please Enter year", Toast.LENGTH_SHORT).show();
        }else if (gender.equals("")){
            Toast.makeText(this, "Please Select gender", Toast.LENGTH_SHORT).show();
        }else if (mobile_name.equals("")){
            Toast.makeText(this, "Please Enter Mobile name", Toast.LENGTH_SHORT).show();
        }else if (model.equals("")){
            Toast.makeText(this, "Please Enter Model", Toast.LENGTH_SHORT).show();
        }else if (imei.equals("")){
            Toast.makeText(this, "Please IMEI", Toast.LENGTH_SHORT).show();
        }else if (price.equals("")){
            Toast.makeText(this, "Please Enter price", Toast.LENGTH_SHORT).show();
        }else if (address.equals("")){
            Toast.makeText(this, "Please Address", Toast.LENGTH_SHORT).show();
        }else {
            SaveData();
        }
    }
    private void SaveData() {
        SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =preferences.edit();

        editor.putString("mobile_for", mobileFor);
        editor.putString("first_name", f_name);
        editor.putString("last_name",l_name);
        editor.putString("date",date);
        editor.putString("month",month);
        editor.putString("year",year);
        editor.putString("gender",gender);
        editor.putString("mobile_name",mobile_name);
        editor.putString("model",model);
        editor.putString("imei",imei);
        editor.putString("price",price);
        editor.putString("address",address);

        editor.apply();

        startActivity(new Intent(getApplicationContext(),ShowData.class));
    }

}