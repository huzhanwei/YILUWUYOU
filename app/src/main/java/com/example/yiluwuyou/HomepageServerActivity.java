package com.example.yiluwuyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


public class HomepageServerActivity extends AppCompatActivity {
    private ListView homegage_server_listView;
    private int[] homegage_server_list_imageview={R.drawable.baoyang, R.drawable.baoyang, R.drawable.baoyang,R.drawable.baoyang,R.drawable.baoyang,R.drawable.baoyang,R.drawable.baoyang,R.drawable.baoyang,R.drawable.baoyang,R.drawable.baoyang};
    private String[] homegage_server_list_textview1={"京东ww","QQ","氰化钾","hudhudh","ijdch","ghsd","ijdch","ghsd","ijdch","ghsd"};
    private String[] homegage_server_list_textview22={"1.33","2.00","6.52","6.21","0.00","3.00","ijdch","ghsd","ijdch","ghsd"};
    private String[] homegage_server_list_textview24={"1.33","2.00","6.52","6.21","0.00","3.00","ijdch","ghsd","ijdch","ghsd"};
    private String[] homegage_server_list_textview31={"京东","QQ","氰化钾","hudhudh","ijdch","ghsd","ijdch","ghsd","ijdch","ghsd"};
    private String[] homegage_server_list_textview32={"1.33km","2.00km","6.52km","6.21km","0.00km","3.00km","ijdch","ghsd","ijdch","ghsd"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.server);
        homegage_server_listView=(ListView)findViewById(R.id.homegage_server_list_view);
        MyBaseAdapter myBaseAdapter=new MyBaseAdapter();
        homegage_server_listView.setAdapter(myBaseAdapter);
        homegage_server_listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                Intent intent=new Intent(HomepageServerActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return homegage_server_list_textview1.length;
        }

        @Override
        public Object getItem(int position) {
            return homegage_server_list_textview1[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.homepage_server_list_item, parent, false);
                holder = new ViewHolder();
                holder.homegage_server_list_textview01 = (TextView) convertView.findViewById(R.id.homepage_server_list_textview1);
                holder.homegage_server_list_textview022 = (TextView) convertView.findViewById(R.id.homepage_server_list_textview22);
                holder.homegage_server_list_textview024 = (TextView) convertView.findViewById(R.id.homepage_server_list_textview24);
                holder.homegage_server_list_textview031 = (TextView) convertView.findViewById(R.id.homepage_server_list_textview31);
                holder.homegage_server_list_textview032 = (TextView) convertView.findViewById(R.id.homepage_server_list_textview32);
                holder.homegage_server_list_imageView = (ImageView) convertView.findViewById(R.id.homepage_server_list_imageview);
                convertView.setTag(holder);
            } else {
                holder=(ViewHolder)convertView.getTag();
            }
            holder.homegage_server_list_textview01.setText(homegage_server_list_textview1[position]);
            holder.homegage_server_list_textview022.setText(homegage_server_list_textview22[position]);
            holder.homegage_server_list_textview024.setText(homegage_server_list_textview24[position]);
            holder.homegage_server_list_textview031.setText(homegage_server_list_textview31[position]);
            holder.homegage_server_list_textview032.setText(homegage_server_list_textview32[position]);
            holder.homegage_server_list_imageView.setBackgroundResource(homegage_server_list_imageview[position]);

            //holder.homegage_server_list_imageView.setOnClickListener(HomepageServerActivity.this);

            return convertView;
        }

        class ViewHolder {
            TextView homegage_server_list_textview01;
            TextView homegage_server_list_textview022;
            TextView homegage_server_list_textview024;
            TextView homegage_server_list_textview031;
            TextView homegage_server_list_textview032;
            ImageView homegage_server_list_imageView;
        }
    }
}

