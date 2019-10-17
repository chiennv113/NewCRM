package com.example.anew.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.Model.ModelAddCallAndCustomerNew;
import com.example.anew.Model.ModelCustomeFeelNew;
import com.example.anew.Model.ModelLoadAllProduct;
import com.example.anew.Model.ModelLoadCity;
import com.example.anew.Model.ModelLoadCustomerType;
import com.example.anew.Model.ModelLoadObjCustomer;
import com.example.anew.Model.ModelLoadSourceCustomer;
import com.example.anew.R;
import com.example.anew.Retrofit.ApiClient;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCallActivity extends AppCompatActivity {

    private TextInputEditText mEdtPhone;
    private TextInputEditText mEdtName;
    private TextInputEditText mEdtEmail;
    private TextInputEditText mEdtZalo;
    private TextInputEditText mEdtSkype;
    private Spinner mLayoutCity;
    private TextInputEditText mEdtAddress;
    private TextInputEditText mEdtDateOfBirth;
    private Spinner mLayoutSoftWareCare;
    private Spinner mLayoutObjCustome;
    private Spinner mLayoutSourceCustomer;
    private Spinner mLayoutCustomerType;
    private TextInputEditText mEdtContent;
    private Spinner mLayoutCustomerStatus;
    private TextInputEditText mEdtNote;
    private Button mBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_call);
        initView();

        SharedPreferences prefs = getSharedPreferences("cookie", Context.MODE_PRIVATE);
        final String cookie = prefs.getString("cookie_name", "No name defined");

        LoadCity(cookie);
        LoadAllProduct(cookie);
        LoadCustomerType(cookie);
        LoadObjCustomer(cookie);
        LoadSourceCustomer(cookie);
        LoadCustomerFeel();

        final String phone = mEdtPhone.getText().toString().trim();
        final String address = mEdtAddress.getText().toString().trim();
        final String birthday = mEdtDateOfBirth.getText().toString().trim();
        final String content = mEdtContent.getText().toString().trim();
        final String email = mEdtEmail.getText().toString().trim();
        final String fullname = mEdtName.getText().toString().trim();
        final String note = mEdtNote.getText().toString().trim();
        final String skype = mEdtSkype.getText().toString().trim();
        final String zalo = mEdtZalo.getText().toString().trim();

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = mLayoutCity.getSelectedItem().toString();
                String product = mLayoutSoftWareCare.getSelectedItem().toString();
                String cus_type = mLayoutCustomerType.getSelectedItem().toString();
                String obj_cus = mLayoutObjCustome.getSelectedItem().toString();
                String source_cus = mLayoutSourceCustomer.getSelectedItem().toString();
                String cus_feel = mLayoutCustomerStatus.getSelectedItem().toString();
                ApiClient.getInstance().addCallAndCus("add_register_phone_call",
                        phone,
                        address,
                        birthday,
                        city,
                        content,
                        source_cus,
                        cus_feel,
                        obj_cus,
                        email,
                        fullname,
                        note,
                        skype,
                        product,
                        cus_type,
                        zalo,
                        cookie).
                        enqueue(new Callback<ModelAddCallAndCustomerNew>() {
                            @Override
                            public void onResponse(Call<ModelAddCallAndCustomerNew> call, Response<ModelAddCallAndCustomerNew> response) {
                                Toast.makeText(AddCallActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<ModelAddCallAndCustomerNew> call, Throwable t) {

                            }
                        });
                finish();

            }
        });
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
        mLayoutSoftWareCare = findViewById(R.id.layoutSoftWareCare);
        mLayoutObjCustome = findViewById(R.id.layoutObjCustome);
        mLayoutSourceCustomer = findViewById(R.id.layoutSourceCustomer);
        mLayoutCustomerType = findViewById(R.id.layoutCustomerType);
        mEdtContent = findViewById(R.id.edt_content);
        mLayoutCustomerStatus = findViewById(R.id.layoutCustomerStatus);
        mEdtNote = findViewById(R.id.edt_note);
        mBtnSave = findViewById(R.id.btnSave);
    }

    private void LoadCity(String cookie) {
        ApiClient.getInstance().getCity("load_city", cookie).enqueue(new Callback<List<ModelLoadCity>>() {
            @Override
            public void onResponse(Call<List<ModelLoadCity>> call, Response<List<ModelLoadCity>> response) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().size(); i++) {
                        arrayList.add(response.body().get(i).getName());
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddCallActivity.this, android.R.layout.simple_spinner_item, arrayList);
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        mLayoutCity.setAdapter(arrayAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelLoadCity>> call, Throwable t) {

            }
        });
    }

    private void LoadCustomerType(String cookie) {
        ApiClient.getInstance().getCustomerType("get_CustomerType", cookie).enqueue(new Callback<List<ModelLoadCustomerType>>() {
            @Override
            public void onResponse(Call<List<ModelLoadCustomerType>> call, Response<List<ModelLoadCustomerType>> response) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().size(); i++) {
                        arrayList.add(response.body().get(i).getName());
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddCallActivity.this, android.R.layout.simple_spinner_item, arrayList);
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        mLayoutCustomerType.setAdapter(arrayAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelLoadCustomerType>> call, Throwable t) {

            }
        });
    }

    private void LoadObjCustomer(String cookie) {
        ApiClient.getInstance().getObjCustomer("get_customer_type", cookie).enqueue(new Callback<List<ModelLoadObjCustomer>>() {
            @Override
            public void onResponse(Call<List<ModelLoadObjCustomer>> call, Response<List<ModelLoadObjCustomer>> response) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().size(); i++) {
                        arrayList.add(response.body().get(i).getName());
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddCallActivity.this, android.R.layout.simple_spinner_item, arrayList);
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        mLayoutObjCustome.setAdapter(arrayAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelLoadObjCustomer>> call, Throwable t) {

            }
        });
    }

    private void LoadSourceCustomer(String cookie) {
        ApiClient.getInstance().getSourceCustomer("get_customer_base", cookie).enqueue(new Callback<List<ModelLoadSourceCustomer>>() {
            @Override
            public void onResponse(Call<List<ModelLoadSourceCustomer>> call, Response<List<ModelLoadSourceCustomer>> response) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().size(); i++) {
                        arrayList.add(response.body().get(i).getName());
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddCallActivity.this, android.R.layout.simple_spinner_item, arrayList);
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        mLayoutSourceCustomer.setAdapter(arrayAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelLoadSourceCustomer>> call, Throwable t) {

            }
        });
    }

    private void LoadAllProduct(String cookie) {
        ApiClient.getInstance().getAllProduct("get_allProduct", cookie).enqueue(new Callback<List<ModelLoadAllProduct>>() {
            @Override
            public void onResponse(Call<List<ModelLoadAllProduct>> call, Response<List<ModelLoadAllProduct>> response) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().size(); i++) {
                        arrayList.add(response.body().get(i).getName());
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddCallActivity.this, android.R.layout.simple_spinner_item, arrayList);
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        mLayoutSoftWareCare.setAdapter(arrayAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelLoadAllProduct>> call, Throwable t) {

            }
        });
    }

    private void LoadCustomerFeel() {
        ApiClient.getInstance().getFeel("get_PhoneCallFeel").enqueue(new Callback<List<ModelCustomeFeelNew>>() {
            @Override
            public void onResponse(Call<List<ModelCustomeFeelNew>> call, Response<List<ModelCustomeFeelNew>> response) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().size(); i++) {
                        arrayList.add(response.body().get(i).getName());
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddCallActivity.this, android.R.layout.simple_spinner_item, arrayList);
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        mLayoutCustomerStatus.setAdapter(arrayAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelCustomeFeelNew>> call, Throwable t) {

            }
        });
    }
}
