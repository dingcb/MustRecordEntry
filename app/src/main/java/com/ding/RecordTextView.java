package com.ding;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ding on 2017/6/16.
 */
public class RecordTextView extends TextView {

    public RecordTextView(Context context) {
        super(context);
    }

    public RecordTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecordTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public void setText(CharSequence text, BufferType type) {
        //判断有字符、第一个字符是"*"时，"*"字符标红再插入两个空格。
        if (!TextUtils.isEmpty(text) && text.subSequence(0,1).equals("*")){

            SpannableStringBuilder style=new SpannableStringBuilder(text);

            style.insert(1,"  ");
            style.setSpan(new ForegroundColorSpan(Color.RED),0,1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE); //设置指定位置文字的颜色
            super.setText(style, type);
        }else{//其它情况头部加四个空格
            super.setText("    "+text, type);
        }

    }
}

