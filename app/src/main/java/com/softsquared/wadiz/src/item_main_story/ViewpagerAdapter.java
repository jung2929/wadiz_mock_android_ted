package com.softsquared.wadiz.src.item_main_story;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.softsquared.wadiz.R;

import java.util.ArrayList;


public class ViewpagerAdapter extends PagerAdapter {

    private Context mContext = null ; // LayoutInflater 서비스 사용을 위한 Context 참조 저장.
    final int view_count = 3 ; //배너 갯수

    public ViewpagerAdapter() {

    }
    // Context를 전달받아 mContext에 저장하는 생성자 추가.
    public ViewpagerAdapter(Context context) {
        mContext = context ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null ;
        ArrayList<Integer> imgarray = new ArrayList<>();
        imgarray.add(R.drawable.banner0);
        imgarray.add(R.drawable.banner1);
        imgarray.add(R.drawable.banner2);

        if (mContext != null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.viewpager_item, container,false);
            ImageView ivBanner = view.findViewById(R.id.vp_tem_iv);
            position %= view_count;
            ivBanner.setImageResource(imgarray.get(position));
        }

        // 뷰페이저에 추가.
        container.addView(view);

        return view ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // 뷰페이저에서 삭제.
        container.removeView((View) object);
    }

    @Override
    public int getCount() {

        return view_count*3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View)object);
    }
}
