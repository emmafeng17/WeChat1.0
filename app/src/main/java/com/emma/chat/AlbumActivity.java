package com.emma.chat;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.emma.chat.Adapter.AlbumAdpter;


public class AlbumActivity extends Activity {
    private TextView txt_title;
    private ImageView img_talk;
    private ListView mlistview;
    private View layout_head;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_listview);
        super.onCreate(savedInstanceState);
        initControl();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    protected void initControl() {
       findViewById(R.id.img_back).setVisibility(View.VISIBLE);
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setText("朋友圈");
        img_talk = (ImageView) findViewById(R.id.img_right);
        img_talk.setVisibility(View.VISIBLE);
        img_talk.setImageResource(R.drawable.icon_talk);
        mlistview = (ListView) findViewById(R.id.listview);

        layout_head = getLayoutInflater().inflate(R.layout.layout_album_header,
                null);
        mlistview.addHeaderView(layout_head);
        mlistview.setAdapter(new AlbumAdpter(this));
    }
}


//   protected void initView() {
//
//    }


//    protected void setListener() {
//        findViewById(R.id.img_back).setOnClickListener(this);
//        img_talk.setOnClickListener(this);
//        img_talk.setOnLongClickListener(new View.OnLongClickListener() {
//
//
//            public boolean onLongClick(View v) {
//                Utils.showLongToast(context, "长按发送文字");
//                return true;
//            }
//        });
//    }


//    protected void initData() {

//    }
//
//
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.img_back:
//                Utils.finish(AlbumActivity.this);
//                break;
//            case R.id.img_right:
//                Utils.start_Activity(this, ShareActivity.class);
//                break;
//            default:
//                break;
//        }
//    }
//
//}
