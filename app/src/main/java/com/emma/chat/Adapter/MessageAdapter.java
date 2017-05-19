package com.emma.chat.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.emma.chat.Model.Message;
import com.emma.chat.R;

import java.util.List;



public class MessageAdapter extends BaseAdapter {

    List<Message> messagesObjectList=null;
    LayoutInflater inf;
    public   MessageAdapter(Context con,List<Message> messages){
        if (messages==null)
            Log.d("", "MessageAdapter: ");
        messagesObjectList=messages;
        inf=LayoutInflater.from(con);
    }
    @Override
    public int getCount() {
        return messagesObjectList.size();
    }

    @Override
    public Object getItem(int position) {
        return messagesObjectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message=messagesObjectList.get(position);
        if (messagesObjectList.get(position).getDirect()==Message.RECEIVE) {
            convertView=inf.inflate(R.layout.row_received_message,null);
        }else {
            convertView=inf.inflate(R.layout.row_sent_message,null);
        }
        ImageView image=(ImageView) convertView.findViewById(R.id.iv_userhead);
        TextView text=(TextView) convertView.findViewById(R.id.tv_chatcontent);
        text.setText(new String(message.getBody()));
        return convertView;
    }
}