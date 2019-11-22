package com.softsquared.wadiz.src.main.mypage.editprofile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.CursorLoader;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.mypage.editprofile.interfaces.EditProfileActivityView;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.CategoryItem;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.ProfileEditList;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class EditprofileActivity extends BaseActivity implements EditProfileActivityView {
    MainActivity mainActivity;
    public static Context mcontext;
    ImageButton ibBack, ibHome;
    Button btnCancel, btnOk, btnImgupdate, btnImgdelete, btnImgchange;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    EditText etIntroduce;
    ArrayList<CategoryItem> mCategoryItem;
    ProfileEditList mProfileList;
    CircleImageView mIvProfile;
    StorageReference mStorageReference;
    FirebaseStorage mFirebaseStorage;
    Uri mImgUri;
    public static final int GALLERY = 1000;

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
        mIvProfile = findViewById(R.id.profile_edit_iv_profile);
        mcontext = this;
        mCategoryItem = new ArrayList<>();
        mProfileList = new ProfileEditList(null, mCategoryItem);
        mFirebaseStorage = FirebaseStorage.getInstance("gs://wadiz-20532.appspot.com/");
        mStorageReference = mFirebaseStorage.getReference();


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

        btnImgupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExplorer(v);
            }
        });

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
                                if (cb1.isChecked()) mCategoryItem.add(new CategoryItem(1));
                                else mCategoryItem.remove((Integer) 1);
                                if (cb2.isChecked()) mCategoryItem.add(new CategoryItem(2));
                                else mCategoryItem.remove((Integer) 2);
                                if (cb3.isChecked()) mCategoryItem.add(new CategoryItem(3));
                                else mCategoryItem.remove((Integer) 3);
                                if (cb4.isChecked()) mCategoryItem.add(new CategoryItem(4));
                                else mCategoryItem.remove((Integer) 4);
                                if (cb5.isChecked()) mCategoryItem.add(new CategoryItem(5));
                                else mCategoryItem.remove((Integer) 5);
                                if (cb6.isChecked()) mCategoryItem.add(new CategoryItem(6));
                                else mCategoryItem.remove((Integer) 6);
                                if (cb7.isChecked()) mCategoryItem.add(new CategoryItem(7));
                                else mCategoryItem.remove((Integer) 7);
                                if (cb8.isChecked()) mCategoryItem.add(new CategoryItem(8));
                                else mCategoryItem.remove((Integer) 8);
                                mProfileList.setUserinfo(etIntroduce.getText().toString());
                                mProfileList.setCategoryItem(mCategoryItem);


                                tryGetTest();
                            }
                        });
                builder.show();
            }
        });

        Intent getintent = getIntent();
        Glide.with(getApplicationContext()).load(getintent.getStringExtra("profileImg")).into(mIvProfile);
        etIntroduce.setText(getintent.getStringExtra("indroduce"));

    }

    public void openExplorer(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        startActivityForResult(intent.createChooser(intent, "Select Picture"), 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY) {
            Uri uri = data.getData();
            upload(uri);
        }
    }
    //파이어 베이스에 올리고 성공적으로 올리면 다시 url다운받아서 프로필에 보이도록 해주기
    public void upload(Uri file) {
        StorageReference riversRef = mStorageReference.child("images/" + file.getLastPathSegment().replace(":",""));
        UploadTask uploadTask = riversRef.putFile(file);
        showProgressDialog();

        // Register observers to listen for when the download is done or if it fails
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                hideProgressDialog();
                Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                download(riversRef);
            }
        });
    }

    public void download(StorageReference riversRef) {
        riversRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    hideProgressDialog();
                    Glide.with(getApplicationContext()).load(task.getResult()).into(mIvProfile);
                    mImgUri = task.getResult();
                } else {
                    hideProgressDialog();
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void tryGetTest() {
        showProgressDialog();

        final EditProfileService editProfileService = new EditProfileService(this);
        editProfileService.patchProfile(SaveSharedPreference.getUserToken(getApplicationContext()), mProfileList);
        System.out.println(mImgUri);
        if (mImgUri != null){
            editProfileService.patchProfileImg(SaveSharedPreference.getUserToken(getApplicationContext()), mImgUri.toString());
        }

    }

    @Override
    public void validateSuccess(int code, String message) {
        hideProgressDialog();
        if (code == 200) {
            System.out.println("프로필 수정 완료");
            finish();
        } else {
            System.out.println("프로필 수정 실패 " + code + message);
            finish();
            Toast.makeText(getApplicationContext(), "프로필 수정을 실패하였습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT);
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
