package com.emma.chat.Model;

import android.graphics.Bitmap;

/**
 * Created by emma on 17/5/20.
 */

public class AlbumBean {

    String content;
    Bitmap image1;

    public AlbumBean(String s,Bitmap b){
        content=s;
        image1=b;
    }

    public AlbumBean(){

    }


    public Bitmap getImage1() {
        return image1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage1(Bitmap image1) {
        this.image1 = image1;
    }
}
