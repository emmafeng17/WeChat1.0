package com.emma.chat.fragment;



import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.emma.chat.ChatActivity;
import com.emma.chat.FriendMsgActivity;
import com.emma.chat.LoginActivity;
import com.emma.chat.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment_Friends extends Fragment implements
        AdapterView.OnItemClickListener {
    private ListView listView;
    //  private FoodListAdapter adapter;
    private int[] imgageids = new int[]{R.drawable.head, R.drawable.headself,};
    private String[] names = new String[]{"cici", "emma"};
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View friendView = inflater.inflate(R.layout.fragment__friends, null);
        listView = (ListView) friendView.findViewById(R.id.lvContact);
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", imgageids[i]);
            item.put("name", names[i]);
            list.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.item, new String[]{"name", "image"},
                new int[]{R.id.txt_name, R.id.contactitem_avatar_iv});

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return friendView;

    }
    public void onItemClick(AdapterView<?> arg0, View arg1, int index,long arg3) {

        Bundle bundle = new Bundle();
        bundle.putInt("photo", imgageids[index]);
        bundle.putString("name", names[index]);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(getActivity(), FriendMsgActivity.class);
        startActivity(intent);
    }
    }



