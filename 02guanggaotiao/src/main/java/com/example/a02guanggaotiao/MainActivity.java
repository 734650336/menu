package com.example.a02guanggaotiao;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TextView tv_title;
    private LinearLayout ll_point_group;
    private ArrayList<ImageView> imageViews;
    private int prepostion=0;


    private final int[] imageIds = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e };


    private int prePosition = 0;

    private boolean isDragging = false;

    // 图片标题集合
    private final String[] imageDescriptions = {
            "尚硅谷波河争霸赛！",
            "凝聚你我，放飞梦想！",
            "抱歉没座位了！",
            "7月就业名单全部曝光！",
            "平均起薪11345元"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.vp);
        tv_title=findViewById(R.id.tv_title);
        ll_point_group=findViewById(R.id.ll_point_group);

        imageViews=new ArrayList<>();

        for(int i=0;i<imageIds.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            imageViews.add(imageView);

            ImageView point =new ImageView(this);
            point.setBackgroundResource(R.drawable.point_select);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(8,8);




            if(i==0){
                point.setEnabled(true);
            }

            else {
                point.setEnabled(false);
                params.leftMargin=8;
            }

            point.setLayoutParams(params);
            ll_point_group.addView(point);


        }

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViews.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

                return view==o;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {

                ImageView imageView = imageViews.get(position);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                super.destroyItem(container, position, object);
                container.removeView((View) object);
            }
        });

        tv_title.setText(imageDescriptions[0]);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                tv_title.setText(imageDescriptions[i]);
                ll_point_group.getChildAt(prePosition).setEnabled(false);
                ll_point_group.getChildAt(i).setEnabled(true);
                prePosition=i;


            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }
}
