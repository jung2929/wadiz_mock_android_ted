package com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.interfaces;

import com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.models.ItemOpenlist;

public interface OpenItemStoryActivityView {

    void validateSuccess(ItemOpenlist item);

    void validateFailure(String message);
}
