package com.example.anew.Activity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddCallActivity extends AppCompatActivity {


    private TextInputEditText mEdtPhone;
    private TextInputEditText mEdtName;
    private TextInputEditText mEdtEmail;
    private TextInputEditText mEdtZalo;
    private TextInputEditText mEdtSkype;
    private Spinner mLayoutCity;
    private TextInputEditText mEdtAddress;
    private TextInputEditText mEdtDateOfBirth;
    private TextView mTvSoftWareCare;
    private Spinner mLayoutSoftWareCare;
    private Spinner mLayoutObjCustome;
    private TextInputEditText mEdtSourceCustomer;
    private Spinner mLayoutCustomerType;
    private TextInputEditText mEdtContent;
    private Spinner mLayoutCustomerStatus;
    private TextInputEditText mEdtNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_call);
        initView();


    }


    private void initView() {
        mEdtPhone = findViewById(R.id.edt_phone);
        mEdtName = findViewById(R.id.edt_name);
        mEdtEmail = findViewById(R.id.edt_email);
        mEdtZalo = findViewById(R.id.edt_zalo);
        mEdtSkype = findViewById(R.id.edt_skype);
        mLayoutCity = findViewById(R.id.layoutCity);
        mEdtAddress = findViewById(R.id.edt_address);
        mEdtDateOfBirth = findViewById(R.id.edt_date_of_birth);
        mTvSoftWareCare = findViewById(R.id.tv_soft_ware_care);
        mLayoutSoftWareCare = findViewById(R.id.layoutSoftWareCare);
        mLayoutObjCustome = findViewById(R.id.layoutObjCustome);
        mEdtSourceCustomer = findViewById(R.id.edt_source_customer);
        mLayoutCustomerType = findViewById(R.id.layoutCustomerType);
        mEdtContent = findViewById(R.id.edt_content);
        mLayoutCustomerStatus = findViewById(R.id.layoutCustomerStatus);
        mEdtNote = findViewById(R.id.edt_note);
    }
}
