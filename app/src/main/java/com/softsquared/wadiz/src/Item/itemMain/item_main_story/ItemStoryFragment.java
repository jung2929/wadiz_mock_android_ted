package com.softsquared.wadiz.src.Item.itemMain.item_main_story;

import android.content.Intent;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.Item.itemMain.ItemMainActivity;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.Adapters.ItemRvAdapter;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.interfaces.ItemStoryActivityView;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.ItemRewardlist;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.ItemStorylist;
import com.softsquared.wadiz.src.Item.itemMain.policy.PolicyActivity;
import com.softsquared.wadiz.src.common.RecyclerDecoration;
import com.softsquared.wadiz.src.common.SaveSharedPreference;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class ItemStoryFragment extends BaseFragment implements ItemStoryActivityView {
    View view;
    TextView tvName, tvCategory, tvInfo, tvDay, tvPercent, tvMoney, tvSupporter, tvGoalmoney, tvFundingday, tvFinishday, tvMain, tvSchedule, tvQna, tvDelivery, tvCompany_name;
    ImageView ivMainimage;
    CircleImageView ivCompany_image;
    ProgressBar pb;
    Button btnFunding, btnLike, btnMore, btnLess, btnCompany_homepage;
    RecyclerView rvItem;
    NestedScrollView scrollView;
    WebView mWv;
    public String mTitle;
    WebSettings mWvSetting;
    int mProjectIdx;
    ArrayList<ItemRewardlist> mItemRewardList;

    public ItemStoryFragment() {

    }

    public static ItemStoryFragment newInstance() {
        ItemStoryFragment itemmainstoryFragment = new ItemStoryFragment();
        return itemmainstoryFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_main_story, container, false);
        tvName = view.findViewById(R.id.item_main_tv_name);
        tvCategory = view.findViewById(R.id.item_main_tv_category);
        tvInfo = view.findViewById(R.id.item_main_tv_info);
        tvDay =view.findViewById(R.id.item_main_tv_day);
        tvPercent = view.findViewById(R.id.item_main_tv_percent);
        tvMoney = view.findViewById(R.id.item_main_tv_money);
        tvSupporter = view.findViewById(R.id.item_main_tv_supporter);
        tvGoalmoney = view.findViewById(R.id.item_main_tv_goalmoney);
        tvFundingday = view.findViewById(R.id.item_main_tv_fundingday);
        tvCompany_name = view.findViewById(R.id.item_main_tv_company_name);
        ivMainimage = view.findViewById(R.id.item_main_iv_mainimage);
        btnMore = view.findViewById(R.id.item_main_btn_more);
        btnLess = view.findViewById(R.id.item_main_btn_less);
        ivCompany_image = view.findViewById(R.id.item_main_iv_companyimage);
        pb = view.findViewById(R.id.item_main_progress);
        btnFunding = view.findViewById(R.id.item_main_btn_funding);
        btnLike = view.findViewById(R.id.item_main_btn_like);
        btnCompany_homepage = view.findViewById(R.id.item_main_btn_company_homepage);
        scrollView = view.findViewById(R.id.item_main_sv);
        mWv = view.findViewById(R.id.item_main_story_wv);
        mItemRewardList = new ArrayList<>();

        mProjectIdx = ((ItemMainActivity)getActivity()).mProjectIdx;

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

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trypostLike();
            }
        });



        btnFunding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PolicyActivity.class);
                intent.putExtra("projectidx",mProjectIdx);
                startActivity(intent);
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

        final ItemStoryService itemStoryService = new ItemStoryService(this);
        itemStoryService.getStory(mProjectIdx, SaveSharedPreference.getUserToken(getActivity()));
        itemStoryService.getReward(mProjectIdx, SaveSharedPreference.getUserToken(getActivity()));
    }
    private void trypostLike() {
        showProgressDialog();

        final ItemStoryService itemStoryService = new ItemStoryService(this);
        itemStoryService.postLike(mProjectIdx, SaveSharedPreference.getUserToken(getActivity()));
    }

    @Override
    public void validateLikeSuccess(int code) {
        hideProgressDialog();
        if (code == 201){
            Toast.makeText(getActivity(), "좋아하는 프로젝트에서 제외 되었습니다.",Toast.LENGTH_SHORT).show();
        } else  if (code == 200) {
            Toast.makeText(getActivity(), "좋아하는 프로젝트 저장 완료!\n마이메뉴 > 좋아한 에서 확인 할 수 있습니다.",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void validateLikeFailure(String message) {
        hideProgressDialog();

    }

    @Override
    public void validateStorySuccess(ItemStorylist item) {
        hideProgressDialog();
        tvName.setText(item.getName());
        tvCategory.setText(item.getCategory());
        tvInfo.setText(item.getInfoText());
        ((ItemMainActivity)getActivity()).tvTitleName.setText(item.getName());
        ((ItemMainActivity)getActivity()).mTitle = item.getName();
        tvDay.setText(((ItemMainActivity)getActivity()).mDay);
        tvPercent.setText(((ItemMainActivity)getActivity()).mPercent);
        tvMoney.setText(((ItemMainActivity)getActivity()).mMoney);
        tvGoalmoney.setText(item.getGoal());
        tvFundingday.setText(item.getTerm());
        tvCompany_name.setText(item.getMakerName());
        Glide.with(getActivity()).load(item.getMakerImg()).into(ivCompany_image);
        if (item.getFacebook() != null ){
            btnCompany_homepage.setText(item.getFacebook());
        } else if (item.getInstagram() != null) {
            btnCompany_homepage.setText(item.getInstagram());
        } else {
            btnCompany_homepage.setText("");
        }


        tvSupporter.setText(item.getSupporter());
        Glide.with(getActivity()).load(item.getImage()).into(ivMainimage);
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

        // 프로그레스 바
        int idx = (((ItemMainActivity)getActivity()).mPercent).indexOf("%");
        pb.setProgress(Integer.parseInt(((ItemMainActivity)getActivity()).mPercent.substring(0,idx)));

    }

    @Override
    public void validateStoryFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void validateRewardSuccess(ArrayList<ItemRewardlist> item) {
        hideProgressDialog();


        //리사이클러 뷰 간 간격 조정
        RecyclerDecoration recyclerDecoration = new RecyclerDecoration(20);

        //아이템 리사이클러뷰 생성
        rvItem = view.findViewById(R.id.item_main_rv);
        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemRvAdapter itemRvAdapter = new ItemRvAdapter(item, getActivity());
        rvItem.addItemDecoration(recyclerDecoration);
        rvItem.setAdapter(itemRvAdapter);

    }

    @Override
    public void validateRewardFailure(String message) {
        hideProgressDialog();

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