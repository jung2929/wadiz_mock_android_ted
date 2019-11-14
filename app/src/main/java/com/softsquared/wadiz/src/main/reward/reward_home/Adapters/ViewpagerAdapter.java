package com.softsquared.wadiz.src.main.reward.reward_home.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerItemlist;

import java.util.ArrayList;


public class ViewpagerAdapter extends PagerAdapter {
    public ArrayList<BannerItemlist> mData = null;
    public Context mContext = null ; // LayoutInflater 서비스 사용을 위한 Context 참조 저장.
    public int view_count = 0 ; //배너 갯수

    public ViewpagerAdapter() {

    }

    // Context랑 Arraylist를 전달받아 저장하는 생성자 추가.
    public ViewpagerAdapter(Context context, ArrayList<BannerItemlist> list) {
        mContext = context;
        mData = list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null ;


        if (mContext != null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.viewpager_banner, container,false);

            ImageView ivBanner = view.findViewById(R.id.banner_iv);
            TextView tvBannermain = view.findViewById(R.id.banner_maintv);
            TextView tvBannersub  = view.findViewById(R.id.banner_subtv);

            position %= view_count;

            Glide.with(mContext).load(mData.get(position).getImage()).into(ivBanner);
            tvBannermain.setText(mData.get(position).getText());
            tvBannersub.setText(mData.get(position).getSub());
            ivBanner.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);



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
