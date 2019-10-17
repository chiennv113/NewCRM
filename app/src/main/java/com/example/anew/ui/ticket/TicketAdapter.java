package com.example.anew.ui.ticket;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;



public class TicketAdapter extends FragmentStatePagerAdapter {
    public TicketAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new ListTicketFragment();
                break;
            case 1:
                frag = new TicketReceivedFragment();
                break;
            case 2:
                frag = new ListWaitFragment();
                break;
            case 3:
                frag = new TicketDashboarFragment();
                break;
        }
        return frag;

    }

    @Override
    public int getCount() {

        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "List";
                break;
            case 1:
                title = "Received";
                break;
            case 2:
                title = "Wait";
                break;
            case 3:
                title="Dashboard";
        }
        return title;
    }
}

