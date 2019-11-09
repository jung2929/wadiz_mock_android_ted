package com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.card1.Card1Fragment;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.interfaces.MainActivityView;


public class Register_cardActivity extends BaseActivity implements MainActivityView {
    FragmentManager fragmentManager;
    Button btnX;
    Fragment card1Fragment;
    Intent intent;
    String mainstring;

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
//        super.onBackPressed();
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
