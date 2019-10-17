package com.example.anew.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.anew.R;

public class DashboardFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
<<<<<<< HEAD:app/src/main/java/com/example/anew/ui/dashboard/HomeFragment.java
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//                Log.e("abcde", "onChanged: "+s );
//            }
//        });
=======
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
>>>>>>> b8a9116b60e7598c52f99e84a0af2d07ba7476a6:app/src/main/java/com/example/anew/ui/dashboard/DashboardFragment.java
        return root;
    }
}