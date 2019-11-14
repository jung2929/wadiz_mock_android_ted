package com.softsquared.wadiz.src.main.mypage.editprofile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.mypage.editprofile.interfaces.EditProfileActivityView;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.CategoryItem;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.ProfileEditList;

import java.util.ArrayList;


public class EditprofileActivity extends BaseActivity implements EditProfileActivityView {
    MainActivity mainActivity;
    public static Context mcontext;
    ImageButton ibBack, ibHome;
    Button btnCancel, btnOk, btnImgupdate, btnImgdelete, btnImgchange;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    EditText etIntroduce;
    public static Intent intent;
    ArrayList<CategoryItem> mCategoryItem;
    ArrayList<ProfileEditList> mProfileList;

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
        mCategoryItem = new ArrayList<>();
        mProfileList = new ArrayList<>();

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


        etIntroduce = findViewById(R.id.profile_edit_et);
        etIntroduce.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        Ok_customDialog okCustomDialog = new Ok_customDialog(EditprofileActivity.this);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditprofileActivity.this);
                builder.setMessage("프로필 설정이 성공정으로 변경되었습니다.");
                builder.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (cb1.isChecked()) mCategoryItem.add(new CategoryItem("1"));
                                if (cb2.isChecked()) mCategoryItem.add(new CategoryItem("2"));
                                if (cb3.isChecked()) mCategoryItem.add(new CategoryItem("3"));
                                if (cb4.isChecked()) mCategoryItem.add(new CategoryItem("4"));
                                if (cb5.isChecked()) mCategoryItem.add(new CategoryItem("5"));
                                if (cb6.isChecked()) mCategoryItem.add(new CategoryItem("6"));
                                if (cb7.isChecked()) mCategoryItem.add(new CategoryItem("7"));
                                if (cb8.isChecked()) mCategoryItem.add(new CategoryItem("8"));
                                mProfileList.add((new ProfileEditList(etIntroduce.getText().toString(), mCategoryItem)));

                                System.out.println("1번 선택?? : "+mCategoryItem.get(0).getCategoryIdx());

                                tryGetTest();
                            }
                        });
                builder.show();
            }
        });
    }

    private void tryGetTest() {
        showProgressDialog();

        final EditProfileService editProfileService = new EditProfileService(this);
        editProfileService.getTest(SaveSharedPreference.getUserToken(getApplicationContext()));
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        System.out.println("프로필 수정 완료");
        finish();
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
