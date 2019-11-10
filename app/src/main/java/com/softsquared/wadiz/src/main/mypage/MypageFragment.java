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

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.mypage.editprofile.EditprofileActivity;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.main.mypage.interfaces.MainActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_card.Mypage_cardFragment;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.Mypage_fundingFragment;
import com.softsquared.wadiz.src.main.mypage.mypage_like.Mypage_likeFragment;

import de.hdodenhof.circleimageview.CircleImageView;


public class MypageFragment extends BaseFragment implements MainActivityView {
    View view;
    Button btnEditprofile;
    Context myContext;
    TextView tvName, tvMember, tvIntroduce, tvInterest1, tvInterest2, tvInterest3, tvInterest4, tvInterest5, tvInterest6, tvInterest7, tvInterest8, tvNum;
    TextView mtvCardnum;
    CircleImageView ivProfile;
    Mypage_fundingFragment fundingFragment;
    Mypage_likeFragment likeFragment;
    Mypage_cardFragment cardFragment;
    Button btnFunding, btnLike, btnCard;
    FragmentManager fragmentManager;
    public static LinearLayout mllCardregister;
    RelativeLayout mrlCardInfo;
    MainActivity mainActivity = new MainActivity();


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
        tvIntroduce = view.findViewById(R.id.mypage_tv_member);
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

        fundingFragment = new Mypage_fundingFragment();
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
            if (likeFragment != null) fragmentManager.beginTransaction().hide(likeFragment).commitAllowingStateLoss();
            if (cardFragment != null) fragmentManager.beginTransaction().hide(cardFragment).commitAllowingStateLoss();
            if (fundingFragment == null) {
                fundingFragment = new Mypage_fundingFragment();
                fragmentManager.beginTransaction().add(R.id.main_fl_container,fundingFragment).commitAllowingStateLoss();
            } else {
                if (fundingFragment != null) fragmentManager.beginTransaction().show(fundingFragment).commitAllowingStateLoss();
            }
            btnFunding.setTypeface(null, Typeface.BOLD);
            btnFunding.setTextColor(ContextCompat.getColor(myContext,R.color.percent));
            Drawable img_click = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_click);
            btnFunding.setBackground(img_click);
            btnLike.setTypeface(null,Typeface.NORMAL);
            btnCard.setTypeface(null,Typeface.NORMAL);
            btnLike.setTextColor(ContextCompat.getColor(myContext,R.color.black));
            btnCard.setTextColor(ContextCompat.getColor(myContext,R.color.black));
            Drawable img_nonclick = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_nonclick);
            btnCard.setBackground(img_nonclick);
            btnLike.setBackground(img_nonclick);

        } else if (index==1) { //좋아한
            if (fundingFragment != null) fragmentManager.beginTransaction().hide(fundingFragment).commitAllowingStateLoss();
            if (cardFragment != null) fragmentManager.beginTransaction().hide(cardFragment).commitAllowingStateLoss();
            if (likeFragment == null) {
                likeFragment = new Mypage_likeFragment();
                fragmentManager.beginTransaction().add(R.id.mypage_fl_container,likeFragment).commitAllowingStateLoss();

            } else {
                if (likeFragment != null) fragmentManager.beginTransaction().show(likeFragment).commitAllowingStateLoss();

            }
            btnLike.setTypeface(null, Typeface.BOLD);
            btnLike.setTextColor(ContextCompat.getColor(myContext,R.color.percent));
            Drawable img_click = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_click);
            btnLike.setBackground(img_click);
            btnFunding.setTypeface(null,Typeface.NORMAL);
            btnCard.setTypeface(null,Typeface.NORMAL);
            btnFunding.setTextColor(ContextCompat.getColor(myContext,R.color.black));
            btnCard.setTextColor(ContextCompat.getColor(myContext,R.color.black));
            Drawable img_nonclick = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_nonclick);
            btnCard.setBackground(img_nonclick);
            btnFunding.setBackground(img_nonclick);

        } else if (index==2) { //간편카드정보
            if (fundingFragment != null) fragmentManager.beginTransaction().hide(fundingFragment).commitAllowingStateLoss();
            if (likeFragment != null) fragmentManager.beginTransaction().hide(likeFragment).commitAllowingStateLoss();
            if (cardFragment == null) {
                cardFragment = new Mypage_cardFragment();
                fragmentManager.beginTransaction().add(R.id.mypage_fl_container,cardFragment).commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().show(cardFragment).commitAllowingStateLoss();
            }
            btnCard.setTypeface(null, Typeface.BOLD);
            btnCard.setTextColor(ContextCompat.getColor(myContext,R.color.percent));
            Drawable img_click = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_click);
            btnCard.setBackground(img_click);
            btnFunding.setTypeface(null,Typeface.NORMAL);
            btnLike.setTypeface(null,Typeface.NORMAL);
            btnFunding.setTextColor(ContextCompat.getColor(myContext,R.color.black));
            btnLike.setTextColor(ContextCompat.getColor(myContext,R.color.black));
            Drawable img_nonclick = getActivity().getResources().getDrawable(R.drawable.customborder_mypage_nonclick);
            btnLike.setBackground(img_nonclick);
            btnFunding.setBackground(img_nonclick);
        }
    }

    @Override
    public void onResume() {
        Intent getintent = getActivity().getIntent();
        tvIntroduce.setText(getintent.getStringExtra("introducetext"));

        if (getintent.getBooleanExtra("interest1", false)) tvInterest1.setVisibility(View.VISIBLE);
        if (getintent.getBooleanExtra("interest2", false)) tvInterest2.setVisibility(View.VISIBLE);
        if (getintent.getBooleanExtra("interest3", false)) tvInterest3.setVisibility(View.VISIBLE);
        if (getintent.getBooleanExtra("interest4", false)) tvInterest4.setVisibility(View.VISIBLE);
        if (getintent.getBooleanExtra("interest5", false)) tvInterest5.setVisibility(View.VISIBLE);
        if (getintent.getBooleanExtra("interest6", false)) tvInterest6.setVisibility(View.VISIBLE);
        if (getintent.getBooleanExtra("interest7", false)) tvInterest7.setVisibility(View.VISIBLE);
        if (getintent.getBooleanExtra("interest8", false)) tvInterest8.setVisibility(View.VISIBLE);

        super.onResume();
    }


    public void onAttach(Context context) {
        myContext = (FragmentActivity) context;


        super.onAttach(context);
    }

    private void tryGetTest() {
        showProgressDialog();

        final MainService mainService = new MainService(this);
        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
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
