package com.emma.chat.Model;

/**
 * Created by emma on 17/5/17.
 */

public class TextMessage implements Message {
    private int direct=0;
    private byte body[];
    @Override
    public int getType() {
        return TYPE_TEXT;
    }

    @Override
    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    @Override
    public byte[] getBody() {
        return body;
    }

    public void setBody(String mes){
        body=mes.getBytes();
    }
}
