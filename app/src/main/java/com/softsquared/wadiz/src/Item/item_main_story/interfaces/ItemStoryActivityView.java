package com.softsquared.wadiz.src.Item.item_main_story.interfaces;

import com.softsquared.wadiz.src.Item.item_main_story.models.Itemmainlist;

import java.util.ArrayList;

public interface ItemStoryActivityView {

    void validateSuccess(ArrayList<Itemmainlist> item);

    void validateFailure(String message);
}
