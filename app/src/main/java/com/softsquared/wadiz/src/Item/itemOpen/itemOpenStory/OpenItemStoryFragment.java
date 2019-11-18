package com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.Item.itemOpen.ItemOpenActivity;
import com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.interfaces.OpenItemStoryActivityView;
import com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.models.ItemOpenlist;
import com.softsquared.wadiz.src.common.SaveSharedPreference;

import de.hdodenhof.circleimageview.CircleImageView;


public class OpenItemStoryFragment extends BaseFragment implements OpenItemStoryActivityView {
    View view;
    TextView tvName, tvCategory, tvInfo, tvDay, tvCompany_name,mTvMakerName;
    ImageView ivMainimage;
    CircleImageView ivCompany_image;
    Button btnMore, btnLess, btnCompany_homepage;
    RecyclerView rvItem;
    NestedScrollView scrollView;
    WebView mWv;
    WebSettings mWvSetting;
    int mProjectIdx;

    public OpenItemStoryFragment() {

    }

    public static OpenItemStoryFragment newInstance() {
        OpenItemStoryFragment itemmainstoryFragment = new OpenItemStoryFragment();
        return itemmainstoryFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_open_story, container, false);
        tvName = view.findViewById(R.id.item_open_tv_name);
        tvInfo = view.findViewById(R.id.item_open_tv_info);
        tvDay =view.findViewById(R.id.item_open_tv_day);
        mTvMakerName = view.findViewById(R.id.item_open_tv_maker);
        tvCompany_name = view.findViewById(R.id.item_open_tv_maker);
        ivMainimage = view.findViewById(R.id.item_open_iv_mainimage);
        tvDay = view.findViewById(R.id.item_open_tv_day);
        btnMore = view.findViewById(R.id.item_open_btn_more);
        btnLess = view.findViewById(R.id.item_open_btn_less);
        ivCompany_image = view.findViewById(R.id.item_open_iv_maker);
        scrollView = view.findViewById(R.id.item_open_sv);
        mWv = view.findViewById(R.id.item_open_story_wv);

        mProjectIdx = ((ItemOpenActivity)getActivity()).mProjectIdx;
        System.out.println("프로젝트 번호 : " + mProjectIdx);

        tryGetTest();

//        더보기 기능
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                btnMore.setVisibility(View.GONE);
                btnLess.setVisibility(View.VISIBLE);
            }
        });

//      접기
        btnLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float dp =  getResources().getDisplayMetrics().density;
                mWv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int)(300*dp)));
                btnMore.setVisibility(View.VISIBLE);
                btnLess.setVisibility(View.GONE);
            }
        });


        return view;
    }

    public void scrollstart() {
        scrollToView(rvItem, scrollView, 0);
    }

    //스크롤뷰를 내리기 위한 클래스
    public static void scrollToView(View view, final NestedScrollView scrollView, int count) {
        if (view != null && view != scrollView) {
            count += view.getTop();
            scrollToView((View) view.getParent(), scrollView, count);
        } else if (scrollView != null) {
            final int finalCount = count;
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    scrollView.smoothScrollTo(0, finalCount);
                }
            }, 200);
        }
    }

    private void tryGetTest() {
        showProgressDialog();

        final OpenItemStoryService openItemStoryService = new OpenItemStoryService(this);
        openItemStoryService.getTest(mProjectIdx, SaveSharedPreference.getUserToken(getActivity()));
    }

    @Override
    public void validateSuccess(ItemOpenlist item) {
        hideProgressDialog();
        tvName.setText(item.getName());
        tvInfo.setText(item.getInfoText());
        Glide.with(getActivity()).load(item.getImage()).into(ivMainimage);
        ((ItemOpenActivity)getActivity()).tvTitleName.setText(item.getName());
        mTvMakerName.setText(item.getMakername());
        Glide.with(getActivity()).load(item.getMakerimg()).into(ivCompany_image);

        // 웹뷰 붙이기
        mWv.setWebViewClient(new WebViewClient());
        mWvSetting = mWv.getSettings();
        mWvSetting.setJavaScriptEnabled(true);
        mWvSetting.setSupportZoom(true);
        mWvSetting.setBuiltInZoomControls(true);
        mWvSetting.setDisplayZoomControls(true);
        mWvSetting.setLoadWithOverviewMode(true);
        mWvSetting.setUseWideViewPort(true);
        mWv.loadData(item.getStory(), "text/html; charset=UTF-8", null);


    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
//            case R.id.main_btn_hello_world:
//                tryGetTest();
//                break;
            default:
                break;
        }
    }
}