package com.softsquared.wadiz.src.main.reward.reward_home.interfaces;

import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerItemlist;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryItemList;

import java.util.ArrayList;

public interface RewardHomeView {

    void validateBannerSuccess(ArrayList<BannerItemlist> item);

    void validateBannerFailure(String message);

    void validateCategorySuccess(ArrayList<CategoryItemList> item);

    void validateCategoryFailure(String message);
}
