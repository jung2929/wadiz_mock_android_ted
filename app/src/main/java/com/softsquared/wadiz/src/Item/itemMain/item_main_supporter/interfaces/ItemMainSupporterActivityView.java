package com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.models.SupporterResult;
import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.models.Supporterlist;

import java.util.ArrayList;

public interface ItemMainSupporterActivityView {

    void validateSuccess(SupporterResult result, int code);

    void validateFailure(String message);
}
