package com.example.yiluwuyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.os.Handler;
import android.os.Message;

import com.mob.MobSDK;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    String APPKEY = "2ad13472a965f";
    String APPSECRET = "a387f464f133788860fc96b94a871344";
    private Button register_button,register_yzm_button;
    int i=30;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        register_button = (Button) this.findViewById(R.id.register_yes);
        register_yzm_button= (Button) this.findViewById(R.id.register_yzm_button);

        MobSDK.init(this, APPKEY, APPSECRET);
//        EventHandler eventHandler = new EventHandler(){
//            @Override
//            public void afterEvent(int event, int result, Object data) {
//                Message msg = new Message();
//                msg.arg1 = event;
//                msg.arg2 = result;
//                msg.obj = data;
//                handler.sendMessage(msg);
//            }
//        };


        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });

        register_yzm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}