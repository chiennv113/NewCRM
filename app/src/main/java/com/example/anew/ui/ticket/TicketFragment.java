package com.example.anew.ui.ticket;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.anew.R;
import com.example.anew.ui.call.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

<<<<<<< HEAD:app/src/main/java/com/example/anew/ui/ticket/SlideshowFragment.java
public class SlideshowFragment extends Fragment {
    private static final String KEY_COOKIE = "SlideshowFragment.KEY_COOKIE";

    private SlideshowViewModel slideshowViewModel;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    public static Fragment newInstance(String abc) {
        Fragment fragment = new SlideshowFragment();
        Bundle args = new Bundle();
        args.putString(KEY_COOKIE, abc);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        initView(root);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        TicketAdapter ticketAdapter = new TicketAdapter(fragmentManager);
        mViewPager.setAdapter(ticketAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setTabsFromPagerAdapter(ticketAdapter);
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        View view = mTabLayout.getChildAt(0);
        if(view instanceof LinearLayout){
            ((LinearLayout) view).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.colorAccent));
            ((LinearLayout) root).setDividerPadding(10);
            ((LinearLayout) root).setDividerDrawable(drawable);
            drawable.setSize(1, 1);
        }


        if (getArguments() != null) {
            String cookie = getArguments().getString(KEY_COOKIE);
            Log.e("cookie in gallery", "onCreateView: "+cookie );

        }


        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
=======
public class TicketFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ticket, container, false);
>>>>>>> b8a9116b60e7598c52f99e84a0af2d07ba7476a6:app/src/main/java/com/example/anew/ui/ticket/TicketFragment.java
        return root;


    }

    private void initView(View view) {
        mTabLayout = view.findViewById(R.id.tab_layout);
        mViewPager = view.findViewById(R.id.view_pager);
    }

}