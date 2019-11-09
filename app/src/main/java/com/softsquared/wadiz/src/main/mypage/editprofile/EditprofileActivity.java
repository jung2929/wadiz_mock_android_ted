package com.softsquared.wadiz.src.main.mypage.editprofile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.main.mypage.editprofile.interfaces.MainActivityView;
import com.softsquared.wadiz.src.main.MainActivity;


public class EditprofileActivity extends BaseActivity implements MainActivityView {
    MainActivity mainActivity;
    public static Context mcontext;
    ImageButton ibBack, ibHome;
    Button btnCancel, btnOk, btnImgupdate, btnImgdelete, btnImgchange;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    EditText etIntroduce;
    public static Intent intent;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        mainActivity = new MainActivity();
        ibBack = findViewById(R.id.profile_edit_ib_back);
        ibHome = findViewById(R.id.profile_edit_ib_home);
        btnCancel = findViewById(R.id.profile_edit_btn_cancel);
        btnOk = findViewById(R.id.profile_edit_btn_ok);
        btnImgupdate = findViewById(R.id.profile_edit_btn_imgupdate);
        btnImgchange = findViewById(R.id.profile_edit_btn_imgchange);
        btnImgdelete = findViewById(R.id.profile_edit_btn_imgdelete);
        mcontext = this;

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)MainActivity.mcontext).onFragmentChange(0);
                finish();
            }
        });
        Cancel_customDialog cancelCustomDialog = new Cancel_customDialog(EditprofileActivity.this);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelCustomDialog.callFunction();
            }
        });

        intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        cb1 = findViewById(R.id.profile_edit_cb1);
        cb2 = findViewById(R.id.profile_edit_cb2);
        cb3 = findViewById(R.id.profile_edit_cb3);
        cb4 = findViewById(R.id.profile_edit_cb4);
        cb5 = findViewById(R.id.profile_edit_cb5);
        cb6 = findViewById(R.id.profile_edit_cb6);
        cb7 = findViewById(R.id.profile_edit_cb7);
        cb8 = findViewById(R.id.profile_edit_cb8);

        btnImgchange.setText(Html.fromHtml(getResources().getString(R.string.profilechange)));
        btnImgdelete.setText(Html.fromHtml(getResources().getString(R.string.profiledelete)));
        btnImgupdate.setText(Html.fromHtml(getResources().getString(R.string.profileupdate)));


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
