package com.example.yiluwuyou.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.yiluwuyou.HomepageServerActivity;
import com.example.yiluwuyou.LoginActivity;
import com.example.yiluwuyou.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomepagekFragment extends Fragment {
    ViewFlipper viewFlipper;
    ImageView homepage_butai_imageview;
    ImageView homepage_meirong_imageview;
    ImageView homepage_baoyang_imageview;
    ImageView homepage_jiayouzhan_imageview;
    ImageView homepage_silundingwei_imageview;
    ImageView homepage_diaoche_imageview;
    ImageView homepage_xiche_imageview;
    ImageView homepage_liudongxiuche_imageview;

    public HomepagekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage,container,false);
        viewFlipper=(ViewFlipper)view.findViewById(R.id.home_vflipper);
        viewFlipper.startFlipping();
        homepage_butai_imageview=(ImageView)view.findViewById(R.id.butai);
        homepage_meirong_imageview=(ImageView)view.findViewById(R.id.meirong);
        homepage_baoyang_imageview=(ImageView)view.findViewById(R.id.baoyang);
        homepage_jiayouzhan_imageview=(ImageView)view.findViewById(R.id.jiayouzhan);
        homepage_silundingwei_imageview=(ImageView)view.findViewById(R.id.silundingwei);
        homepage_diaoche_imageview=(ImageView)view.findViewById(R.id.diaoche);
        homepage_xiche_imageview=(ImageView)view.findViewById(R.id.xiche);
        homepage_liudongxiuche_imageview=(ImageView)view.findViewById(R.id.liudongxiuche);

        homepage_butai_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HomepageServerActivity.class);
                startActivity(intent);
            }
        });

        homepage_meirong_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        homepage_baoyang_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        homepage_jiayouzhan_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        homepage_silundingwei_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        homepage_diaoche_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        homepage_xiche_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        homepage_liudongxiuche_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
