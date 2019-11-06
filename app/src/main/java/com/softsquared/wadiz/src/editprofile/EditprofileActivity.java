package com.softsquared.wadiz.src.editprofile;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.editprofile.interfaces.MainActivityView;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.mypage.MypageFragment;


public class EditprofileActivity extends BaseActivity implements MainActivityView {
    MainActivity mainActivity;
    ImageButton ibBack, ibHome;
    Button btnCancel, btnOk;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    EditText etIntroduce;
    Intent intent;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        mainActivity = new MainActivity();
        ibBack = findViewById(R.id.profile_edit_ib_back);
        ibHome = findViewById(R.id.profile_edit_ib_home);
        btnCancel = findViewById(R.id.profile_edit_btn_cancel);
        btnOk = findViewById(R.id.profile_edit_btn_ok);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        ibHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mainActivity.onFragmentChange(0);
//                finish();
//            }
//        }); 홈이미지버튼 누르면 홈으로 돌아가기 안됨 개썅 짜증나서 주석처리 context활용어쩌고 해야담닝라ㅓ미나어리
        Cancel_customDialog cancelCustomDialog = new Cancel_customDialog(EditprofileActivity.this);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelCustomDialog.callFunction();
            }
        });

        intent = new Intent(this, MypageFragment.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        cb1 = findViewById(R.id.profile_edit_cb1);
        cb2 = findViewById(R.id.profile_edit_cb2);
        cb3 = findViewById(R.id.profile_edit_cb3);
        cb4 = findViewById(R.id.profile_edit_cb4);
        cb5 = findViewById(R.id.profile_edit_cb5);
        cb6 = findViewById(R.id.profile_edit_cb6);
        cb7 = findViewById(R.id.profile_edit_cb7);
        cb8 = findViewById(R.id.profile_edit_cb8);

        if (cb1.isChecked()) intent.putExtra("interest1", true);
        if (cb2.isChecked()) intent.putExtra("interest2", true);
        if (cb3.isChecked()) intent.putExtra("interest3", true);
        if (cb4.isChecked()) intent.putExtra("interest4", true);
        if (cb5.isChecked()) intent.putExtra("interest5", true);
        if (cb6.isChecked()) intent.putExtra("interest6", true);
        if (cb7.isChecked()) intent.putExtra("interest7", true);
        if (cb8.isChecked()) intent.putExtra("interest8", true);

        etIntroduce = findViewById(R.id.profile_edit_et);

        intent.putExtra("introducetext", etIntroduce.getText().toString());

        Ok_customDialog okCustomDialog = new Ok_customDialog(EditprofileActivity.this);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okCustomDialog.callFunction();
                startActivity(intent);
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
