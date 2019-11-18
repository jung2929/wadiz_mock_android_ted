package com.softsquared.wadiz.src.main.reward;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.wadiz.src.common.InavailableFragment;
import com.softsquared.wadiz.src.main.reward.reward_home.RewardHomeFragment;
import com.softsquared.wadiz.src.main.reward.reward_open.RewardOpenFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return RewardHomeFragment.newInstance();
            case 1:
                return RewardOpenFragment.newInstance();
            case 2:
                return InavailableFragment.newInstance();
            case 3:
                return InavailableFragment.newInstance();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 4;
    }
}