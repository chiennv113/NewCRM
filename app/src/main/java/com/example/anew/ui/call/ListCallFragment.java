package com.example.anew.ui.call;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.anew.Model.ModelSearchCu.Search;
import com.example.anew.R;
import com.example.anew.Retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCallFragment extends Fragment {
    private static final String KEY_COOKIE = "ListCallFragment.KEY_COOKIE";
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public ListCallFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listcall, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences prefs = getActivity().getSharedPreferences("cookie", Context.MODE_PRIVATE);
        String cookie = prefs.getString("cookie_name", "No name defined");
        Log.e("sharedPre", "onViewCreated: " + cookie);


    }

    public void search(String info, String option, String cookie, String content) {
        ApiClient.getInstance().search(info, option, cookie, content).enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {

            }
        });
    }
}
