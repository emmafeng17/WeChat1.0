package com.emma.chat;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends Activity implements View.OnClickListener {


    private TextView txt_title;
    private ImageView img_back;
    private Button btn_login, btn_register;
    private EditText et_usertel, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setText("登陆");
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_qtlogin);
        et_usertel = (EditText) findViewById(R.id.et_usertel);
        et_password = (EditText) findViewById(R.id.et_password);

        btn_login.setOnClickListener(this);//对按钮设置监听
        //  img_back.setOnClickListener(clickListener);
        btn_register.setOnClickListener(this);
    }

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_qtlogin:
                    startActivity(new Intent(LoginActivity.this, registActivity.class));
                     break;
                case R.id.btn_login:
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    break;
            }
        }



     /*
       btn_login=(Button) findViewById(R.id.btn_login) ;
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName comp=new ComponentName(LoginActivity.this,MainActivity.class);
                Intent intent=new Intent();
                intent.setComponent(comp);
                startActivity(intent);
            }
        });

        btn_register = (Button) findViewById(R.id.btn_qtlogin);
     btn_register.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             ComponentName comp=new ComponentName(LoginActivity.this,registActivity.class);
             Intent intent=new Intent();
             intent.setComponent(comp);
             startActivity(intent);
         }
     });
*/

    }
