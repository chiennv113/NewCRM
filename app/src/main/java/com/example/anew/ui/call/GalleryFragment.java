package com.example.anew.ui.call;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.anew.R;
import com.google.android.material.tabs.TabLayout;

public class GalleryFragment extends Fragment {
    private static final String KEY_COOKIE = "GalleryFragment.KEY_COOKIE";

    private GalleryViewModel galleryViewModel;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public static Fragment newInstance(String abc) {
        Fragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(KEY_COOKIE, abc);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        initView(root);


        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        PagerAdapter pagerAdapter = new PagerAdapter(fragmentManager);
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setTabsFromPagerAdapter(pagerAdapter);
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        View view = mTabLayout.getChildAt(0);
        if(view instanceof LinearLayout){
            ((LinearLayout) view).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.colorAccent));
            ((LinearLayout) root).setDividerPadding(10);
            ((LinearLayout) root).setDividerDrawable(drawable);
            drawable.setSize(2, 1);
        }


        if (getArguments() != null) {
            String cookie = getArguments().getString(KEY_COOKIE);
            Log.e("cookie in gallery", "onCreateView: "+cookie );

        }


        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;


    }

    private void initView(View view) {
        mTabLayout = view.findViewById(R.id.tab_layout);
        mViewPager = view.findViewById(R.id.view_pager);
    }



}