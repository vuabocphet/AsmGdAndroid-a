package com.example.asmgdandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Thu_Fragment extends Fragment {


    private TabLayout tablayout;
    private ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.thu_fragment,container,false);

        tablayout = (TabLayout) view.findViewById(R.id.TabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        myPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());

        viewPager.setAdapter(myPagerAdapter);

        tablayout.setupWithViewPager(viewPager);


        return view;
    }
}
