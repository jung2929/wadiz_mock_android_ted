package com.softsquared.wadiz.src.main.reward.reward_home;

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

        ArrayList<String> maintvarray = new ArrayList<>();
        maintvarray.add("휴일 1도 없는 11월, 휴식이 필요해");
        maintvarray.add("지금 배고픈 사람 손 들어보세요");
        maintvarray.add("피부, 영양관리 잘하고 있나요?");

        ArrayList<String> subtvarray = new ArrayList<>();
        subtvarray.add("오늘도 고생한 당신을 위한 리워드");
        subtvarray.add("그 손 그대로 이 리워드를 눌러봐요");
        subtvarray.add("찬바람 불 때 필요한 리워드");



        if (mContext != null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.viewpager_banner, container,false);

            ImageView ivBanner = view.findViewById(R.id.banner_iv);
            TextView tvBannermain = view.findViewById(R.id.banner_maintv);
            TextView tvBannersub  = view.findViewById(R.id.banner_subtv);

            position %= view_count;

            ivBanner.setImageResource(imgarray.get(position));
            tvBannermain.setText(maintvarray.get(position));
            tvBannersub.setText(subtvarray.get(position));


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
