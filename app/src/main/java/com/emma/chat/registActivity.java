package com.emma.chat;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class registActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txt_title;
    private ImageView img_back;
    private Button btn_register, btn_send;
    private EditText et_usertel, et_password, et_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setText("注册");
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_register = (Button) findViewById(R.id.btn_register);
        et_usertel = (EditText) findViewById(R.id.et_usertel);
        et_password = (EditText) findViewById(R.id.et_password);
        et_code = (EditText) findViewById(R.id.et_code);

        //btn_register=(Button) findViewById(R.id.btn_login) ;
//        btn_register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ComponentName comp=new ComponentName(registActivity.this,MainActivity.class);
//                Intent intent=new Intent();
//                intent.setComponent(comp);
//                startActivity(intent);
//            }
//        });
        btn_register.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        startActivity(new Intent(registActivity.this, LoginActivity.class));
    }
}
