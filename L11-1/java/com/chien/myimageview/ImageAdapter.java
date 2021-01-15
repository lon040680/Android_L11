package com.chien.myimageview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageAdapter extends BaseAdapter {
    Context context;
    int[] imgArr;

    public ImageAdapter(Context context, int[] imgArr) {
        this.context = context;
        this.imgArr = imgArr;
    }

    @Override //依長度決定排的次數
    public int getCount() {
        return imgArr.length;
    }

    @Override //目前沒用到
    public Object getItem(int position) {
        return null;
    }

    @Override //目前沒用到
    public long getItemId(int position) {
        return 0;
    }

    @Override //用這個來排 丟資料上去 gridview // 可以理解成 > int position 是次數   View convertView 圖群元件 ViewGroup parent 父層圖片容器
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView v;
        // ImageView if null 就新增, 否則直接使用 這裡還沒去貼圖喔~~ 這裡有先裝好預備在印刷機的感覺
        if(convertView == null){
            v = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            //開新記憶體位置放 params 而 params 前面利用了 LinearLayout.LayoutParams來做設定的寬高模式
            v.setLayoutParams(new GridLayout.LayoutParams(params));
            //設定圖的縮放型態
            v.setScaleType(ImageView.ScaleType.FIT_CENTER);
            //圖與圖的內距 就是圖跟圖上下左右要有點距離
            v.setPadding(10,10,10,10);
        }
        else{
            v = (ImageView)convertView;  //這是多型
        }

        //依position順序排列縮圖 這裡才開始貼圖
        v.setImageResource(imgArr[position]);

        return v;
    }
}
