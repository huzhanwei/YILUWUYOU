package com.example.yiluwuyou;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import android.os.Message;
import com.example.yiluwuyou.database.DataLogin;

public class LoginActivity extends AppCompatActivity {
    private Button login_button;
    private EditText login_account, login_password;
    private TextView login_register;

    boolean aBoolean;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
       @Override
        public void handleMessage(Message msg) {
           switch (msg.what){
               case 0x11:
                   aBoolean = (boolean) msg.obj;
                    if(aBoolean){
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast toast2=Toast.makeText(getApplication(),"帐号或密码错误！", Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.TOP,0,700);
                        toast2.show();
                    }
                    break;
           }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login_button = (Button)this.findViewById(R.id.login_button);
        login_account =(EditText)this.findViewById(R.id.login_account);
        login_password = (EditText)this.findViewById(R.id.login_password);
        login_register=(TextView)this.findViewById(R.id.login_register);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String account=login_account.getText().toString().trim();//提取logon_account中的数据
                final String password=login_password.getText().toString().trim();
                int account_int=account.length();
                int password_int=password.length();
                if((account_int!=0)&&(password_int!=0)){
                    new Thread(new Runnable() {
                        @Override
                         public void run() {
                            DataLogin dataLogin = new DataLogin(account, password);
                            boolean aBoolean = dataLogin.login();
                            Message message = handler.obtainMessage();
                            message.what = 0x11;
                            message.obj = aBoolean;
                            handler.sendMessage(message);
                        }
                    }).start();
                }else {
                    Toast toast2=Toast.makeText(getApplication(),"帐号或密码不能为空！", Toast.LENGTH_LONG);
                    toast2.setGravity(Gravity.TOP,0,700);
                    toast2.show();
                }
           }
        });
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public  void passdata(){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
