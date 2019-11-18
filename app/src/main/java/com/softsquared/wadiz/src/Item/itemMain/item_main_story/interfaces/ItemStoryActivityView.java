package com.softsquared.wadiz.src.Item.itemMain.item_main_story.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.ItemRewardlist;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.ItemStorylist;

import java.util.ArrayList;

public interface ItemStoryActivityView {

    void validateStorySuccess(ItemStorylist item);

    void validateStoryFailure(String message);

    void validateRewardSuccess(ArrayList<ItemRewardlist> item);

    void validateRewardFailure(String message);


    void validateLikeSuccess(int code);

    void validateLikeFailure(String message);


}
