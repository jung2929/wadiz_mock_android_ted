package com.softsquared.wadiz.src.join.join_email;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.join.JoinActivity;
import com.softsquared.wadiz.src.join.JoinFinish.JoinFinishFragment;
import com.softsquared.wadiz.src.join.join_email.interfaces.JoinEmailView;
import com.softsquared.wadiz.src.join.join_email.models.EmailList;
import com.softsquared.wadiz.src.join.join_email.models.JoinEmailResponse;

import java.util.ArrayList;


public class JoinEmailFragment extends BaseFragment implements JoinEmailView {
    View view;
    Button btnOk;
    Context myContext;
    EditText mEtEmail, mEtName, mEtPw, mEtPwConfirm;
    TextView mTvError;
    ArrayList<JoinEmailResponse> mJoinEmailResponses;
    String mEmail, mName, mPw, mRepw;
    public EmailList mEmailList = new EmailList(mEmail,mName,mPw,mRepw);

    public JoinEmailFragment() {

    }

    public static JoinEmailFragment newInstance() {
        JoinEmailFragment joinemailFragment = new JoinEmailFragment();
        return joinemailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_join_email, container, false);
        btnOk = view.findViewById(R.id.join_email_btn_ok);
        mEtEmail = view.findViewById(R.id.join_email_et_email);
        mEtName = view.findViewById(R.id.join_email_et_name);
        mEtPw = view.findViewById(R.id.join_email_et_password);
        mEtPwConfirm = view.findViewById(R.id.join_email_et_password_right);
        mTvError = view.findViewById(R.id.join_email_tv_name_error);
        mJoinEmailResponses = new ArrayList<>();


        mEtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mEmail = mEtEmail.getText().toString();
            }
        });

        mEtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mName = mEtName.getText().toString();

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
                mPw = mEtPw.getText().toString();
            }
        });

        mEtPwConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mRepw = mEtPwConfirm.getText().toString();
                mEmailList.setEmail(mEmail);
                mEmailList.setName(mName);
                mEmailList.setPw(mPw);
                mEmailList.setRepw(mRepw);
            }
        });


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("이메일 리스트 : " +mEmailList);
                tryGetTest();

            }
        });


        return view;
    }


    public void onAttach(Context context) {
        myContext = (FragmentActivity) context;
        super.onAttach(context);
    }

    private void tryGetTest() {
        showProgressDialog();

        final JoinEmailService joinEmailService = new JoinEmailService(this);
        joinEmailService.postJoin(mEmailList);
    }

    @Override
    public void validateSuccess(boolean success, int code, String message) {
        hideProgressDialog();

        if (code == 201) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("계정이 만들어졌습니다");
            builder.setMessage("입력하신 이메일 계정으로 로그인 하실 수 있습니다.");
            builder.setPositiveButton("확인",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ((JoinActivity) getActivity()).replaceFragment(JoinFinishFragment.newInstance());
                        }
                    });
            builder.show();
        } else if (code == 301) {
            mTvError.setText(message);
            mTvError.setVisibility(View.VISIBLE);
        } else if (code == 302) {
            mTvError.setVisibility(View.VISIBLE);
            mTvError.setText(message);
        } else if (code == 303) {
            mTvError.setVisibility(View.VISIBLE);
            mTvError.setText(message);
        } else if (code == 304) {
            mTvError.setVisibility(View.VISIBLE);
            mTvError.setText(message);
        } else if (code == 305) {
            mTvError.setVisibility(View.VISIBLE);
            mTvError.setText(message);
        } else if (code == 306) {
            mTvError.setVisibility(View.VISIBLE);
            mTvError.setText(message);
        } else if (code == 307) {
            mTvError.setText(message);
            mTvError.setVisibility(View.VISIBLE);
        } else if (code == 308) {
            mTvError.setVisibility(View.VISIBLE);
            mTvError.setText(message);
        } else if (code == 309) {
            mTvError.setText(message);
            mTvError.setVisibility(View.VISIBLE);
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
