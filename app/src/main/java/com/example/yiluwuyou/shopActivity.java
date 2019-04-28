package com.example.yiluwuyou;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yiluwuyou.database.DataBusiness;
import com.example.yiluwuyou.entity.ShopEntity;

import java.util.ArrayList;


public class shopActivity extends AppCompatActivity {
    private Button login_button1;
    private ListView shop_listView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        shop_listView=(ListView)findViewById(R.id.list_view);
       // login_button1 = (Button)this.findViewById(R.id.shop_button);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
               //setContentView(R.layout.shop);
                        DataBusiness dataBusiness = new DataBusiness();
                        ArrayList<ShopEntity> list=dataBusiness.login1();
                        ShopEntity[] shopEntities=new ShopEntity[list.size()];
                        for(int i=0;i<list.size();i++) {
                            shopEntities[i] = list.get(i);
                        }
//                        MyBaseAdapter myBaseAdapter=new MyBaseAdapter(shopEntities);
//                        shop_listView.setAdapter(myBaseAdapter);
                Message message = handler.obtainMessage();
                message.what = 0x11;
                message.obj = shopEntities;
                handler.sendMessage(message);
            }
        }).start();
            //}
      //  MyBaseAdapter myBaseAdapter=new MyBaseAdapter(shopEntities);
       // shop_listView.setAdapter(myBaseAdapter);
//

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
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.shop_list_item, parent, false);
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
}

