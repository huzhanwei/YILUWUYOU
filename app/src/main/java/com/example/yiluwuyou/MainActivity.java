package com.example.yiluwuyou;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.yiluwuyou.fragment.ShopFragment;
import com.example.yiluwuyou.fragment.HomepagekFragment;
import com.example.yiluwuyou.fragment.MineFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    //底部的4个导航布局bottom
    private LinearLayout homepage_layout,boutique_layout,mine_layout;
    private ImageView homepage_iv,boutique_iv,mine_iv;
    private Fragment homepage_f,boutique_f,mine_f;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.main);
        initView();
        homepage_layout.setOnClickListener(this);
        boutique_layout.setOnClickListener(this);
        mine_layout.setOnClickListener(this);
    }
    void initView(){
        homepage_layout = (LinearLayout)this.findViewById(R.id.bottom_homepage_layout);
        boutique_layout = (LinearLayout)this.findViewById(R.id.bottom_boutique_layout);
        mine_layout = (LinearLayout)this.findViewById(R.id.bottom_mine_layout);
        homepage_iv=(ImageView)this.findViewById(R.id.bottom_homepage_iv);
        boutique_iv=(ImageView)this.findViewById(R.id.bottom_boutique_iv);
        mine_iv =(ImageView)this.findViewById(R.id.bottom_mine_iv);
    }
    @Override
    public void onClick(View view){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        homepage_iv.setImageResource(R.mipmap.ylwy);
        boutique_iv.setImageResource(R.mipmap.ylwy);
        mine_iv.setImageResource(R.mipmap.ylwy);
        switch (view.getId()){
            case R.id.bottom_homepage_layout:
                homepage_f=new HomepagekFragment();
                transaction.replace(R.id.main_frameLayout_xml,homepage_f);
                homepage_iv.setImageResource(R.mipmap.picture1);
                break;

            case R.id.bottom_boutique_layout:
                boutique_f=new ShopFragment();
                transaction.replace(R.id.main_frameLayout_xml,boutique_f);
                boutique_iv.setImageResource(R.mipmap.picture3);
                break;
            case R.id.bottom_mine_layout:
                mine_f=new MineFragment();
                transaction.replace(R.id.main_frameLayout_xml,mine_f);
                mine_iv.setImageResource(R.mipmap.picture4);
                break;
        }
        transaction.commit();//提交事务
    }

}
