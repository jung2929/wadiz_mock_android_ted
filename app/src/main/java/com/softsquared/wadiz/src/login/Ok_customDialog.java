package com.softsquared.wadiz.src.login;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.softsquared.wadiz.R;

public class Ok_customDialog {
    LoginActivity loginActivity;
    Context mcontext;

    public Ok_customDialog(Context context) {
        mcontext = context;
    }

    public void callFunction() {
        loginActivity = new LoginActivity();
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
                ((Activity)mcontext).finish();
            }
        });

    }

}
