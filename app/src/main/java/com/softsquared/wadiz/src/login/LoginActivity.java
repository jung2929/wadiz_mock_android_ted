package com.softsquared.wadiz.src.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.ApplicationClass;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.join.JoinActivity;
import com.softsquared.wadiz.src.login.interfaces.LoginActivityView;
import com.softsquared.wadiz.src.login.models.LoginList;
import com.softsquared.wadiz.src.login.models.SociaList;
import com.softsquared.wadiz.src.main.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import static com.softsquared.wadiz.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.wadiz.src.ApplicationClass.sSharedPreferences;


public class LoginActivity extends BaseActivity implements LoginActivityView {

    public static Context mContext;
    ImageButton ibBack, ibHome;
    Button btnLogin, btnJoin, btnFind, mbtnLogin;
    CheckBox cbSave;
    CallbackManager mCallbackManager;
    Button mBtnFacebook;
    LoginButton mBtnFacebookReal;
    EditText mEtEmail, mEtPw;
    TextView mTvError;
    LoginList mLoginList = new LoginList(null, null);
    SociaList mSocialList = new SociaList(null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_login);
        ibBack = findViewById(R.id.profile_edit_ib_back);
        ibHome = findViewById(R.id.profile_edit_ib_home);
        btnJoin = findViewById(R.id.login_btn_join);
        btnFind = findViewById(R.id.login_btn_find);
        cbSave = findViewById(R.id.login_cb_save);
        mBtnFacebook = findViewById(R.id.login_btn_facebook);
        mBtnFacebookReal = findViewById(R.id.login_btn_facebook_real);
        mbtnLogin = findViewById(R.id.login_btn_login);
        mEtEmail = findViewById(R.id.login_et_id);
        mEtPw = findViewById(R.id.login_et_passward);
        mTvError = findViewById(R.id.login_tv_error);

        mBtnFacebookReal.setReadPermissions("public_profile", "email");

        // Callback registration
        mCallbackManager = CallbackManager.Factory.create();
        mBtnFacebookReal.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                String fbt = loginResult.getAccessToken().getToken();
                Log.d("Success", String.valueOf(loginResult.getAccessToken()));
                mSocialList.setFbt(fbt);
                tryGetSocial();

            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "페이스북 로그인을 취소하셨습니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        if (SaveSharedPreference.getUserName(getApplicationContext()).length() != 0) {
            mEtEmail.setText(SaveSharedPreference.getUserName(getApplicationContext()));
            mLoginList.setEmail(mEtEmail.getText().toString());
        }

        mEtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mLoginList.setEmail(mEtEmail.getText().toString());
            }
        });
        mEtPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mLoginList.setPw(mEtPw.getText().toString());
            }
        });

        mBtnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnFacebookReal.performClick();
            }
        });

        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryGetLogin();
            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) MainActivity.mcontext).onFragmentChange(0);
                finish();
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void tryGetLogin() {
        showProgressDialog();

        final LoginService loginService = new LoginService(this);
        loginService.postLogin(mLoginList);
    }

    private void tryGetSocial() {
        showProgressDialog();


        final LoginService loginService = new LoginService(this);
        loginService.postSocial(mSocialList);
    }

    @Override
    public void validateLoginSuccess(String token, int code, String message) {
        hideProgressDialog();

        if (code == 200) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            setResult(RESULT_OK, intent);
            finish();
            System.out.println(token);
            SaveSharedPreference.setUserToken(getApplicationContext(), token);

            if (cbSave.isChecked()) {
                SaveSharedPreference.setUserName(getApplicationContext(), mEtEmail.getText().toString());
            } else {
                SaveSharedPreference.clearUserName(getApplicationContext());
            }
        } else {
            mTvError.setText(message);
            mTvError.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void validateLoginFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void validateSocialSuccess(String text, int code, String message, String result) {
        hideProgressDialog();
        if (code == 200) {
            String jwt = result;
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            setResult(RESULT_OK, intent);
            finish();
            SaveSharedPreference.setUserToken(getApplicationContext(), jwt);
        } else {
            mTvError.setText(message);
            mTvError.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void validateSocialFailure(String message) {
        hideProgressDialog();

    }

    public void customOnClick(View view) {
        switch (view.getId()) {
//            case R.id.main_btn_hello_world:
//                tryGetLogin();
//                break;
            default:
                break;
        }
    }
}
