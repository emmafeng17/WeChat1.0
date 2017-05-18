package com.emma.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_msg);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        int photo=bundle.getInt("photo");
        String  name= bundle.getString("name");
        ImageView imageView=(ImageView)findViewById(R.id.iv_avatar);
        TextView textview=(TextView)findViewById(R.id.tv_name);
        imageView.setImageResource(photo);
        textview.setText(name);
    }
}
