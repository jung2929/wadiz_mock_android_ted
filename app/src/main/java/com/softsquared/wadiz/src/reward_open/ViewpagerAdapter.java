package com.softsquared.wadiz.src.reward_open;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.softsquared.wadiz.R;


public class ViewpagerAdapter extends PagerAdapter {

    // LayoutInflater 서비스 사용을 위한 Context 참조 저장.
    private Context mContext = null ;

    public ViewpagerAdapter() {

    }
    // Context를 전달받아 mContext에 저장하는 생성자 추가.
    public ViewpagerAdapter(Context context) {
        mContext = context ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null ;

        if (mContext != null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.viewpager, container, false);

            TextView textView = (TextView) view.findViewById(R.id.title) ;
            textView.setText("TEXT " + position) ;

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
        // 전체 페이지 수는 10개로 고정.
        return 10;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View)object);
    }
}
