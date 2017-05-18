package com.emma.chat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.emma.chat.Adapter.MessageAdapter;
import com.emma.chat.Model.Message;
import com.emma.chat.Model.TextMessage;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends Activity {

    private ListView mListView;
    MessageAdapter listViewAdapter=null;
    List<Message> listMessage=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mListView=(ListView)findViewById(R.id.listchat);
        initListView();


    }

    private void initListView() {
        listMessage=new ArrayList<>();
        listViewAdapter=new MessageAdapter(this,listMessage);
        TextMessage temp=new TextMessage();
        temp.setBody("SEND");
        temp.setDirect(Message.SEND);
        listMessage.add(temp);

        temp=new TextMessage();
        temp.setBody("RECEIVE");
        temp.setDirect(Message.RECEIVE);
        listMessage.add(temp);

        mListView.setAdapter(listViewAdapter);


    }
}