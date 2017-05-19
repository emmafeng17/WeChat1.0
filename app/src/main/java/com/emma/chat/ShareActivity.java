package com.emma.chat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.emma.chat.R.id.txt_title;

public class ShareActivity extends Activity implements View.OnClickListener {

    public static final int RES_SEND=6;

    private TextView txt_title, txt_right;
    private ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        initControl();

    }
    protected void initControl() {
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setText("朋友圈分享");
        txt_right = (TextView) this.findViewById(R.id.txt_right);
        txt_right.setText("发送");
        txt_right.setTextColor(0xFF45C01A);
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);
        txt_right.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.txt_right:
                doSomething();
                break;



        }
    }

    private void doSomething() {
        EditText shareedit=(EditText)findViewById(R.id.et_usertel);
        String shareString=shareedit.getText().toString();
        Bundle shareBundle=new Bundle();
        shareBundle.putString("textContext",shareString);
        Intent intent=new Intent();
        intent.putExtra("sharebundle",shareBundle);
        setResult(RES_SEND,intent);
        finish();
    }

}
