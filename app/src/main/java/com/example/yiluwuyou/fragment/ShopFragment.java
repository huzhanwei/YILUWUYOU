package com.example.yiluwuyou.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yiluwuyou.R;
import com.example.yiluwuyou.database.DataBusiness;
import com.example.yiluwuyou.database.DataMaybeShop;
import com.example.yiluwuyou.entity.ShopEntity;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {
    private ListView shop_listView;
    private Button shop_button;
    private EditText shop_editText;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.shop,container,false);
        shop_listView=(ListView)view.findViewById(R.id.list_view);
        shop_button=(Button)view.findViewById(R.id.shop_button);
        shop_editText=(EditText)view.findViewById(R.id.shop_editText);

        new Thread(new Runnable() {
            @Override
            public void run() {
                DataBusiness dataBusiness = new DataBusiness();
                ArrayList<ShopEntity> list=dataBusiness.login1();
                ShopEntity[] shopEntities=new ShopEntity[list.size()];
                for(int i=0;i<list.size();i++) {
                    shopEntities[i] = list.get(i);
                }
                Message message = handler.obtainMessage();
                message.what = 0x11;
                message.obj = shopEntities;
                handler.sendMessage(message);
            }
        }).start();

        shop_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String shopEditText = shop_editText.getText().toString().trim();
                ;
                int shopEditText_int = shopEditText.length();
                if (shopEditText_int != 0) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            DataMaybeShop dataMaybeShop = new DataMaybeShop(shopEditText);
                            ArrayList<ShopEntity> list=dataMaybeShop.maybeshop();
                            ShopEntity[] shopEntities=new ShopEntity[list.size()];
                            for(int i=0;i<list.size();i++) {
                                shopEntities[i] = list.get(i);
                            }
                            Message message = handler.obtainMessage();
                            message.what = 0x11;
                            message.obj = shopEntities;
                            handler.sendMessage(message);
                        }
                    }).start();
                }
            }
        });

        return view;
    }

    class MyBaseAdapter extends BaseAdapter {
        ShopEntity[] shopEntities;
        public MyBaseAdapter(ShopEntity[] shopEntities){
            this.shopEntities=shopEntities;
        }
        @Override
        public int getCount() {
            return shopEntities.length;
        }

        @Override
        public Object getItem(int position) {
            return shopEntities[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.shop_list_item, parent, false);
                holder = new ViewHolder();
//                holder.shop_list_textview01 = (TextView) convertView.findViewById(R.id.shop_list_textview1);
//                holder.shop_list_textview022 = (TextView) convertView.findViewById(R.id.shop_list_textview22);
                holder.shop_list_textview024 = (TextView) convertView.findViewById(R.id.shop_list_textview24);
                holder.shop_list_textview031 = (TextView) convertView.findViewById(R.id.shop_list_textview31);
                holder.shop_list_textview032 = (TextView) convertView.findViewById(R.id.shop_list_textview32);
//                holder.imageView = (ImageView) convertView.findViewById(R.id.shop_list_imageview);
                convertView.setTag(holder);
            } else {
                holder=(ViewHolder)convertView.getTag();
            }

//            holder.shop_list_textview01.setText(shop_list_textview1[position]);
//            holder.shop_list_textview022.setText(shop_list_textview22[position]);
            holder.shop_list_textview024.setText(shopEntities[position].getAccount());
            holder.shop_list_textview031.setText(shopEntities[position].getPassword());
            holder.shop_list_textview032.setText(shopEntities[position].getName());
            // holder.imageView.setBackgroundResource(shop_list_imageview[position]);
            return convertView;
        }

        class ViewHolder {
            //            TextView shop_list_textview01;
//            TextView shop_list_textview022;
            TextView shop_list_textview024;
            TextView shop_list_textview031;
            TextView shop_list_textview032;
            //           ImageView imageView;
        }
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x11:
                    ShopEntity[] shopEntities = (ShopEntity[]) msg.obj;
                    MyBaseAdapter myBaseAdapter=new MyBaseAdapter(shopEntities);
                    shop_listView.setAdapter(myBaseAdapter);
                    break;
            }
        }
    };

}
