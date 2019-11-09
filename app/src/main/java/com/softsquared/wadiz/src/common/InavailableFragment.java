package com.softsquared.wadiz.src.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;


public class InavailableFragment extends BaseFragment {
    View view;


    public InavailableFragment() {

    }

    public static InavailableFragment newInstance() {
        InavailableFragment mainActivity = new InavailableFragment();
        return mainActivity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_inavailable, container, false);

        return view;
    }

}
