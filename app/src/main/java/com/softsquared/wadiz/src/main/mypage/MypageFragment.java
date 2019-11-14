package com.softsquared.wadiz.src.main.mypage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.mypage.editprofile.EditprofileActivity;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.main.mypage.interfaces.MypageActivityView;
import com.softsquared.wadiz.src.main.mypage.models.MypageList;
import com.softsquared.wadiz.src.main.mypage.mypage_card.MypageCardFragment;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.MypageFundingFragment;
import com.softsquared.wadiz.src.main.mypage.mypage_like.MypageLikeFragment;

import de.hdodenhof.circleimageview.CircleImageView;


public class MypageFragment extends BaseFragment implements MypageActivityView {
    View view;
    Button btnEditprofile;
    Context myContext;
    TextView tvName, tvMember, tvIntroduce, tvInterest1, tvInterest2, tvInterest3, tvInterest4, tvInterest5, tvInterest6, tvInterest7, tvInterest8, tvNum;
    TextView mtvCardnum;
    CircleImageView ivProfile;
    MypageFundingFragment fundingFragment;
    MypageLikeFragment likeFragment;
    MypageCardFragment cardFragment;
    Button btnFunding, btnLike, btnCard, mBtnLogout;
    FragmentManager fragmentManager;
    public static LinearLayout mllCardregister;
    RelativeLayout mrlCardInfo;
    public boolean[] mInterestNum = new boolean[8];
    public String mInfo;


    public MypageFragment() {

    }

    public static MypageFragment newInstance() {
        MypageFragment mypageFragment = new MypageFragment();
        return mypageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage, container, false);
        btnEditprofile = view.findViewById(R.id.mypage_btn_edit);
        tvName = view.findViewById(R.id.mypage_tv_name);
        tvMember = view.findViewById(R.id.mypage_tv_member);
        tvIntroduce = view.findViewById(R.id.mypage_tv_introduce);
        tvInterest1 = view.findViewById(R.id.mypage_tv_interest1);
        tvInterest2 = view.findViewById(R.id.mypage_tv_interest2);
        tvInterest3 = view.findViewById(R.id.mypage_tv_interest3);
        tvInterest4 = view.findViewById(R.id.mypage_tv_interest4);
        tvInterest5 = view.findViewById(R.id.mypage_tv_interest5);
        tvInterest6 = view.findViewById(R.id.mypage_tv_interest6);
        tvInterest7 = view.findViewById(R.id.mypage_tv_interest7);
        tvInterest8 = view.findViewById(R.id.mypage_tv_interest8);
        ivProfile = view.findViewById(R.id.mypage_iv_profile);
        mllCardregister = view.findViewById(R.id.mypage_card_ll_register);
        mrlCardInfo = view.findViewById(R.id.mypage_card_rl_card);
        mtvCardnum = view.findViewById(R.id.mypage_card_tv_cardnum);
        mBtnLogout = view.findViewById(R.id.mypage_btn_logout);


        btnEditprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditprofileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent, 2000); // 프로필 수정 액티비티 호출 리퀘스트 코드 : 3000
            }
        });

        btnFunding = view.findViewById(R.id.mypage_btn_funding);
        btnLike = view.findViewById(R.id.mypage_btn_like);
        btnCard = view.findViewById(R.id.mypage_btn_card);

        fragmentManager = getActivity().getSupportFragmentManager();

        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.clearUserToken(getActivity());
                ((MainActivity) MainActivity.mcontext).onFragmentChange(1);
            }
        });

        fundingFragment = new MypageFundingFragment();
        fragmentManager.beginTransaction().replace(R.id.mypage_fl_container, fundingFragment).commitAllowingStateLoss();

        btnFunding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentChange(0);
            }
        });

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentChange(1);
            }
        });

        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentChange(2);
            }
        });


        return view;
    }


    public void onFragmentChange(int index) {
        if (index == 0) { //펀딩한
            if (fundingFragment == null) {
                fundingFragment = new MypageFundingFragment();
                fragmentManager.beginTransaction().replace(R.id.mypage_fl_container, fundingFragment).commitAllowingStateLoss();
            } else {
                if (fundingFragment != null)
                    fragmentManager.beginTransaction().replace(R.id.mypage_fl_container, fundingFragment).commitAllowingStateLoss();
            }
            btnFunding.setTypeface(null, Typeface.BOLD);
            btnFunding.setTextColor(ContextCompat.getColor(myContext, R.color.percent));
            Drawable img_click = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_click);
            btnFunding.setBackground(img_click);
            btnLike.setTypeface(null, Typeface.NORMAL);
            btnCard.setTypeface(null, Typeface.NORMAL);
            btnLike.setTextColor(ContextCompat.getColor(myContext, R.color.black));
            btnCard.setTextColor(ContextCompat.getColor(myContext, R.color.black));
            Drawable img_nonclick = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_nonclick);
            btnCard.setBackground(img_nonclick);
            btnLike.setBackground(img_nonclick);

        } else if (index == 1) { //좋아한
            if (likeFragment == null) {
                likeFragment = new MypageLikeFragment();
                fragmentManager.beginTransaction().replace(R.id.mypage_fl_container, likeFragment).commitAllowingStateLoss();

            } else {
                if (likeFragment != null)
                    fragmentManager.beginTransaction().replace(R.id.mypage_fl_container, likeFragment).commitAllowingStateLoss();
            }
            btnLike.setTypeface(null, Typeface.BOLD);
            btnLike.setTextColor(ContextCompat.getColor(myContext, R.color.percent));
            Drawable img_click = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_click);
            btnLike.setBackground(img_click);
            btnFunding.setTypeface(null, Typeface.NORMAL);
            btnCard.setTypeface(null, Typeface.NORMAL);
            btnFunding.setTextColor(ContextCompat.getColor(myContext, R.color.black));
            btnCard.setTextColor(ContextCompat.getColor(myContext, R.color.black));
            Drawable img_nonclick = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_nonclick);
            btnCard.setBackground(img_nonclick);
            btnFunding.setBackground(img_nonclick);

        } else if (index == 2) { //간편카드정보
            if (cardFragment == null) {
                cardFragment = new MypageCardFragment();
                fragmentManager.beginTransaction().replace(R.id.mypage_fl_container, cardFragment).commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().replace(R.id.mypage_fl_container, cardFragment).commitAllowingStateLoss();
            }
            btnCard.setTypeface(null, Typeface.BOLD);
            btnCard.setTextColor(ContextCompat.getColor(myContext, R.color.percent));
            Drawable img_click = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_click);
            btnCard.setBackground(img_click);
            btnFunding.setTypeface(null, Typeface.NORMAL);
            btnLike.setTypeface(null, Typeface.NORMAL);
            btnFunding.setTextColor(ContextCompat.getColor(myContext, R.color.black));
            btnLike.setTextColor(ContextCompat.getColor(myContext, R.color.black));
            Drawable img_nonclick = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_nonclick);
            btnLike.setBackground(img_nonclick);
            btnFunding.setBackground(img_nonclick);
        }
    }

    @Override
    public void onResume() {
        tryGetTest();

        super.onResume();
    }


    public void onAttach(Context context) {
        myContext = (FragmentActivity) context;


        super.onAttach(context);
    }

    private void tryGetTest() {
        showProgressDialog();
        String token = SaveSharedPreference.getUserToken(getActivity());
        final MypageService mypageService = new MypageService(this);
        mypageService.getProfile(token);
    }

    @Override
    public void validateSuccess(MypageList mypageList) {
        hideProgressDialog();

        tvName.setText(mypageList.getName());
        Glide.with(myContext).load(mypageList.getImg()).into(ivProfile);
        System.out.println(SaveSharedPreference.getUserToken(myContext));

        if (mypageList.getUserInfo() != null) {
            tvIntroduce.setText(mypageList.getUserInfo());
            tvIntroduce.setVisibility(View.VISIBLE);
        } else {
            tvIntroduce.setVisibility(View.GONE);
        }

        if (!mypageList.getInterestList().isEmpty()) {
            if (mypageList.getInterestList().size() == 1) {
                tvInterest1.setText(mypageList.getInterestList().get(0).getInterest());
                tvInterest1.setVisibility(View.VISIBLE);
            } else {
                tvInterest2.setVisibility(View.GONE);
                tvInterest3.setVisibility(View.GONE);
                tvInterest4.setVisibility(View.GONE);
                tvInterest5.setVisibility(View.GONE);
                tvInterest6.setVisibility(View.GONE);
                tvInterest7.setVisibility(View.GONE);
                tvInterest8.setVisibility(View.GONE);
            }
            if (mypageList.getInterestList().size() == 2) {
                tvInterest1.setText(mypageList.getInterestList().get(0).getInterest());
                tvInterest1.setVisibility(View.VISIBLE);
                tvInterest2.setText(mypageList.getInterestList().get(1).getInterest());
                tvInterest2.setVisibility(View.VISIBLE);
            } else {
                tvInterest3.setVisibility(View.GONE);
                tvInterest4.setVisibility(View.GONE);
                tvInterest5.setVisibility(View.GONE);
                tvInterest6.setVisibility(View.GONE);
                tvInterest7.setVisibility(View.GONE);
                tvInterest8.setVisibility(View.GONE);
            }
            if (mypageList.getInterestList().size() == 3) {
                tvInterest1.setText(mypageList.getInterestList().get(0).getInterest());
                tvInterest1.setVisibility(View.VISIBLE);
                tvInterest2.setText(mypageList.getInterestList().get(1).getInterest());
                tvInterest2.setVisibility(View.VISIBLE);
                tvInterest3.setText(mypageList.getInterestList().get(2).getInterest());
                tvInterest3.setVisibility(View.VISIBLE);
            } else {
                tvInterest4.setVisibility(View.GONE);
                tvInterest5.setVisibility(View.GONE);
                tvInterest6.setVisibility(View.GONE);
                tvInterest7.setVisibility(View.GONE);
                tvInterest8.setVisibility(View.GONE);
            }
            if (mypageList.getInterestList().size() == 4) {
                tvInterest1.setText(mypageList.getInterestList().get(0).getInterest());
                tvInterest1.setVisibility(View.VISIBLE);
                tvInterest2.setText(mypageList.getInterestList().get(1).getInterest());
                tvInterest2.setVisibility(View.VISIBLE);
                tvInterest3.setText(mypageList.getInterestList().get(2).getInterest());
                tvInterest3.setVisibility(View.VISIBLE);
                tvInterest4.setText(mypageList.getInterestList().get(3).getInterest());
                tvInterest4.setVisibility(View.VISIBLE);
            } else {
                tvInterest5.setVisibility(View.GONE);
                tvInterest6.setVisibility(View.GONE);
                tvInterest7.setVisibility(View.GONE);
                tvInterest8.setVisibility(View.GONE);
            }
            if (mypageList.getInterestList().size() == 5) {
                tvInterest1.setText(mypageList.getInterestList().get(0).getInterest());
                tvInterest1.setVisibility(View.VISIBLE);
                tvInterest2.setText(mypageList.getInterestList().get(1).getInterest());
                tvInterest2.setVisibility(View.VISIBLE);
                tvInterest3.setText(mypageList.getInterestList().get(2).getInterest());
                tvInterest3.setVisibility(View.VISIBLE);
                tvInterest4.setText(mypageList.getInterestList().get(3).getInterest());
                tvInterest4.setVisibility(View.VISIBLE);
                tvInterest5.setText(mypageList.getInterestList().get(4).getInterest());
                tvInterest5.setVisibility(View.VISIBLE);
            } else {
                tvInterest6.setVisibility(View.GONE);
                tvInterest7.setVisibility(View.GONE);
                tvInterest8.setVisibility(View.GONE);
            }
            if (mypageList.getInterestList().size() == 6) {
                tvInterest1.setText(mypageList.getInterestList().get(0).getInterest());
                tvInterest1.setVisibility(View.VISIBLE);
                tvInterest2.setText(mypageList.getInterestList().get(1).getInterest());
                tvInterest2.setVisibility(View.VISIBLE);
                tvInterest3.setText(mypageList.getInterestList().get(2).getInterest());
                tvInterest3.setVisibility(View.VISIBLE);
                tvInterest4.setText(mypageList.getInterestList().get(3).getInterest());
                tvInterest4.setVisibility(View.VISIBLE);
                tvInterest5.setText(mypageList.getInterestList().get(4).getInterest());
                tvInterest5.setVisibility(View.VISIBLE);
                tvInterest6.setText(mypageList.getInterestList().get(5).getInterest());
                tvInterest6.setVisibility(View.VISIBLE);
            } else {
                tvInterest7.setVisibility(View.GONE);
                tvInterest8.setVisibility(View.GONE);
            }
            if (mypageList.getInterestList().size() == 7) {
                tvInterest1.setText(mypageList.getInterestList().get(0).getInterest());
                tvInterest1.setVisibility(View.VISIBLE);
                tvInterest2.setText(mypageList.getInterestList().get(1).getInterest());
                tvInterest2.setVisibility(View.VISIBLE);
                tvInterest3.setText(mypageList.getInterestList().get(2).getInterest());
                tvInterest3.setVisibility(View.VISIBLE);
                tvInterest4.setText(mypageList.getInterestList().get(3).getInterest());
                tvInterest4.setVisibility(View.VISIBLE);
                tvInterest5.setText(mypageList.getInterestList().get(4).getInterest());
                tvInterest5.setVisibility(View.VISIBLE);
                tvInterest6.setText(mypageList.getInterestList().get(5).getInterest());
                tvInterest6.setVisibility(View.VISIBLE);
                tvInterest7.setText(mypageList.getInterestList().get(6).getInterest());
                tvInterest7.setVisibility(View.VISIBLE);
            } else {
                tvInterest8.setVisibility(View.GONE);
            }
            if (mypageList.getInterestList().size() == 8) {
                tvInterest1.setText(mypageList.getInterestList().get(0).getInterest());
                tvInterest1.setVisibility(View.VISIBLE);
                tvInterest2.setText(mypageList.getInterestList().get(1).getInterest());
                tvInterest2.setVisibility(View.VISIBLE);
                tvInterest3.setText(mypageList.getInterestList().get(2).getInterest());
                tvInterest3.setVisibility(View.VISIBLE);
                tvInterest4.setText(mypageList.getInterestList().get(3).getInterest());
                tvInterest4.setVisibility(View.VISIBLE);
                tvInterest5.setText(mypageList.getInterestList().get(4).getInterest());
                tvInterest5.setVisibility(View.VISIBLE);
                tvInterest6.setText(mypageList.getInterestList().get(5).getInterest());
                tvInterest6.setVisibility(View.VISIBLE);
                tvInterest7.setText(mypageList.getInterestList().get(6).getInterest());
                tvInterest7.setVisibility(View.VISIBLE);
                tvInterest8.setText(mypageList.getInterestList().get(7).getInterest());
                tvInterest8.setVisibility(View.VISIBLE);
            }

        } else {
            tvInterest1.setVisibility(View.GONE);
            tvInterest2.setVisibility(View.GONE);
            tvInterest3.setVisibility(View.GONE);
            tvInterest4.setVisibility(View.GONE);
            tvInterest5.setVisibility(View.GONE);
            tvInterest6.setVisibility(View.GONE);
            tvInterest7.setVisibility(View.GONE);
            tvInterest8.setVisibility(View.GONE);
        }


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
