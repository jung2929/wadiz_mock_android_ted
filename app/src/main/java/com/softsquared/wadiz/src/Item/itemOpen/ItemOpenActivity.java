package com.softsquared.wadiz.src.Item.itemOpen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.Item.itemOpen.interfaces.ItemOpenActivityView;
import com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.OpenItemStoryFragment;
import com.softsquared.wadiz.src.main.MainActivity;


public class ItemOpenActivity extends BaseActivity implements ItemOpenActivityView {
    public static Context mcontext;
    ImageButton ibBack, ibHome;
    public TextView tvTitleName;
    Button btnFunding;
    Fragment storyFragment;
    FragmentManager fragmentManager;
    public int mProjectIdx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_open);
        ibBack = findViewById(R.id.item_open_ib_back);
        ibHome = findViewById(R.id.item_open_ib_home);
        tvTitleName = findViewById(R.id.item_open_tv_title_name);
        btnFunding = findViewById(R.id.item_open_footer_btn_funding);

        Intent getintent = getIntent();
        mProjectIdx = getintent.getIntExtra("projectIdx", 999);
        storyFragment = new OpenItemStoryFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.item_open_container, storyFragment).commitAllowingStateLoss();

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

    }




    private void tryGetTest() {
        showProgressDialog();

        final ItemOpenService itemOpenService = new ItemOpenService(this);
        itemOpenService.getTest();
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
