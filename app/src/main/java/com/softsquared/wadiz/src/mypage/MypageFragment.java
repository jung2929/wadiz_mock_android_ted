package com.softsquared.wadiz.src.mypage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.editprofile.EditprofileActivity;
import com.softsquared.wadiz.src.mypage.interfaces.MainActivityView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class MypageFragment extends BaseFragment implements MainActivityView {
    View view;
    Button btnEditprofile;
    Context myContext;
    TextView tvName, tvMember, tvIntroduce, tvInterest1, tvInterest2, tvInterest3, tvInterest4, tvInterest5, tvInterest6, tvInterest7, tvInterest8;
    CircleImageView ivProfile;

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

        btnEditprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditprofileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        return view;
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
