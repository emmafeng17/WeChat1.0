package com.emma.chat.Model;

/**
 * Created by emma on 17/5/17.
 */

public interface Message {
    final int TYPE_TEXT=0,TYPE_IMG=1;
    final int  RECEIVE=0,SEND=1;

    int getType();
    int getDirect();
    byte[] getBody();


}
