package com.softsquared.wadiz.src.Item.itemMain.item_main_supporter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.Item.itemMain.ItemMainActivity;
import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.Adapters.SupporterItemRvAdapter;
import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.interfaces.ItemMainSupporterActivityView;
import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.models.SupporterResult;
import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.models.Supporterlist;
import com.softsquared.wadiz.src.common.SaveSharedPreference;

import java.util.ArrayList;


public class ItemMainSupporterFragment extends BaseFragment implements ItemMainSupporterActivityView {
    View view;
    TextView tvSum;
    RecyclerView rv;
    SupporterItemRvAdapter rvAdapter;
    ArrayList<Supporterlist> mSupporterListArrayList;
    int mProjectIdx;


    public ItemMainSupporterFragment() {

    }

    public static ItemMainSupporterFragment newInstance() {
        ItemMainSupporterFragment itemmainsupporterFragment = new ItemMainSupporterFragment();
        return itemmainsupporterFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_main_supporter, container, false);

        mProjectIdx = ((ItemMainActivity) getActivity()).mProjectIdx;
        mSupporterListArrayList = new ArrayList<>();
        tvSum = view.findViewById(R.id.item_main_supporter_tv_sum);
        rv = view.findViewById(R.id.item_main_supporter_rv);

        tryGetTest();

        return view;
    }


    private void tryGetTest() {
        showProgressDialog();

        final ItemMainSupporterService itemMainSupporterService = new ItemMainSupporterService(this);
        itemMainSupporterService.getTest(mProjectIdx, SaveSharedPreference.getUserToken(getActivity()));
    }

    @Override
    public void validateSuccess(SupporterResult result) {
        hideProgressDialog();
        if (result == null) {
            tvSum.setText("0");
        } else {
            mSupporterListArrayList = result.getResult();
        }

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        tvSum.setText(Integer.toString(result.getCnt()));
        rvAdapter = new SupporterItemRvAdapter(mSupporterListArrayList, getActivity());
        rv.setAdapter(rvAdapter);


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