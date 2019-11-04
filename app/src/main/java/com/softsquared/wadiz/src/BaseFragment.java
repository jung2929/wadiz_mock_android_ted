package com.softsquared.wadiz.src;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.softsquared.wadiz.R;

@SuppressLint("Registered")
public class BaseFragment extends Fragment {
    public ProgressDialog mProgressDialog;

    public void showCustomToast(final String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }
}
