package com.example.anew.ui.call;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.anew.Model.ModelAdd;
import com.example.anew.Model.ModelCustomeFeelNew;
import com.example.anew.Model.ModelSearchCu.Search;
import com.example.anew.R;
import com.example.anew.Retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCallFragment extends Fragment {

    private EditText mEdtInfoSearch;
    private ImageView mBtnSearch;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listcall, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        mEdtInfoSearch.setText("0979090897");


        SharedPreferences prefs = getActivity().getSharedPreferences("cookie", Context.MODE_PRIVATE);
        final String cookie = prefs.getString("cookie_name", "No name defined");
        Log.e("sharedPre", "onViewCreated: " + cookie);

        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search(mEdtInfoSearch.getText().toString().trim(), "search_customer", cookie, "application/x-www-form-urlencoded");
            }
        });


    }

    public void search(String info, String option, final String cookie, String content) {
        ApiClient.getInstance().search(info, option, cookie, content).enqueue(new Callback<Search>() {

            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                int customer_id = response.body().getPhonecall().get(0).getCustomerId();
                String content = response.body().getPhonecall().get(0).getContent();
                String name = response.body().getFullname();
                String email = response.body().getEmail();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Result_Info_Dialog result_info_dialog = Result_Info_Dialog.newInstance(name, email, content, customer_id);
                result_info_dialog.show(fm, null);
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {

            }
        });
    }

    private void initView(View view) {
        mEdtInfoSearch = view.findViewById(R.id.edtInfoSearch);
        mBtnSearch = view.findViewById(R.id.btnSearch);
    }

}
