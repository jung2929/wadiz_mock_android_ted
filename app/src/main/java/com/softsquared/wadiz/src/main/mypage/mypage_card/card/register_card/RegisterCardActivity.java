package com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.card1.Card1Fragment;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.interfaces.RegisterCardActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.models.RegisterCardList;

import java.util.ArrayList;


public class RegisterCardActivity extends BaseActivity implements RegisterCardActivityView {
    FragmentManager fragmentManager;
    Button btnX;
    Fragment card1Fragment;
    Intent intent;
    String mainstring;
    public String mCardnum, mBirth;
    public RegisterCardList mRegisterCardList;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeer_card);

        intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        mRegisterCardList = new RegisterCardList(null, null);

        btnX = findViewById(R.id.register_card_btn_x);

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        fragmentManager = getSupportFragmentManager();

        card1Fragment = new Card1Fragment();
        fragmentManager.beginTransaction().replace(R.id.register_card_container, card1Fragment).commitAllowingStateLoss();

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed(); 뒤로가기 막기
    }

    public void replaceFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.register_card_container, fragment).commit();
    }

    public void putIntent(String name, String string) {
        intent.putExtra(name, string);
        System.out.println("인텐트 담기 : " + string);
        mainstring = string;
    }

    public void startIntent() {
        System.out.println("인텐트 보내기 : " + mainstring);
        intent.putExtra("cardnum", mainstring);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void tryGetTest() {
        showProgressDialog();

        final RegisterCardService registerCardService = new RegisterCardService(this);
        registerCardService.getTest(SaveSharedPreference.getUserToken(getApplicationContext()), mRegisterCardList);
    }

    @Override
    public void validateSuccess(boolean success, int code, String message) {
        hideProgressDialog();
        if (code == 200) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(),"카드 정보 입력중 오류가 발생했습니다.",Toast.LENGTH_SHORT).show();
            finish();
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
