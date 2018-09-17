package com.something.pew;

import android.graphics.Rect;
import android.graphics.RectF;

public class RectFAnimate extends RectF {
    public RectFAnimate() {
        super();
    }

    public RectFAnimate(float left, float top, float right, float bottom) {
        super(left, top, right, bottom);
    }

    public RectFAnimate(RectF r) {
        super(r);
    }

    public RectFAnimate(Rect r) {
        super(r);
    }

    public void setTop(float top){
        this.top = top;
    }
    public void setBottom(float bottom){
        this.bottom = bottom;
    }
    public void setRight(float right){
        this.right = right;
    }
    public void setLeft(float left){
        this.left = left;
    }
}