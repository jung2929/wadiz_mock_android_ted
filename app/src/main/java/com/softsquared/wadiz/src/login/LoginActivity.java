package com.softsquared.wadiz.src.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.login.interfaces.MainActivityView;
import com.softsquared.wadiz.src.main.MainActivity;


public class LoginActivity extends BaseActivity implements MainActivityView {

    ImageButton ibBack, ibHome;
    Button btnLogin, btnJoin, btnFind;
    CheckBox cbSave;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ibBack = findViewById(R.id.profile_edit_ib_back);
        ibHome = findViewById(R.id.profile_edit_ib_home);
        btnLogin = findViewById(R.id.login_btn_login);
        btnJoin = findViewById(R.id.login_btn_join);
        btnFind = findViewById(R.id.login_btn_find);
        cbSave = findViewById(R.id.login_cb_save);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getApplicationContext()).onFragmentChange(0);
                finish();
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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
