package com.softsquared.wadiz.src.main.reward.reward_home.interfaces;

import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerItemlist;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryItemList;
import com.softsquared.wadiz.src.main.reward.reward_home.models.Itemlist;

import java.util.ArrayList;

public interface RewardHomeView {

    void validateBannerSuccess(ArrayList<BannerItemlist> item);

    void validateBannerFailure(String message);

    void validateCategorySuccess(ArrayList<CategoryItemList> item);

    void validateCategoryFailure(String message);

    void validateItemSuccess(ArrayList<Itemlist> item);

    void validateItemFailure(String message);
}
