package com.softsquared.wadiz.src.join.JoinFinish;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.join.JoinActivity;
import com.softsquared.wadiz.src.join.JoinFinish.interfaces.MainActivityView;
import com.softsquared.wadiz.src.join.join_email.JoinEmailFragment;
import com.softsquared.wadiz.src.login.LoginActivity;
import com.softsquared.wadiz.src.main.MainActivity;


public class JoinFinishFragment extends BaseFragment implements MainActivityView {
    View view;
    Button mBtnGo;
    Context myContext;

    public JoinFinishFragment() {

    }

    public static JoinFinishFragment newInstance() {
        JoinFinishFragment joinhomeFragment = new JoinFinishFragment();
        return joinhomeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_join_finish, container, false);
        mBtnGo = view.findViewById(R.id.join_finish_btn_go);
        mBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
                ((LoginActivity)LoginActivity.mContext).finish();
                ((MainActivity) MainActivity.mcontext).onFragmentChange(0);
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
