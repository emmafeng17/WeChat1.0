package com.emma.chat;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.emma.chat.R.id.txt_title;

public class ShareActivity extends Activity implements View.OnClickListener {

    public static final int RES_SEND = 6;
    private static final int PHOTO_REQUEST_GALLERY = 3;// 从相册中选择
    private TextView txt_title, txt_right;
    private ImageView img_back, imageadd;

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
        imageadd = (ImageView) findViewById(R.id.btnaddimg);
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);
        txt_right.setOnClickListener(this);
        imageadd.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_right:
                doSomething();
                break;
            case R.id.btnaddimg:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, PHOTO_REQUEST_GALLERY);


        }
    }

    private void doSomething() {
        EditText shareedit = (EditText) findViewById(R.id.et_usertel);
        String shareString = shareedit.getText().toString();
        Bundle shareBundle = new Bundle();
        shareBundle.putString("textContext", shareString);
        if (savedUri!=null)
            shareBundle.putParcelable("bitmap",savedUri);
        Intent intent = new Intent();
        intent.putExtra("sharebundle", shareBundle);
        setResult(RES_SEND, intent);
        finish();
    }

    Uri savedUri=null;
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            Uri uri = data.getData();
//            Log.e("uri", uri.toString());
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                savedUri=uri;

                if (bitmap!=null)
                    imageadd.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(), e);
            }
        }
//        super.onActivityResult(requestCode, resultCode, data);
    }
}



