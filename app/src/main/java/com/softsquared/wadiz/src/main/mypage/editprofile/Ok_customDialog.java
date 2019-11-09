package com.softsquared.wadiz.src.main.mypage.editprofile;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.softsquared.wadiz.R;

public class Ok_customDialog {
    EditprofileActivity editprofileActivity;
    Context mcontext;

    public Ok_customDialog(Context context) {
        mcontext = context;
    }

    public void callFunction() {
        editprofileActivity = new EditprofileActivity();
        final Dialog dlg = new Dialog(mcontext);

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.profile_edit_ok_customdialog);
        dlg.show();

        final Button okButton = (Button) dlg.findViewById(R.id.profile_edit_btn_ok);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커스텀 다이얼로그를 종료한다.
                dlg.dismiss();
//                ((EditprofileActivity)EditprofileActivity.mcontext).startActivity((EditprofileActivity) intent);
                //확인 누르면 인텐트 넘어가면서 다이얼로그랑 액티비티 다 종료시켜야함
            }
        });

    }

}
