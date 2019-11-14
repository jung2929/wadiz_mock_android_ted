package com.softsquared.wadiz.src.join;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.join.interfaces.MainActivityView;
import com.softsquared.wadiz.src.join.join_email.JoinEmailFragment;
import com.softsquared.wadiz.src.join.join_home.JoinHomeFragment;
import com.softsquared.wadiz.src.main.MainActivity;


public class JoinActivity extends BaseActivity implements MainActivityView {

    Button mBtnLogin;
    ImageButton ibBack, ibHome;
    public Fragment mHomeFragment, mEmailFragment;
    public FragmentManager mFragmentManager;
    public Context mContext;


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        mContext = this;

        ibBack= findViewById(R.id.join_ib_back);
        ibHome = findViewById(R.id.join_ib_home);
        mBtnLogin = findViewById(R.id.join_btn_login);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ((MainActivity)MainActivity.mcontext).onFragmentChange(0);
                startActivity(intent);
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mHomeFragment = new JoinHomeFragment();
        mEmailFragment = new JoinEmailFragment();

     replaceFragment(mHomeFragment);
    }
    public void replaceFragment(Fragment fragment) {
        mFragmentManager = getSupportFragmentManager();

        mFragmentManager.beginTransaction().replace(R.id.join_container, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
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
