package com.softsquared.wadiz.src.Item.item_main_supporter;

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
import com.softsquared.wadiz.src.Item.item_main_supporter.interfaces.MainActivityView;

import java.util.ArrayList;


public class Item_main_supporterFragment extends BaseFragment implements MainActivityView {
    View view;
    TextView tvSum;
    RecyclerView rv;
    SupporterItemRvAdapter rvAdapter;


    public Item_main_supporterFragment() {

    }

    public static Item_main_supporterFragment newInstance() {
        Item_main_supporterFragment itemmainsupporterFragment = new Item_main_supporterFragment();
        return itemmainsupporterFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_main_supporter, container, false);


        ArrayList<Supporterlist> supporterlistArrayList = new ArrayList<>();
        for (int i=0; i<50; i++) {
            supporterlistArrayList.add(new Supporterlist(R.drawable.banner0+i,"태웅김",Integer.toString(i)));
        }

        rv = view.findViewById(R.id.item_main_supporter_rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAdapter = new SupporterItemRvAdapter(supporterlistArrayList);
        rv.setAdapter(rvAdapter);
        return view;
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