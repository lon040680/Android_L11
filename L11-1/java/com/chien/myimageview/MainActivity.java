package com.chien.myimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ImageSwitcher switcher;
    ImageAdapter adapter;
    Context context;

    int[] thuArr = {R.drawable.img01th, R.drawable.img02th, R.drawable.img03th, R.drawable.img04th,
            R.drawable.img05th, R.drawable.img06th, R.drawable.img07th, R.drawable.img08th};
    int[] imgArr = {R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04,
            R.drawable.img05, R.drawable.img06, R.drawable.img07, R.drawable.img08};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        gridView = findViewById(R.id.gridView);
        switcher = findViewById(R.id.imgSwitcher);
        adapter = new ImageAdapter(context, thuArr);

        gridView.setAdapter(adapter);
        //點擊監聽
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switcher.setImageResource(imgArr[position]);
            }
        });
        //呈現圖片 setFactory
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView v = new ImageView(context);
                v.setBackgroundColor(0xFFBB86FC);
                v.setScaleType(ImageView.ScaleType.FIT_CENTER);
                v.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                ));
                return v;
            }
        });
        //圖片切換動畫
        switcher.setInAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in));
        switcher.setOutAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out));
    }
}