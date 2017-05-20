package com.emma.chat;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.emma.chat.Adapter.AlbumAdpter;
import com.emma.chat.Model.AlbumBean;

import java.util.LinkedList;
import java.util.List;

import static com.emma.chat.ShareActivity.RES_SEND;


public class AlbumActivity extends Activity  implements OnClickListener {
    private TextView txt_title;
    private ImageView img_talk;
    private ListView mlistview;
    private View layout_head;
    private List<AlbumBean> listString=new LinkedList<AlbumBean>();
    AlbumAdpter adpter;
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
        findViewById(R.id.img_back).setOnClickListener(this);
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setText("朋友圈");
        img_talk = (ImageView) findViewById(R.id.img_right);
        img_talk.setVisibility(View.VISIBLE);
        img_talk.setImageResource(R.drawable.icon_talk);

        mlistview = (ListView) findViewById(R.id.listview);

        layout_head = getLayoutInflater().inflate(R.layout.layout_album_header,
                null);
        mlistview.addHeaderView(layout_head);
        adpter= new AlbumAdpter(listString,this);
        mlistview.setAdapter(adpter);
        img_talk.setOnClickListener(this);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_right:
                Intent intentshare=new Intent(this,ShareActivity.class);
                startActivityForResult(intentshare,0);
                break;
            default:
                finish();
                break;
        }
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (resultCode){
            case RES_SEND:
                Bundle stringbundle=data.getBundleExtra("sharebundle");
                String context=stringbundle.getString("textContext");
                Uri uri=(Uri) stringbundle.getParcelable("bitmap");
                ContentResolver cr = this.getContentResolver();
                AlbumBean bean=null;
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));

                    bean = new AlbumBean(context, bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }
                listString.add(0,bean);
                Context mContext = AlbumActivity.this;
//                AlbumAdpter mAdapter = new AlbumAdpter((LinkedList<String>) listString, mContext);
                adpter.notifyDataSetChanged();

        }
    }
}
//
//}
